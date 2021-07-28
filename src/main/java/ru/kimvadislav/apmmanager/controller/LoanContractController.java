package ru.kimvadislav.apmmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kimvadislav.apmmanager.model.LoanContractDto;
import ru.kimvadislav.apmmanager.service.LoanContractService;

import java.util.List;

@Controller
@RequestMapping ("LoanContract")
public class LoanContractController {
    private LoanContractService contractService;

    @Autowired
    public LoanContractController(LoanContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public String showPage(Model model) {
        List<LoanContractDto> contractDtoList = contractService.getLoanContractDto();
        model.addAttribute("contractDtoList", contractDtoList);
        model.addAttribute("contractToSign", new LoanContractDto());
        return "loanContract";
    }

    @GetMapping ("/sign/{id}")
    public String signContract(@PathVariable ("id") Long id) {
        contractService.signContract(id);
        return "redirect:/LoanContract";
    }
}
