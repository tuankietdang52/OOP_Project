import InputManage.Input;
import ProductContainer.Shirt;
import Users.Customer;
import ProductContainer.DSSP;
import ProductContainer.Pant;
import Users.Employee;

import java.util.Scanner;

public class Main {
    public final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Customer e = new Customer();
        e.setByInput();

        System.out.println(e);

        DSSP a = new DSSP();
        Pant quan = new Pant("123123","Quan jean","Nam",100,71.9,"Cotton","XL",true);
        Shirt ao = new Shirt("111","Ao thun","Nu",70,16.4,"Nilon","M",false,"Banh xe");
        a.nhap();
        a.them(quan);
        a.them(ao);
        a.timkiemTensp_Product("Ao thun").toString();
    }
}