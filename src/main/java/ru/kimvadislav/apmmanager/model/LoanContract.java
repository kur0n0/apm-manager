package ru.kimvadislav.apmmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "contracts")
public class LoanContract {
    @Id
    private Long loanRequestId;
    private Date signDate;
    private boolean isSigned;

    public Long getLoanRequestId() {
        return loanRequestId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setLoanRequestId(Long loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public static LoanContractBuilder newLoanContractBuilder() {
        return new LoanContract().new LoanContractBuilder();
    }

    public class LoanContractBuilder {

        private LoanContractBuilder() {
        }

        public LoanContractBuilder withLoanRequestId(Long loanRequestId) {
            LoanContract.this.loanRequestId = loanRequestId;
            return this;
        }

        public LoanContractBuilder withSignDate(Date signDate) {
            LoanContract.this.signDate = signDate;
            return this;
        }

        public LoanContractBuilder withSigned(boolean signed) {
            LoanContract.this.isSigned = signed;
            return this;
        }

        public LoanContract build() {
            return LoanContract.this;
        }
    }
}
