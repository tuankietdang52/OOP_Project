package Users;
import InputManage.Input;
import Interface.IFile;
import Interface.IList;
import ProductContainer.Product;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;
import java.util.*;
public class EmployeeList implements IFile, IList<Employee> {
    private Employee[] ds;
    private int n;
    public void nhap() {
        System.out.print("Nhap so luong nhan vien: ");
        n = Input.getInt();
        ds = new Employee[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Nhan vien thu " + (i + 1));
            ds[i] = new Employee();
            ds[i].setByInput();
        }
        save();
    }

    public String toString() {
        for (int i = 0; i < n; ++i) {
            System.out.println("\nNhan vien thu " + (i + 1) + ":");
            System.out.println(ds[i]);
        }
        return "";
    }

    public EmployeeList() {
    }

    public EmployeeList(Boolean isGetData){
        if (!isGetData) return;

        try{
            read();
        }
        catch (Exception ex){
            if (ds.length == 0){
                ds = new Employee[0];
                return;
            }
            System.out.println("Cant get data from file\nError: " + ex);
        }

    }

    public EmployeeList(Employee[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public EmployeeList(@org.jetbrains.annotations.NotNull EmployeeList a) {
        n = a.n;
        ds = a.ds;
    }

    public Employee[] getDs() {
        return ds;
    }
    public int getN(){return n;}

    public void setDs(Employee[] ds) {
        this.ds = ds;
    }

    public void setElementofDs(int pos, Employee employee){
        ds[pos] = employee;
    }

    @Override
    public Employee @NotNull [] increaseLength(){
        var temparray = new Employee[ds.length + 1];
        System.arraycopy(ds, 0, temparray, 0, ds.length);
        return temparray;
    }

    @Override
    public void read() throws Exception {
        ds = new Employee[0];
        var i = 0;

        File employeedata = new File("./src/Data/Employee.bin");
        FileInputStream stream = new FileInputStream(employeedata);
        ObjectInputStream read = new ObjectInputStream(stream);
        try{
            while (true){
                var employee = (Employee)read.readObject();
                if (employee == null) break;

                if (i >= ds.length) ds = increaseLength();

                ds[i] = employee;
                i++;
            }
        }
        catch (EOFException ex){
            read.close();
        }
        n = ds.length;
    }

    @Override
    public void save() {
        File employeedata = new File("./src/Data/Employee.bin");
        try{
            FileOutputStream stream = new FileOutputStream(employeedata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            for (var item : ds) {
                write.writeObject(item);
            }
            write.close();
        }
        catch (Exception ex){
            System.out.println("Cant write data from file\nError: " + ex);
        }

    }

    @Override
    public void clear() {
        File employeedata = new File("./src/Data/Employee.bin");
        try{
            FileOutputStream stream = new FileOutputStream(employeedata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            write.writeChars("");
            write.close();
        }
        catch (Exception ex){
            System.out.println("Cant write data from file\nError: " + ex);
        }

    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Employee();
        ds[n].setByInput();
        ++n;
        save();
    }

    @Override
    public void them(Employee employee) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Employee(employee);
        ++n;
        save();
    }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            ds[n] = new Employee();
            ds[n].setByInput();
            ++i;
            ++n;
        }
        save();
    }

    @Override
    public void xoa(String manv) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getManv().equals(manv)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
        save();
    }
    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public void timkiemManv() {
        System.out.println("Ma nhan vien can tim: ");
        String manv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemManv(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                return i;
        }
        return -1;
    }

    public void timkiemManv_Employee() {
        System.out.println("Ma nhan vien can tim: ");
        String manv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Employee timkiemManv_Employee(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                return ds[i];
        }
        return null;
    }
    public void timkiemTennv() {
        System.out.println("Ten nhan vien can tim: ");
        String tennv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(Xoa_khoang_trang_thua(tennv)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemTennv(String tennv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(tennv))
                return i;
        }
        return -1;
    }
    public void timkiemTennv_Employee() {
        System.out.println("Ten nhan vien can tim: ");
        String tennv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(Xoa_khoang_trang_thua(tennv)))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public Employee timkiemTennv_Employee(String tennv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(tennv))
                return ds[i];
        }
        return null;
    }
    public EmployeeList timkiemTennv_EmployeeList() {
        System.out.print("Ten nhan vien can tim: ");
        String tennv = Input.getString();
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(Xoa_khoang_trang_thua(tennv))) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public EmployeeList timkiemTennv_EmployeeList(String tennv) {
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(Xoa_khoang_trang_thua(tennv))) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemCMND() {
        System.out.println("CMND can tim: ");
        String cmnd = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemCMND(String cmnd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd))
                return i;
        }
        return -1;
    }
    public void timkiemCMND_Employee() {
        System.out.println("CMND can tim: ");
        String cmnd = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public Employee timkiemCMND_Employee(String cmnd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd))
                return ds[i];
        }
        return null;
    }
    public void timkiemSdt() {
        System.out.println("Sdt can tim: ");
        String sdt = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemSdt(String sdt) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                return i;
        }
        return -1;
    }

    public void timkiemSdt_Employee() {
        System.out.println("Sdt can tim: ");
        String sdt = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Employee timkiemSdt_Employee(String sdt) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                return ds[i];
        }
        return null;
    }

    public EmployeeList timkiemSdt_EmployeeList() {
        System.out.print("Sdt can tim: ");
        String sdt = Input.getString();
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public EmployeeList timkiemSdt_EmployeeList(String sdt) {
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }


    public void timkiemEmail() {
        System.out.println("Email can tim: ");
        String email = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemEmail(String email) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email))
                return i;
        }
        return -1;
    }

    public void timkiemEmail_Employee() {
        System.out.println("Email can tim: ");
        String email = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Employee timkiemEmail_Employee(String email) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().contains(email))
                return ds[i];
        }
        return null;
    }

    public EmployeeList timkiemEmail_EmployeeList() {
        System.out.print("Email can tim: ");
        String email = Input.getString();
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public EmployeeList timkiemEmail_EmployeeList(String email) {
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemUsername() {
        System.out.println("Username can tim: ");
        String username = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsername().equals(username))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemUsername(String username) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsername().equals(username))
                return i;
        }
        return -1;
    }

    public void timkiemUsername_Employee() {
        System.out.println("Username can tim: ");
        String username = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsername().equals(username))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Employee timkiemUsername_Employee(String username) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsername().equals(username))
                return ds[i];
        }
        return null;
    }
    public void timkiemPassword() {
        System.out.println("Password can tim: ");
        String password = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemPassword(String password) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                return i;
        }
        return -1;
    }

    public void timkiemPassword_Employee() {
        System.out.println("Password can tim: ");
        String password = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Employee timkiemPassword_Employee(String password) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                return ds[i];
        }
        return null;
    }

    public EmployeeList timkiemPassword_EmployeeList() {
        System.out.print("Password can tim: ");
        String password = Input.getString();
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public EmployeeList timkiemPassword_EmployeeList(String password) {
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void sua(String manv) {
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getManv().equals(manv)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getManv().equals(manv)) {
                    do {
                        menuSua();
                        opt=Input.getInt();
                        switch(opt) {
                            case 1:
                                doiTenNhanVien(ds[i]);
                                break;
                            case 2:
                                doiCMND(ds[i]);
                                break;
                            case 3:
                                doiSDT(ds[i]);
                                break;
                            case 4:
                                doiEmail(ds[i]);
                                break;
                            case 5:
                                doiPassword(ds[i]);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                    }
                    while(opt!=0);
                }
            }
            save();
        }
        else    System.out.println("Ma khach hang khong ton tai!");
    }
    public void sua() {
        System.out.print("Nhap ma cua nhan vien muon sua thong tin: ");
        String manv = Input.getString();
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getManv().equals(manv)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getManv().equals(manv)) {
                    do {
                        menuSua();
                        opt=Input.getInt();
                        switch(opt) {
                            case 1:
                                doiTenNhanVien(ds[i]);
                                break;
                            case 2:
                                doiCMND(ds[i]);
                                break;
                            case 3:
                                doiSDT(ds[i]);
                                break;
                            case 4:
                                doiEmail(ds[i]);
                                break;
                            case 5:
                                doiPassword(ds[i]);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                    }
                    while(opt!=0);
                }
            }
            save();
        }
        else    System.out.println("Ma khach hang khong ton tai!");
    }
    private void menuSua(){
        System.out.println("---------------------------");
        System.out.println("1. Sua ten nhan vien:");
        System.out.println("2. Sua CMND nhan vien:");
        System.out.println("3. Sua sdt nhan vien:");
        System.out.println("4. Sua email nhan vien:");
        System.out.println("5. Doi mat khau:");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
    private void doiTenNhanVien(@NotNull Employee a){
        System.out.println("Doi ten nhan vien thanh:");
        String tennv = Input.getString();
        a.setTennv(tennv);
    }
    private void doiCMND(@NotNull Employee a){
        System.out.println("Doi CMND nhan vien thanh:");
        String cmnd = Input.getString();
        a.setCmnd(cmnd);
    }
    private void doiSDT(@NotNull Employee a){
        System.out.println("Doi sdt nhan vien thanh:");
        String sdt = Input.getString();
        a.setSdt(sdt);
    }
    private void doiEmail(@NotNull Employee a){
        System.out.println("Doi email nhan vien thanh:");
        String email = Input.getString();
        a.setEmail(email);
    }
    private void doiPassword(@NotNull Employee a){
        System.out.println("Doi password nhan vien thanh:");
        String password = Input.getString();
        a.setPassword(password);
    }
}
