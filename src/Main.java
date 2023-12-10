import Bill.HoaDon;
import InputManage.Input;
import Menu.MainMenu;
import ProductContainer.Product;
import ProductContainer.Shirt;
import Users.Customer;
import ProductContainer.DSSP;
import ProductContainer.Pant;
import Users.Customerlist;
import Users.Employee;

public class Main {
    public static void main(String[] args) {
        HoaDon hoadon = new HoaDon();
        hoadon.setByInput();

        System.out.println(hoadon);


        Input.close();
    }
}