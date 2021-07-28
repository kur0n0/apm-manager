package ru.kimvadislav.apmmanager.model;

public class LoanContractDto {
    private LoanRequest loanRequest;
    private LoanContract loanContract;

    public LoanContractDto(LoanRequest loanRequest, LoanContract loanContract) {
        this.loanRequest = loanRequest;
        this.loanContract = loanContract;
    }

    public LoanContractDto() {
    }

    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public LoanContract getLoanContract() {
        return loanContract;
    }
}
