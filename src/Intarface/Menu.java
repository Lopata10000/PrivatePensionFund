package Intarface;

import BusinessLogic.AdminActions.AdminActions;
import BusinessLogic.Authentication.Authorization;
import BusinessLogic.Authentication.Registration;
import BusinessLogic.UserActions.ActionsWithData;
import BusinessLogic.UserActions.Calculator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static DataBase.Data.getNewLogin;
import static java.lang.System.out;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static String command;

    public static void mainMenu() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        out.println("" + "\n" +
                "|--======================================================================-- Пенсійний фонд ''Чахлики'' --========================================================================--|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "\n" + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1: Авторизуватися  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "\n" + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~2: Зареєструватися ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "\n" + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~3:   Калькулятор   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "\n" + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~4:     Про нас     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "\n" + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~5:      Вихід      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "                                                                         ▒▒▒▒▒▒▒▒▒▒▒▄▄▄▄░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒▒▒▒▒▒▄██████▒▒▒▒▒▄▄▄█▄▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒▒▒▒▄██▀░░▀██▄▒▒▒▒████████▄▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒▒▒███░░░░░░██▒▒▒▒▒▒█▀▀▀▀▀██▄▄▒▒▒\n" +
                "                                                                         ▒▒▒▒▒▄██▌░░░░░░░██▒▒▒▒▐▌▒▒▒▒▒▒▒▒▀█▄▒\n" +
                "                                                                         ▒▒▒▒▒███░░▐█░█▌░██▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▀▌\n" +
                "                                                                         ▒▒▒▒████░▐█▌░▐█▌██▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▐████░▐░░░░░▌██▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒████░░░▄█░░░██▒▒▐█▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒████░░░██░░██▌▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒████▌░▐█░░███▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒▐████░░▌░███▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒▒▒████░░░███▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▒▒██████▌░████▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒▐████████████▒▒███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ▒█████████████▄████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         █████████████████▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         █████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                         ████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                Authorization.Authorization();
                break;
            case "2":
                Registration.Registration();
                break;
            case "3":
                Calculator.Calculations();
                break;
            case "4":
                ActionsWithData.informationAboutUs();
                break;
            case "5":
                System.exit(0);
                break;

            default:
                out.println("Непоняль");
                Menu.mainMenu();
        }
    }

    public static void ActionsWithAccounts() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "| Ви увійшли як: " + getNewLogin() + "|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|Що ви бажаєте зробити?                                            |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|1: Створити вклад                                                 |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|2: Переглянути вклад                                              |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|3: Вирахувати пенсійні накопичення                                |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|4: Вийти                                                          |" + "\n" +
                "|------------------------------------------------------------------|" + "\n");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                ActionsWithData.addDeposit();
                break;
            case "2":

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

    public static void AdminMenu() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
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
                "|6: Вийти                                                          |" + "\n" +
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
                Registration.Registration();
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