package ru.kimvadislav.apmmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kimvadislav.apmmanager.model.LoanRequest;
import ru.kimvadislav.apmmanager.service.LoanRequestService;

import java.util.List;

@Controller
@RequestMapping ("Search")
public class SearchController {
    private LoanRequestService requestService;

    @Autowired
    public SearchController(LoanRequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("data", new String());
        return "search";
    }

    @PostMapping ("/{type}/{data}")
    public ModelAndView searchLoanRequest(@RequestParam ("data") String data,
                                          @RequestParam ("radioType") String radioType,
                                          Model model) {

        List<LoanRequest> loanRequest = requestService.findRequestByType(radioType, data);

        ModelAndView modelAndView = new ModelAndView("searchingResult");
        modelAndView.addObject("loanRequest", loanRequest);
        modelAndView.addObject("data", data);
        modelAndView.addObject("radioType", radioType);

        return modelAndView;
    }
}
