package dataBase;

import com.google.common.hash.Hashing;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static dataBase.Data.*;

public class Encryption {
    public static void EncryptionGmail() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException, ShortBufferException {
        String sha256hex = String.valueOf(Hashing.sha256().hashString(getGmail() , StandardCharsets.UTF_8));
        setGmail(sha256hex);
    }

    public static void EncryptionPassword() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        String sha256hex = Hashing.sha256().hashString(getNewPassword() , StandardCharsets.UTF_8).toString();
        setNewPassword(sha256hex);
        setPassword(getNewPassword());
    }



}
