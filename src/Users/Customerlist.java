package Users;
import InputManage.Input;
import Interface.IFile;
import Interface.IList;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
public class Customerlist implements IFile, IList<Customer> {
    private Customer[] ds;
    private int n;

    public void nhap() {
        System.out.print("Nhap so luong khach hang: ");
        n = Input.getInt();
        ds = new Customer[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Khach hang thu " + (i + 1));
            ds[i] = new Customer();
            ds[i].setByInput();
            ds[i].createMakh();
        }
        save();
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

    public Customerlist(Boolean isGetData) {
        if (!isGetData) return;

        try {
            read();
        } catch (Exception ex) {
            if (ds.length == 0) {
                ds = new Customer[0];
                System.out.println("Error: " + ex);
                return;
            }
            System.out.println("Cant get data from file\nError: " + ex);
        }


    }

    public Customerlist(Customer[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public Customerlist(@NotNull Customerlist a) {
        n = a.n;
        ds = a.ds;
    }

    public Customer[] getDs() {
        return ds;
    }

    public int getN() {
        return n;
    }

    public void setDs(Customer[] ds) {
        this.ds = ds;
    }

    public void setElementofDs(int pos, Customer customer) {
        ds[pos] = customer;
    }

    @Override
    public Customer @NotNull [] increaseLength() {
        var temparray = new Customer[ds.length + 1];
        System.arraycopy(ds, 0, temparray, 0, ds.length);
        return temparray;
    }

    @Override
    public void read() throws Exception {
        ds = new Customer[0];
        var i = 0;

        File customerdata = new File("./src/Data/Customer.bin");
        FileInputStream stream = new FileInputStream(customerdata);
        ObjectInputStream read = new ObjectInputStream(stream);
        try {
            while (true) {
                var customer = (Customer) read.readObject();
                if (customer == null) break;

                if (i >= ds.length) ds = increaseLength();

                ds[i] = customer;
                i++;
            }
        } catch (EOFException ex) {
            read.close();
        }
        n = ds.length;
    }

    @Override
    public void save() {
        File customerdata = new File("./src/Data/Customer.bin");
        try {
            FileOutputStream stream = new FileOutputStream(customerdata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            for (var item : ds) {
                write.writeObject(item);
            }
            write.close();
        } catch (Exception ex) {
            System.out.println("Cant write data from file\nError: " + ex);
        }
    }

    @Override
    public void clear() {
        File customerdata = new File("./src/Data/Customer.bin");
        try {
            FileOutputStream stream = new FileOutputStream(customerdata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            write.writeChars("");
            write.close();

            read();
        } catch (Exception ex) {
            System.out.println("Cant write data from file\nError: " + ex);
        }
    }

    public void setCustomer(@NotNull Customer customer) {
        int index = timkiemMakh(customer.getMakh());

        ds[index] = customer;
        save();
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Customer();
        ds[n].setByInput();
        ds[n].createMakh();
        ++n;
        save();
    }

    @Override
    public void them(Customer customer) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Customer(customer);
        ++n;
        save();
    }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            ds[n] = new Customer();
            ds[n].setByInput();
            ds[n].createMakh();
            ++i;
            ++n;
        }
        save();
    }

    @Override
    public void xoa(String makh) {
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
        save();
    }

    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public void timkiemMakh() {
        System.out.println("Ma khach hang can tim: ");
        String makh = Input.getString();
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
        String makh = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                System.out.print(ds[i] + "\n");
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
        String tenkh = Input.getString();
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
        String tenkh = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenkh().contains(Xoa_khoang_trang_thua(tenkh)))
                System.out.print(ds[i] + "\n");
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
        String tenkh = Input.getString();
        Customerlist a = new Customerlist();
        a.ds = new Customer[a.n];
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
        a.ds = new Customer[a.n];
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
        String diachi = Input.getString();
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
        String diachi = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getDiachi().contains(Xoa_khoang_trang_thua(diachi)))
                System.out.print(ds[i] + "\n");
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
        String diachi = Input.getString();
        Customerlist a = new Customerlist();
        a.ds = new Customer[a.n];
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
        a.ds = new Customer[a.n];
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

    public void timkiemSdt_Customer() {
        System.out.println("Sdt can tim: ");
        String sdt = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSdt().equals(sdt))
                System.out.print(ds[i] + "\n");
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
        String sdt = Input.getString();
        Customerlist a = new Customerlist();
        a.ds = new Customer[a.n];
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
        a.ds = new Customer[a.n];
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

    public void timkiemEmail_Customer() {
        System.out.println("Email can tim: ");
        String email = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email))
                System.out.print(ds[i] + "\n");
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
        String email = Input.getString();
        Customerlist a = new Customerlist();
        a.ds = new Customer[a.n];
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
        a.ds = new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getEmail().equals(email)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
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

    public void timkiemUsername_Customer() {
        System.out.println("Username can tim: ");
        String username = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getUsername().equals(username))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Customer timkiemUsername_Customer(String username) {
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

    public void timkiemPassword_Customer() {
        System.out.println("Password can tim: ");
        String password = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Customer timkiemPassword_Customer(String password) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password))
                return ds[i];
        }
        return null;
    }

    public Customerlist timkiemPassword_CustomerList() {
        System.out.print("Password can tim: ");
        String password = Input.getString();
        Customerlist a = new Customerlist();
        a.ds = new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public Customerlist timkiemPassword_Customerlist(String password) {
        Customerlist a = new Customerlist();
        a.ds = new Customer[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getPassword().equals(password)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new Customer(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    @Override
    public void sua(String makh) {
        int flag = 0;
        int opt;
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMakh().equals(makh)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                if (ds[i].getMakh().equals(makh)) {
                    do {
                        menuSua();
                        opt = Input.getInt();
                        switch (opt) {
                            case 1:
                                doiTenKhachHang(ds[i]);
                                break;
                            case 2:
                                doiDiaChi(ds[i]);
                                break;
                            case 3:
                                doiSDT(ds[i]);
                                break;
                            case 4:
                                doiEmail(ds[i]);
                                break;
                            case 5:
                                doiMatKhau(ds[i]);
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
            save();
        } else System.out.println("Ma khach hang khong ton tai!");
    }

    public void sua() {
        System.out.print("Nhap ma cua khach hang muon sua thong tin: ");
        String makh = Input.getString();
        int flag = 0;
        int opt;
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMakh().equals(makh)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                if (ds[i].getMakh().equals(makh)) {
                    do {
                        menuSua();
                        opt = Input.getInt();
                        switch (opt) {
                            case 1:
                                doiTenKhachHang(ds[i]);
                                break;
                            case 2:
                                doiDiaChi(ds[i]);
                                break;
                            case 3:
                                doiSDT(ds[i]);
                                break;
                            case 4:
                                doiEmail(ds[i]);
                                break;
                            case 5:
                                doiMatKhau(ds[i]);
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
            save();
        } else System.out.println("Ma khach hang khong ton tai!");
    }

    private void menuSua() {
        System.out.println("---------------------------");
        System.out.println("1. Sua ten khach hang:");
        System.out.println("2. Sua dia chi khach hang:");
        System.out.println("3. Sua sdt khach hang:");
        System.out.println("4. Sua email khach hang:");
        System.out.println("5. Doi mat khau:");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    private void doiTenKhachHang(@NotNull Customer a) {
        System.out.println("Doi ten khach hang thanh:");
        String tenkh = Input.getString();
        a.setTenkh(tenkh);
    }

    private void doiDiaChi(@NotNull Customer a) {
        System.out.println("Doi dia chi khach hang thanh:");
        String diachi = Input.getString();
        a.setDiachi(diachi);
    }

    private void doiSDT(@NotNull Customer a) {
        System.out.println("Doi sdt khach hang thanh:");
        String sdt = Input.getString();
        a.setSdt(sdt);
    }

    private void doiEmail(@NotNull Customer a) {
        System.out.println("Doi email khach hang thanh:");
        String email = Input.getString();
        a.setEmail(email);
    }

    private void doiMatKhau(@NotNull Customer a) {
        System.out.println("Doi mat khau thanh:");
        String password = Input.getString();
        a.setPassword(password);
    }

    public void tangChiTieu(String makh, double money) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh)) {
                ds[i].tangChitieu(money);
            }
        }
    }
    public void top3KhachHangChitieu() {

        Arrays.sort(ds, Comparator.comparingDouble(Customer::getChitieu).reversed());

        int count = Math.min(3, n);
        Customer[] topCustomers = Arrays.copyOf(ds, count);

        System.out.println("Top 3 khách hàng chi tiêu nhiều nhất:");
        for (int i = 0; i < topCustomers.length; i++) {
            System.out.println("Khách hàng " + (i + 1) + ":");
            System.out.println(topCustomers[i]);
            System.out.println("---------------------------");
        }
    }
}
