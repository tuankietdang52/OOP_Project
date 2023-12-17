import Bill.DSHD;
import Bill.HoaDon;
import EntrySlip.DSPN;
import InputManage.Input;
import Menu.MainMenu;
import ProductContainer.DSSP;
import Users.AccountManagement;
import Users.Customerlist;
import Users.Employee;
import Users.EmployeeList;

public class Main {
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        MainMenu menu = new MainMenu(accountManagement);

        menu.menu();







        Input.close();
    }
}