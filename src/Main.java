import Bill.HoaDon;
import InputManage.Input;
import Menu.MainMenu;
import ProductContainer.Product;
import ProductContainer.Shirt;
import Users.AccountManagement;
import Users.Customer;
import ProductContainer.DSSP;
import ProductContainer.Pant;
import Users.Customerlist;
import Users.Employee;

public class Main {
    public static void main(String[] args) {
        AccountManagement.SignIn();

        System.out.println(AccountManagement.currentUser);


        Input.close();
    }
}