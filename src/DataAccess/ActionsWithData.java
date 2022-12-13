package DataAccess;

import BuisnesLogic.Authorization;
import intarface.Menu;
import intarface.ShowInformation;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.lines;

public class ActionsWithData extends Data implements getLine {
    public static void checkAuthorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        try {
            Path path = Paths.get(userData);
            if (lines(path , StandardCharsets.UTF_8).noneMatch(("Password: " + getNewPassword())::equals) && lines(path , StandardCharsets.UTF_8).noneMatch(("E-mail: " + getGmail())::equals) && lines(path , StandardCharsets.UTF_8).noneMatch(("Login: " + getNewLogin())::equals)) {
                ShowInformation.dontHaveAccout();
                Authorization.authorization();
            } else {
                Menu.actionsWithAccounts();
            }
        } finally {
            ShowInformation.dontHaveAccout();
        }
    }

    public static void saveUser() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        Encryption.encryptionPassword();
        Encryption.encryptionGmail();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData , true))) {
            writer.append("|------------------------------------------------------------------|" + "\n" +
                    "Login: " + getNewLogin() + "\n" +
                    "E-mail: " + getGmail() + "\n" +
                    "Password: " + getNewPassword() + "\n");
            writer.close();
            ShowInformation.successfulRegistration();
        }
    }

    public static void response() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        ShowInformation.writeResponse();
        setWrittenResponse(scanner.nextLine());
        Path users = Path.of(userData);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(users , StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals("Password: " + getNewPassword())) {
                fileContent.set(i , "Password: " + getNewPassword() + "\n" + "Response: " + getWrittenResponse());
                break;
            }
        }
        Files.write(users , fileContent , StandardCharsets.UTF_8);
        Menu.actionsWithAccounts();
    }

}
