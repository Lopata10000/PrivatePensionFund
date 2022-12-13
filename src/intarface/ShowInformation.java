package intarface;

import BuisnesLogic.Encryption;
import BuisnesLogic.Validation;
import DataAccess.ActionsWithData;

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

import static DataAccess.Data.*;
import static DataAccess.getLine.dividingLine;
import static java.lang.System.out;

public class ShowInformation {
    public static void enterLogin() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println(dividingLine + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                dividingLine);
        setNewLogin(scanner.nextLine());
        out.println(dividingLine + "\n" +
                "|E-mail:                                                           |" + "\n" +
                dividingLine);
        setGmail(scanner.nextLine());
        Encryption.encryptionGmail();
        out.println(dividingLine + "\n" +
                "|Ваш пароль(English):                                              |" + "\n" +
                dividingLine);
        setNewPassword(scanner.nextLine());
        Encryption.encryptionPassword();
        ActionsWithData.checkAuthorization();
    }

    public static void successfulRegistration() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println(dividingLine + "\n" +
                "|Вас зареєстровано успішно!                                        |" + "\n" +
                dividingLine);
        Menu.actionsWithAccounts();
    }

    public static void dontHaveAccout() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println(dividingLine + "\n" +
                "|Такого акаунту немає.                                             |" + "\n" +
                dividingLine);
        Menu.mainMenu();
    }

    public static void writeResponse() {
        out.println(dividingLine + "\n" +
                "|Уведіть відгук                                                    |" + "\n" +
                dividingLine);
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
            ShowInformation.loginValidation();
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
                ShowInformation.loginValidation();
            }
        } catch (Exception ex) {
            if (Validation.isValidLogin())
                ShowInformation.gmailValidation();
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
            ShowInformation.passwordValidation();
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
            ShowInformation.gmailValidation();
        }
    }

}
