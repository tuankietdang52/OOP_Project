package StatisticContainer;

import Bill.DSHD;
import InputManage.Input;
import Users.Customerlist;
import Users.Employee;
import Users.EmployeeList;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class StatisticManagement {
    private DSHD billList;
    private Customerlist customerList;
    private EmployeeList employeeList;

    public StatisticManagement(){}

    public void getData(){
        billList = new DSHD(true);
        customerList = new Customerlist(true);
        employeeList = new EmployeeList(true);
    }

    public Boolean checkValidDay(@NotNull LocalDate dateStart, @NotNull LocalDate dateEnd){
        if (dateStart.getYear() > dateEnd.getYear()) return false;
        else if (dateStart.getMonth().getValue() > dateEnd.getMonth().getValue()) return false;

        return dateStart.getDayOfMonth() <= dateEnd.getDayOfMonth();
    }

    public void handleStatisticByDay(){
        getData();
        Statistic statistic = new Statistic(billList, customerList, employeeList);

        LocalDate dateStart, dateEnd;
        boolean isValid = true;

        do{
            System.out.println("Nhap ngay bat dau: ");
            dateStart = Input.getDate();

            System.out.println("Nhap ngay ket thuc: ");
            dateEnd = Input.getDate();

            isValid = checkValidDay(dateStart, dateEnd);

            if (!isValid){
                System.out.println("Ngay ket thuc khong duoc be hon ngay bat dau, Nhap lai:");
            }
        } while (!isValid);


        statistic.statisticByDay(dateStart, dateEnd);
    }
}
