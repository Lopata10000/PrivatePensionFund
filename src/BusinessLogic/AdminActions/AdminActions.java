package BusinessLogic.AdminActions;

import BusinessLogic.Authentication.Validation;
import Intarface.Menu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static DataBase.Data.*;
import static java.lang.System.out;

public class AdminActions {
    public static void VeiwList() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        int line = 1;
        try (var reader = new BufferedReader(new FileReader(userData))) {
            while (reader.readLine() != null) {
                line++;
                setNumberLine(line);
            }
            Scanner numberedFile = new Scanner(Paths.get(userData) , StandardCharsets.UTF_8);
            while (numberedFile.hasNext()) {
                for (int i = 1; i < getNumberLine(); i++)
                    System.out.println("[Line Number: " + i + "] " + numberedFile.nextLine());
            }
        } catch (Exception ex) {
            out.println("Немає даних");
            Menu.mainMenu();
        }

    }

    public static void DeleadUser() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        AdminActions.VeiwList();
        try {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Виберіть дані які ви хочете видалити                              |" + "\n" +
                    "|------------------------------------------------------------------|");
            setNumberForDelead(scanner.nextLine());
            File tmp = File.createTempFile("tmp" , "");

            BufferedReader reader = new BufferedReader(new FileReader(userData));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmp));

            for (int i = 0; i < Integer.parseInt(getNumberForDelead()); i++)
                writer.write(String.format("%s%n" , reader.readLine()));

            reader.readLine();

            String usersData;
            while (null != (usersData = reader.readLine()))
                writer.write(String.format("%s%n" , usersData));

            reader.close();
            writer.close();

            File oldFile = new File(userData);
            if (oldFile.delete())
                tmp.renameTo(oldFile);
            Menu.AdminMenu();
        } catch (Exception ex) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Дані відсутні.                                                    |" + "\n" +
                    "|------------------------------------------------------------------|");
            Menu.mainMenu();
        }
    }

    public static void Rewu() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        VeiwList();
        Validation.lineForChangeValidation();
        String changeContent = scanner.nextLine();

        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(userData) , StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals(getChangeLine())) {
                fileContent.set(i , changeContent);
                break;
            }
        }

        Files.write(Path.of(userData) , fileContent , StandardCharsets.UTF_8);
    }
}
