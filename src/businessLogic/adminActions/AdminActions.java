package businessLogic.adminActions;

import businessLogic.authentication.Validation;
import businessLogic.userActions.getLine;
import dataBase.Data;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import intarface.Menu;

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

import static java.lang.System.out;

@SuppressWarnings("ALL")
public class AdminActions extends Data implements getLine {
    @SuppressFBWarnings("NM_METHOD_NAMING_CONVENTION")
    public static void veiwList() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
       Menu.clearConsole();
        int line = 1;
        try (var reader = new BufferedReader(new FileReader(userData))) {
            while (reader.readLine() != null) {
                line++;
                setNumberLine(line);
            }
            Scanner numberedFile = new Scanner(Paths.get(userData) , StandardCharsets.UTF_8);
            while (numberedFile.hasNext()) {
                for (int i = 1; i < getNumberLine(); i++)
                    out.println("[Line Number: " + i + "] " + numberedFile.nextLine());
            }
        } catch (IOException ex) {
            out.println("Немає даних");
            Menu.mainMenu();
        }

    }

    @SuppressFBWarnings("REC_CATCH_EXCEPTION")
    public static void deleadUser() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        veiwList();
        try {
            out.println(dividingLine + "\n" +
                    "|Виберіть дані які ви хочете видалити                              |" + "\n" +
                    dividingLine);
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
            Menu.adminMenu();
        } catch (Exception ex) {
            out.println(dividingLine + "\n" +
                    "|Дані відсутні.                                                    |" + "\n" +
                    dividingLine);
            Menu.mainMenu();
        }
    }

    public static void rewu() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Menu.clearConsole();
        veiwList();
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
