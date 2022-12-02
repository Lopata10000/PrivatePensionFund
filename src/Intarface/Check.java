package Intarface;

import BusinessLogic.Authentication.Authorization;
import DataBase.Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.FileReader;
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
    public static void checkAuthorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewLogin(scanner.nextLine());
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш e-mail:                                                       |" + "\n" +
                "|------------------------------------------------------------------|");
        setGmail(scanner.nextLine());
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш пароль(English):                                              |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewPassword(scanner.nextLine());
        Encryption.EncryptionPassword();
        Encryption.EncryptionGmail();
        try (FileReader reader = new FileReader(userData)) {
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("Логін: " + getNewLogin())::equals)
                    && Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("Пароль: " + getNewPassword())::equals)
                    && Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("E-mail: " + getGmail())::equals)) {
                if (getNewLogin().equals("FantaPetro"))
                    IntarfaceMenu.AdminMenu();
                else
                    IntarfaceMenu.ActionsWithAccounts();
            } else {
                out.println("|------------------------------------------------------------------|" + "\n" +
                        "|Такого акаунту немає.                                             |" + "\n" +
                        "|------------------------------------------------------------------|");
                Authorization.Authorization();
            }
        }
    }

    public static void checkRegistration() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {

    }
}

