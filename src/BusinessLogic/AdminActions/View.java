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

import static DataBase.Data.scanner;
import static DataBase.Data.userData;
import static java.lang.System.out;

public class View {

    public static void VeiwList() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Scanner in = new Scanner(Paths.get(userData) , StandardCharsets.UTF_8);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        IntarfaceMenu.AdminMenu();
    }

    public static void DeleadUser() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        View.VeiwList();
        try {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Виберіть дані які ви хочете видалити                              |" + "\n" +
                    "|------------------------------------------------------------------|");
            int number = scanner.nextInt();
            File tmp = File.createTempFile("tmp" , "");

            BufferedReader reader = new BufferedReader(new FileReader(userData));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmp));

            for (int i = 0; i < number; i++)
                writer.write(String.format("%s%n" , reader.readLine()));

            reader.readLine();

            String userData;
            while (null != (userData = reader.readLine()))
                writer.write(String.format("%s%n" , userData));

            reader.close();
            writer.close();

            File oldFile = new File(userData);
            if (oldFile.delete())
                tmp.renameTo(oldFile);
            IntarfaceMenu.AdminMenu();
        } catch (Exception ex) {
            out.println("|------------------------------------------------------------------|" + "\n" +
                    "|Дані відсутні.                                                    |" + "\n" +
                    "|------------------------------------------------------------------|");
        }
    }
}
