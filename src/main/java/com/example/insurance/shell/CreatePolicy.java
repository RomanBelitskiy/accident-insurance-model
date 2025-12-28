package com.example.insurance.shell;

import com.example.insurance.model.InsurancePolicy;
import com.example.insurance.model.InsurancePolicyBuilder;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Команда для створення нового страхового полісу з використанням Builder pattern.
 */
public class CreatePolicy implements Command {
    
    private final Scanner scanner;
    
    /**
     * Конструктор команди CreatePolicy.
     * 
     * @param scanner Scanner для читання вводу користувача
     */
    public CreatePolicy(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    public Result execute() {
        System.out.println("Creating a new insurance policy...");
        
        try {
            // Використання Builder pattern для створення полісу
            InsurancePolicy policy = InsurancePolicyBuilder.create()
                    .firstName("John")
                    .lastName("Doe")
                    .age(30)
                    .insuranceAmount(100000.0)
                    .insuranceType("accident")
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusYears(1))
                    .policyNumber("POL-" + System.currentTimeMillis())
                    .active(true)
                    .build();
            
            System.out.println("Insurance policy created successfully:");
            System.out.println(policy);
            
        } catch (RuntimeException e) {
            System.out.println("Error creating policy: " + e.getMessage());
        }
        
        return Result.CONTINUE;
    }
    
    @Override
    public String name() {
        return "create";
    }
}

