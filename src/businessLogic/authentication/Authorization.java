package businessLogic.authentication;

import businessLogic.userActions.ActionsWithData;
import dataBase.Data;

import static dataBase.Data.*;
import static intarface.Menu.dividingLine;
import static java.lang.System.out;

public class Authorization extends Check {
    public static void authorization() {
        out.println(dividingLine + "\n" +
                "|Ваш логін:                                                        |" + "\n" +
                dividingLine);
        setNewLogin(scanner.nextLine());
        out.println(dividingLine + "\n" +
                "|E-mail:                                                           |" + "\n" +
                dividingLine);
        setGmail(scanner.nextLine());
        out.println(dividingLine + "\n" +
                "|Ваш пароль(English):                                              |" + "\n" +
                dividingLine);
        setNewPassword(scanner.nextLine());
        Check.inputData();
        Data.Encryption.encryptionGmail();
        ActionsWithData.checkAuthorization();


    }
}
