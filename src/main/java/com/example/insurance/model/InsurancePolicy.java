package com.example.insurance.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Клас страхового полісу.
 */
public class InsurancePolicy {
    private String firstName;
    private String lastName;
    private int age;
    private double insuranceAmount;
    private String insuranceType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String policyNumber;
    private boolean active;
    
    public InsurancePolicy() {
    }
    
    // Getters
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getInsuranceAmount() {
        return insuranceAmount;
    }
    
    public String getInsuranceType() {
        return insuranceType;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public boolean isActive() {
        return active;
    }
    
    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }
    
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString() {
        return String.format(
            "InsurancePolicy[firstName='%s', lastName='%s', age=%d, insuranceAmount=%.2f, insuranceType='%s', startDate=%s, endDate=%s, policyNumber='%s', active=%s]",
            firstName, lastName, age, insuranceAmount, insuranceType, startDate, endDate, policyNumber, active
        );
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return age == that.age &&
               Double.compare(that.insuranceAmount, insuranceAmount) == 0 &&
               active == that.active &&
               Objects.equals(firstName, that.firstName) &&
               Objects.equals(lastName, that.lastName) &&
               Objects.equals(insuranceType, that.insuranceType) &&
               Objects.equals(startDate, that.startDate) &&
               Objects.equals(endDate, that.endDate) &&
               Objects.equals(policyNumber, that.policyNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, insuranceAmount, insuranceType, startDate, endDate, policyNumber, active);
    }
}

