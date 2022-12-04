package businessLogic.authentication;

import businessLogic.userActions.ActionsWithData;
import businessLogic.userActions.getLine;
import dataBase.Data;
import dataBase.Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

@SuppressWarnings("ALL")
public class Validation extends Data implements getLine {
    private static boolean isValidPassword() {
        String regex = "^(?=.*\\d)"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternPassword = Pattern.compile(regex);
        Matcher matcherPassword = patternPassword.matcher(getNewPassword());
        return matcherPassword.matches();
    }

    private static boolean isValidAge() {
        String regex = "^\\d{1,2}$";
        Pattern patternAge = Pattern.compile(regex);
        Matcher matcherAge = patternAge.matcher(getAge());
        return matcherAge.matches();
    }

    private static boolean isValidContribution() {
        String regex = "^\\d{1,10}$";
        Pattern patternContribution = Pattern.compile(regex);
        Matcher matcherContribution = patternContribution.matcher(Data.getInitialСontribution());
        return matcherContribution.matches();
    }

    private static boolean isValidRegularContribution() {
        String regex = "^\\d{1,10}$";
        Pattern patternRegularСontribution = Pattern.compile(regex);
        Matcher matcherRegularContribution = patternRegularСontribution.matcher(getRegularСontributions());
        return matcherRegularContribution.matches();
    }

    private static boolean isValidGmail() {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern
        Pattern patternGmail = Pattern.compile(regex);
        Matcher matcherGmail = patternGmail.matcher(getGmail());
        return matcherGmail.matches();
    }

    public static boolean isValidLogin() {
        String regex = "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternLogin = Pattern.compile(regex);
        Matcher matcherLogin = patternLogin.matcher(getNewLogin());
        return matcherLogin.matches();
    }

    public static void loginValidation() {
        out.println(dividingLine + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                dividingLine);
        setNewLogin(scanner.nextLine());
        if (!Validation.isValidLogin()) {
            out.println(dividingLine + "\n" +
                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |" + "\n" +
                    dividingLine + "\n" +
                    "|Логін повинен складатися із букв верхнього і нижнього регістру.   |" + "\n" +
                    dividingLine + "\n" +
                    "|Спробуйте вибрати логін ще раз.                                   |" + "\n" +
                    dividingLine);
            Validation.loginValidation();
        }
        try {
            //noinspection resource
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8)
                    .anyMatch(("Login: " + getNewLogin())::equals)) {
                out.println(dividingLine + "\n" +
                        "|Користувач з таким логіном існує.                                 |" + "\n" +
                        dividingLine + "\n" +
                        "|Будьте оригінальними.                                             |" + "\n" +
                        dividingLine);
                Validation.loginValidation();
            }
        } catch (Exception ex) {
            if (Validation.isValidLogin())
                Validation.gmailValidation();
        }
    }

    public static void passwordValidation() {
        out.println(dividingLine + "\n" +
                "|Ваш пароль:                                                       |" + "\n" +
                dividingLine);
        setNewPassword(scanner.nextLine());
        if (!Validation.isValidPassword()) {
            out.println(dividingLine + "\n" +
                    "|Довжина пароля повинна бути менше 30 і більше 8 символів.           |" + "\n" +
                    dividingLine + "\n" +
                    "|У паролі повинна бути присутня хоча б одна буква верхнього регістру.|" + "\n" +
                    dividingLine + "\n" +
                    "|У паролі повинна бути присутня хоча б одна буква нижнього регістру. |" + "\n" +
                    dividingLine + "\n" +
                    "|У паролі повинна бути хоча б одна цифра.                            |" + "\n" +
                    dividingLine);
            Validation.passwordValidation();
        }
    }

    public static void gmailValidation() {
        out.println(dividingLine + "\n" +
                "|Ваш e-mail:                                                       |" + "\n" +
                dividingLine);
        setGmail(scanner.nextLine());
        if (!Validation.isValidGmail()) {
            out.println(dividingLine + "\n" +
                    "|E-mail повиннен бути написаний на англійській мові і включати '@' '.' та домен.|" + "\n" +
                    dividingLine);
            Validation.gmailValidation();
        }
        try {
            Encryption.encryptionGmail();
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8)
                    .anyMatch(("E-mail: " + getGmail())::equals)) {
                out.println(dividingLine + "\n" +
                        "|Користувач з таким e-mail існує.                                  |" + "\n" +
                        dividingLine);
                Validation.gmailValidation();
            }
        } catch (Exception ex) {
            if (Validation.isValidGmail())
                Validation.passwordValidation();
        }
    }

    public static void totalCheck() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        if (Validation.isValidPassword()) {
            ActionsWithData.saveUser();
        } else {
            Registration.registration();
        }
    }

    public static void ageValidation() {
        out.println(dividingLine + "\n" +
                "|Уведіть свій вік:                                                 |" + "\n" +
                dividingLine);
        setAge(scanner.nextLine());
        if (!Validation.isValidAge()) {
            out.println(dividingLine + "\n" +
                    "|Некоректний вік!                                                  |" + "\n" +
                    dividingLine);
            ageValidation();
        }
        if (60 <= Integer.parseInt(getAge())) {
            out.println(dividingLine + "\n" +
                    "|Ми надаємо послуги людям до 60 років. Приносимо свої вибачення.   |" + "\n" +
                    dividingLine);
            ageValidation();
        }
    }

    public static void contributionsValidation() {
        out.println(dividingLine + "\n" +
                "|Уведіть свій перший вклад.                                        |" + "\n" +
                dividingLine);
        Data.setInitialСontribution(scanner.nextLine());
        if (!Validation.isValidContribution()) {
            out.println(dividingLine + "\n" +
                    "|Уведено некректні дані (до 20 символі, тільки цифри!)             |" + "\n" +
                    dividingLine);
            contributionsValidation();
        }
    }

    @SuppressWarnings("NonAsciiCharacters")
    public static void regularContributionsValidation() {
        out.println(dividingLine + "\n" +
                "|Скільки ви готові відкладати кожного року?                        |" + "\n" +
                dividingLine);
        setRegularСontributions(scanner.nextLine());
        if (!Validation.isValidRegularContribution()) {
            out.println(dividingLine + "\n" +
                    "|Уведено некректні дані (до 20 символі, тільки цифри!)             |" + "\n" +
                    dividingLine);
            regularContributionsValidation();
        }

    }

    public static void lineForChangeValidation() {
        out.println(dividingLine + "\n" +
                "|Уведіть рядок який ви хочете змінити(Повний рядок окрім номера рядка)|" + "\n" +
                dividingLine);
        setChangeLine(scanner.nextLine());
        out.println(dividingLine + "\n" +
                "|Уведіть дані які ви хочете змінити(Без номеру рядка)                 |" + "\n" +
                dividingLine);
    }
    }

