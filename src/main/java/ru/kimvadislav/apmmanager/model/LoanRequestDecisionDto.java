package ru.kimvadislav.apmmanager.model;

public class LoanRequestDecisionDto {
    private LoanRequest loanRequest;
    private LoanRequestDecision requestDecision;

    public LoanRequestDecisionDto(LoanRequest loanRequest, LoanRequestDecision requestDecision) {
        this.loanRequest = loanRequest;
        this.requestDecision = requestDecision;
    }

    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public LoanRequestDecision getRequestDecision() {
        return requestDecision;
    }
}
