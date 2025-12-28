package com.example.insurance.shell;

/**
 * Команда для виведення допомоги.
 */
public class Help implements Command {
    
    private final String description;
    
    /**
     * Конструктор команди Help.
     * 
     * @param description опис, який буде виведено
     */
    public Help(String description) {
        this.description = description;
    }
    
    @Override
    public Result execute() {
        System.out.println(description);
        return Result.CONTINUE;
    }
    
    @Override
    public String name() {
        return "help";
    }
}

