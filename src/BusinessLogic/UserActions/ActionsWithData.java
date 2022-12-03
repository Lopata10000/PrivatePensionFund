package BusinessLogic.UserActions;

import BusinessLogic.Authentication.Authorization;
import BusinessLogic.Authentication.Validation;
import DataBase.Encryption;
import Intarface.Menu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static DataBase.Data.*;
import static java.lang.System.out;

public class ActionsWithData {
    public static void checkAuthorization() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        try (
                FileReader reader = new FileReader(userData)) {
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("Login: " + getNewLogin())::equals)
                    && Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("Password: " + getNewPassword())::equals)
                    && Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("E-mail: " + getGmail())::equals)) {
                if (getNewLogin().equals("FantaPetro"))
                    Menu.AdminMenu();
                else
                    Menu.ActionsWithAccounts();
            } else {
                out.println("|------------------------------------------------------------------|" + "\n" +
                        "|Такого акаунту немає.                                             |" + "\n" +
                        "|------------------------------------------------------------------|");
                Authorization.Authorization();
            }
        }
    }

    public static void saveUser() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData , true))) {
            Encryption.EncryptionPassword();
            writer.append("|------------------------------------------------------------------|" + "\n" +
                    "Login: " + getNewLogin() + "\n" +
                    "E-mail: " + getGmail() + "\n" +
                    "Password: " + getNewPassword() + "\n");
            writer.close();
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Вас зареєстровано успішно!                                        |" + "\n" +
                    "|------------------------------------------------------------------|");
            if (getNewLogin().equals("FantaPetro"))
                Menu.AdminMenu();
            else
                Menu.ActionsWithAccounts();
            Menu.ActionsWithAccounts();
        }
    }

    public static void addDeposit() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Validation.contributionsValidation();
        Validation.ageValidation();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(userData) , StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals("Password: " + getPassword())) {
                fileContent.set(i , "Password: " + getPassword() + "\n" + "Age: " + getAge() + "\n" + " Deposit: " + getInitialСontribution() + "Time: " + formatter);
                break;
            }
        }
        Files.write(Path.of(userData) , fileContent , StandardCharsets.UTF_8);
        Menu.ActionsWithAccounts();
    }

    public static void changeInformationAboutUs() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Нова інформація:                                                  |" + "\n" +
                "|------------------------------------------------------------------|");
        String newInformationAboutUs = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(informationAboutUs , false))) {
            writer.write("|------------------------------------------------------------------|" + "\n" +
                    newInformationAboutUs);
            writer.close();
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Дані змінено успішно!                                             |" + "\n" +
                    "|------------------------------------------------------------------|");
            Menu.AdminMenu();
        }
    }

    public static void informationAboutUs() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if (Files.exists((Path.of(informationAboutUs)))) {
            FileReader reader = new FileReader(informationAboutUs);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            Menu.mainMenu();

        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(informationAboutUs , true))) {
                writer.write("|--======================================================================-- Пенсійний фонд ''Чахлики'' --========================================================================--|" + "\n" +
                        "Ми - це пенсій фонд із великим досвідом. У сфері з 2000 року. Ми надаємо можливість відкласти гроші під 8% до моменту виходу на Вашу пенсію.");
                informationAboutUs();
            }
            Menu.mainMenu();
        }
    }


    public static double compoundInterest(double InitialСontribution1) {
        int RegularСontribution = Integer.parseInt(getRegularСontributions());
        int age = Integer.parseInt(getAge());
        int pensionAge = (getRetirementAge() - age);
        for (int i = 1; i < pensionAge; i++) {
            InitialСontribution1 = InitialСontribution1 + RegularСontribution;
            InitialСontribution1 = (InitialСontribution1 * (1.1));
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|За " + i + " рік|" + "\n" +
                    "|------------------------------------------------------------------|" + "\n" +
                    "|" + Math.round(InitialСontribution1) + "|");
        }
        return InitialСontribution1;
    }
}
