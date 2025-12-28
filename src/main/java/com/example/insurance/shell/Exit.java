package com.example.insurance.shell;

/**
 * Команда для виходу з програми.
 */
public class Exit implements Command {
    
    @Override
    public Result execute() {
        return Result.EXIT;
    }
    
    @Override
    public String name() {
        return "exit";
    }
}

