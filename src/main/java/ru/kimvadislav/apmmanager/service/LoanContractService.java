package ru.kimvadislav.apmmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kimvadislav.apmmanager.dao.LoanContractRepository;
import ru.kimvadislav.apmmanager.dao.LoanRequestDecisionRepository;
import ru.kimvadislav.apmmanager.dao.LoanRequestRepository;
import ru.kimvadislav.apmmanager.model.LoanContract;
import ru.kimvadislav.apmmanager.model.LoanContractDto;
import ru.kimvadislav.apmmanager.model.LoanRequest;
import ru.kimvadislav.apmmanager.model.LoanRequestDecision;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanContractService {
    private LoanContractRepository contractRepository;
    private LoanRequestRepository requestRepository;
    private LoanRequestDecisionRepository requestDecisionRepository;

    @Autowired
    public LoanContractService(LoanContractRepository contractRepository,
                               LoanRequestRepository requestRepository,
                               LoanRequestDecisionRepository requestDecisionRepository) {

        this.contractRepository = contractRepository;
        this.requestRepository = requestRepository;
        this.requestDecisionRepository = requestDecisionRepository;

    }

    public List<LoanContractDto> getLoanContractDto() {
        List<LoanRequestDecision> contractsWithAproval = requestDecisionRepository
                .findAllRequestsWithAproval();

        List<LoanContractDto> contractDtoList = new ArrayList<>();
        for (LoanRequestDecision requestDecision : contractsWithAproval) {
            Long id = requestDecision.getLoanRequestId();

            Optional<LoanRequest> optionalLoanRequest = requestRepository
                    .findRequestById(id);

            Optional<LoanContract> optionalLoanContract = contractRepository
                    .findContractById(id);

            if (optionalLoanRequest.isPresent() && optionalLoanContract.isPresent()) {
                LoanRequest loanRequest = optionalLoanRequest.get();
                LoanContract loanContract = optionalLoanContract.get();

                contractDtoList.add(new LoanContractDto(loanRequest, loanContract));
            }
        }

        return contractDtoList;
    }

    public void signContract(Long id) {
        contractRepository.signContract(id);
    }
}
