import InputManage.Input;
import ProductContainer.Product;
import ProductContainer.Shirt;
import Users.Customer;
import ProductContainer.DSSP;
import ProductContainer.Pant;
import Users.Customerlist;
import Users.Employee;

public class Main {
    public static void main(String[] args) {
        Customerlist ds = new Customerlist();

        for (var item : ds.getDs()){
            System.out.println(item);
        }
    }
}