package com.example.insurance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Клас для розрахунку страхування від нещасних випадків.
 * Перша версія бізнес-логіки.
 */
public class AccidentInsuranceCalculator {
    
    private static final Logger logger = LogManager.getLogger(AccidentInsuranceCalculator.class);
    private static final double BASE_PREMIUM_RATE = 0.02; // 2% базовий тариф
    
    /**
     * Розраховує страхову премію на основі страхової суми.
     * 
     * @param insuranceAmount страхова сума
     * @return розрахована страхова премія
     * @throws IllegalArgumentException якщо страхова сума <= 0
     */
    public double calculatePremium(double insuranceAmount) {
        logger.info("Розрахунок страхової премії для суми: {}", insuranceAmount);
        
        if (insuranceAmount <= 0) {
            logger.error("Невалідна страхова сума: {} (має бути > 0)", insuranceAmount);
            throw new IllegalArgumentException("Страхова сума повинна бути більше 0");
        }
        
        double premium = insuranceAmount * BASE_PREMIUM_RATE;
        logger.debug("Розрахована премія: {} ({}% від {})", premium, BASE_PREMIUM_RATE * 100, insuranceAmount);
        logger.info("Розрахунок премії завершено: {}", premium);
        
        return premium;
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
        logger.info("Розрахунок виплати: страхова сума={}, збиток={}", insuranceAmount, damageAmount);
        
        if (insuranceAmount <= 0) {
            logger.error("Невалідна страхова сума: {} (має бути > 0)", insuranceAmount);
            throw new IllegalArgumentException("Страхова сума повинна бути більше 0");
        }
        
        if (damageAmount < 0) {
            logger.error("Невалідна сума збитку: {} (не може бути від'ємною)", damageAmount);
            throw new IllegalArgumentException("Сума збитку не може бути від'ємною");
        }
        
        // Виплата не може перевищувати страхову суму
        double payout = Math.min(damageAmount, insuranceAmount);
        
        if (damageAmount > insuranceAmount) {
            logger.warn("Збиток ({}) перевищує страхову суму ({}), виплата обмежена: {}", 
                    damageAmount, insuranceAmount, payout);
        } else {
            logger.debug("Виплата: {} (збиток не перевищує страхову суму)", payout);
        }
        
        logger.info("Розрахунок виплати завершено: {}", payout);
        return payout;
    }
}
