package com.example.insurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Тести для класу AccidentInsuranceCalculator з використанням Mockito.
 */
@ExtendWith(MockitoExtension.class)
class AccidentInsuranceCalculatorTest {
    
    @Spy
    private AccidentInsuranceCalculator calculator;
    
    @BeforeEach
    void setUp() {
        // Якщо не використовуєш @Spy, створи екземпляр вручну
        if (calculator == null) {
            calculator = new AccidentInsuranceCalculator();
        }
    }
    
    @Test
    void testCalculatePremium_ValidAmount() {
        double insuranceAmount = 100000.0;
        double expectedPremium = 2000.0; // 2% від 100000
        double actualPremium = calculator.calculatePremium(insuranceAmount);
        
        assertEquals(expectedPremium, actualPremium, 0.01, 
            "Премія повинна бути 2% від страхової суми");
        
        // Перевірка, що метод викликався
        verify(calculator, times(1)).calculatePremium(insuranceAmount);
    }
    
    @Test
    void testCalculatePremium_WithSpy() {
        // Використання spy для перевірки викликів методів
        AccidentInsuranceCalculator spyCalculator = spy(new AccidentInsuranceCalculator());
        
        double insuranceAmount = 100000.0;
        double result = spyCalculator.calculatePremium(insuranceAmount);
        
        assertEquals(2000.0, result, 0.01);
        verify(spyCalculator).calculatePremium(insuranceAmount);
    }
    
    @Test
    void testCalculatePremium_ZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePremium(0);
        }, "Повинен бути викинутий виняток для нульової суми");
        
        verify(calculator, times(1)).calculatePremium(0);
    }
    
    @Test
    void testCalculatePremium_NegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePremium(-1000);
        }, "Повинен бути викинутий виняток для від'ємної суми");
        
        verify(calculator, times(1)).calculatePremium(-1000);
    }
    
    @Test
    void testCalculatePayout_DamageLessThanInsurance() {
        double insuranceAmount = 100000.0;
        double damageAmount = 50000.0;
        double expectedPayout = 50000.0;
        double actualPayout = calculator.calculatePayout(insuranceAmount, damageAmount);
        
        assertEquals(expectedPayout, actualPayout, 0.01,
            "Виплата повинна дорівнювати сумі збитку, якщо вона менша за страхову суму");
        
        verify(calculator).calculatePayout(insuranceAmount, damageAmount);
    }
    
    @Test
    void testCalculatePayout_DamageGreaterThanInsurance() {
        double insuranceAmount = 100000.0;
        double damageAmount = 150000.0;
        double expectedPayout = 100000.0; // Не більше страхової суми
        double actualPayout = calculator.calculatePayout(insuranceAmount, damageAmount);
        
        assertEquals(expectedPayout, actualPayout, 0.01,
            "Виплата не повинна перевищувати страхову суму");
        
        verify(calculator).calculatePayout(insuranceAmount, damageAmount);
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
        
        verify(calculator).calculatePayout(0, 10000);
    }
    
    @Test
    void testCalculatePayout_NegativeDamage() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculatePayout(100000, -5000);
        }, "Повинен бути викинутий виняток для від'ємної суми збитку");
        
        verify(calculator).calculatePayout(100000, -5000);
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
    
    @Test
    void testCalculatePayout_ArgumentCaptor() {
        // Приклад використання ArgumentCaptor для перевірки переданих параметрів
        AccidentInsuranceCalculator spyCalculator = spy(new AccidentInsuranceCalculator());
        
        double insuranceAmount = 50000.0;
        double damageAmount = 30000.0;
        
        spyCalculator.calculatePayout(insuranceAmount, damageAmount);
        
        // Перевірка, що метод викликався з правильними параметрами
        verify(spyCalculator).calculatePayout(eq(50000.0), eq(30000.0));
    }
    
    @Test
    void testCalculatePremium_SpyBehavior() {
        // Приклад використання spy з модифікацією поведінки
        AccidentInsuranceCalculator spyCalculator = spy(new AccidentInsuranceCalculator());
        
        // Викликати реальний метод
        double result = spyCalculator.calculatePremium(100000.0);
        assertEquals(2000.0, result, 0.01);
        
        // Перевірити кількість викликів
        verify(spyCalculator, atLeastOnce()).calculatePremium(anyDouble());
    }
}

