package ProductContainer;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.*;
public class DSSP {
    private Product[] ds;
    private int n;
    Scanner input = new Scanner(System.in);
    public void nhap() {
        System.out.print("Nhap so luong san pham: ");
        n = input.nextInt();
        ds = new Product[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("San pham thu " + (i + 1));
            System.out.print("Day la quan(0) hay ao(1)?: ");
            int opt = input.nextInt();
            if (opt == 0) {
                ds[i] = new Pant();
            } else {
                ds[i] = new Shirt();
            }
            ds[i].setByInput();
        }
    }

    public String toString() {
        for (int i = 0; i < n; ++i) {
            System.out.println("\nSan pham thu " + (i + 1) + ":");
            System.out.println(ds[i]);
        }
        return "";
    }

    public DSSP() {
    }

    public DSSP(Product[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public DSSP(@NotNull DSSP a) {
        n = a.n;
        ds = a.ds;
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.print("Quan(0) / ao(1)");
        int opt = input.nextInt();
        if (opt == 0) {
            ds[n] = new Pant();
        } else {
            ds[n] = new Shirt();
        }
        ds[n].setByInput();
        ++n;
    }

    public void them(Pant a) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Pant(a);
        ++n;
    }

    public void them(Shirt a) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new Shirt(a);
        ++n;
    }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            System.out.print("Day la quan(0) hay ao(1)?: ");
            int opt = input.nextInt();
            if (opt == 0) {
                ds[n] = new Pant();
            } else {
                ds[n] = new Shirt();
            }
            ds[n].setByInput();
            ++i;
            ++n;
        }
    }

    public void xoaMa(String masp) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMasp().equals(masp)) {
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

    public void xoaTen(String tensp) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMasp().contains(Xoa_khoang_trang_thua(tensp))) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
    }

    public void timkiemMasp() {
        System.out.println("Ma sp can tim: ");
        String masp = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMasp().equals(masp))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemMasp(String masp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMasp().equals(masp))
                return i;
        }
        return -1;
    }

    public void timkiemMasp_Product() {
        System.out.println("Ma sp can tim: ");
        String masp = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMasp().equals(masp))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Product timkiemMasp_Product(String masp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMasp().equals(masp))
                return ds[i];
        }
        return null;
    }
    public void timkiemTensp() {
        System.out.println("Ten sp can tim: ");
        String tensp = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(Xoa_khoang_trang_thua(tensp)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemTensp(String tensp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(tensp))
                return i;
        }
        return -1;
    }
    public void timkiemTensp_Product() {
        System.out.println("Ten sp can tim: ");
        String tensp = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(Xoa_khoang_trang_thua(tensp)))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }
    public Product timkiemTensp_Product(String tensp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(tensp))
                return ds[i];
        }
        return null;
    }
    public DSSP timkiemTensp_DSSP() {
        System.out.print("Ten sp can tim: ");
        String tensp = input.nextLine();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(Xoa_khoang_trang_thua(tensp))) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }
    public DSSP timkiemTensp_DSSP(String tensp) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(tensp)) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }
    public void timkiemGioitinh() {
        System.out.println("Gioi tinh can tim: ");
        String gioitinh = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh().contains(Xoa_khoang_trang_thua(gioitinh)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemGioitinh(String gioitinh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh().contains(gioitinh))
                return i;
        }
        return -1;
    }
    public void timkiemGioitinh_Product() {
        System.out.println("Gioi tinh can tim: ");
        String gioitinh = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh().contains(Xoa_khoang_trang_thua(gioitinh)))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }
    public Product timkiemGioitinh_Product(String gioitinh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh().contains(gioitinh))
                return ds[i];
        }
        return null;
    }
    public DSSP timkiemGioitinh_DSSP() {
        System.out.print("Gioi tinh can tim: ");
        String gioitinh = input.nextLine();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh().contains(Xoa_khoang_trang_thua(gioitinh))) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }
    public DSSP timkiemGioitinh_DSSP(String gioitinh) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh().contains(gioitinh)) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }
    public void timkiemSize() {
        System.out.println("Size can tim: ");
        String size = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().contains(size))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemSize(String size) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().contains(size))
                return i;
        }
        return -1;
    }

    public void timkiemSize_Product() {
        System.out.println("Size can tim: ");
        String size = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().contains(size))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Product timkiemSize_Product(String size) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().contains(size))
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemSize_DSSP() {
        System.out.print("Size can tim: ");
        String size = input.nextLine();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().contains(size)) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public DSSP timkiemSize_DSSP(String size) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().contains(size)) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public void timkiemChatlieu() {
        System.out.println("Chat lieu can tim: ");
        String chatlieu = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(Xoa_khoang_trang_thua(chatlieu)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemChatlieu(String chatlieu) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(chatlieu))
                return i;
        }
        return -1;
    }

    public void timkiemChatlieu_Product() {
        System.out.println("Chat lieu can tim: ");
        String chatlieu = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(Xoa_khoang_trang_thua(chatlieu)))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Product timkiemChatlieu_Product(String chatlieu) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(chatlieu))
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemChatlieu_DSSP() {
        System.out.print("Chat lieu can tim: ");
        String chatlieu = input.nextLine();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(Xoa_khoang_trang_thua(chatlieu))) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public DSSP timkiemChatlieu_DSSP(String chatlieu) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(chatlieu)) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public void timkiemDongia() {
        System.out.println("Don gia can tim: ");
        double dongia = input.nextDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemDongia(double dongia) {
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                return i;
        }
        return -1;
    }

    public void timkiemDongia_Product() {
        System.out.println("Size can tim: ");
        double dongia = input.nextDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Product timkiemDongia_Product(double dongia) {
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemDongia_DSSP() {
        System.out.print("Don gia can tim: ");
        double dongia = input.nextDouble();
        input.nextLine();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public DSSP timkiemDongia_DSSP(double dongia) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0) {
                if (ds[i] instanceof Pant) {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Pant((Pant) ds[i]);
                    ++a.n;
                }
                else  {
                    a.ds=Arrays.copyOf(a.ds, a.n+1);
                    a.ds[a.n]=new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public void timkiemMutrumdau() {
        System.out.println("Tim ao co mu hay khong mu: ");
        boolean mutrumdau = input.nextBoolean();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }

    public int timkiemMutrumdau(boolean mutrumdau) {
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    return i;
            }
        }
        return -1;
    }

    public void timkiemMutrumdau_Product() {
        System.out.println("Tim ao co mu hay khong mu: ");
        boolean mutrumdau = input.nextBoolean();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    System.out.print(ds[i] + "/n");
            }
        }
        System.out.println("\n");
    }

    public Product timkiemMutrumdau_Product(boolean mutrumdau) {
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    return ds[i];
            }
        }
        return null;
    }

    public DSSP timkiemMutrumdau_DSSP() {
        System.out.print("Tim ao co mu hay khong mu: ");
        boolean mutrumdau = input.nextBoolean();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau) {
                    a.ds = Arrays.copyOf(a.ds, a.n + 1);
                    a.ds[a.n] = new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public DSSP timkiemMutrumdau_DSSP(boolean mutrumdau) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau) {
                    a.ds = Arrays.copyOf(a.ds, a.n + 1);
                    a.ds[a.n] = new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }


    public void timkiemThunquan() {
        System.out.println("Tim quan co thun hay khong thun: ");
        boolean thunquan = input.nextBoolean();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }

    public int timkiemThunquan(boolean thunquan) {
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    return i;
            }
        }
        return -1;
    }

    public void timkiemThunquan_Product() {
        System.out.println("Tim quan co thun hay khong thun: ");
        boolean thunquan = input.nextBoolean();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    System.out.print(ds[i] + "/n");
            }
        }
        System.out.println("\n");
    }

    public Product timkiemThunquan_Product(boolean thunquan) {
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    return ds[i];
            }
        }
        return null;
    }

    public DSSP timkiemThunquan_DSSP() {
        System.out.print("Tim quan co thun hay khong thun: ");
        boolean thunquan = input.nextBoolean();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan) {
                    a.ds = Arrays.copyOf(a.ds, a.n + 1);
                    a.ds[a.n] = new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public DSSP timkiemThunquan_DSSP(boolean thunquan) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan) {
                    a.ds = Arrays.copyOf(a.ds, a.n + 1);
                    a.ds[a.n] = new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }
    public void timkiemHoatiet() {
        System.out.println("Hoa tiet can tim: ");
        String hoatiet = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (((Shirt) ds[i]).getHoatiet().contains(Xoa_khoang_trang_thua(hoatiet)))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemHoatietu(String hoatiet) {
        for (int i = 0; i < n; i++) {
            if (((Shirt) ds[i]).getHoatiet().contains(hoatiet))
                return i;
        }
        return -1;
    }

    public void timkiemHoatiet_Product() {
        System.out.println("Hoa tiet can tim: ");
        String hoatiet = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (((Shirt) ds[i]).getHoatiet().contains(Xoa_khoang_trang_thua(hoatiet)))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Product timkiemHoatiet_Product(String hoatiet) {
        for (int i = 0; i < n; i++) {
            if (((Shirt) ds[i]).getHoatiet().contains(hoatiet))
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemHoatiet_DSSP() {
        System.out.print("Hoa tiet can tim: ");
        String hoatiet = input.nextLine();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getHoatiet().contains(hoatiet)) {
                    a.ds = Arrays.copyOf(a.ds, a.n + 1);
                    a.ds[a.n] = new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }

    public DSSP timkiemHoatiet_DSSP(String hoatiet) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getHoatiet().contains(hoatiet)) {
                    a.ds = Arrays.copyOf(a.ds, a.n + 1);
                    a.ds[a.n] = new Shirt((Shirt) ds[i]);
                    ++a.n;
                }
            }
        }
        return a;
    }
    public void sua(String masp) {
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMasp().equals(masp)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getMasp().equals(masp)) {
                    if(ds[i] instanceof Pant) {
                        do {
                            System.out.println("---------------------------");
                            System.out.println("1. Sua ten sp:");
                            System.out.println("2. Sua so luong ton kho:");
                            System.out.println("3. Sua don gia:");
                            System.out.println("4. Sua size:");
                            System.out.println("5. Sua chat lieu:");
                            System.out.println("6. Sua thun quan:");
                            System.out.println("0. Exit.");
                            System.out.println("---------------------------");
                            System.out.print("Please choose: ");
                            opt=input.nextInt();
                            input.nextLine();
                            switch(opt) {
                                case 1:
                                    System.out.println("Doi ten sp thanh:");
                                    String tensp = input.nextLine();
                                    ds[i].setTensp(tensp);
                                    break;
                                case 2:
                                    System.out.println("Doi so luong ton kho thanh:");
                                    int sltonkho = input.nextInt();
                                    input.nextLine();
                                    ds[i].setSltonkho(sltonkho);
                                    break;
                                case 3:
                                    System.out.println("Doi don gia thanh:");
                                    double dongia = input.nextDouble();
                                    input.nextLine();
                                    ds[i].setDongia(dongia);
                                    break;
                                case 4:
                                    System.out.println("Doi size thanh:");
                                    String size = input.nextLine();
                                    ds[i].setSize(size);
                                    break;
                                case 5:
                                    System.out.println("Doi chat lieu thanh:");
                                    String chatlieu = input.nextLine();
                                    input.nextLine();
                                    ds[i].setChatlieu(chatlieu);
                                    break;
                                case 6:
                                    System.out.println("Doi thun quan thanh:");
                                    boolean thunquan = input.nextBoolean();
                                    ((Pant) ds[i]).setThunquan(thunquan);
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
                    else if(ds[i] instanceof Shirt){
                        do {
                            System.out.println("---------------------------");
                            System.out.println("1. Sua ten sp:");
                            System.out.println("2. Sua so luong ton kho:");
                            System.out.println("3. Sua don gia:");
                            System.out.println("4. Sua size:");
                            System.out.println("5. Sua chat lieu:");
                            System.out.println("6. Sua mu trum dau:");
                            System.out.println("7. Sua mu hoa tiet:");
                            System.out.println("0. Exit.");
                            System.out.println("---------------------------");
                            System.out.print("Please choose: ");
                            opt=input.nextInt();
                            input.nextLine();
                            switch(opt) {
                                case 1:
                                    System.out.println("Doi ten sp thanh:");
                                    String tensp = input.nextLine();
                                    ds[i].setTensp(tensp);
                                    break;
                                case 2:
                                    System.out.println("Doi so luong ton kho thanh:");
                                    int sltonkho = input.nextInt();
                                    input.nextLine();
                                    ds[i].setSltonkho(sltonkho);
                                    break;
                                case 3:
                                    System.out.println("Doi don gia thanh:");
                                    double dongia = input.nextDouble();
                                    input.nextLine();
                                    ds[i].setDongia(dongia);
                                    break;
                                case 4:
                                    System.out.println("Doi size thanh:");
                                    String size = input.nextLine();
                                    ds[i].setSize(size);
                                    break;
                                case 5:
                                    System.out.println("Doi chat lieu thanh:");
                                    String chatlieu = input.nextLine();
                                    input.nextLine();
                                    ds[i].setChatlieu(chatlieu);
                                    break;
                                case 6:
                                    System.out.println("Doi mu trum dau thanh:");
                                    boolean mutrumdau = input.nextBoolean();
                                    ((Shirt) ds[i]).setMutrumdau(mutrumdau);
                                    break;
                                case 7:
                                    System.out.println("Doi hoa tiet thanh:");
                                    String hoatiet = input.nextLine();
                                    ((Shirt) ds[i]).setHoatiet(hoatiet);
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
            }}
        else {
            System.out.println("Ma sp khong ton tai!");
        }}
    public void sua() {
        System.out.print("Nhap ma cua sp muon sua thong tin: ");
        String masp=input.nextLine();
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMasp().equals(masp)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getMasp().equals(masp)) {
                    if(ds[i] instanceof Pant) {
                        do {
                            System.out.println("---------------------------");
                            System.out.println("1. Sua ten sp:");
                            System.out.println("2. Sua gioi tinh:");
                            System.out.println("3. Sua so luong ton kho:");
                            System.out.println("4. Sua don gia:");
                            System.out.println("5. Sua size:");
                            System.out.println("6. Sua chat lieu:");
                            System.out.println("7. Sua thun quan:");
                            System.out.println("0. Exit.");
                            System.out.println("---------------------------");
                            System.out.print("Please choose: ");
                            opt=input.nextInt();
                            input.nextLine();
                            switch(opt) {
                                case 1:
                                    System.out.println("Doi ten sp thanh:");
                                    String tensp = input.nextLine();
                                    ds[i].setTensp(tensp);
                                    break;
                                case 2:
                                    System.out.println("Doi gioi tinh thanh:");
                                    String gioitinh = input.nextLine();
                                    ds[i].setGioitinh(gioitinh);
                                    break;
                                case 3:
                                    System.out.println("Doi so luong ton kho thanh:");
                                    int sltonkho = input.nextInt();
                                    input.nextLine();
                                    ds[i].setSltonkho(sltonkho);
                                    break;
                                case 4:
                                    System.out.println("Doi don gia thanh:");
                                    double dongia = input.nextDouble();
                                    input.nextLine();
                                    ds[i].setDongia(dongia);
                                    break;
                                case 5:
                                    System.out.println("Doi size thanh:");
                                    String size = input.nextLine();
                                    ds[i].setSize(size);
                                    break;
                                case 6:
                                    System.out.println("Doi chat lieu thanh:");
                                    String chatlieu = input.nextLine();
                                    input.nextLine();
                                    ds[i].setChatlieu(chatlieu);
                                    break;
                                case 7:
                                    System.out.println("Doi thun quan thanh:");
                                    boolean thunquan = input.nextBoolean();
                                    ((Pant) ds[i]).setThunquan(thunquan);
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
                    else if(ds[i] instanceof Shirt){
                        do {
                            System.out.println("---------------------------");
                            System.out.println("1. Sua ten sp:");
                            System.out.println("2. Sua gioi tinh:");
                            System.out.println("3. Sua so luong ton kho:");
                            System.out.println("4. Sua don gia:");
                            System.out.println("5. Sua size:");
                            System.out.println("6. Sua chat lieu:");
                            System.out.println("7. Sua mu trum dau:");
                            System.out.println("8. Sua mu hoa tiet:");
                            System.out.println("0. Exit.");
                            System.out.println("---------------------------");
                            System.out.print("Please choose: ");
                            opt=input.nextInt();
                            input.nextLine();
                            switch(opt) {
                                case 1:
                                    System.out.println("Doi ten sp thanh:");
                                    String tensp = input.nextLine();
                                    ds[i].setTensp(tensp);
                                    break;
                                case 2:
                                    System.out.println("Doi gioi tinh thanh:");
                                    String gioitinh = input.nextLine();
                                    ds[i].setGioitinh(gioitinh);
                                    break;
                                case 3:
                                    System.out.println("Doi so luong ton kho thanh:");
                                    int sltonkho = input.nextInt();
                                    input.nextLine();
                                    ds[i].setSltonkho(sltonkho);
                                    break;
                                case 4:
                                    System.out.println("Doi don gia thanh:");
                                    double dongia = input.nextDouble();
                                    input.nextLine();
                                    ds[i].setDongia(dongia);
                                    break;
                                case 5:
                                    System.out.println("Doi size thanh:");
                                    String size = input.nextLine();
                                    ds[i].setSize(size);
                                    break;
                                case 6:
                                    System.out.println("Doi chat lieu thanh:");
                                    String chatlieu = input.nextLine();
                                    input.nextLine();
                                    ds[i].setChatlieu(chatlieu);
                                    break;
                                case 7:
                                    System.out.println("Doi mu trum dau thanh:");
                                    boolean mutrumdau = input.nextBoolean();
                                    ((Shirt) ds[i]).setMutrumdau(mutrumdau);
                                    break;
                                case 8:
                                    System.out.println("Doi hoa tiet thanh:");
                                    String hoatiet = input.nextLine();
                                    ((Shirt) ds[i]).setHoatiet(hoatiet);
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
            }}
        else {
            System.out.println("Ma sp khong ton tai!");
        }
    }
}
