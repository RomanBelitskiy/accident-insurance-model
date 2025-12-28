package com.example.insurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тести для класу AccidentInsuranceCalculator.
 */
class AccidentInsuranceCalculatorTest {
    
    private AccidentInsuranceCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new AccidentInsuranceCalculator();
    }
    
    @Test
    void testCalculatePremium_ValidAmount() {
        double insuranceAmount = 100000.0;
        double expectedPremium = 2000.0; // 2% від 100000
        double actualPremium = calculator.calculatePremium(insuranceAmount);
        
        assertEquals(expectedPremium, actualPremium, 0.01, 
            "Премія повинна бути 2% від страхової суми");
    }
    
    @Test
    void testCalculatePremium_ZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePremium(0);
        }, "Повинен бути викинутий виняток для нульової суми");
    }
    
    @Test
    void testCalculatePremium_NegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePremium(-1000);
        }, "Повинен бути викинутий виняток для від'ємної суми");
    }
    
    @Test
    void testCalculatePayout_DamageLessThanInsurance() {
        double insuranceAmount = 100000.0;
        double damageAmount = 50000.0;
        double expectedPayout = 50000.0;
        double actualPayout = calculator.calculatePayout(insuranceAmount, damageAmount);
        
        assertEquals(expectedPayout, actualPayout, 0.01,
            "Виплата повинна дорівнювати сумі збитку, якщо вона менша за страхову суму");
    }
    
    @Test
    void testCalculatePayout_DamageGreaterThanInsurance() {
        double insuranceAmount = 100000.0;
        double damageAmount = 150000.0;
        double expectedPayout = 100000.0; // Не більше страхової суми
        double actualPayout = calculator.calculatePayout(insuranceAmount, damageAmount);
        
        assertEquals(expectedPayout, actualPayout, 0.01,
            "Виплата не повинна перевищувати страхову суму");
    }
    
    @Test
    void testCalculatePayout_DamageEqualsInsurance() {
        double insuranceAmount = 100000.0;
        double damageAmount = 100000.0;
        double expectedPayout = 100000.0;
        double actualPayout = calculator.calculatePayout(insuranceAmount, damageAmount);
        
        assertEquals(expectedPayout, actualPayout, 0.01,
            "Виплата повинна дорівнювати страховій сумі, коли збиток дорівнює страховій сумі");
    }
    
    @Test
    void testCalculatePayout_ZeroInsuranceAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePayout(0, 10000);
        }, "Повинен бути викинутий виняток для нульової страхової суми");
    }
    
    @Test
    void testCalculatePayout_NegativeDamage() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePayout(100000, -5000);
        }, "Повинен бути викинутий виняток для від'ємної суми збитку");
    }
    
    @Test
    void testCalculatePayout_ZeroDamage() {
        double insuranceAmount = 100000.0;
        double damageAmount = 0.0;
        double expectedPayout = 0.0;
        double actualPayout = calculator.calculatePayout(insuranceAmount, damageAmount);
        
        assertEquals(expectedPayout, actualPayout, 0.01,
            "Виплата повинна бути 0, коли збиток дорівнює 0");
    }
}



