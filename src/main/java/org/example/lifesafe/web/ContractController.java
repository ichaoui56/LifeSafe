package org.example.lifesafe.web;

import org.example.lifesafe.model.entities.Contract;
import org.example.lifesafe.model.entities.Devis;
import org.example.lifesafe.service.IContractService;
import org.example.lifesafe.service.IDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private final IContractService contractService;
    private final IDevisService devisService;

    @Autowired
    public ContractController(IContractService contractService, IDevisService devisService) {
        this.contractService = contractService;
        this.devisService = devisService;
    }

    @GetMapping("/addForm/{devisId}")
    public String showContractForm(@PathVariable("devisId") int devisId, Model model) {
        model.addAttribute("devisId", devisId);
        return "forms/contractForm"; // Adjust path if necessary
    }

    @PostMapping("/add")
    public String addContract(@RequestParam("devisId") int devisId,
                              @RequestParam("document") MultipartFile document,
                              HttpSession session) {
        Optional<Devis> devisOpt = devisService.findById(devisId);
        if (devisOpt.isPresent()) {
            Devis devis = devisOpt.get();
            Contract contract = new Contract();

            contract.setSubscriptionDate(LocalDate.now());
            contract.setExpirationDate(LocalDate.now().plusMonths(1));  // Example duration
            contract.setActive(true);
            contract.setDevis(devis);

            // Save the uploaded document to a file
            try {
                // Use the absolute path to save the uploaded file
                String filePath = "/Users/mac/Documents/GitHub/LifeSafe/src/main/webapp/files/" + document.getOriginalFilename(); // Updated path
                File file = new File(filePath);
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(document.getBytes());
                    contract.setDocument(filePath);  // Store the file path in the Contract
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/error";  // Redirect to an error page if needed
            }


            contractService.addContract(contract);
            return "redirect:/contracts/success";  // Redirect to a success page or contract list
        } else {
            return "redirect:/devis";  // Redirect to Devis list if not found
        }
    }
}
