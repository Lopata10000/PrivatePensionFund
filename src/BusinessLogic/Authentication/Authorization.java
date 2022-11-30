package BusinessLogic.Authentication;

import DataBase.Encryption;
import Intarface.Check;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Authorization {
    public static void authorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                "|------------------------------------------------------------------|" + "\n");
        setNewLogin(scanner.nextLine());
        Encryption.EncryptionLogin();
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш пароль:                                                       |" + "\n" +
                "|------------------------------------------------------------------|" + "\n");
        setNewPassword(scanner.nextLine());
        Encryption.EncryptionPassword();
        Check.checkAuthorization();
    }
}
