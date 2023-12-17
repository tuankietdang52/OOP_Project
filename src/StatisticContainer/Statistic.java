package StatisticContainer;

import Bill.DSHD;
import InputManage.Input;
import ProductContainer.DSSP;
import ProductContainer.Product;
import Users.Customer;
import Users.Customerlist;
import Users.EmployeeList;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Statistic {
    private DSHD billList;
    private Customerlist customerList;
    private EmployeeList employeeList;
    private DSSP productList;


    public Statistic(){}

    public Statistic(DSHD billList, Customerlist customerList, EmployeeList employeeList, DSSP productList){
        this.billList = billList;
        this.customerList = customerList;
        this.employeeList = employeeList;
        this.productList = productList;
    }

    public DSHD getBillList() {
        return billList;
    }

    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    public Customerlist getCustomerList() {
        return customerList;
    }

    public void setBillList(DSHD billList) {
        this.billList = billList;
    }

    public void setCustomerList(Customerlist customerList) {
        this.customerList = customerList;
    }

    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    public Boolean checkDay(@NotNull LocalDate dateStart, @NotNull LocalDate dateEnd, @NotNull LocalDate date){
        if (date.getYear() < dateStart.getYear() || date.getYear() > dateEnd.getYear()) return false;
        else if (date.getMonthValue() < dateStart.getMonthValue() || date.getMonthValue() > dateEnd.getMonthValue()) return false;

        return (date.getDayOfMonth() >= dateStart.getDayOfMonth() && date.getDayOfMonth() <= dateEnd.getDayOfMonth());
    }

    public void statisticByDay(@NotNull LocalDate dateStart, @NotNull LocalDate dateEnd){
        int stt = 1;
        var list = billList.getDs();

        for (var bill : list){
            LocalDate date = bill.getNgaylap().toLocalDate();
            if (!checkDay(dateStart, dateEnd, date)) continue;

            System.out.println("Hoa don thu " + stt);
            System.out.println(bill);
            stt++;
        }
    }

    public void top3KhachHangChitieu() {
        var ds = customerList.getDs();
        int n = customerList.getDs().length;

        Arrays.sort(ds, Comparator.comparingDouble(Customer::getChitieu).reversed());

        int count = Math.min(3, n);
        Customer[] topCustomers = Arrays.copyOf(ds, count);

        if (topCustomers.length == 0){
            System.out.println("Chua co khach hang nao da mua hang");
            return;
        }

        System.out.println("Top 3 khách hàng chi tiêu nhiều nhất:");
        for (int i = 0; i < topCustomers.length; i++) {
            System.out.println("Khách hàng " + (i + 1) + ":");
            System.out.println(topCustomers[i]);
            System.out.println("---------------------------");
        }
    }


    public void top3ProductSold(){
        DSSP productList = new DSSP(true);
        var list = Arrays.copyOf(productList.getDs(), productList.getDs().length);

        Arrays.sort(list, (a, b) -> b.getSoldamount() - a.getSoldamount());

        System.out.println("Top 3 san pham duoc ban ra nhieu nhat:");

        for (int i = 0; i < 3; i++){
            if (list.length == 0){
                System.out.println("Chua co khach hang nao da mua hang");
                return;
            }

            System.out.println("San pham thu " + (i + 1) + ":");
            System.out.println(list[i]);
            System.out.println("So luong ban ra: " + list[i].getSoldamount());
            System.out.println("---------------------------");
        }
    }

    public void calRevenue(){
        DSSP productList = new DSSP(true);
        var list = productList.getDs();

        double revenue = 0;

        for (var product : list){
            double price = product.getDongia() * product.getSoldamount();
            revenue += price;
        }

        System.out.println("Tong doanh thu: " + (int)revenue);
    }

}
