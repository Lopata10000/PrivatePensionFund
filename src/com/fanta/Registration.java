package com.fanta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.fanta.Authorization.scanner;
import static com.fanta.LogIn.*;
import static java.lang.System.out;

public class Registration {
    public static void registration() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData))) {
            out.println("Вибери логін");
            setNewLogin(scanner.nextLine());
            out.println("Вибери пароль");
            setNewPassword(scanner.nextLine());
            writer.append("-----------------------------------------------------" + "\n" +
                    "Логін: " + getNewLogin() + "\n" +
                    "Пароль: " + getNewPassword() + "\n");
            writer.close();
            out.println("Успішно");
        } catch (Exception exception) {
            out.println("Пусто");
        }
    }
}
