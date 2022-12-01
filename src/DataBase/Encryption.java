package DataBase;

import com.google.common.hash.Hashing;

import javax.crypto.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

import static DataBase.Data.*;

public class Encryption {
    static KeyGenerator keyGenerator;
    static SecretKey key = keyGenerator.generateKey();

    static {
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Encryption() throws NoSuchAlgorithmException {
    }

    public static void EncryptionGmail() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException, ShortBufferException {
        Signature sign = Signature.getInstance("SHA256withRSA");
        String sha256hex = Hashing.sha256().hashString(getGmail() , StandardCharsets.UTF_8).toString();
        setNewLogin(sha256hex);
//
//        //Creating KeyPair generator object
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
//
//        //Initializing the key pair generator
//        keyPairGen.initialize(2048);
//
//        //Generating the pair of keys
//        KeyPair pair = keyPairGen.generateKeyPair();
//
//        //Creating a Cipher object
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//
//        //Initializing a Cipher object
//        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
//
//        //Adding data to the cipher
//        byte[] bytesNewLogin = getNewLogin().getBytes();
//        cipher.update(bytesNewLogin);
//
//        //encrypting the data
//        byte[] cipherText = cipher.doFinal();
//        setNewLogin(String.valueOf(cipherText));
    }

    public static void EncryptionPassword() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        Signature sign = Signature.getInstance("SHA256withRSA");

//        //Creating KeyPair generator object
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
//
//        //Initializing the key pair generator
//        keyPairGen.initialize(2048);
//
//        //Generating the pair of keys
//        KeyPair pair = keyPairGen.generateKeyPair();
//
//        //Creating a Cipher object
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        String sha256hex = Hashing.sha256().hashString(getNewPassword() , StandardCharsets.UTF_8).toString();
        setNewPassword(sha256hex);

        //Initializing a Cipher object
//        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
//
//        //Adding data to the cipher
//        byte[] bytesNewLogin = getNewPassword().getBytes();
//        cipher.update(bytesNewLogin);
//
//        //encrypting the data
//        byte[] cipherText = cipher.doFinal();
//        setNewPassword(String.valueOf(cipherText));
//        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //Adding data to the cipher
//        byte[] bytesFile = userData.getBytes();
//        cipher.update(bytesFile);
//
//        //encrypting the data
//        bytesFile = cipher.doFinal();
//        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
//        byte[] decipheredText = cipher.doFinal(bytesFile);
//        cipher.update(decipheredText);
//        System.out.println(new String(decipheredText));

    }

    public static void DecryptionFile() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException {
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
//
//        //Initializing the key pair generator
//        keyPairGen.initialize(2048);
//
//        //Generating the pair of keys
//        KeyPair pair = keyPairGen.generateKeyPair();
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
//        byte[] decipheredText = cipher.doFinal(cipherText);
//        cipher.update(decipheredText);
//        System.out.println(new String(decipheredText));
    }


}
