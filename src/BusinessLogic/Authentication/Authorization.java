package BusinessLogic.Authentication;

import DataBase.Encryption;
import Intarface.Check;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Authorization {
    public static void authorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш e-mail:                                                       |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewLogin(scanner.nextLine());
        setGmail(getNewLogin());
        Encryption.EncryptionGmail();
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш пароль(English):                                              |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewPassword(scanner.nextLine());
        setPassword(getNewPassword());
        Check.checkAuthorization();
    }
}
