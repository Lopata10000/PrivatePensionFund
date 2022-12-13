package BuisnesLogic;

import intarface.ShowInformation;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Authorization {
    public static void authorization() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        ShowInformation.enterLogin();
    }
}
