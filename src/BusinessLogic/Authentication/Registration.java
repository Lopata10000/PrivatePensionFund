package BusinessLogic.Authentication;

import Intarface.Check;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static DataBase.Data.*;
import static java.lang.System.out;

public class Registration {
    public static void registration() throws IOException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        File usersData = new File(userData);
        if (!usersData.exists()) {
            usersData.createNewFile();
            registration();
        } else {
            out.println("Ваш логін:");
            setNewLogin(scanner.nextLine());
            Check.loginValidation();
            out.println("Ваш пароль");
            setNewPassword(scanner.nextLine());
            Check.passwordValidation();
        }
    }
}
