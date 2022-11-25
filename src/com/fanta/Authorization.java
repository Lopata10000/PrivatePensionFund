package com.fanta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.fanta.LogIn.userData;
import static java.lang.System.in;
import static java.lang.System.out;

public class Authorization {
    static Scanner scanner = new Scanner(in);
    public static String newLogin;
    public static String newPassword;
    public static  String login;
    public static String password;
    public static void authorization()
    {
        out.println("Ваш логін:");
        login = scanner.nextLine();
        out.println("Ваш пароль");
        password = scanner.nextLine();
        try( FileReader reader= new FileReader(userData))
        {
            Scanner scan = new Scanner(reader);

            if (Files.lines(Paths.get(userData), StandardCharsets.UTF_8)
                    .anyMatch(login::equals) && Files.lines(Paths.get(userData), StandardCharsets.UTF_8).anyMatch(password::equals))
            {
                out.println("Такий акаунт знайдено");
            }
            else {
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
