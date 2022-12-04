package businessLogic.authentication;

import intarface.Menu;

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

import static dataBase.Data.*;
import static intarface.Menu.dividingLine;
import static java.lang.System.out;

public class Registration extends Check {
    public static void registration() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        Validation.loginValidation();
        Validation.gmailValidation();
        Validation.passwordValidation();
        Validation.totalCheck();
        Check.inputData();
        Registration.Save.saveUser();
    }

    public static class Save {
        public static void saveUser() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData , true))) {
                writer.append(dividingLine + "\n" + "Login: ").append(getNewLogin()).append("\n").append("E-mail: ").append(getGmail()).append("\n").append(password).append(getNewPassword()).append("\n");
                out.println(dividingLine + "\n" +
                        "|Вас зареєстровано успішно!                                        |" + "\n" +
                        dividingLine);
                if (getNewLogin().equals("FantaPetro"))
                    Menu.adminMenu();
                else
                    Menu.actionsWithAccounts();
                Menu.actionsWithAccounts();
            }
        }
    }
}
