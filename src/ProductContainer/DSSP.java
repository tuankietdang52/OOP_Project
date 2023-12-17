package ProductContainer;
import InputManage.Input;
import Interface.IFile;
import java.io.Serializable;

import Interface.IList;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
public class DSSP implements IFile, IList<Product> {
    private Product[] ds;
    private int n;
    public void nhap() {
        System.out.print("Nhap so luong san pham: ");
        n = Input.getInt();
        ds = new Product[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("San pham thu " + (i + 1));
            System.out.print("Day la quan(0) hay ao(1)?: ");
            int opt = Input.getInt();
            if (opt == 0) {
                ds[i] = new Pant();
            } else {
                ds[i] = new Shirt();
            }
            ds[i].setByInput();
        }
        save();
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

    public DSSP(Boolean isGetData){
        if (!isGetData) return;

        try{
            read();
        }
        catch (Exception ex){
            System.out.println("Cant get data from file\nError: " + ex);
        }

        if (ds.length == 0) System.out.println("No data\n");

    }
    public DSSP(Product[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public DSSP(@NotNull DSSP a) {
        n = a.n;
        ds = a.ds;
    }

    @Override
    public Product @NotNull [] increaseLength(){
        var temparray = new Product[ds.length + 1];
        System.arraycopy(ds, 0, temparray, 0, ds.length);
        return temparray;
    }

    @Override
    public void read() throws Exception{
        ds = new Product[0];
        var i = 0;

        File productdata = new File("./src/Data/Product.bin");
        FileInputStream stream = new FileInputStream(productdata);
        ObjectInputStream read = new ObjectInputStream(stream);
        try{
            while (true){
                var product = (Product)read.readObject();
                if (product == null) break;

                if (i >= ds.length) ds = increaseLength();

                ds[i] = product;
                i++;
            }
        }
        catch (EOFException ex){
            read.close();
        }
        n = ds.length;
    }

    @Override
    public void save(){
        File productdata = new File("./src/Data/Product.bin");
        try{
            FileOutputStream stream = new FileOutputStream(productdata);
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
    public void clear(){
        File productdata = new File("./src/Data/Product.bin");
        try{
            FileOutputStream stream = new FileOutputStream(productdata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            write.writeChars("");
            write.close();

            read();
        }
        catch (Exception ex){
            System.out.println("Cant write data from file\nError: " + ex);
        }
    }

    public Product[] getDs() {
        return ds;
    }

    public void setDs(Product[] ds){
        this.ds = ds;
    }

    public void setElementofDs(int pos, Product product){
        ds[pos] = product;
        save();
    }

    public void setElementsofDs(Product[] listProducts){
        for (int i = 0; i < ds.length; i++){
            for (int j = 0; j < listProducts.length; j++){
                if (ds[i].getMasp() != listProducts[j].getMasp()) continue;

                ds[i] = listProducts[j];
            }
        }

        save();
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        System.out.print("Quan(0) / ao(1)");
        int opt = Input.getInt();
        if (opt == 0) {
            ds[n] = new Pant();
        } else {
            ds[n] = new Shirt();
        }
        ds[n].setByInput();
        ++n;
        save();
    }

    @Override
    public void them(Product product) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = product;

        save();
    }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            System.out.print("Day la quan(0) hay ao(1)?: ");
            int opt = Input.getInt();
            if (opt == 0) {
                ds[n] = new Pant();
            } else {
                ds[n] = new Shirt();
            }
            ds[n].setByInput();
            ++i;
            ++n;
        }
        save();
    }

    @Override
    public void xoa(String masp) {
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
        save();
    }

    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public void timkiemMasp() {
        System.out.println("Ma sp can tim: ");
        String masp = Input.getString();
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
        String masp = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMasp().equals(masp))
                System.out.print(ds[i] + "\n");
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
        String tensp = Input.getString();
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
        String tensp = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getTensp().contains(Xoa_khoang_trang_thua(tensp)))
                System.out.print(ds[i] + "\n");
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
        String tensp = Input.getString();
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
        ESex gioitinh = Input.getSex();
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh() == gioitinh)
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemGioitinh(ESex gioitinh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh() == gioitinh)
                return i;
        }
        return -1;
    }
    public void timkiemGioitinh_Product() {
        System.out.println("Gioi tinh can tim: ");
        ESex gioitinh = Input.getSex();
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh() == gioitinh)
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public Product timkiemGioitinh_Product(ESex gioitinh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh() == gioitinh)
                return ds[i];
        }
        return null;
    }
    public DSSP timkiemGioitinh_DSSP() {
        System.out.print("Gioi tinh can tim: ");
        ESex gioitinh = Input.getSex();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh() == gioitinh) {
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
    public DSSP timkiemGioitinh_DSSP(ESex gioitinh) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getGioitinh() == gioitinh) {
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
        ESize size = Input.getSize();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize() == size)
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemSize(ESize size) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize() == size)
                return i;
        }
        return -1;
    }

    public void timkiemSize_Product() {
        System.out.println("Size can tim: ");
        ESize size = Input.getSize();
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize() == size)
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public Product timkiemSize_Product(ESize size) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize() == size)
                return ds[i];
        }
        return null;
    }

    public DSSP timkiemSize_DSSP() {
        System.out.print("Size can tim: ");
        ESize size = Input.getSize();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize() == size) {
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

    public DSSP timkiemSize_DSSP(ESize size) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getSize() == size) {
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
        String chatlieu = Input.getString();
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
        String chatlieu = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getChatlieu().contains(Xoa_khoang_trang_thua(chatlieu)))
                System.out.print(ds[i] + "\n");
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
        String chatlieu = Input.getString();
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
        double dongia = Input.getDouble();
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
        double dongia = Input.getDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), dongia) == 0)
                System.out.print(ds[i] + "\n");
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
        double dongia = Input.getDouble();
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
    public DSSP timkiemKhoangDongia_DSSP() {
        System.out.print("From: ");
        double minDongia = Input.getDouble();
        System.out.print("to: ");
        double maxDongia = Input.getDouble();
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), minDongia) >= 0
                && Double.compare(ds[i].getDongia(), maxDongia) <= 0) {
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

    public DSSP timkiemKhoangDongia_DSSP(double minDongia,double maxDongia) {
        DSSP a = new DSSP();
        a.ds=new Product[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getDongia(), minDongia) >= 0
                    && Double.compare(ds[i].getDongia(), maxDongia) <= 0) {
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
        boolean mutrumdau = Input.getBoolean();
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
        boolean mutrumdau = Input.getBoolean();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Shirt) {
                if (((Shirt) ds[i]).getMutrumdau() == mutrumdau)
                    System.out.print(ds[i] + "\n");
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
        boolean mutrumdau = Input.getBoolean();
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
        boolean thunquan = Input.getBoolean();
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
        boolean thunquan = Input.getBoolean();
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof Pant) {
                if (((Pant) ds[i]).getThunquan() == thunquan)
                    System.out.print(ds[i] + "\n");
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
        boolean thunquan = Input.getBoolean();
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
        String hoatiet = Input.getString();
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
        String hoatiet = Input.getString();
        for (int i = 0; i < n; i++) {
            if (((Shirt) ds[i]).getHoatiet().contains(Xoa_khoang_trang_thua(hoatiet)))
                System.out.print(ds[i] + "\n");
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
        String hoatiet = Input.getString();
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

    @Override
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
                            menuSua();
                            opt = Input.getInt();
                            switch(opt) {
                                case 1:
                                    doiTenSp(ds[i]);
                                    break;
                                case 2:
                                    doiSLTonKho(ds[i]);
                                    break;
                                case 3:
                                    doiDonGia(ds[i]);
                                    break;
                                case 4:
                                    doiSize(ds[i]);
                                    break;
                                case 5:
                                    doiChatLieu(ds[i]);
                                    break;
                                case 6:
                                    doiThunQuan(ds[i]);
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
                            menuSua();
                            opt=Input.getInt();
                            switch(opt) {
                                case 1:
                                    doiTenSp(ds[i]);
                                    break;
                                case 2:
                                    doiSLTonKho(ds[i]);
                                    break;
                                case 3:
                                    doiDonGia(ds[i]);
                                    break;
                                case 4:
                                    doiSize(ds[i]);
                                    break;
                                case 5:
                                    doiChatLieu(ds[i]);
                                    break;
                                case 6:
                                    doiMuTrumDau(ds[i]);
                                    break;
                                case 7:
                                    doiHoaTiet(ds[i]);
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
            save();
        }
        else {
            System.out.println("Ma sp khong ton tai!");
        }
    }
    public void sua() {
        System.out.print("Nhap ma cua sp muon sua thong tin: ");
        String masp = Input.getString();
        int flag = 0;
        int opt;
        for (int i = 0; i < n; ++i) {
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
                            menuSua();
                            opt = Input.getInt();
                            switch(opt) {
                                case 1:
                                    doiTenSp(ds[i]);
                                    break;
                                case 2:
                                    doiSLTonKho(ds[i]);
                                    break;
                                case 3:
                                    doiDonGia(ds[i]);
                                    break;
                                case 4:
                                    doiSize(ds[i]);
                                    break;
                                case 5:
                                    doiChatLieu(ds[i]);
                                    break;
                                case 6:
                                    doiThunQuan(ds[i]);
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
                            menuSua();
                            opt=Input.getInt();
                            switch(opt) {
                                case 1:
                                    doiTenSp(ds[i]);
                                    break;
                                case 2:
                                    doiSLTonKho(ds[i]);
                                    break;
                                case 3:
                                    doiDonGia(ds[i]);
                                    break;
                                case 4:
                                    doiSize(ds[i]);
                                    break;
                                case 5:
                                    doiChatLieu(ds[i]);
                                    break;
                                case 6:
                                    doiMuTrumDau(ds[i]);
                                    break;
                                case 7:
                                    doiHoaTiet(ds[i]);
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
            save();
        }
        else {
            System.out.println("Ma sp khong ton tai!");
        }
    }
    private void menuSua(){
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
    }
    private void doiTenSp(@NotNull Product a){
        System.out.println("Doi ten sp thanh:");
        String tensp = Input.getString();
        a.setTensp(tensp);
    }
    private void doiSLTonKho(@NotNull Product a){
        System.out.println("Doi so luong ton kho thanh:");
        int sltonkho = Input.getInt();
        a.setSltonkho(sltonkho);
    }
    private void doiDonGia(@NotNull Product a){
        System.out.println("Doi don gia thanh:");
        double dongia = Input.getDouble();
        a.setDongia(dongia);
    }
    private void doiSize(@NotNull Product a){
        System.out.println("Doi size thanh:");
        ESize size = Input.getSize();
        a.setSize(size);
    }
    private void doiChatLieu(@NotNull Product a){
        System.out.println("Doi chat lieu thanh:");
        String chatlieu = Input.getString();
        a.setChatlieu(chatlieu);
    }
    private void doiMuTrumDau(@NotNull Product a){
        System.out.println("Doi mu trum dau thanh:");
        boolean mutrumdau = Input.getBoolean();
        ((Shirt) a).setMutrumdau(mutrumdau);
    }
    private void doiHoaTiet(@NotNull Product a){
        System.out.println("Doi hoa tiet thanh:");
        String hoatiet = Input.getString();
        ((Shirt) a).setHoatiet(hoatiet);
    }
    private void doiThunQuan(@NotNull Product a){
        System.out.println("Doi thun quan thanh:");
        boolean thunquan = Input.getBoolean();
        ((Pant) a).setThunquan(thunquan);
    }
}
