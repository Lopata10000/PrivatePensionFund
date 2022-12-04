package businessLogic.userActions;
import intarface.Menu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static businessLogic.authentication.Validation.*;
import static java.lang.System.out;

public class Calculator {

    public static void Calculations() throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, ShortBufferException {
        ageValidation();
        contributionsValidation();
        regularContributionsValidation();
        int age = Integer.parseInt(getAge());
        int pensionAge = (getRetirementAge() - age);
        double initialСontribution = Integer.parseInt(getInitialСontribution());

        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваші накопичення після виходу на пенсію через " + pensionAge + " років складатимуть:  |" + "\n" +
                "|" + Math.round(Calculation.compoundInterest(initialСontribution)) + " грошових одиниць |" + "\n" +
                "|------------------------------------------------------------------|");
        Menu.mainMenu();
    }
}
