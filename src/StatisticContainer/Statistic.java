package StatisticContainer;

import Bill.DSHD;
import InputManage.Input;
import Users.Customerlist;
import Users.EmployeeList;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Statistic {
    private DSHD billList;
    private Customerlist customerList;
    private EmployeeList employeeList;


    public Statistic(){}

    public Statistic(DSHD billList, Customerlist customerList, EmployeeList employeeList){
        this.billList = billList;
        this.customerList = customerList;
        this.employeeList = employeeList;
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

}
