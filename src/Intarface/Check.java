package Intarface;

import DataBase.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Check {
    public static void checkDataRegistration() {
        out.println("Виберіть логін:");
        Data.setNewLogin(scanner.nextLine());
        while (true) {
            if (!(newLogin.length() > 8))
                out.println("Мінімальна довжина паролю 8 символів");
            else break;
            out.println("Виберіть пароль:");
            Data.setNewPassword(scanner.nextLine());
            if (!(newPassword.length() > 8))
                out.println("Мінімальна довжина паролю 8 символів");
            else break;
        }
//        if (Data.newLogin.length() <= 8) {
//            out.println("" +
//                    "\n" + "Уведіть логін");
//        } else {
//            out.println("Виберіть пароль:");
//            Data.setNewPassword(scanner.nextLine());
//            if (Data.newPassword.length() <= 8) {
//                out.println("Мінімальна довжина паролю 8 символів");
//                Data.setConfirmRegistration(false);
//            } else {
//                out.println("Підтвердіть пароль:");
//                Check.checkDataRegistration();
//                if (Data.ConfirmPassword != Data.newPassword) {
//                    out.println("Паролі не співпадають");
//                    Data.setConfirmRegistration(false);
//                } else {
//                    Data.setConfirmRegistration(true);
//                }
//            }
    }

    public static void checkAuthorization() {
        out.println("Ваш логін:");
        Data.setLogin(scanner.nextLine());
        out.println("Ваш пароль");
        Data.setPassword(scanner.nextLine());
        try (FileReader reader = new FileReader(Data.userData)) {
            Scanner scan = new Scanner(reader);
            if (Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8)
                    .anyMatch(Data.getLogin()::equals) && Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8).anyMatch(Data.getPassword()::equals)) {
                out.println("Такий акаунт знайдено");
            } else {
                out.println("Такого акаунту немає");
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
