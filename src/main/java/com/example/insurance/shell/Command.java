package com.example.insurance.shell;

/**
 * Інтерфейс для команд shell.
 */
public interface Command {
    /**
     * Виконує команду.
     * 
     * @return результат виконання команди
     */
    Result execute();
    
    /**
     * Повертає назву команди.
     * 
     * @return назва команди
     */
    String name();
}

