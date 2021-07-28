package ru.kimvadislav.apmmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kimvadislav.apmmanager.model.LoanRequest;
import ru.kimvadislav.apmmanager.service.LoanRequestService;


@Controller
@RequestMapping ("LoanRequest")
public class LoanRequestController {
    private LoanRequestService service;

    @Autowired
    public LoanRequestController(LoanRequestService service) {
        this.service = service;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("loanRequest", new LoanRequest());
        return "loanRequest";
    }

    @PostMapping ("/create")
    public String createLoanRequest(@ModelAttribute LoanRequest loanRequest) {
        boolean decision = service.saveLoanRequest(loanRequest);
        if (decision == true) {
            return "redirect:/LoanContract";
        } else {
            return "redirect:/LoanRequest";
        }
    }
}
