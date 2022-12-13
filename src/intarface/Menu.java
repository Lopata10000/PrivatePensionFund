package intarface;

import DataAccess.getLine;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static BuisnesLogic.Authorization.authorization;
import static BuisnesLogic.Registration.registration;
import static DataAccess.ActionsWithData.response;
import static DataAccess.Data.getNewLogin;
import static java.lang.System.out;

public class Menu implements getLine {
    public static final Scanner scanner = new Scanner(System.in);
    static String command;
    public static final String uKnowActions = "Незрозуміла опція";

    public static void mainMenu() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        out.println("""

                |--======================================================================--       Театр Корифеїв          --========================================================================--|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1: Авторизуватися  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~2: Зареєструватися ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~3:      Вихід      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
                """);
        command = scanner.nextLine();

        switch (command) {
            case "1" -> authorization();
            case "2" -> registration();
//            case "3" -> Calculations();
//            case "4" -> informationAboutUs();
            case "5" -> System.exit(0);
            default -> {
                out.println(uKnowActions);
                Menu.mainMenu();
            }
        }
    }

    public static void actionsWithAccounts() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "| Ви увійшли як: " + getNewLogin() + "|" + "\n" +
                dividingLine + "\n" +
                "|Що ви бажаєте зробити?                                               |" + "\n" +
                dividingLine + "\n" +
                "|1: Залишити відгук                                                   |" + "\n" +
                dividingLine + "\n" +
                "|2: Вийти.                                                            |" + "\n" +
                dividingLine + "\n");
        command = scanner.nextLine();

        switch (command) {
            case "1" -> response();
            case "2" -> Menu.mainMenu();
            default -> {
                out.println(uKnowActions);
                Menu.mainMenu();
            }
        }
    }
}