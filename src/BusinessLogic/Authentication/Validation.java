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
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Validation {
    public static boolean isValidLogin = true;
    public static boolean isValidPassword = true;
    public static boolean isValidGmail = true;


    public static boolean isValidPassword() {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternPassword = Pattern.compile(regex);
        Matcher matcherPassword = patternPassword.matcher(getNewPassword());
        return matcherPassword.matches();
    }

    public static boolean isValidGmail() {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern
        Pattern patternGmail = Pattern.compile(regex);
        Matcher matcherGmail = patternGmail.matcher(getNewPassword());
        return matcherGmail.matches();
    }

    public static boolean isIsValidLogin() {
        String regex = "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternLogin = Pattern.compile(regex);
        Matcher matcherLogin = patternLogin.matcher(getNewLogin());
        return matcherLogin.matches();
    }

    public static void loginValidation() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        boolean validLogin = true;
        if (!Validation.isValidLogin) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |" + "\n" +
                    "|------------------------------------------------------------------|" + "\n" +
                    "|Логін повинен складатися із букв верхнього і нижнього регістру    |" +
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
//    public static void loginValidation()
//    {
////        FileWriter fileWriter = new FileWriter(userData);
////        BufferedWriter writer = new BufferedWriter(fileWriter);
////        String currentLine;
////        String data[];
////        boolean validLogin = true;
////        if (getNewLogin().length() > 30 || getNewLogin().length() < 8) {
////            out.println("|------------------------------------------------------------------|" + "\n" +
////                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |" + "\n" +
////                    "|------------------------------------------------------------------|");
////            validLogin = false;
////        }
////            if (!validLogin) {
////                out.println("|------------------------------------------------------------------|" + "\n" +
////                        "|Спробуйте вибрати логін ще раз.                                   |" + "\n" +
////                        "|------------------------------------------------------------------|" + "\n");
////                Registration.registration();
////            }
////        }
////        return false;
//    }

    public static void passwordValidation() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        if (Validation.isValidPassword() && Validation.isValidLogin && Validation.isValidGmail) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData , true))) {
                Encryption.EncryptionGmail();
                Encryption.EncryptionPassword();
                writer.append("|------------------------------------------------------------------|" + "\n" +
                        "Логін: " + getNewLogin() + "\n" +
                        "E-mail: " + getGmail() + "\n" +
                        "Пароль: " + getNewPassword() + "\n");
                writer.close();
                out.println("|------------------------------------------------------------------|" + "\n" +
                        "|Вас зареєстровано успішно!                                        |" + "\n" +
                        "|------------------------------------------------------------------|" + "\n" +
                        "");
                IntarfaceMenu.mainMenu();
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
                    "|--------------------------------------------------------------------|");
            setNewPassword(scanner.nextLine());
            passwordValidation();
        }
    }

    public static void gmailValidation() {
        if (!isValidGmail) {
            out.println("|------------------------------------------------------------------------------|" + "\n" +
                    "|E-mail повиннен бути написаний на англійській мові і включати '@' '.' та домен|" + "\n" +
                    "|------------------------------------------------------------------------------|" + "\n" +
                    "|Спробуйте ще раз                                                              |" + "\n" +
                    "|------------------------------------------------------------------------------|" + "\n");
        }
    }

}
