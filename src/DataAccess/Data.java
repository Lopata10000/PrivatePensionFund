package DataAccess;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.System.in;

public class Data {

    public static final Scanner scanner = new Scanner(in);
    public static final String userData = "Users.txt";
    public static final String response = "Users.txt";
    public static String newLogin;
    public static String gmail;
    public static String writtenResponse;
    public static String newPassword;

    public static String getWrittenResponse() {
        return writtenResponse;
    }

    public static void setWrittenResponse(String writtenResponse) {
        Data.writtenResponse = writtenResponse;
    }

    public static String getGmail() {
        return gmail;
    }

    public static void setGmail(String gmail) {
        Data.gmail = gmail;
    }

    public static String getNewLogin() {
        return newLogin;
    }

    public static void setNewLogin(String newLogin) {
        Data.newLogin = newLogin;
    }

    public static String getNewPassword() {
        return newPassword;
    }

    public static void setNewPassword(String newPassword) {
        Data.newPassword = newPassword;
    }

    // хешування
    public class Encryption {
        public static void encryptionGmail() {
            String sha256hex = String.valueOf(Hashing.sha256().hashString(getGmail() , StandardCharsets.UTF_8));
            setGmail(sha256hex);
        }

        public static void encryptionPassword() {
            String sha256hex = Hashing.sha256().hashString(getNewPassword() , StandardCharsets.UTF_8).toString();
            setNewPassword(sha256hex);
        }
    }


}

