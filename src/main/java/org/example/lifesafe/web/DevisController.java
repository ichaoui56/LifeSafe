package org.example.lifesafe.web;

import org.example.lifesafe.model.entities.Devis;
import org.example.lifesafe.model.entities.User;
import org.example.lifesafe.model.enums.DevisStatus;
import org.example.lifesafe.service.IDevisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/devis")
public class DevisController {

    private final IDevisService devisService;

    @Autowired
    public DevisController(IDevisService devisService) {
        this.devisService = devisService;
    }

//    @GetMapping
//    public String listDevis(HttpSession session, Model model) {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//
//        if (loggedInUser != null) {
//            List<Devis> devisList = devisService.findByUser(loggedInUser);
//            model.addAttribute("devisList", devisList);
//            return "devis/list";
//        } else {
//            return "redirect:/login"; // Redirect to login if not authenticated
//        }
//    }

    @GetMapping("/{id}")
    public String showDevisDetails(@PathVariable("id") int id, Model model, HttpSession session) {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");

        Optional<Devis> optionalDevis = devisService.findById(id);
        if (optionalDevis.isPresent()) {
            Devis devis = optionalDevis.get();
//            if (devis.getUser().equals(loggedInUser)) {
            model.addAttribute("devis", devis);
            return "devisDetails";
//            } else {
//                return "redirect:/devis";
//            }
        } else {
            return "redirect:/devis";
        }

    }


    @PostMapping("/{id}/accept")
    public String acceptDevis(@PathVariable("id") int id, HttpSession session) {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//
//        if (loggedInUser != null) {
        Optional<Devis> devisOpt = devisService.findById(id);
//        if (devis != null && devis.getUser().equals(loggedInUser)) {
        if (devisOpt.isPresent()) {
            Devis devis = devisOpt.get();
            devis.setStatus(DevisStatus.Accepted); // Correct way to set the status
            devisService.updateDevis(devis);
            return "redirect:/devis";
        } else {
            return "redirect:/";
        }

//        }
//        }
//        return "redirect:/login";
    }

    @PostMapping("/{id}/reject")
    public String rejectDevis(@PathVariable("id") int id, HttpSession session) {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//
//        if (loggedInUser != null) {
        Optional<Devis> devisOpt = devisService.findById(id);
//            if (devis != null && devis.getUser().equals(loggedInUser)) {
        if (devisOpt.isPresent()) {
            Devis devis = devisOpt.get();
            devis.setStatus(DevisStatus.Rejected);
            devisService.updateDevis(devis);
            return "redirect:/devis";
        } else {
            return  "redirect:/";
        }
//            }
//        }
//        return "redirect:/login";
    }
}
