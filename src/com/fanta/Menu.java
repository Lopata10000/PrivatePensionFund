package com.fanta;

import java.util.Scanner;

public class Menu {
    public static void mainMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command;

        do{
            System.out.println("Салам братку! Чого бажаєш?");
            System.out.println("1: Авторизуватися");
            System.out.println("2: Зареєструватися");
            System.out.println("3: Калькулятор");
            System.out.println("4: Вихід");

            command = scanner.nextLine();

            switch (command){

                case "1":
                    Authorization.authorization();
                    break;
                case "2":
                    Registration.registration();
                    break;
                case "3":
                    Calculator.Calculations();
                    break;
                case "4":
                    break;

                default:
                    System.out.println("Непоняль");
            }
        }

        while(!command.equals("4"));
    }
}
