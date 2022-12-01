package Intarface;

import BusinessLogic.Authentication.Authorization;
import DataBase.Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.BufferedReader;
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
    public static boolean checkUser() throws IOException {
        FileReader fileWriter = new FileReader(userData);
        BufferedReader reader = new BufferedReader(fileWriter);
        String currentLine;
        String[] data;
        while (null != (currentLine = reader.readLine())) {
            data = currentLine.split(", ");
        }
        return false;
    }

    public static void checkAuthorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        Encryption.EncryptionPassword();
        try (FileReader reader = new FileReader(userData)) {
            if (Files.lines(Paths.get(userData) , StandardCharsets.UTF_8)
                    .anyMatch(("Логін: " + getNewLogin())::equals) && Files.lines(Paths.get(userData) , StandardCharsets.UTF_8).anyMatch(("Пароль: " + getNewPassword())::equals)) {
                IntarfaceMenu.ActionsWithAccounts();
            } else {
                out.println("Такого акаунту немає");
                Authorization.authorization();
            }
        }
    }

    public static void checkRegistration() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {

    }
}

