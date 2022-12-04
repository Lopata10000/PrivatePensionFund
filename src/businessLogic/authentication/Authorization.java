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

import static dataBase.Data.*;
import static intarface.Menu.dividingLine;
import static java.lang.System.out;

public class Authorization extends Check {
    public static void authorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        out.println(dividingLine + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                dividingLine);
        setNewLogin(scanner.nextLine());
        out.println(dividingLine + "\n" +
                "|E-mail:                                                           |" + "\n" +
                dividingLine);
        setGmail(scanner.nextLine());
        Encryption.encryptionGmail();
        out.println(dividingLine + "\n" +
                "|Ваш пароль(English):                                              |" + "\n" +
                dividingLine);
        setNewPassword(scanner.nextLine());
        Encryption.encryptionPassword();
        ActionsWithData.checkAuthorization();


    }
}
