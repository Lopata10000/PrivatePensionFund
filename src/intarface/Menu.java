package intarface;

import businessLogic.adminActions.AdminActions;
import businessLogic.authentication.Authorization;
import businessLogic.authentication.Registration;
import businessLogic.userActions.ActionsWithData;
import businessLogic.userActions.Calculator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static dataBase.Data.getNewLogin;
import static java.lang.System.out;

public class Menu {
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
    static Scanner scanner = new Scanner(System.in);
    static String command;

    public static void mainMenu() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
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
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|                                                                        
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
            case "1" -> Authorization.Authorization();
            case "2" -> Registration.registration();
            case "3" -> Calculator.Calculations();
            case "4" -> ActionsWithData.informationAboutUs();
            case "5" -> System.exit(0);
            default -> {
                out.println("Непоняль");
                Menu.mainMenu();
            }
        }
    }

    public static void actionsWithAccounts() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "| Ви увійшли як: " + getNewLogin() + "|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|Що ви бажаєте зробити?                                            |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|1: Створити вклад.                                                |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|2: Переглянути вклад.                                             |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|3: Вирахувати пенсійні накопичення.                               |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|4: Вийти.                                                         |" + "\n" +
                "|------------------------------------------------------------------|" + "\n");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                ActionsWithData.addDeposit();
                break;
            case "2":
                ActionsWithData.viewDeposit();
                break;
            case "4":
                Calculator.Calculations();
                break;
            case "5":
                Menu.mainMenu();
                break;


            default:
                out.println("Непоняль");
                Menu.mainMenu();
        }
    }

    public static void adminMenu() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "| Ви увійшли як: " + getNewLogin() + "|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|Що ви бажаєте зробити?                                            |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|1: Переглянути користувачів.                                      |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|2: Видалити дані.                                                 |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|3: Відредагувати дані.                                            |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|4: Добавити користувача.                                          |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|5: Змінити дані про фонд.                                         |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|6: Вийти.                                                         |" + "\n" +
                "|------------------------------------------------------------------|");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                AdminActions.VeiwList();
                break;
            case "2":
                AdminActions.DeleadUser();
                break;
            case "3":
                AdminActions.Rewu();
                break;
            case "4":
                Registration.registration();
                break;
            case "5":
                ActionsWithData.changeInformationAboutUs();
            case "6":
                Menu.mainMenu();
                break;


            default:
                out.println("Непоняль");
                Menu.mainMenu();
        }
    }

    public static void backtoMainMenu() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        byte command;
        command = (scanner.nextByte());

        if (command == 27) {
            Menu.mainMenu();
        }
    }

    public final static void clearConsole() {
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