package com.example.insurance;

import com.example.insurance.shell.*;

import java.util.Scanner;

/**
 * Головний клас додатку для моделі страхування від нещасних випадків.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello! It is a new project!!!");
        
        Scanner scanner = new Scanner(System.in);
        
        // Створення базових команд
        Return returnCommand = new Return();
        Exit exitCommand = new Exit();
        
        // Створення головного меню
        Menu mainMenu = new Menu("main", scanner);
        mainMenu.add(returnCommand);
        mainMenu.add(exitCommand);
        mainMenu.add(new Help("This is the main menu. Available commands: return, exit, help, policy"));
        
        // Створення підменю для роботи з полісами
        Menu policyMenu = new Menu("policy", scanner);
        policyMenu.add(returnCommand);
        policyMenu.add(exitCommand);
        policyMenu.add(new CreatePolicy(scanner));
        policyMenu.add(new Help("This is the policy menu. Available commands: return, exit, help, create"));
        
        // Додавання підменю до головного меню
        mainMenu.add(policyMenu);
        
        // Запуск shell
        mainMenu.execute();
        
        scanner.close();
    }
}

