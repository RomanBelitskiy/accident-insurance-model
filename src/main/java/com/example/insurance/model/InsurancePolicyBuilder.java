package com.example.insurance.model;

import java.time.LocalDate;

/**
 * Builder для створення InsurancePolicy об'єктів (Builder pattern).
 */
public class InsurancePolicyBuilder {
    
    private InsurancePolicy policy = new InsurancePolicy();
    
    /**
     * Конструктор, встановлює значення за замовчуванням.
     */
    public InsurancePolicyBuilder() {
        policy.setActive(true);
        policy.setAge(0);
        policy.setInsuranceAmount(0.0);
        policy.setFirstName("noname");
        policy.setLastName("noname");
        policy.setInsuranceType("accident");
    }
    
    /**
     * Статичний метод для створення builder.
     * 
     * @return новий InsurancePolicyBuilder
     */
    public static InsurancePolicyBuilder create() {
        return new InsurancePolicyBuilder();
    }
    
    /**
     * Встановлює ім'я.
     */
    public InsurancePolicyBuilder firstName(String firstName) {
        policy.setFirstName(firstName);
        return this;
    }
    
    /**
     * Встановлює прізвище.
     */
    public InsurancePolicyBuilder lastName(String lastName) {
        policy.setLastName(lastName);
        return this;
    }
    
    /**
     * Встановлює вік.
     */
    public InsurancePolicyBuilder age(int age) {
        policy.setAge(age);
        return this;
    }
    
    /**
     * Встановлює страхову суму.
     */
    public InsurancePolicyBuilder insuranceAmount(double insuranceAmount) {
        policy.setInsuranceAmount(insuranceAmount);
        return this;
    }
    
    /**
     * Встановлює тип страхування.
     */
    public InsurancePolicyBuilder insuranceType(String insuranceType) {
        policy.setInsuranceType(insuranceType);
        return this;
    }
    
    /**
     * Встановлює дату початку.
     */
    public InsurancePolicyBuilder startDate(LocalDate startDate) {
        policy.setStartDate(startDate);
        return this;
    }
    
    /**
     * Встановлює дату закінчення.
     */
    public InsurancePolicyBuilder endDate(LocalDate endDate) {
        policy.setEndDate(endDate);
        return this;
    }
    
    /**
     * Встановлює номер полісу.
     */
    public InsurancePolicyBuilder policyNumber(String policyNumber) {
        policy.setPolicyNumber(policyNumber);
        return this;
    }
    
    /**
     * Встановлює статус активності.
     */
    public InsurancePolicyBuilder active(boolean active) {
        policy.setActive(active);
        return this;
    }
    
    /**
     * Створює InsurancePolicy об'єкт з валідацією.
     * 
     * @return створений InsurancePolicy
     * @throws RuntimeException якщо дані некоректні
     */
    public InsurancePolicy build() {
        if (policy.getAge() < 0) {
            throw new RuntimeException("Age cannot be negative");
        }
        if (policy.getFirstName() == null || policy.getFirstName().trim().isEmpty()) {
            throw new RuntimeException("First name is required");
        }
        if (policy.getLastName() == null || policy.getLastName().trim().isEmpty()) {
            throw new RuntimeException("Last name is required");
        }
        if (policy.getInsuranceAmount() < 0) {
            throw new RuntimeException("Insurance amount cannot be negative");
        }
        if (policy.getStartDate() != null && policy.getEndDate() != null) {
            if (policy.getEndDate().isBefore(policy.getStartDate())) {
                throw new RuntimeException("End date cannot be before start date");
            }
        }
        
        return policy;
    }
}

