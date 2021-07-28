package ru.kimvadislav.apmmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kimvadislav.apmmanager.dao.LoanRequestDecisionRepository;
import ru.kimvadislav.apmmanager.dao.LoanRequestRepository;
import ru.kimvadislav.apmmanager.model.LoanRequest;
import ru.kimvadislav.apmmanager.model.LoanRequestDecision;
import ru.kimvadislav.apmmanager.model.LoanRequestDecisionDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestDecisionService {
    private LoanRequestRepository requestRepository;
    private LoanRequestDecisionRepository decisionRepository;

    @Autowired
    public RequestDecisionService(LoanRequestRepository requestRepository,
                                  LoanRequestDecisionRepository decisionRepository) {

        this.requestRepository = requestRepository;
        this.decisionRepository = decisionRepository;

    }

    public List<LoanRequestDecisionDto> getAll() {
        List<LoanRequest> requests = requestRepository.findAll();
        List<LoanRequestDecision> decisions = decisionRepository.findAll();

        List<LoanRequestDecisionDto> loanRequestDecisionDtos = new ArrayList<>();
        if (requests.size() == decisions.size()) {
            for (int i = 0; i < requests.size(); i++) {
                loanRequestDecisionDtos.add(
                        new LoanRequestDecisionDto(requests.get(i), decisions.get(i)));
            }
        }

        return loanRequestDecisionDtos;
    }
}
