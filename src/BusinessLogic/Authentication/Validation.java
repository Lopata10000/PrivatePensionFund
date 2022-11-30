package BusinessLogic.Authentication;

import DataBase.Data;
import DataBase.Encryption;
import Intarface.IntarfaceMenu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedWriter;
import java.io.File;
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
import static Intarface.Check.checkRegistration;
import static java.lang.System.out;

public class Validation {
    public static boolean isValidLogin = true;

    public static boolean isValidPassword() {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"
                + "(?=\\S+$).{8,30}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(getNewPassword());
        return m.matches();
    }

    public static void loginValidation() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        boolean validLogin = true;
        if (getNewLogin().length() > 30 || getNewLogin().length() < 8) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |" + "\n" +
                    "|------------------------------------------------------------------|");
            validLogin = false;
        }
        if (Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8).anyMatch(Data.getNewLogin()::equals)) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Користувач з таким логіном існує.                                 |" + "\n" +
                    "|------------------------------------------------------------------|" + "\n");
            validLogin = false;
        }
        if (!validLogin) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Спробуйте вибрати логін ще раз.                                   |" + "\n" +
                    "|------------------------------------------------------------------|" + "\n");
            Registration.registration();
        }
    }

    public static void passwordValidation() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        if (Validation.isValidPassword() && Validation.isValidLogin) {
            if (userData == null) {
                File usersData = new File(userData);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData))) {
                    Encryption.EncryptionLogin();
                    Encryption.EncryptionPassword();
                    writer.append("-----------------------------------------------------" + "\n" +
                            "Логін: " + getNewLogin() + "\n" +
                            "Пароль: " + getNewPassword() + "\n");
                    writer.close();
                    out.println("Вас зареєстровано успішно!");
                    IntarfaceMenu.mainMenu();
                }
            } else {
                checkRegistration();
            }
        } else {
            out.println("|--------------------------------------------------------------------|" + "\n" +
                    "|Довжина пароля повинна бути менше 30 і більше 8 символів.           |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|У паролі повинна бути присутня хоча б одна буква верхнього регістру-|" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|У паролі повинна бути присутня хоча б одна буква нижнього регістру  |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|У паролі повинна бути хоча б одна цифра                             |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n" +
                    "|Спробуйте вибрати пароль ще раз.                                    |" + "\n" +
                    "|--------------------------------------------------------------------|" + "\n");
            setNewPassword(scanner.nextLine());
            passwordValidation();
        }
    }
}
