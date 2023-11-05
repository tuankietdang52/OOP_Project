package Users;
import java.util.Scanner;
import java.util.*;
public class EmployeeList {
    private Employee[] ds;
    private int n;
    Scanner input = new Scanner(System.in);
    public void nhap() {
        System.out.print("Nhap so luong nhan vien: ");
        n = input.nextInt();
        ds = new Employee[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Nhan vien thu " + (i + 1));
            ds[i] = new Employee();
            ds[i].setByInput();
        }
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

    public EmployeeList(Employee[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public EmployeeList(@org.jetbrains.annotations.NotNull EmployeeList a) {
        n = a.n;
        ds = a.ds;
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Employee();
        ds[n].setByInput();
        ++n;
    }

    public void them(Employee employee) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Employee(employee);
        ++n;
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
    }

    public void xoaMa(String manv) {
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
    }
    public void xoaTennv(String tennv) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getTennv().contains(Xoa_khoang_trang_thua(tennv))) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
    }
    public void xoaCMND(String cmnd) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getCmnd().equals(cmnd)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
    }
    public void xoaSdt(String sdt) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getSdt().equals(sdt)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
    }
    public void xoaEmail(String email) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getEmail().equals(email)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
    }
    public void xoaUsernames(String usernames) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getUsernames().equals(usernames)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
    }
    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public void timkiemManv() {
        System.out.println("Ma nhan vien can tim: ");
        String manv = input.nextLine();
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
        String manv = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                System.out.print(ds[i] + "/n");
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
        String tennv = input.nextLine();
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
        String tennv = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTennv().contains(Xoa_khoang_trang_thua(tennv)))
                System.out.print(ds[i] + "/n");
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
        String tennv = input.nextLine();
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
        String cmnd = input.nextLine();
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
        String cmnd = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd))
                System.out.print(ds[i] + "/n");
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
    public EmployeeList timkiemCMND_EmployeeList() {
        System.out.print("CMND can tim: ");
        String cmnd = input.nextLine();
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public EmployeeList timkiemCMND_EmployeeList(String cmnd) {
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getCmnd().equals(cmnd)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemSdt() {
        System.out.println("Sdt can tim: ");
        String sdt = input.nextLine();
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
        String sdt = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                System.out.print(ds[i] + "/n");
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
        String sdt = input.nextLine();
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
        String email = input.nextLine();
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
        String email = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email))
                System.out.print(ds[i] + "/n");
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
        String email = input.nextLine();
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
        String username = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsernames().equals(username))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemUsername(String username) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsernames().equals(username))
                return i;
        }
        return -1;
    }

    public void timkiemUsername_Employee() {
        System.out.println("Username can tim: ");
        String username = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsernames().equals(username))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Employee timkiemUsername_Employee(String username) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsernames().equals(username))
                return ds[i];
        }
        return null;
    }

    public EmployeeList timkiemUsername_EmployeeList() {
        System.out.print("Username can tim: ");
        String username = input.nextLine();
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsernames().equals(username)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public EmployeeList timkiemUsername_EmployeeList(String username) {
        EmployeeList a = new EmployeeList();
        a.ds=new Employee[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsernames().equals(username)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Employee(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemPassword() {
        System.out.println("Password can tim: ");
        String password = input.nextLine();
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
        String password = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                System.out.print(ds[i] + "/n");
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
        String password = input.nextLine();
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
                        System.out.println("---------------------------");
                        System.out.println("1. Sua ten nhan vien:");
                        System.out.println("2. Sua CMND nhan vien:");
                        System.out.println("3. Sua sdt nhan vien:");
                        System.out.println("4. Sua email nhan vien:");
                        System.out.println("5. Sua username nhan vien:");
                        System.out.println("6. Sua password nhan vien:");
                        System.out.println("0. Exit.");
                        System.out.println("---------------------------");
                        System.out.print("Please choose: ");
                        opt=input.nextInt();
                        input.nextLine();
                        switch(opt) {
                            case 1:
                                System.out.println("Doi ten nhan vien thanh:");
                                String tennv = input.nextLine();
                                ds[i].setTennv(tennv);
                                break;
                            case 2:
                                System.out.println("Doi CMND nhan vien thanh:");
                                String cmnd = input.nextLine();
                                ds[i].setCmnd(cmnd);
                                break;
                            case 3:
                                System.out.println("Doi sdt nhan vien thanh:");
                                String sdt = input.nextLine();
                                ds[i].setSdt(sdt);
                                break;
                            case 4:
                                System.out.println("Doi email nhan vien thanh:");
                                String email = input.nextLine();
                                ds[i].setEmail(email);
                                break;
                            case 5:
                                System.out.println("Doi username nhan vien thanh:");
                                String username = input.nextLine();
                                ds[i].setUsernames(username);
                                break;
                            case 6:
                                System.out.println("Doi password nhan vien thanh:");
                                String password = input.nextLine();
                                ds[i].setPassword(password);
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
        }
        else    System.out.println("Ma khach hang khong ton tai!");
    }
    public void sua() {
        System.out.print("Nhap ma cua nhan vien muon sua thong tin: ");
        String manv = input.nextLine();
        int flag = 0;
        int opt;
        for (int i = 0; i < n; ++i) {
            if (ds[i].getManv().equals(manv)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                if (ds[i].getManv().equals(manv)) {
                    do {
                        System.out.println("---------------------------");
                        System.out.println("1. Sua ten nhan vien:");
                        System.out.println("2. Sua CMND nhan vien:");
                        System.out.println("3. Sua sdt nhan vien:");
                        System.out.println("4. Sua email nhan vien:");
                        System.out.println("5. Sua username nhan vien:");
                        System.out.println("6. Sua password nhan vien:");
                        System.out.println("0. Exit.");
                        System.out.println("---------------------------");
                        System.out.print("Please choose: ");
                        opt = input.nextInt();
                        input.nextLine();
                        switch (opt) {
                            case 1:
                                System.out.println("Doi ten nhan vien thanh:");
                                String tennv = input.nextLine();
                                ds[i].setTennv(tennv);
                                break;
                            case 2:
                                System.out.println("Doi CMND nhan vien thanh:");
                                String cmnd = input.nextLine();
                                ds[i].setCmnd(cmnd);
                                break;
                            case 3:
                                System.out.println("Doi sdt nhan vien thanh:");
                                String sdt = input.nextLine();
                                ds[i].setSdt(sdt);
                                break;
                            case 4:
                                System.out.println("Doi email nhan vien thanh:");
                                String email = input.nextLine();
                                ds[i].setEmail(email);
                                break;
                            case 5:
                                System.out.println("Doi username nhan vien thanh:");
                                String username = input.nextLine();
                                ds[i].setUsernames(username);
                                break;
                            case 6:
                                System.out.println("Doi password nhan vien thanh:");
                                String password = input.nextLine();
                                ds[i].setPassword(password);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                    }
                    while (opt != 0);
                }
            }
        } else System.out.println("Ma khach hang khong ton tai!");
    }
}
