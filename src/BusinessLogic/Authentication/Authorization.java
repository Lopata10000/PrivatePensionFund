package BusinessLogic.Authentication;

import DataBase.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Authorization {
    static Scanner scanner = new Scanner(in);
    public static void authorization() {
        out.println("Ваш логін:");
        Data.setLogin(scanner.nextLine());
        out.println("Ваш пароль");
        Data.setPassword(scanner.nextLine());
        try (FileReader reader = new FileReader(Data.userData)) {
            Scanner scan = new Scanner(reader);
            if (Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8)
                    .anyMatch(Data.getLogin()::equals) && Files.lines(Paths.get(Data.userData) , StandardCharsets.UTF_8).anyMatch(Data.getPassword()::equals)) {
                out.println("Такий акаунт знайдено");
            } else {
                out.println("Такого акаунту немає");
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
