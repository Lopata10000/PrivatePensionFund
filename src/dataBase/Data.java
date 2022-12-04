package dataBase;

import java.util.Scanner;

import static java.lang.System.in;

public class Data {

    public static final Scanner scanner = new Scanner(in);
    public static final String userData = "./src/DataBase/Users.txt";
    protected static final String informationAboutUs = "./src/DataBase/InformationAboutUs.txt";
    public static String newLogin;
    public static String changeLine;
    public static int numberLine = 0;
    public static String numberForDelead;

    public static String gmail;
    public static String age;
    public static String initialСontribution;
    public static String regularСontributions;
    public static String password = null;


    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Data.password = password;
    }

    public static String getChangeLine() {
        return changeLine;
    }

    public static void setChangeLine(String changeLine) {
        Data.changeLine = changeLine;
    }

    public static String getNumberForDelead() {
        return numberForDelead;
    }

    public static void setNumberForDelead(String numberForDelead) {
        Data.numberForDelead = numberForDelead;
    }

    public static int getNumberLine() {
        return numberLine;
    }

    public static void setNumberLine(int numberLine) {
        Data.numberLine = numberLine;
    }

    public static int retirementAge = 60;

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        Data.age = age;
    }

    public static String getInitialСontribution() {
        return initialСontribution;
    }

    public static void setInitialСontribution(String initialСontribution) {
        Data.initialСontribution = initialСontribution;
    }

    public static String getRegularСontributions() {
        return regularСontributions;
    }

    public static void setRegularСontributions(String regularСontributions) {
        Data.regularСontributions = regularСontributions;
    }

    public static int getRetirementAge() {
        return retirementAge;
    }

    public static String getGmail() {
        return gmail;
    }

    public static void setGmail(String gmail) {
        Data.gmail = gmail;
    }

    public static String newPassword;

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

    }


