package BusinessLogic.Authentication;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Registration {
    public static void registration() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        out.println("Ваш логін:");
        setNewLogin(scanner.nextLine());
        Validation.loginValidation();
        out.println("Ваш пароль:");
        setNewPassword(scanner.nextLine());
        Validation.passwordValidation();
    }
}
