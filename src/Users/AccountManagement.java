package Users;

import InputManage.Input;
import Interface.IAccount;
import Menu.CustomerMenu;
import Menu.EmployeeMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AccountManagement {
    private static Customerlist customerList;
    private static EmployeeList employeeList;

    public static Customer currentUser;
    public static Employee currentEmployee;
    private static Boolean isUser = true;
    private static Boolean isEmployee = true;

    private static void getData(){
        customerList = new Customerlist(true);
        employeeList = new EmployeeList(true);
    }

    public static @NotNull Boolean checkAccount(String username) {
        getData();

        // Khong tim thay se tra ve false, tim thay se tra ve true
        if (checkCustomerAccount(username)) return true;
        return checkEmployeeAccount(username);
    }

    private static @NotNull Boolean checkCustomerAccount(String username){
        var accountData = customerList.getDs();

        for (var customer : accountData){
            if (username.equals(customer.getUsername())) return true;
        }

        return false;
    }

    private static @NotNull Boolean checkEmployeeAccount(String username){
        var accountData = employeeList.getDs();

        for (var employee : accountData){
            if (username.equals(employee.getUsername())) return true;
        }

        return false;
    }

    public static @Nullable IAccount getAccountData(String username, String type){
        type = type.toLowerCase();
        switch (type){
            case "customer":
                return getCustomerAccount(username);

            case "employee":
                return getEmployeeAccount(username);

            default:
                return null;
        }
    }

    private static @Nullable Customer getCustomerAccount(String username){
        for (var customer : customerList.getDs()){
            if (customer.getUsername().equals(username)) return customer;
        }
        return null;
    }

    private static @Nullable Employee getEmployeeAccount(String username){
        for (var employee : employeeList.getDs()){
            if (employee.getUsername().equals(username)) return employee;
        }
        return null;
    }

    private static void setAccount(String username){
        currentUser = (Customer)getAccountData(username, "customer");
        currentEmployee = (Employee)getAccountData(username, "employee");

        // neu khong tim duoc thi bien current se bang new (object rong~) de tranh loi~ null
        // neu bang null thi bien kiem tra khach hang hay nhan vien se tra ve false
        if (currentUser == null){
            isUser = false;
            currentUser = new Customer();
        }
        if (currentEmployee == null) {
            isEmployee = false;
            currentEmployee = new Employee();
        }
    }

    public static void SignIn(){
        String username, password;
        var isValid = true;

        System.out.println("----------------Dang nhap----------------");
        do{
            // reset lai 2 bien kiem tra la khach hang hay nhan vien
            isUser = true;
            isEmployee = true;

            if (!isValid){
                System.out.println("Sai tk hoac mat khau, Nhap lai: ");
            }

            System.out.print("Tai khoan: ");
            username = Input.getString();

            System.out.print("Mat khau: ");
            password = Input.getString();

            if (username.isEmpty() || password.isEmpty()) continue;

            isValid = checkAccount(username);

            if (isValid) setAccount(username);
            else continue;

            isValid = password.equals(currentUser.getPassword());
            if (!isValid) isValid = password.equals(currentEmployee.getPassword());

        }while (!isValid);

        showMenu();

    }

    private static void showMenu(){
        if (isUser) showCustomerMenu();
        else showEmployeeMenu();
    }

    public static void SignUp(){
        Customer newcustomer = new Customer();
        var isValid = true;
        System.out.println("-----------------Dang ki-----------------");
        do{
            System.out.print("Tao tai khoan: ");
            newcustomer.setUsername(Input.getString());

            isValid = !checkAccount(newcustomer.getUsername());

            if (!isValid){
                System.out.println("Ten tai khoan da co nguoi su dung, vui long dung tai khoan khac");
                continue;
            }

            System.out.print("Tao mat khau: ");
            newcustomer.setPassword(Input.getString());

        }while (!isValid);

        newcustomer.setByInput();
        newcustomer.createMakh();
        customerList.them(newcustomer);
    }

    private static void showCustomerMenu(){
        CustomerMenu csmenu = new CustomerMenu();
        csmenu.showMenu();
    }

    private static void showEmployeeMenu(){
        EmployeeMenu epmenu = new EmployeeMenu();
        epmenu.showMenu();
    }
}
