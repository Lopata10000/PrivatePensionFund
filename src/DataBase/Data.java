package DataBase;

import javax.xml.validation.Validator;
import java.util.Scanner;

import static java.lang.System.in;

public class Data {

    public static Scanner scanner = new Scanner(in);
    public static final String userData = "Users.txt";
    public static String ConfirmPassword;

    public static String newLogin;
    public static String newPassword;
    static boolean confirmRegistration;
    public static String login;
    public static String password;
    Validator validation;

    public static boolean ConfirmRegistration() {
        return confirmRegistration;
    }

    public static void setConfirmRegistration(boolean confirmRegistration) {
        Data.confirmRegistration = confirmRegistration;
    }

    public static String getNewLogin() {
        return newLogin;
    }

    public static void setNewLogin(String newLogin) {
        Data.newLogin = newLogin;
    }

    public static String getNewPassword() {
        return newPassword;
    }

    public static void setNewPassword(String newPassword) {
        Data.newPassword = newPassword;
    }

    public static String getConfirmPassword() {
        return ConfirmPassword;
    }

    public static void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Data.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Data.password = password;
    }

}

