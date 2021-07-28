package ru.kimvadislav.apmmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kimvadislav.apmmanager.model.LoanRequest;
import ru.kimvadislav.apmmanager.service.ClientsService;

import java.util.List;

@Controller
@RequestMapping ("/Clients")
public class ClientsController {
    private ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public String showPage(Model model) {
        List<LoanRequest> allClients = clientsService.getAllClients();
        model.addAttribute("allClients", allClients);
        return "clients";
    }
}
