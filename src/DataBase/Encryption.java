package DataBase;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static DataBase.Data.*;

public class Encryption {
    static KeyGenerator newkey;
    static Cipher decript;
    static SecretKey key = newkey.generateKey();
    static Cipher cipher;
    static byte[] bytesNewLogin;

    static {
        try {
            decript = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            newkey = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            bytesNewLogin = cipher.doFinal(newLogin.getBytes());
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public Encryption() throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    }

    public static void EncryptionLogin() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE , key);
        setNewLogin(String.valueOf(bytesNewLogin));

    }

    public static void EncryptionPassword() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        byte[] bytesNewPassword = cipher.doFinal(newPassword.getBytes());
        setNewPassword(String.valueOf(bytesNewPassword));
    }

    public static void DecryptionLogin() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        decript.init(Cipher.ENCRYPT_MODE , key);
        byte[] decriptLoginBytes = decript.doFinal(bytesNewLogin);
    }

    public static void DecryptionPassword() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        decript.init(Cipher.ENCRYPT_MODE , key);
        byte[] decriptLoginBytes = decript.doFinal(bytesNewLogin);
    }

}
