package Intarface;

import DataBase.Data;
import DataBase.Encryption;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Check {
    static Path path = Paths.get(userData);
    static String upperCaseChars = "(.[A-Z].)";
    static String lowerCaseChars = "(.[a-z].)";
    static String numbers = "(.[0-9].)";
    static String specialChars = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";

    public static void checkAuthorization() {
        out.println("Ваш логін:");
        Data.setLogin(scanner.nextLine());
        out.println("Ваш пароль");
        Data.setPassword(scanner.nextLine());
        try (FileReader reader = new FileReader(Data.userData)) {
            Scanner scan = new Scanner(reader);
            if (Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8)
                    .anyMatch(Data.getLogin()::equals) || Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8).anyMatch(Data.getPassword()::equals)) {
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

    public static void loginValidation() throws IOException {
        boolean validLogin = true;
        Path path = Paths.get(userData);
        if (getNewLogin().length() > 30 || getNewLogin().length() < 8) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |");
            validLogin = false;
        }
        if (Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8).anyMatch(Data.getNewLogin()::equals)) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Користувач з таким логіном існує.                                 |" + "\n" +
                    "|------------------------------------------------------------------|" + "\n");
            validLogin = false;
        }
        if (validLogin) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Data.userData))) {
                Encryption.EncryptionLogin();
                writer.append("-----------------------------------------------------" + "\n" +
                        "Логін: " + getNewLogin() + "\n");
                writer.close();
                out.println("Логін підібрано успішно!");
            } catch (Exception exception) {
                out.println("Пусто");
            }
        } else {
            out.println("Спробуйте вибрати логін ще раз.");
            setNewLogin(scanner.nextLine());
            loginValidation();
        }
    }

    public static void passwordValidation() {
        boolean validPassword = true;
        if (getNewPassword().length() > 30 || getNewPassword().length() < 8) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Довжина пароля повинна бути менше 30 і більше 8 символів.         |");
            validPassword = false;
        }
        if (getNewPassword().equals(getNewLogin())) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Пароль не повинен збігатися з іменем користувача.                 |");
            validPassword = false;
        }
        if (!getNewPassword().matches(upperCaseChars)) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Пароль має містити принаймні одну літеру верхнього регістру.      |");
            validPassword = false;
        }
        if (!getNewPassword().matches(lowerCaseChars)) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Пароль має містити принаймні одну букву нижнього регістру.        |");
            validPassword = false;
        }
        if (!getNewPassword().matches(numbers)) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Пароль повинен містити хоча б одну цифру.                         |");
            validPassword = false;
        }
        if (!getNewPassword().matches(specialChars)) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Пароль повинен містити принаймні один спеціальний символ.         |" + "\n" +
                    "|------------------------------------------------------------------|");
            validPassword = false;
        }
        if (validPassword) {
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                Encryption.EncryptionPassword();
                writer.append("Пароль: " + getNewPassword() + "\n");
                writer.close();
                out.println("Пароль підібрано успішно!");
            } catch (Exception exception) {
                out.println("Пусто");
            }
        } else {
            out.println("Спробуйте увести пароль ще раз.");
            setNewPassword(scanner.nextLine());
            passwordValidation();
        }
    }
}
