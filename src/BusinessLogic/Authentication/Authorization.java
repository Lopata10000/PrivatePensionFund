package BusinessLogic.Authentication;

import Intarface.Check;

import java.util.Scanner;

import static java.lang.System.in;

public class Authorization {
    static Scanner scanner = new Scanner(in);
    public static void authorization() {
        Check.checkAuthorization();
    }
}
