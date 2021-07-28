package ru.kimvadislav.apmmanager.dao;

import ru.kimvadislav.apmmanager.model.LoanContract;

import java.util.Optional;

public interface LoanContractRepository {
    void saveContract(LoanContract loanContract);

    Optional<LoanContract> findContractById(Long id);

    void signContract(Long id);
}
