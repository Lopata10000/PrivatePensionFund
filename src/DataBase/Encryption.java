package DataBase;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static DataBase.Data.*;

public class Encryption {
    public static final String initVector = "encryptionIntVec";
    private static final String key = "aesEncryptionKey";

    public static void EncryptionLogin() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        IvParameterSpec parameter = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec newkey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8) , "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE , newkey , parameter);

        byte[] bytesNewLogin = cipher.doFinal(getNewLogin().getBytes());

        setNewLogin(String.valueOf(bytesNewLogin));
    }

    public static void EncryptionPassword() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        IvParameterSpec parameter = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec newkey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8) , "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE , newkey , parameter);

        byte[] bytesNewPassword = cipher.doFinal(getNewLogin().getBytes());

        setNewPassword(String.valueOf(bytesNewPassword));
    }

    public static void DecryptionFile() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8) , "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE , skeySpec , iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(userData));
    }


}
