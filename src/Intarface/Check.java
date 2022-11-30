package Intarface;

import BusinessLogic.Authentication.Authorization;
import DataBase.Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Check {
    public static void checkAuthorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        try (FileReader reader = new FileReader(userData)) {
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8)
                    .anyMatch(getNewLogin()::equals) && Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(getNewPassword()::equals)) {
                out.println("Такий акаунт знайдено");
                IntarfaceMenu.mainMenu();
            } else {
                out.println("Такого акаунту немає");
                Authorization.authorization();
            }
        }
    }

    public static void checkRegistration() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        FileWriter fileWriter = new FileWriter(userData , true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        Encryption.EncryptionLogin();
        Encryption.EncryptionPassword();
        writer.append("-----------------------------------------------------" + "\n" +
                "Логін: " + getNewLogin() + "\n" +
                "Пароль: " + getNewPassword() + "\n");
        out.println("Вас зареєстровано успішно!");
        IntarfaceMenu.mainMenu();
    }
}
//        if (getNewLogin().length() > 30 || getNewLogin().length() < 8) {
//            out.println("|------------------------------------------------------------------|" + "\n" +
//                    "|Довжина логіна повинна бути менше 30 і більше 8 символів.         |" + "\n"+
//                    "|------------------------------------------------------------------|");
//            validLogin = false;
//        }
//        if (Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8).anyMatch(Data.getNewLogin()::equals)) {
//            out.println("|------------------------------------------------------------------|" + "\n" +
//                    "|Користувач з таким логіном існує.                                 |" + "\n" +
//                    "|------------------------------------------------------------------|" + "\n");
//            validLogin = false;
//        }
//        if (!validLogin) {
//            out.println("|------------------------------------------------------------------|" + "\n"+
//                        "|Спробуйте вибрати логін ще раз.                                   |" + "\n" +
//                        "|------------------------------------------------------------------|" + "\n");
//            setNewLogin(scanner.nextLine());
//            loginValidation();
//        }
//        else
//        {
//            out.println("Ваш пароль");
//            setNewPassword(scanner.nextLine());
//            Check.passwordValidation();
//        }
//    }
//    public static void passwordValidation() {
//        boolean validPassword = true;
//            if (getNewPassword().length() > 30 || getNewPassword().length() < 8) {
//                out.println("|------------------------------------------------------------------|" + "\n" +
//                        "|Довжина пароля повинна бути менше 30 і більше 8 символів.         |" +"\n" +
//                        "|------------------------------------------------------------------|");
//                validPassword = false;
//            }
//            if (getNewPassword().equals(getNewLogin())) {
//                out.println("|------------------------------------------------------------------|" + "\n" +
//                        "|Пароль не повинен збігатися з іменем користувача.                 |" +"\n" +
//                        "|------------------------------------------------------------------|");
//                validPassword = false;
//            }
//            if (validPassword== true) {
//                try (BufferedWriter writer = new BufferedWriter(new FileWriter(Data.userData))) {
//                    Encryption.EncryptionLogin();
//                    Encryption.EncryptionPassword();
//                    writer.append(
//                            getNewLogin() + "\n" +
//                                    getNewPassword() + "\n");
//
//                    writer.close();
//                    out.println( "|------------------------------------------------------------------|" + "\n" +
//                                       "|Вас зареєстровано успішно!                                        |" +
//                            "\n" + "|------------------------------------------------------------------|");
//                    IntarfaceMenu.mainMenu();
//                } catch (Exception exception) {
//                    out.println("Пусто");
//                }
//            } else {
//                out.println("|------------------------------------------------------------------|" + "\n" +
//                            "|Спробуйте увести пароль ще раз.                                   |" +
//                        "\n" + "|------------------------------------------------------------------|");
//                setNewPassword(scanner.nextLine());
//                passwordValidation();
//            }
//        }
