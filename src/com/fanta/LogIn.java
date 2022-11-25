package com.fanta;

import java.util.Scanner;

import static java.lang.System.in;

public class LogIn {
    public static final String userData = "Users.txt";
    static Scanner scanner = new Scanner(in);
    public static String newLogin;
    public static String newPassword;
    public static String login;
    public static String password;
    boolean checkData;

    LogIn(String newLogin , String newPassword , String login , String password) {
        LogIn.newLogin = newLogin;
        LogIn.newPassword = newPassword;
    }

    public static String getNewLogin() {
        return newLogin;
    }

    public static void setNewLogin(String newLogin) {
        LogIn.newLogin = newLogin;
    }

    public static String getNewPassword() {
        return newPassword;
    }

    public static void setNewPassword(String newPassword) {
        LogIn.newPassword = newPassword;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        LogIn.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LogIn.password = password;
    }

//    public static void registration() throws IOException {
//
//                try(BufferedWriter writer = new BufferedWriter(new FileWriter(userData))) {
//                    out.println("Вибери логін");
//                    newLogin = scanner.nextLine();
//                    out.println("Вибери пароль");
//                    newPassword = scanner.nextLine();
//                    writer.append("\n" + newPassword);
//                    writer.append("\n" + newPassword);
//                    writer.close();
//                    out.println("Успішно");
//                }
//                        catch (Exception exception)
//                        {
//                            out.println("Пусто");
//                        }
//                    }
}

