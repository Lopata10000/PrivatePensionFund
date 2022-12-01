package BusinessLogic.Authentication;

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

public class Registration {
    public static void registration() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewLogin(scanner.nextLine());
        Validation.loginValidation();
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш e-mail:                                                       |" + "\n" +
                "|------------------------------------------------------------------|");
        setGmail(scanner.nextLine());
        Validation.isValidGmail();
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш пароль:                                                       |" + "\n" +
                "|------------------------------------------------------------------|");
        setNewPassword(scanner.nextLine());
        Validation.passwordValidation();
    }

}
