package InputManage;

import ProductContainer.ESex;
import ProductContainer.ESize;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.nextLine();
    }

    public static @NotNull Boolean getBoolean() {
        var bool = getString();
        if (bool.equals("true")) return true;
        else if (bool.equals("false")) return false;
        else {
            System.out.println("Nhap true hoac false");
            return getBoolean();
        }
    }

    public static int getInt() {
        try {
            return Integer.parseInt(getString());
        }
        catch (NumberFormatException ex) {
            System.out.println("Nhap lai: ");
            return getInt();
        }
    }

    public static long getLong() {
        try {
            return Long.parseLong(getString());
        }
        catch (NumberFormatException ex) {
            System.out.println("Nhap lai: ");
            return getLong();
        }
    }

    public static double getDouble() {
        try {
            return Double.parseDouble(getString());
        }
        catch (NumberFormatException ex) {
            System.out.println("Nhap lai: ");
            return getDouble();
        }
    }

    public static ESize getSize(){
        String size = getString().toUpperCase();

        switch (size){
            case "S":
                return ESize.S;
            case "M":
                return ESize.M;
            case "L":
                return ESize.L;
            case "XL":
                return ESize.XL;
            default:
                System.out.println("Sai dinh dang Size, Nhap lai: ");
                return getSize();
        }
    }

    public static ESex getSex(){
        String size = getString().toUpperCase();

        switch (size){
            case "NAM":
                return ESex.Nam;
            case "NU":
                return ESex.Nu;
            default:
                System.out.println("Nam hoac Nu, Nhap lai: ");
                return getSex();
        }
    }

    public static void close(){
        scanner.close();
    }
}