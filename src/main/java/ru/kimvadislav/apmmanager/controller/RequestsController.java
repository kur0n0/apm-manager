package ru.kimvadislav.apmmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kimvadislav.apmmanager.model.LoanRequestDecisionDto;
import ru.kimvadislav.apmmanager.service.RequestDecisionService;

import java.util.List;

@Controller
@RequestMapping ("Requests")
public class RequestsController {
    private RequestDecisionService requestDecisionService;

    @Autowired
    public RequestsController(RequestDecisionService requestDecisionService) {
        this.requestDecisionService = requestDecisionService;
    }

    @GetMapping
    public String showPage(Model model) {
        List<LoanRequestDecisionDto> requestDecisionDtos = requestDecisionService.getAll();
        model.addAttribute("dtoList", requestDecisionDtos);
        return "requests";
    }
}
