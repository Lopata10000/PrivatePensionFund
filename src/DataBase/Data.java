package DataBase;

import javax.xml.validation.Validator;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Files;

import static java.lang.System.in;

public class Data {

    public static Scanner scanner = new Scanner(in);
    public static final String userData = "Users.txt";
    public static String newLogin;
    public static String newPassword;
    public static String login;
    public static String password;
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

