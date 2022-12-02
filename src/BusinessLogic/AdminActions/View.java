package BusinessLogic.AdminActions;

import Intarface.IntarfaceMenu;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static DataBase.Data.*;
import static java.lang.System.out;

public class View {
    public static File sourceFile = new File(userData);
    public static File outputFile = new File(userData);

    public static void VeiwList() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Scanner in = new Scanner(Paths.get(userData) , StandardCharsets.UTF_8);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        IntarfaceMenu.AdminMenu();
    }

    public static void DeleadUser() throws IOException {
        String line;
        out.println("|------------------------------------------------------------------|" + "\n" +
                "|Ваш пароль(English):                                              |" + "\n" +
                "|------------------------------------------------------------------|");
        setLogin(scanner.nextLine());
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!line.equals(getLogin())) {
                writer.write(line);
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }
}
