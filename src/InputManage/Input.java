package InputManage;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    private static String _getString() {
        return scanner.nextLine();
    }

    public static String getString() {
        return _getString();
    }

    public static @NotNull Boolean getBoolean() {
        var bool = _getString();
        if (bool.equals("true")) return true;
        else if (bool.equals("false")) return false;
        else {
            System.out.println("Nhap true hoac false");
            return getBoolean();
        }
    }

    public static int getInt() {
        try {
            return Integer.parseInt(_getString());
        }
        catch (NumberFormatException ex) {
            System.out.println("Nhap lai: ");
            return getInt();
        }
    }

    public static long getLong() {
        try {
            return Long.parseLong(_getString());
        }
        catch (NumberFormatException ex) {
            System.out.println("Nhap lai: ");
            return getLong();
        }
    }

    public static double getDouble() {
        try {
            return Double.parseDouble(_getString());
        }
        catch (NumberFormatException ex) {
            System.out.println("Nhap lai: ");
            return getDouble();
        }
    }

    public static void close(){
        scanner.close();
    }
}