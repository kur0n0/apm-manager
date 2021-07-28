package ru.kimvadislav.apmmanager.dao;

import ru.kimvadislav.apmmanager.model.LoanRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface LoanRequestRepository {
    void saveRequest(LoanRequest loanRequest);

    Optional<LoanRequest> findRequestById(Long id);

    Optional<LoanRequest> findByPassportInfoAndLoanAmount(
            String passportSeries, String passportNumber, BigDecimal loanAmount);

    List<LoanRequest> findAll();

    List<LoanRequest> findRequestByPhoneNumber(String data);

    List<LoanRequest> findRequestByFio(String name, String surname, String patronymic);

    LoanRequest findRequestByPassportData(String passportSeries, String passportNumber);
}
