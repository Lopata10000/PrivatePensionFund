package BuisnesLogic;

import DataAccess.ActionsWithData;
import DataAccess.Data;
import DataAccess.getLine;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("ALL")
public class Validation extends Data implements getLine {
    public static boolean isValidPassword() {
        String regex = "^(?=.*\\d)"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternPassword = Pattern.compile(regex);
        Matcher matcherPassword = patternPassword.matcher(getNewPassword());
        return matcherPassword.matches();
    }

    public static boolean isValidGmail() {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        //Compile regular expression to get the pattern
        Pattern patternGmail = Pattern.compile(regex);
        Matcher matcherGmail = patternGmail.matcher(getGmail());
        return matcherGmail.matches();
    }

    public static boolean isValidLogin() {
        String regex = "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,30}$";
        Pattern patternLogin = Pattern.compile(regex);
        Matcher matcherLogin = patternLogin.matcher(getNewLogin());
        return matcherLogin.matches();
    }


    public static void totalCheck() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        if (Validation.isValidPassword()) {
            ActionsWithData.saveUser();
        } else {
            Registration.registration();
        }
    }
    }

