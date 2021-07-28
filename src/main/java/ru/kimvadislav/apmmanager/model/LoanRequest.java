package ru.kimvadislav.apmmanager.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name = "requests")
public class LoanRequest {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String passportSeries;
    private String passportNumber;
    private String maritalStatus;
    private String registrationAddress;
    private String phoneNumber;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date dayEmployment;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date dayDismissal;
    private String jobPosition;
    private String organizationName;
    private BigDecimal loanAmount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDayEmployment() {
        return dayEmployment;
    }

    public Date getDayDismissal() {
        return dayDismissal;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDayEmployment(Date dayEmployment) {
        this.dayEmployment = dayEmployment;
    }

    public void setDayDismissal(Date dayDismissal) {
        this.dayDismissal = dayDismissal;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public static LoanRequestBuilder newLoanRequestBuilder() {
        return new LoanRequest().new LoanRequestBuilder();
    }

    public class LoanRequestBuilder {

        private LoanRequestBuilder() {
        }

        public LoanRequestBuilder setId(Long id) {
            LoanRequest.this.id = id;
            return this;
        }

        public LoanRequestBuilder withName(String name) {
            LoanRequest.this.name = name;
            return this;
        }

        public LoanRequestBuilder withSurname(String surname) {
            LoanRequest.this.surname = surname;
            return this;
        }

        public LoanRequestBuilder withPatronymic(String patronymic) {
            LoanRequest.this.patronymic = patronymic;
            return this;
        }

        public LoanRequestBuilder withPassportSeries(String passportSeries) {
            LoanRequest.this.passportSeries = passportSeries;
            return this;
        }

        public LoanRequestBuilder withPassportNumber(String passportNumber) {
            LoanRequest.this.passportNumber = passportNumber;
            return this;
        }

        public LoanRequestBuilder withMaritalStatus(String maritalStatus) {
            LoanRequest.this.maritalStatus = maritalStatus;
            return this;
        }

        public LoanRequestBuilder withRegistrationAddress(String registrationAddress) {
            LoanRequest.this.registrationAddress = registrationAddress;
            return this;
        }

        public LoanRequestBuilder withPhoneNumber(String phoneNumber) {
            LoanRequest.this.phoneNumber = phoneNumber;
            return this;
        }

        public LoanRequestBuilder withDayEmployment(Date dayEmployment) {
            LoanRequest.this.dayEmployment = dayEmployment;
            return this;
        }

        public LoanRequestBuilder withDayDismissal(Date dayDismissal) {
            LoanRequest.this.dayDismissal = dayDismissal;
            return this;
        }

        public LoanRequestBuilder withJobPosition(String jobPosition) {
            LoanRequest.this.jobPosition = jobPosition;
            return this;
        }

        public LoanRequestBuilder withOrganizationName(String organizationName) {
            LoanRequest.this.organizationName = organizationName;
            return this;
        }

        public LoanRequestBuilder withLoanAmount(BigDecimal loanAmount) {
            LoanRequest.this.loanAmount = loanAmount;
            return this;
        }

        public LoanRequest build() {
            return LoanRequest.this;
        }
    }
}
