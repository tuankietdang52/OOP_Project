package ProductContainer;
import java.util.Scanner;
import java.util.*;
public class DSSP {
    private Product[] ds;
    private int n;
    Scanner input = new Scanner(System.in);
    public void nhap() {
        System.out.print("Nhap so luong san pham: ");
        this.n = input.nextInt();
        this.ds = new Product[this.n];
        for (int i = 0; i < this.n; ++i) {
            System.out.println("San pham thu " + (i + 1));
            System.out.print("Day la quan(0) hay ao(1)?: ");
            int opt = input.nextInt();
            if (opt == 0) {
                this.ds[i] = new Pant();
            } else {
                this.ds[i] = new Shirt();
            }
            this.ds[i].setByInput();
        }
    }

    public String toString() {
        for (int i = 0; i < this.n; ++i) {
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

    public DSSP(DSSP a) {
        n = a.n;
        ds = a.ds;
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
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
            System.out.print("Day la quan hay ao?: ");
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
            if (ds[i].getSize().equals(size))
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemSize_DSSP() {
        System.out.print("Size can tim: ");
        String size = input.nextLine();
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().equals(size))
                if (ds[i] instanceof Pant) {
                    a.them((Pant) ds[i]);
                } else {
                    a.them((Shirt) ds[i]);
                }
        }
        return a;
    }

    public DSSP timkiemSize_DSSP(String size) {
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize().equals(size))
                if (ds[i] instanceof Pant) {
                    a.them((Pant) ds[i]);
                } else {
                    a.them((Shirt) ds[i]);
                }
        }
        return a;
    }

    public void timkiemChatlieu() {
        System.out.println("Chat lieu can tim: ");
        String chatlieu = input.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(chatlieu))
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
            if (ds[i].getChatlieu().contains(chatlieu))
                System.out.print(ds[i] + "/n");
        }
        System.out.println("\n");
    }

    public Product timkiemChatlieu_Product(String chatlieu) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().equals(chatlieu))
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemChatlieu_DSSP() {
        System.out.print("Chat lieu can tim: ");
        String chatlieu = input.nextLine();
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().equals(chatlieu))
                if (ds[i] instanceof Pant) {
                    a.them((Pant) ds[i]);
                } else {
                    a.them((Shirt) ds[i]);
                }
        }
        return a;
    }

    public DSSP timkiemChatlieu_DSSP(String chatlieu) {
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().equals(chatlieu))
                if (ds[i] instanceof Pant) {
                    a.them((Pant) ds[i]);
                } else {
                    a.them((Shirt) ds[i]);
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
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                if (ds[i] instanceof Pant) {
                    a.them((Pant) ds[i]);
                } else {
                    a.them((Shirt) ds[i]);
                }
        }
        return a;
    }

    public DSSP timkiemDongia_DSSP(double dongia) {
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                if (ds[i] instanceof Pant) {
                    a.them((Pant) ds[i]);
                } else {
                    a.them((Shirt) ds[i]);
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
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    a.them((Shirt) ds[i]);
            }
        }
        return a;
    }

    public DSSP timkiemMutrumdau_DSSP(boolean mutrumdau) {
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    a.them((Shirt) ds[i]);
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
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    a.them((Pant) ds[i]);
            }
        }
        return a;
    }

    public DSSP timkiemThunquan_DSSP(boolean thunquan) {
        DSSP a = new DSSP();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    a.them((Pant) ds[i]);
            }
        }
        return a;
    }
}