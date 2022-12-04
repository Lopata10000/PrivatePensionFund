package dataBase;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

import static dataBase.Data.*;

public class Encryption {
    public static void encryptionGmail() {
        String sha256hex = String.valueOf(Hashing.sha256().hashString(getGmail() , StandardCharsets.UTF_8));
        setGmail(sha256hex);
    }

    public static void encryptionPassword() {
        String sha256hex = Hashing.sha256().hashString(getNewPassword() , StandardCharsets.UTF_8).toString();
        setNewPassword(sha256hex);
        setPassword(getNewPassword());
    }
}
