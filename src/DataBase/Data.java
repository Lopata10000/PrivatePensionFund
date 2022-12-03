package DataBase;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Data {

    public static Scanner scanner = new Scanner(in);
    public static final String userData = "./src/DataBase/Users.txt";
    public static String newLogin;
    public static String changeLine;
    public static int numberLine;
    public static String numberForDelead;

    public static String gmail;
    public static String age;
    public static String initialСontribution;
    public static String regularСontributions;

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

    public static double compoundInterest(double InitialСontribution1) {
        int RegularСontribution = Integer.parseInt(getRegularСontributions());
        int age = Integer.parseInt(getAge());
        int pensionAge = (getRetirementAge() - age);
        for (int i = 1; i < pensionAge; i++) {
            InitialСontribution1 = InitialСontribution1 + RegularСontribution;
            InitialСontribution1 = (InitialСontribution1 * (1.1));
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|За " + i + " рік|" + "\n" +
                    "|------------------------------------------------------------------|" + "\n" +
                    "|" + Math.round(InitialСontribution1) + "|");
        }
        return InitialСontribution1;
    }

}

