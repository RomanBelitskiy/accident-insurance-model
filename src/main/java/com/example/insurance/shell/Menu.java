package com.example.insurance.shell;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Меню команд (Composite pattern).
 * Меню може містити інші команди, включаючи інші меню.
 */
public class Menu implements Command {
    
    private final String name;
    private final Scanner scanner;
    private final Map<String, Command> commands = new HashMap<>();
    
    /**
     * Конструктор меню.
     * 
     * @param name назва меню
     * @param scanner Scanner для читання вводу користувача
     */
    public Menu(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }
    
    /**
     * Додає команду до меню.
     * 
     * @param command команда для додавання
     */
    public void add(Command command) {
        commands.put(command.name(), command);
    }
    
    @Override
    public Result execute() {
        if (commands.isEmpty()) {
            System.out.println("Menu is empty. Returning");
            return Result.CONTINUE;
        }
        
        Result result;
        do {
            result = Result.CONTINUE;
            prompt();
            String commandName = scanner.nextLine();
            Command command = commands.get(commandName);
            
            if (command != null) {
                result = command.execute();
            } else {
                System.out.println("Command not found. Try again");
            }
        } while (result == Result.CONTINUE);
        
        return result == Result.EXIT ? Result.EXIT : Result.CONTINUE;
    }
    
    @Override
    public String name() {
        return name;
    }
    
    /**
     * Виводить підказку зі списком доступних команд.
     */
    private void prompt() {
        String commandNames = String.join(", ", commands.keySet());
        System.out.println("Enter one of the commands: " + commandNames);
        System.out.print(">");
    }
}

