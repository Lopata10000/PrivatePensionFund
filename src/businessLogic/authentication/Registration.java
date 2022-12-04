package businessLogic.authentication;

import businessLogic.userActions.ActionsWithData;
import dataBase.Encryption;
import intarface.Menu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Registration extends Check {
    public static void registration() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        Menu.clearConsole();
        Validation.loginValidation();
        Validation.gmailValidation();
        Validation.passwordValidation();
        Validation.totalCheck();
        Encryption.encryptionGmail();
        Encryption.encryptionPassword();
        ActionsWithData.saveUser();
    }
}
