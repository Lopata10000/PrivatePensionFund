package businessLogic.userActions;

import businessLogic.authentication.Validation;
import dataBase.Data;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import intarface.Menu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static java.nio.file.Files.lines;

@SuppressWarnings({"resource" , "NonAsciiCharacters"})
public class ActionsWithData extends Data implements getLine {
    private static final String password = "Password: ";

    @SuppressFBWarnings("REC_CATCH_EXCEPTION")
    //перевірка даних для авторизації
    public static void checkAuthorization() {
        try {
            Path path = Paths.get(userData);
            if (lines(path , StandardCharsets.UTF_8).noneMatch(("Login: " + getNewLogin())::equals)) {
                out.println(dividingLine + "\n" +
                        "|Такого акаунту немає.                                             |" + "\n" +
                        dividingLine);
                Menu.mainMenu();
            } else {
                if (lines(path , StandardCharsets.UTF_8).anyMatch((password + getNewPassword())::equals) && lines(path , StandardCharsets.UTF_8).anyMatch(("E-mail: " + getGmail())::equals)) {
                    if (getNewLogin().equals("FantaPetro"))
                        Menu.adminMenu();
                    else
                        Menu.actionsWithAccounts();
                } else {
                    out.println(dividingLine + "\n" +
                            "|Такого акаунту немає.                                             |" + "\n" +
                            dividingLine);
                    Menu.mainMenu();
                }
            }
        } catch (Exception ex) {
            out.println("Немає даних");

        }
    }

    // добавлення депозиту
    public static void addDeposit() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        Validation.contributionsValidation();
        Validation.ageValidation();
        Date date = new Date();
        Path of = Path.of(userData);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(of , StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(password + getPassword())) {
                fileContent.set(i , password + getPassword() + "\n" + "Age: " + getAge() + "\n" + "Deposit: " + getInitialСontribution() + " Time: " + date);
                break;
            }
        }
        Files.write(of , fileContent , StandardCharsets.UTF_8);
        Menu.actionsWithAccounts();
    }

    // зміна інформації про нас
    public static void changeInformationAboutUs() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        out.println(dividingLine + "\n" + "|Нова інформація:                                                  |" + "\n" + dividingLine);
        String newInformationAboutUs = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(informationAboutUs , false))) {
            writer.write(dividingLine + "\n" +
                    newInformationAboutUs);
            out.println(dividingLine + "\n" +
                    "|Дані змінено успішно!                                             |" + "\n" +
                    dividingLine);
            Menu.adminMenu();
        }
        Menu.adminMenu();
    }

    // вивід інформаці\ про нас
    public static void informationAboutUs() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        if (Files.exists((Path.of(informationAboutUs)))) {
            FileReader reader = new FileReader(informationAboutUs);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(informationAboutUs , false))) {
                writer.write("|--======================================================================-- Пенсійний фонд ''Чахлики'' --========================================================================--|" + "\n" +
                        "Зараз все більше людей замислюються над тим, як прожити на державну пенсію. Люди, яким не байдуже своє майбутнє, вже сьогодні намагаються вигідно вкласти свої кошти, щоб забезпечити собі гідне життя і на пенсії. Що ж робити, якщо Вас хвилює питання збереження своїх коштів в умовах фінансової нестабільності?\n" +
                        "\n" +
                        "Вихід є – вкладати свої кошти в Недержавний пенсійний Фонд! Відкритий Пенсійний фонд «Чахлики» допоможе Вам сформувати достатні пенсійні накопичення, зберігши і примноживши їх. Наші активи відокремлені від обслуговуючих компаній, що робить неможливим банкротство Чахликів і його ліквідацію.\n" +
                        "\n" +
                        "Вкладаючи кошти в наш Фонд Ви максимально захищені від непередбачуваних факторів і гарантуєте собі безбідну старість. Ми - це пенсій фонд із великим досвідом. У сфері з 2000 року. Ми надаємо можливість відкласти гроші під 8% до моменту виходу на Вашу пенсію.");
                FileReader reader = new FileReader(informationAboutUs);
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine())
                    System.out.println(scanner.nextLine());
                informationAboutUs();
            }
        }
    }

    //переглянути власний депозит
    public static void viewDeposit() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(userData) , StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(password + getNewPassword())) {
                out.println(fileContent.get(i + 2));
                break;
            }
        }
        Menu.actionsWithAccounts();
    }
}
