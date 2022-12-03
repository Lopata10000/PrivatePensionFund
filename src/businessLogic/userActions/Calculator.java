package businessLogic.userActions;

import businessLogic.authentication.Validation;
import intarface.Menu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static dataBase.Data.*;
import static java.lang.System.out;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static String command;

    public static void Calculations() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        Validation.ageValidation();
        Validation.contributionsValidation();
        Validation.regularContributionsValidation();
        int age = Integer.parseInt(getAge());
        int pensionAge = (getRetirementAge() - age);
        double InitialСontribution = Integer.parseInt(getInitialСontribution());

        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваші накопичення після виходу на пенсію через " + pensionAge + " років складатимуть:  |" + "\n" +
                "|" + Math.round(ActionsWithData.compoundInterest(InitialСontribution)) + " грошових одиниць |" + "\n" +
                "|------------------------------------------------------------------|");
        Menu.actionsWithAccounts();
    }
}
