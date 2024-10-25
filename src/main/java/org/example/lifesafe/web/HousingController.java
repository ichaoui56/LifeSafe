package org.example.lifesafe.web;

import org.example.lifesafe.model.entities.*;
import org.example.lifesafe.model.enums.DevisStatus;
import org.example.lifesafe.model.enums.InsuranceType;
import org.example.lifesafe.service.IDevisService;
import org.example.lifesafe.service.IInsuranceService;
import org.example.lifesafe.util.CalculateDevis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;

@Controller
@RequestMapping("/housing")
public class HousingController {

    private final IInsuranceService insuranceService;
    private final IDevisService devisService;
    private final CalculateDevis calculateDevis;

    @Autowired
    public HousingController(IInsuranceService insuranceService,
                            IDevisService devisService,
                            CalculateDevis calculateDevis) {
        this.insuranceService = insuranceService;
        this.devisService = devisService;
        this.calculateDevis = calculateDevis;
    }

    @GetMapping
    public String showInsuranceHousing() {
        return "housing";
    }

    @GetMapping("/addForm")
    public String showInsuranceHousingForm(Model model) {
        return "forms/housingForm";
    }

    @PostMapping("/addInsurance")
    public String addInsurance(@ModelAttribute Housing housing, Model model, HttpSession session) {

        User loggedInUser = (User) session.getAttribute("loggedInUser");

        housing.setType(InsuranceType.Housing);
        housing.setQuoteAmount(300);
        insuranceService.addInsurance(housing);

        double totalQuote = calculateDevis.calculateHousingDevis(housing);

        System.out.println(totalQuote);
        Devis devis = new Devis(housing, LocalDate.now(), totalQuote, DevisStatus.Pending);
        devisService.addDevis(devis);

        return "redirect:/devis/" + devis.getId();

    }


}
