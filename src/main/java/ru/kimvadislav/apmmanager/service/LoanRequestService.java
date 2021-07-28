package ru.kimvadislav.apmmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kimvadislav.apmmanager.dao.LoanContractRepository;
import ru.kimvadislav.apmmanager.dao.LoanRequestDecisionRepository;
import ru.kimvadislav.apmmanager.dao.LoanRequestRepository;
import ru.kimvadislav.apmmanager.model.LoanContract;
import ru.kimvadislav.apmmanager.model.LoanRequest;
import ru.kimvadislav.apmmanager.model.LoanRequestDecision;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {
    private LoanRequestRepository requestRepository;
    private LoanRequestDecisionRepository decisionRepository;
    private LoanContractRepository contractRepository;

    @Autowired
    public LoanRequestService(LoanRequestRepository requestRepository,
                              LoanRequestDecisionRepository decisionRepository,
                              LoanContractRepository contractRepository) {
        this.requestRepository = requestRepository;
        this.decisionRepository = decisionRepository;
        this.contractRepository = contractRepository;
    }

    public boolean saveLoanRequest(LoanRequest loanRequest) {
        requestRepository.saveRequest(loanRequest);
        boolean decision = makeDecisionAboutRequest(loanRequest);

        if (decision == true) {
            LoanContract contract = LoanContract.newLoanContractBuilder()
                    .withLoanRequestId(loanRequest.getId())
                    .build();
            contractRepository.saveContract(contract);
        }

        return decision;
    }

    public Optional<LoanRequest> getLoanRequestById(Long id) {
        return requestRepository.findRequestById(id);
    }

    public boolean makeDecisionAboutRequest(LoanRequest loanRequest) {
        int periodOfDays = (int) (1 + Math.random() * 365);
        boolean decision = false;
        if (periodOfDays % 2 == 0) {
            decision = true;
        }
        BigDecimal loanAmount = BigDecimal.valueOf(
                (Math.random()) * (loanRequest.getLoanAmount().doubleValue()));

        Optional<LoanRequest> loanRequestWithId = requestRepository.findByPassportInfoAndLoanAmount(
                loanRequest.getPassportSeries(), loanRequest.getPassportNumber(), loanRequest.getLoanAmount());

        if (loanRequestWithId.isPresent()) {
            LoanRequestDecision loanRequestDecision = LoanRequestDecision
                    .newLoanRequestDecisionBuilder()
                    .withDecision(decision)
                    .withLoanDays(periodOfDays)
                    .withApprovedLoanAmount(loanAmount)
                    .withLoanRequestId(loanRequestWithId.get().getId())
                    .build();

            decisionRepository.saveDescision(loanRequestDecision);
        }

        return decision;
    }

    public List<LoanRequest> findRequestByType(String type, String data) {
        List<LoanRequest> loanRequest = new ArrayList<>();
        switch (type) {
            case "phoneNumber":
                loanRequest = requestRepository.findRequestByPhoneNumber(data);
                break;
            case "fio":
                String fio[] = data.split(" ");
                loanRequest = requestRepository.findRequestByFio(fio[0], fio[1], fio[2]);
                break;
            case "passportData":
                String passportData[] = data.split(" ");
                loanRequest.add(requestRepository
                        .findRequestByPassportData(passportData[0], passportData[1]));
                break;
        }

        return loanRequest;
    }
}
