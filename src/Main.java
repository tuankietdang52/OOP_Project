import InputManage.Input;
import ProductContainer.Shirt;
import Users.Customer;
import Users.Employee;

import java.util.Scanner;

public class Main {
    public final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Customer e = new Customer();
        e.setByInput();

        System.out.println(e);

        Input.close();
    }
}