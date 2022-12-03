package BusinessLogic.Authentication;

import DataBase.Encryption;
import Intarface.IntarfaceMenu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Validation {
    public static boolean isValidPassword() {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternPassword = Pattern.compile(regex);
        Matcher matcherPassword = patternPassword.matcher(getNewPassword());
        return matcherPassword.matches();
    }

    public static boolean isValidAge() {
        String regex = "[0-9].{1,2}";
        Pattern patternAge = Pattern.compile(regex);
        Matcher matcherAge = patternAge.matcher(getAge());
        return matcherAge.matches();
    }

    public static boolean isValidLineDelead() {
        String regex = "[0-9].{1,3}";
        Pattern patternLineDelead = Pattern.compile(regex);
        Matcher matcherLineDelead = patternLineDelead.matcher(getNumberForDelead());
        return matcherLineDelead.matches();
    }

    public static boolean isValidСontributions() {
        String regex = "[0-9].{1,15}";
        Pattern patternСontributions = Pattern.compile(regex);
        Matcher matcherСontributions = patternСontributions.matcher(getInitialСontribution());
        return matcherСontributions.matches();
    }

    public static boolean isValidRegularСontributions() {
        String regex = "[0-9].{1,15}";
        Pattern patternRegularСontributions = Pattern.compile(regex);
        Matcher matcherRegularСontributions = patternRegularСontributions.matcher(getRegularСontributions());
        return matcherRegularСontributions.matches();
    }

    public static boolean isValidGmail() {
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

    public static void loginValidation() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewLogin(scanner.nextLine());
        if (!Validation.isValidLogin()) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |" + "\n" +
                    "|------------------------------------------------------------------|" + "\n" +
                    "|Логін повинен складатися із букв верхнього і нижнього регістру.   |" + "\n" +
                    "|------------------------------------------------------------------|" + "\n" +
                    "|Спробуйте вибрати логін ще раз.                                   |" + "\n" +
                    "|------------------------------------------------------------------|");
            Validation.loginValidation();
        }
        try {
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8)
                    .anyMatch(("Логін: " + getNewLogin())::equals)) {
                out.println("|------------------------------------------------------------------|" + "\n" +
                        "|Користувач з таким логіном існує.                                 |" + "\n" +
                        "|------------------------------------------------------------------|" + "\n" +
                        "|Будьте оригінальними.                                             |" + "\n" +
                        "|------------------------------------------------------------------|" + "\n" +
                        "|Спробуйте вибрати логін ще раз.                                   |" + "\n" +
                        "|------------------------------------------------------------------|");
                Validation.loginValidation();
            }
        } catch (Exception ex) {
            if (Validation.isValidLogin())
                Validation.gmailValidation();
        }
    }

    public static void passwordValidation() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш пароль:                                                       |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewPassword(scanner.nextLine());
        if (!Validation.isValidPassword()) {
            out.println("|--------------------------------------------------------------------|" + "\n" +
                    "|Довжина пароля повинна бути менше 30 і більше 8 символів.           |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|У паролі повинна бути присутня хоча б одна буква верхнього регістру.|" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|У паролі повинна бути присутня хоча б одна буква нижнього регістру. |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|У паролі повинна бути хоча б одна цифра.                            |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|Спробуйте вибрати пароль ще раз.                                    |" + "\n" +
                    "|--------------------------------------------------------------------|");
            Validation.passwordValidation();
        }
    }

    public static void gmailValidation() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш e-mail:                                                       |" + "\n" +
                "|------------------------------------------------------------------|");
        setGmail(scanner.nextLine());
        if (!Validation.isValidGmail()) {
            out.println("|-------------------------------------------------------------------------------|" + "\n" +
                    "|E-mail повиннен бути написаний на англійській мові і включати '@' '.' та домен.|" + "\n" +
                    "|-------------------------------------------------------------------------------|" + "\n" +
                    "|Спробуйте ще раз.                                                              |" + "\n" +
                    "|-------------------------------------------------------------------------------|");
            Validation.gmailValidation();
        }
        try {
            Encryption.EncryptionGmail();
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8)
                    .anyMatch(("E-mail: " + getGmail())::equals)) {
                out.println("|------------------------------------------------------------------|" + "\n" +
                        "|Користувач з таким e-mail існує.                                  |" + "\n" +
                        "|------------------------------------------------------------------|" + "\n" +
                        "|Спробуйте вибрати інший e-mail.                                   |" + "\n" +
                        "|------------------------------------------------------------------|");
                Validation.gmailValidation();
            }
        } catch (Exception ex) {
            if (Validation.isValidGmail())
                Validation.passwordValidation();
        }
    }

    public static void totalCheck() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        if (Validation.isValidPassword())
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData , true))) {
                Encryption.EncryptionPassword();
                writer.append("|------------------------------------------------------------------|" + "\n" +
                        "Login: " + getNewLogin() + "\n" +
                        "E-mail: " + getGmail() + "\n" +
                        "Password: " + getNewPassword() + "\n");
                writer.close();
                out.println("|------------------------------------------------------------------|" + "\n" +
                        "|Вас зареєстровано успішно!                                        |" + "\n" +
                        "|------------------------------------------------------------------|");
                if (getNewLogin().equals("FantaPetro"))
                    IntarfaceMenu.AdminMenu();
                else
                    IntarfaceMenu.ActionsWithAccounts();
                IntarfaceMenu.ActionsWithAccounts();
            }
        else {
            Registration.Registration();
        }
    }

    public static void ageValidation() {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Уведіть свій вік:                                                 |" + "\n" +
                "|------------------------------------------------------------------|");
        setAge(scanner.nextLine());
        if (!Validation.isValidAge()) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Некоректний вік!                                                  |" + "\n" +
                    "|------------------------------------------------------------------|");
            ageValidation();
        }
    }

    public static void contributionsValidation() {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Уведіть свій перший вклад.                                        |" + "\n" +
                "|------------------------------------------------------------------|");
        setInitialСontribution(scanner.nextLine());
        if (!Validation.isValidСontributions()) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Уведено некректні дані (до 20 символі, тільки цифри!)             |" + "\n" +
                    "|------------------------------------------------------------------|");
            contributionsValidation();
        }
    }

    public static void regularContributionsValidation() {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Скільки ви готові відкладати кожного року?                        |" + "\n" +
                "|------------------------------------------------------------------|");
        setRegularСontributions(scanner.nextLine());
        if (!Validation.isValidRegularСontributions()) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Уведено некректні дані (до 20 символі, тільки цифри!)             |" + "\n" +
                    "|------------------------------------------------------------------|");
            regularContributionsValidation();
        }

    }

    public static void lineForDelead() {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Виберіть дані які ви хочете видалити                              |" + "\n" +
                "|------------------------------------------------------------------|");
        setNumberForDelead(scanner.nextLine());
        if (!Validation.isValidLineDelead() || Integer.parseInt(getNumberForDelead()) >= getNumberLine()) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Даних під таким номером немає.                                    |" + "\n" +
                    "|------------------------------------------------------------------|");
            lineForDelead();
        }

    }

    public static void lineForChange() {
        out.println("|---------------------------------------------------------------------|" + "\n" +
                "|Уведіть рядок який ви хочете змінити(Повний рядок окрім номера рядка)|" + "\n" +
                "|---------------------------------------------------------------------|");
        setChangeLine(scanner.nextLine());
        if (Integer.parseInt(getChangeLine()) > getNumberLine()) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Даних під таким номером немає.                                    |" + "\n" +
                    "|------------------------------------------------------------------|");
            lineForChange();
        }
    }
}
