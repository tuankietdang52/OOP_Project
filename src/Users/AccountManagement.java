package Users;

import InputManage.Input;
import Interface.IAccount;
import Menu.CustomerMenu;
import Menu.EmployeeMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AccountManagement {
    private Customerlist customerList;
    private EmployeeList employeeList;

    private Customer currentUser;
    private Employee currentEmployee;
    private Boolean isUser = true;
    private Boolean isEmployee = true;

    public Customer getCurrentUser() {
        return currentUser;
    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public Boolean getCheckUser() {
        return isUser;
    }

    public Boolean getCheckEmployee() {
        return isEmployee;
    }

    public void setCurrentUser(Customer currentUser) {
        this.currentUser = currentUser;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public void setCheckUser(Boolean isUser) {
        this.isUser = isUser;
    }

    public void setCheckEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Customerlist getCustomerList() {
        getListData();
        return customerList;
    }

    public EmployeeList getEmployeeList() {
        getListData();
        return employeeList;
    }

    private void getListData(){
        customerList = new Customerlist(true);
        employeeList = new EmployeeList(true);
    }

    private @NotNull Boolean checkCustomerAccount(String username){
        var accountData = customerList.getDs();

        for (var customer : accountData){
            if (username.equals(customer.getUsername())) return true;
        }

        return false;
    }

    private @NotNull Boolean checkEmployeeAccount(String username){
        var accountData = employeeList.getDs();

        for (var employee : accountData){
            if (username.equals(employee.getUsername())) return true;
        }

        return false;
    }

    public @Nullable IAccount getAccountData(String username, String type){
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

    private @Nullable Customer getCustomerAccount(String username){
        for (var customer : customerList.getDs()){
            if (customer.getUsername().equals(username)) return customer;
        }
        return null;
    }

    private @Nullable Employee getEmployeeAccount(String username){
        for (var employee : employeeList.getDs()){
            if (employee.getUsername().equals(username)) return employee;
        }
        return null;
    }

    public @NotNull Boolean checkAccount(String username) {
        getListData();

        // Khong tim thay se tra ve false, tim thay se tra ve true
        if (checkCustomerAccount(username)) return true;
        return checkEmployeeAccount(username);
    }

    public void setAccount(String username){
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
}
