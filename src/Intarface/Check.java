package Intarface;

import DataBase.Data;

import static java.lang.System.out;

public class Check {
    public static void checkDataRegistration() {
        out.println("Виберіть логін:");
        Data.setNewLogin(Data.scanner.nextLine());
        if (Data.newLogin.length() <= 8) {
            out.println("Мінімаль надовжина логіну 8 символів.");
            Data.setConfirmRegistration(false);
        } else {
            out.println("Виберіть пароль:");
            Data.setNewPassword(Data.scanner.nextLine());
            if (Data.newPassword.length() <= 8) {
                out.println("Мінімальна довжина паролю 8 символів");
                Data.setConfirmRegistration(false);
            } else {
                out.println("Підтвердіть пароль:");
                Check.checkDataRegistration();
                if (Data.ConfirmPassword != Data.newPassword) {
                    out.println("Паролі не співпадають");
                    Data.setConfirmRegistration(false);
                } else {
                    Data.setConfirmRegistration(true);
                }
            }
        }
    }
}
