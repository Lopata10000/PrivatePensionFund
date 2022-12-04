package businessLogic.userActions;

import businessLogic.authentication.Authorization;
import businessLogic.authentication.Validation;
import dataBase.Data;
import intarface.Menu;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static java.nio.file.Files.lines;

@SuppressWarnings({"resource" , "NonAsciiCharacters"})
public class ActionsWithData extends Data implements getLine {
    private static final String password = "Password: ";

    public static void checkAuthorization() {
        try {
            Path path = Paths.get(userData);
            if (lines(path , StandardCharsets.UTF_8).noneMatch(("Login: " + getNewLogin())::equals)) {
                out.println(dividingLine + "\n" +
                        "|Такого акаунту немає.                                             |" + "\n" +
                        dividingLine);
                Authorization.authorization();
            } else {
                if (lines(path , StandardCharsets.UTF_8).noneMatch((password + getNewPassword())::equals) || lines(path , StandardCharsets.UTF_8).noneMatch(("E-mail: " + getGmail())::equals)) {
                    out.println(dividingLine + "\n" +
                            "|Такого акаунту немає.                                             |" + "\n" +
                            dividingLine);
                    Authorization.authorization();
                } else {
                    if (getNewLogin().equals("FantaPetro"))
                        Menu.adminMenu();
                    else
                        Menu.actionsWithAccounts();
                }
            }
        } catch (Exception ex) {
            out.println("Немає даних");
        }
    }
    public static void addDeposit() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Validation.contributionsValidation();
        Validation.ageValidation();
        Date date = new Date();
        Path of = Path.of(userData);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(of , StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(password + getPassword())) {
                fileContent.set(i , password + getPassword() + "\n" + "Age: " + getAge() + "\n" + "Deposit: " + getInitialСontribution() + " Time: " + date);
                break;
            }
        }
        Files.write(of , fileContent , StandardCharsets.UTF_8);
        Menu.actionsWithAccounts();
    }

    public static void changeInformationAboutUs() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println(dividingLine + "\n" +
                "|Нова інформація:                                                  |" + "\n" +
                dividingLine);
        String newInformationAboutUs = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(informationAboutUs , false))) {
            writer.write(dividingLine + "\n" +
                    newInformationAboutUs);
            out.println(dividingLine + "\n" +
                    "|Дані змінено успішно!                                             |" + "\n" +
                    dividingLine);
            Menu.adminMenu();
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

    public static void viewDeposit() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(userData) , StandardCharsets.UTF_8));
        int number = 2;
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(password + getNewPassword())) {
                number += i;
                out.println(fileContent.get(i + 2));
                break;
            }
        }
        Menu.actionsWithAccounts();
    }
}
