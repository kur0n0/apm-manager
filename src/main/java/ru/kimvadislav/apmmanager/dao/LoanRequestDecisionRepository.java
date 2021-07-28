package ru.kimvadislav.apmmanager.dao;

import ru.kimvadislav.apmmanager.model.LoanRequestDecision;

import java.util.List;

public interface LoanRequestDecisionRepository {
    void saveDescision(LoanRequestDecision loanRequestDecision);

    List<LoanRequestDecision> findAllRequestsWithAproval();

    List<LoanRequestDecision> findAll();
}
