package com.example.insurance.shell;

/**
 * Команда для повернення до попереднього меню.
 */
public class Return implements Command {
    
    @Override
    public Result execute() {
        return Result.RETURN;
    }
    
    @Override
    public String name() {
        return "return";
    }
}

