package ru.kimvadislav.apmmanager.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "requestsdecision")
public class LoanRequestDecision {
    @Id
    private Long loanRequestId;
    private boolean decision;
    private int loanDays;
    private BigDecimal approvedLoanAmount;

    public void setLoanRequestId(Long loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    public void setLoanDays(int loanDays) {
        this.loanDays = loanDays;
    }

    public void setApprovedLoanAmount(BigDecimal approvedLoanAmount) {
        this.approvedLoanAmount = approvedLoanAmount;
    }

    public Long getLoanRequestId() {
        return loanRequestId;
    }

    public boolean isDecision() {
        return decision;
    }

    public int getLoanDays() {
        return loanDays;
    }

    public BigDecimal getApprovedLoanAmount() {
        return approvedLoanAmount;
    }

    public static LoanRequestDecisionBuilder newLoanRequestDecisionBuilder() {
        return new LoanRequestDecision().new LoanRequestDecisionBuilder();
    }

    public class LoanRequestDecisionBuilder {

        private LoanRequestDecisionBuilder() {
        }

        public LoanRequestDecisionBuilder withLoanRequestId(Long loanRequestId) {
            LoanRequestDecision.this.loanRequestId = loanRequestId;
            return this;
        }

        public LoanRequestDecisionBuilder withDecision(boolean decision) {
            LoanRequestDecision.this.decision = decision;
            return this;
        }

        public LoanRequestDecisionBuilder withLoanDays(int loanDays) {
            LoanRequestDecision.this.loanDays = loanDays;
            return this;
        }

        public LoanRequestDecisionBuilder withApprovedLoanAmount(BigDecimal approvedLoanAmount) {
            LoanRequestDecision.this.approvedLoanAmount = approvedLoanAmount;
            return this;
        }

        public LoanRequestDecision build() {
            return LoanRequestDecision.this;
        }
    }
}
