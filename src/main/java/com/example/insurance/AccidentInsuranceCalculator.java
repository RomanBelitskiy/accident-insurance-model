package com.example.insurance;

/**
 * Клас для розрахунку страхування від нещасних випадків.
 * Перша версія бізнес-логіки.
 */
public class AccidentInsuranceCalculator {
    
    private static final double BASE_PREMIUM_RATE = 0.02; // 2% базовий тариф
    
    /**
     * Розраховує страхову премію на основі страхової суми.
     * 
     * @param insuranceAmount страхова сума
     * @return розрахована страхова премія
     * @throws IllegalArgumentException якщо страхова сума <= 0
     */
    public double calculatePremium(double insuranceAmount) {
        if (insuranceAmount <= 0) {
            throw new IllegalArgumentException("Страхова сума повинна бути більше 0");
        }
        return insuranceAmount * BASE_PREMIUM_RATE;
    }
    
    /**
     * Розраховує виплату при настанні страхового випадку.
     * 
     * @param insuranceAmount страхова сума
     * @param damageAmount сума збитку
     * @return розрахована виплата
     * @throws IllegalArgumentException якщо параметри некоректні
     */
    public double calculatePayout(double insuranceAmount, double damageAmount) {
        if (insuranceAmount <= 0) {
            throw new IllegalArgumentException("Страхова сума повинна бути більше 0");
        }
        if (damageAmount < 0) {
            throw new IllegalArgumentException("Сума збитку не може бути від'ємною");
        }
        // Виплата не може перевищувати страхову суму
        return Math.min(damageAmount, insuranceAmount);
    }
}

