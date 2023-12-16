package Menu;

import InputManage.Input;
import Users.AccountManagement;
import Users.Customer;

public class MainMenu {
    private final AccountManagement accountManage;

    public MainMenu(AccountManagement accountManage){
        this.accountManage = accountManage;
    }

    public void menu(){
        System.out.println("----------Cua hang shiba lmao----------");
        System.out.println("1. Dang nhap              2. Dang ki");
        int choice;

        do{
            choice = Input.getInt();
            switch (choice){
                case 1:
                    SignIn();
                    break;

                case 2:
                    SignUp();
                    break;

                default:
                    System.out.println("Lua chon khong ton tai, Nhap lai: ");
            }
        } while (choice != 1 && choice != 2);
    }

    public void SignIn(){
        String username, password;
        var isValid = true;

        System.out.println("----------------Dang nhap----------------");
        do{
            // reset lai 2 bien kiem tra la khach hang hay nhan vien
            accountManage.setCheckUser(true);
            accountManage.setCheckEmployee(true);

            if (!isValid){
                System.out.println("Sai tk hoac mat khau, Nhap lai: ");
            }

            System.out.print("Tai khoan: ");
            username = Input.getString();

            System.out.print("Mat khau: ");
            password = Input.getString();

            if (username.isEmpty() || password.isEmpty()) continue;

            isValid = accountManage.checkAccount(username);

            if (isValid) accountManage.setAccount(username);
            else continue;

            isValid = password.equals(accountManage.getCurrentUser().getPassword());
            if (!isValid) isValid = password.equals(accountManage.getCurrentEmployee().getPassword());

        }while (!isValid);

        showMenu();

    }

    public void SignUp(){
        Customer newcustomer = new Customer();
        var customerList = accountManage.getCustomerList();

        var isValid = true;
        System.out.println("-----------------Dang ki-----------------");
        do{
            System.out.print("Tao tai khoan: ");
            newcustomer.setUsername(Input.getString());

            isValid = !accountManage.checkAccount(newcustomer.getUsername());

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

    private void showMenu(){
        if (accountManage.getCheckUser()) showCustomerMenu();
        else if (accountManage.getCheckEmployee()) showEmployeeMenu();
        else{
            System.out.println("Khong tim thay menu phu hop voi tai khoan");
        }
    }

    private void showCustomerMenu(){
        CustomerMenu csmenu = new CustomerMenu(accountManage.getCurrentUser());
        csmenu.showMenu();
    }

    private void showEmployeeMenu(){
        EmployeeMenu epmenu = new EmployeeMenu(accountManage.getCurrentEmployee());
        epmenu.showMenu();
    }
}
