package org.example.lifesafe.web;

import org.example.lifesafe.model.entities.Automobile;
import org.example.lifesafe.model.entities.Car;
import org.example.lifesafe.model.entities.Devis;
import org.example.lifesafe.model.entities.User;
import org.example.lifesafe.model.enums.CarUse;
import org.example.lifesafe.model.enums.DevisStatus;
import org.example.lifesafe.model.enums.InsuranceType;
import org.example.lifesafe.service.ICarService;
import org.example.lifesafe.service.IDevisService;
import org.example.lifesafe.service.IInsuranceService;
import org.example.lifesafe.util.CalculateDevis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/automobile")
public class AutomobileController {

    private final IInsuranceService insuranceService;
    private final ICarService carService;
    private final IDevisService devisService;
    private final CalculateDevis calculateDevis;

    @Autowired
    public AutomobileController(IInsuranceService insuranceService,
                                ICarService carService,
                                IDevisService devisService,
                                CalculateDevis calculateDevis) {
        this.insuranceService = insuranceService;
        this.carService = carService;
        this.devisService = devisService;
        this.calculateDevis = calculateDevis;
    }

    @GetMapping("")
    public String showInsuranceAutomobile() {
        return "automobile";
    }

    @GetMapping("/addForm")
    public String showInsuranceAutomobileForm(Model model) {
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        model.addAttribute("carUses", CarUse.values());
        return "forms/automobileForm";
    }

    @PostMapping("/addInsurance")
    public String addInsurance(@ModelAttribute Automobile automobile, Model model, HttpSession session) {

        User loggedInUser = (User) session.getAttribute("loggedInUser");

        Optional<Car> optionalCar = carService.findById(automobile.getCar().getId());
        if (optionalCar.isPresent()) {

            automobile.setCar(optionalCar.get());
            automobile.setType(InsuranceType.Automobile);
            automobile.setQuoteAmount(500);
            insuranceService.addInsurance(automobile);

            double totalQuote = calculateDevis.calculateAutomobileDevis(automobile);

            Devis devis = new Devis(automobile, LocalDate.now(),totalQuote, DevisStatus.Pending);

            devisService.addDevis(devis);

            return "redirect:/devis/" + devis.getId();
        } else {
            model.addAttribute("error", "Car not found. Please select a valid car.");
            return "automobile/addInsuranceForm";
        }
    }



}
