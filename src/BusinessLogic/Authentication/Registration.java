package BusinessLogic.Authentication;

import DataBase.Data;
import Intarface.Check;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class Registration {
    public static void registration() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Data.userData))) {
            Check.checkDataRegistration();

            writer.append("-----------------------------------------------------" + "\n" +
                        "Логін: " + Data.getNewLogin() + "\n" +
                        "Пароль: " + Data.getNewPassword() + "\n");
                writer.close();
                out.println("Успішно");

        } catch (Exception exception) {
            out.println("Пусто");
        }
    }
}
