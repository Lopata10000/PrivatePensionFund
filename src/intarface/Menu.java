package intarface;

import businessLogic.userActions.getLine;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static businessLogic.adminActions.AdminActions.*;
import static businessLogic.authentication.Authorization.authorization;
import static businessLogic.authentication.Registration.registration;
import static businessLogic.userActions.ActionsWithData.*;
import static businessLogic.userActions.Calculator.Calculations;
import static dataBase.Data.getNewLogin;
import static java.lang.System.out;

public class Menu implements getLine {
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"DM_DEFAULT_ENCODING" , "DM_DEFAULT_ENCODING"})
    public static final Scanner scanner = new Scanner(System.in);
    static String command;
    public static final String uKnowActions = "Незрозуміла опція";

    public static void mainMenu() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        clearConsole();
        out.println("""

                |--======================================================================-- Пенсійний фонд ''Чахлики'' --========================================================================--|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1: Авторизуватися  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~2: Зареєструватися ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~3:   Калькулятор   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~4:     Про нас     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~5:      Вихід      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                                                         ▒▒▒▒▒▒▒▒▒▒▒▄▄▄▄░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒▒▒▒▒▒▄██████▒▒▒▒▒▄▄▄█▄▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒▒▒▒▄██▀░░▀██▄▒▒▒▒████████▄▒▒▒▒▒▒
                                                                                         ▒▒▒▒▒▒███░░░░░░██▒▒▒▒▒▒█▀▀▀▀▀██▄▄▒▒▒
                                                                                         ▒▒▒▒▒▄██▌░░░░░░░██▒▒▒▒▐▌▒▒▒▒▒▒▒▒▀█▄▒
                                                                                         ▒▒▒▒▒███░░▐█░█▌░██▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▀▌
                                                                                         ▒▒▒▒████░▐█▌░▐█▌██▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▐████░▐░░░░░▌██▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒████░░░▄█░░░██▒▒▐█▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒████░░░██░░██▌▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒████▌░▐█░░███▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒▐████░░▌░███▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒▒▒████░░░███▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▒▒██████▌░████▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒▐████████████▒▒███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ▒█████████████▄████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         █████████████████▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         █████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                                                                         ████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                """);
        command = scanner.nextLine();
        switch (command) {
            case "1" -> authorization();
            case "2" -> registration();
            case "3" -> Calculations();
            case "4" -> informationAboutUs();
            case "5" -> System.exit(0);
            default -> {
                out.println(uKnowActions);
                Menu.mainMenu();
            }
        }
    }

    public static void actionsWithAccounts() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        clearConsole();
        out.println("|------------------------------------------------------------------|" + "\n" +
                "| Ви увійшли як: " + getNewLogin() + "|" + "\n" +
                dividingLine + "\n" +
                dividingLine + "\n" +
                "|Що ви бажаєте зробити?                                            |" + "\n" +
                dividingLine + "\n" +
                "|1: Створити вклад.                                                |" + "\n" +
                dividingLine + "\n" +
                "|2: Переглянути вклад.                                             |" + "\n" +
                dividingLine + "\n" +
                "|3: Вирахувати пенсійні накопичення.                               |" + "\n" +
                dividingLine + "\n" +
                "|4: Вийти.                                                         |" + "\n" +
                dividingLine + "\n");
        command = scanner.nextLine();

        switch (command) {
            case "1" -> addDeposit();
            case "2" -> viewDeposit();
            case "3" -> Calculations();
            case "4" -> Menu.mainMenu();
            default -> {
                out.println(uKnowActions);
                Menu.mainMenu();
            }
        }
    }

    @SuppressFBWarnings("SF_SWITCH_FALLTHROUGH")
    public static void adminMenu() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        clearConsole();
        out.printf("| Ви ввійшли як: " + getNewLogin() + "|" + "\n" +
                dividingLine + "\n" +
                "|Що ви бажаєте зробити? |" + "\n" +
                dividingLine + "\n" +
                "|1: Переглянути користувачів. |" + "\n" +
                dividingLine + "\n" +
                "|2: Видалити дані. |" + "\n" +
                dividingLine + "\n" +
                "|3: Відредагувати дані. |" + "\n" +
                dividingLine + "\n" +
                "|4: Додати користувача. |" + "\n" +
                dividingLine + "\n" +
                "|5: Змінити дані про фонд. |" + "\n" +
                dividingLine + "\n" +
                "|6: Вийти |" + "\n" +
                dividingLine);
        command = scanner.nextLine();

        switch (command) {
            case "1" -> veiwList();
            case "2" -> deleadUser();
            case "3" -> rewu();
            case "4" -> registration();
            case "5" -> changeInformationAboutUs();
            case "6" -> mainMenu();
            default -> {
                out.println(uKnowActions);
                Menu.mainMenu();
            }
        }
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}