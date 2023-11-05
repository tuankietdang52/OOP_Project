package Users;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.*;
public class Customerlist {
    private Customer[] ds;
    private int n;
    Scanner input = new Scanner(System.in);
    public void nhap() {
        System.out.print("Nhap so luong khach hang: ");
        n = input.nextInt();
        ds = new Customer[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Khach hang thu " + (i + 1));
            ds[i] = new Customer();
            ds[i].setByInput();
        }
    }

    public String toString() {
        for (int i = 0; i < n; ++i) {
            System.out.println("\nKhach hang thu " + (i + 1) + ":");
            System.out.println(ds[i]);
        }
        return "";
    }

    public Customerlist() {
    }

    public Customerlist(Customer[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public Customerlist(@NotNull Customerlist a) {
        n = a.n;
        ds = a.ds;
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Customer();
        ds[n].setByInput();
        ++n;
    }

    public void them(Customer customer) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Customer(customer);
        ++n;
    }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            ds[n] = new Customer();
            ds[n].setByInput();
            ++i;
            ++n;
        }
    }

    public void xoaMa(String makh) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMakh().equals(makh)) {
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
    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public void timkiemMakh() {
        System.out.println("Ma khach hang can tim: ");
        String makh = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemMakh(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                return i;
        }
        return -1;
    }

    public void timkiemMakh_Customer() {
        System.out.println("Ma khach hang can tim: ");
        String makh = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Customer timkiemMakh_Customer(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                return ds[i];
        }
        return null;
    }
    public void timkiemTenkh() {
        System.out.println("Ten khach hang can tim: ");
        String tenkh = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(Xoa_khoang_trang_thua(tenkh)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemTenkh(String tenkh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(Xoa_khoang_trang_thua(tenkh)))
                return i;
        }
        return -1;
    }
    public void timkiemTenkh_Customer() {
        System.out.println("Ten khach hang can tim: ");
        String tenkh = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(Xoa_khoang_trang_thua(tenkh)))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }
    public Customer timkiemTenkh_Customer(String tenkh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(tenkh))
                return ds[i];
        }
        return null;
    }
    public Customerlist timkiemTenkh_CustomerList() {
        System.out.print("Ten khach hang can tim: ");
        String tenkh = input.nextLine();
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(Xoa_khoang_trang_thua(tenkh))) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public Customerlist timkiemTenkh_CustomerList(String tenkh) {
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(tenkh)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemDiachi() {
        System.out.println("Dia chi can tim: ");
        String diachi = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(Xoa_khoang_trang_thua(diachi)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemDiachi(String diachi) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(diachi))
                return i;
        }
        return -1;
    }
    public void timkiemDiachi_Customer() {
        System.out.println("Dia chi can tim: ");
        String diachi = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(Xoa_khoang_trang_thua(diachi)))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }
    public Customer timkiemDiachi_Cuatomer(String diachi) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(diachi))
                return ds[i];
        }
        return null;
    }
    public Customerlist timkiemDiachi_CustomerList() {
        System.out.print("Dia chi can tim: ");
        String diachi = input.nextLine();
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(Xoa_khoang_trang_thua(diachi))) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public Customerlist timkiemDiachi_CustomerList(String diachi) {
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(diachi)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
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

    public void timkiemSdt_Customer() {
        System.out.println("Sdt can tim: ");
        String sdt = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Customer timkiemSdt_Customer(String sdt) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                return ds[i];
        }
        return null;
    }

    public Customerlist timkiemSdt_CustomerList() {
        System.out.print("Sdt can tim: ");
        String sdt = input.nextLine();
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public Customerlist timkiemSdt_CustomerList(String sdt) {
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
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

    public void timkiemEmail_Customer() {
        System.out.println("Email can tim: ");
        String email = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Customer timkiemEmail_Customer(String email) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().contains(email))
                return ds[i];
        }
        return null;
    }

    public Customerlist timkiemEmail_CustomerList() {
        System.out.print("Email can tim: ");
        String email = input.nextLine();
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public Customerlist timkiemEmail_CustomerList(String email) {
        Customerlist a = new Customerlist();
        a.ds=new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public void sua(String makh) {
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMakh().equals(makh)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getMakh().equals(makh)) {
                    do {
                        System.out.println("---------------------------");
                        System.out.println("1. Sua ten khach hang:");
                        System.out.println("2. Sua dia chi khach hang:");
                        System.out.println("3. Sua sdt khach hang:");
                        System.out.println("4. Sua email khach hang:");
                        System.out.println("0. Exit.");
                        System.out.println("---------------------------");
                        System.out.print("Please choose: ");
                        opt=input.nextInt();
                        input.nextLine();
                        switch(opt) {
                            case 1:
                                System.out.println("Doi ten khach hang thanh:");
                                String tenkh = input.nextLine();
                                ds[i].setTenkh(tenkh);
                                break;
                            case 2:
                                System.out.println("Doi dia chi khach hang thanh:");
                                String diachi = input.nextLine();
                                ds[i].setDiachi(diachi);
                                break;
                            case 3:
                                System.out.println("Doi sdt khach hang thanh:");
                                String sdt = input.nextLine();
                                ds[i].setSdt(sdt);
                                break;
                            case 4:
                                System.out.println("Doi email khach hang thanh:");
                                String email = input.nextLine();
                                ds[i].setEmail(email);
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
        System.out.print("Nhap ma cua khach hang muon sua thong tin: ");
        String makh = input.nextLine();
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMakh().equals(makh)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getMakh().equals(makh)) {
                    do {
                        System.out.println("---------------------------");
                        System.out.println("1. Sua ten khach hang:");
                        System.out.println("2. Sua dia chi khach hang:");
                        System.out.println("3. Sua sdt khach hang:");
                        System.out.println("4. Sua email khach hang:");
                        System.out.println("0. Exit.");
                        System.out.println("---------------------------");
                        System.out.print("Please choose: ");
                        opt=input.nextInt();
                        input.nextLine();
                        switch(opt) {
                            case 1:
                                System.out.println("Doi ten khach hang thanh:");
                                String tenkh = input.nextLine();
                                ds[i].setTenkh(tenkh);
                                break;
                            case 2:
                                System.out.println("Doi dia chi khach hang thanh:");
                                String diachi = input.nextLine();
                                ds[i].setDiachi(diachi);
                                break;
                            case 3:
                                System.out.println("Doi sdt khach hang thanh:");
                                String sdt = input.nextLine();
                                ds[i].setSdt(sdt);
                                break;
                            case 4:
                                System.out.println("Doi email khach hang thanh:");
                                String email = input.nextLine();
                                ds[i].setEmail(email);
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
}
