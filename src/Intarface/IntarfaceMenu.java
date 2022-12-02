package Intarface;

import BusinessLogic.AdminActions.View;
import BusinessLogic.Authentication.Authorization;
import BusinessLogic.Authentication.Registration;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static BusinessLogic.AdminActions.View.DeleadUser;
import static DataBase.Data.getNewLogin;
import static java.lang.System.out;

public class IntarfaceMenu {
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
                "\n" + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~4:      Вихід      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|" +
                "\n" + "|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|" +
                "                                                                      ▒▒▒▒▒▒▒▒▒▒▒▄▄▄▄░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒▒▒▒▒▒▄██████▒▒▒▒▒▄▄▄█▄▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒▒▒▒▄██▀░░▀██▄▒▒▒▒████████▄▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒▒▒███░░░░░░██▒▒▒▒▒▒█▀▀▀▀▀██▄▄▒▒▒\n" +
                "                                                                      ▒▒▒▒▒▄██▌░░░░░░░██▒▒▒▒▐▌▒▒▒▒▒▒▒▒▀█▄▒\n" +
                "                                                                      ▒▒▒▒▒███░░▐█░█▌░██▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▀▌\n" +
                "                                                                      ▒▒▒▒████░▐█▌░▐█▌██▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▐████░▐░░░░░▌██▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒████░░░▄█░░░██▒▒▐█▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒████░░░██░░██▌▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒████▌░▐█░░███▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒▐████░░▌░███▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒▒▒████░░░███▒▒▒▒█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▒▒██████▌░████▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒▐████████████▒▒███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ▒█████████████▄████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ██████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      █████████████████▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      █████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "                                                                      ████████████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                Authorization.Authorization();
                break;
            case "2":
                Registration.Registration();
                break;
            case "3":
                View.VeiwList();
                break;
            case "4":
                System.exit(0);
                break;

            default:
                out.println("Непоняль");
                IntarfaceMenu.mainMenu();
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
                "|3: Зробити внесок                                                 |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|4: Вирахувати пенсійні накопичення                                |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|5: Вийти                                                          |" + "\n" +
                "|------------------------------------------------------------------|" + "\n");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                View.VeiwList();
                break;
            case "2":

                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                IntarfaceMenu.mainMenu();
                break;


            default:
                out.println("Непоняль");
                IntarfaceMenu.mainMenu();
        }
    }

    public static void AdminMenu() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "| Ви увійшли як: " + getNewLogin() + "|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|Що ви бажаєте зробити?                                            |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|1: Переглянути користувачів.                                      |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|2: Видалити користувача.                                          |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|3: Відредагувати дані.                                            |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|4: Добавити користувача.                                          |" + "\n" +
                "|------------------------------------------------------------------|" + "\n" +
                "|5: Вийти                                                          |" + "\n" +
                "|------------------------------------------------------------------|" + "\n");
        command = scanner.nextLine();

        switch (command) {

            case "1":
                View.VeiwList();
                break;
            case "2":
                DeleadUser();
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                IntarfaceMenu.mainMenu();
                break;


            default:
                out.println("Непоняль");
                IntarfaceMenu.mainMenu();
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