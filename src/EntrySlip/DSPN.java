package EntrySlip;

import Bill.DSHD;
import Bill.HoaDon;
import InputManage.Input;
import Interface.IFile;
import Interface.IList;
import Users.Customer;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DSPN implements IFile, IList<PhieuNhap> {
    private PhieuNhap[] ds;
    private int n;
    public void nhap() {
        System.out.print("Nhap so luong phieu nhap: ");
        n = Input.getInt();
        ds = new PhieuNhap[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Phieu nhap thu " + (i + 1));
            ds[i] = new PhieuNhap();
            ds[i].setByInput();
        }
        save();
    }

    public String toString() {
        for (int i = 0; i < n; ++i) {
            System.out.println("\nPhieu nhap thu " + (i + 1) + ":");
            System.out.println(ds[i]);
            System.out.println("============================");
        }
        return "";
    }
    public DSPN() {

    }

    public DSPN(Boolean isGetData){
        if (!isGetData) return;

        try{
            read();
        }
        catch (Exception ex){
            if (ds.length == 0){
                ds = new PhieuNhap[0];
                return;
            }
            System.out.println("Cant get data from file\nError: " + ex);
        }

    }

    public DSPN(PhieuNhap[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public DSPN(@NotNull DSPN a) {
        n = a.n;
        ds = a.ds;
    }

    public PhieuNhap[] getDs() {
        return ds;
    }

    public void setDs(PhieuNhap[] ds) {
        this.ds = ds;
    }

    public void setElementofDs(int pos, PhieuNhap phieunhap){
        ds[pos] = phieunhap;
    }

    public PhieuNhap @NotNull [] increaseLength(){
        var temparray = new PhieuNhap[ds.length + 1];
        System.arraycopy(ds, 0, temparray, 0, ds.length);
        return temparray;
    }

    @Override
    public void read() throws Exception {
        ds = new PhieuNhap[0];
        var i = 0;

        File customerdata = new File("./src/Data/PN.bin");
        FileInputStream stream = new FileInputStream(customerdata);
        ObjectInputStream read = new ObjectInputStream(stream);
        try{
            while (true){
                var pn = (PhieuNhap)read.readObject();
                if (pn == null) break;

                if (i >= ds.length) ds = increaseLength();

                ds[i] = pn;
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
        File customerdata = new File("./src/Data/PN.bin");
        try{
            FileOutputStream stream = new FileOutputStream(customerdata);
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
        File customerdata = new File("./src/Data/PN.bin");
        try{
            FileOutputStream stream = new FileOutputStream(customerdata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            write.writeChars("");
            write.close();

            read();
        }
        catch (Exception ex){
            System.out.println("Cant write data from file\nError: " + ex);
        }
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new PhieuNhap();
        ds[n].setByInput();
        ++n;
        save();
    }
    public void nhapHang(){
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new PhieuNhap();
        ds[n].setField();
        ++n;
        ds[n].createMaphieunhap();
        LocalDateTime time = LocalDateTime.now();
        ds[n].setNgaylap(time);
        save();
    }
    @Override
    public void them(PhieuNhap phieuNhap) {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new PhieuNhap(phieuNhap);
        ++n;
        save();
    }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            ds[n] = new PhieuNhap();
            ds[n].setByInput();
            ++i;
            ++n;
        }
        save();
    }

    @Override
    public void xoa(String maphieunhap) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMaphieunhap().equals(maphieunhap)) {
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

    public void timkiemMapn() {
        System.out.println("Ma phieu nhap can tim: ");
        String mapn = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaphieunhap().equals(mapn))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemMapn(String mapn) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaphieunhap().equals(mapn))
                return i;
        }
        return -1;
    }

    public void timkiemMapn_PhieuNhap() {
        System.out.println("Ma phieu nhap can tim: ");
        String mapn = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaphieunhap().equals(mapn))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public PhieuNhap timkiemMapn_PhieuNhap(String mapn) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaphieunhap().equals(mapn))
                return ds[i];
        }
        return null;
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
    public void timkiemManv_PhieuNhap() {
        System.out.println("Ma nhan vien can tim: ");
        String manv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public PhieuNhap timkiemManv_PhieuNhap(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                return ds[i];
        }
        return null;
    }
    public DSPN timkiemManv_DSPN() {
        System.out.print("Ma nhan vien can tim: ");
        String manv = Input.getString();
        DSPN a = new DSPN();
        a.ds=new PhieuNhap[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new PhieuNhap(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public DSPN timkiemManv_DSPN(String manv) {
        DSPN a = new DSPN();
        a.ds=new PhieuNhap[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new PhieuNhap(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemMaNhacc() {
        System.out.println("Ma nha cung cap can tim: ");
        String manhacc = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManhacungcap().equals(manhacc))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemMaNhacc(String manhacc) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManhacungcap().equals(manhacc))
                return i;
        }
        return -1;
    }
    public void timkiemMaNhacc_PhieuNhap() {
        System.out.println("Ma nha cung cap can tim: ");
        String manhacc = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManhacungcap().equals(manhacc))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public PhieuNhap timkiemMaNhacc_PhieuNhap(String manhacc) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManhacungcap().equals(manhacc))
                return ds[i];
        }
        return null;
    }
    public DSPN timkiemMaNhacc_DSPN() {
        System.out.print("Ma nha cung cap can tim: ");
        String manhacc = Input.getString();
        DSPN a = new DSPN();
        a.ds=new PhieuNhap[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getManhacungcap().equals(manhacc)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new PhieuNhap(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public DSPN timkiemMaNhacc_DSPN(String manhacc) {
        DSPN a = new DSPN();
        a.ds=new PhieuNhap[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getManhacungcap().equals(manhacc)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new PhieuNhap(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemTongTien() {
        System.out.println("Tong tien can tim: ");
        double tongtien = Input.getDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemTongTien(double tongtien) {
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                return i;
        }
        return -1;
    }
    public void timkiemTongTien_HoaDon() {
        System.out.println("Tong tien can tim: ");
        double tongtien = Input.getDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public PhieuNhap timkiemTongTienh_HoaDon(double tongtien) {
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                return ds[i];
        }
        return null;
    }
    public DSPN timkiemTongTien_DSPN() {
        System.out.print("Tong tien can tim: ");
        double tongtien = Input.getDouble();
        DSPN a = new DSPN();
        a.ds=new PhieuNhap[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new PhieuNhap(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public DSPN timkiemTongTien_DSPN(double tongtien) {
        DSPN a = new DSPN();
        a.ds=new PhieuNhap[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new PhieuNhap(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    @Override
    public void sua(String mapn) {
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMaphieunhap().equals(mapn)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getMaphieunhap().equals(mapn)) {
                    do {
                        menuSua();
                        opt=Input.getInt();
                        switch(opt) {
                            case 1:
                                doiMaNhanVien(ds[i]);
                                break;
                            case 2:
                                doiMaNhacc(ds[i]);
                                break;
                            case 3:
                                doiTongTien(ds[i]);
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
        else    System.out.println("Ma phieu nhap khong ton tai!");
    }
    public void sua() {
        System.out.print("Nhap ma phieu nhap muon sua thong tin: ");
        String mapn = Input.getString();
        int flag = 0;
        int opt;
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMaphieunhap().equals(mapn)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                if (ds[i].getMaphieunhap().equals(mapn)) {
                    do {
                        menuSua();
                        opt = Input.getInt();
                        switch (opt) {
                            case 1:
                                doiMaNhanVien(ds[i]);
                                break;
                            case 2:
                                doiMaNhacc(ds[i]);
                                break;
                            case 3:
                                doiTongTien(ds[i]);
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
        } else System.out.println("Ma phieu nhap khong ton tai!");
    }
    private void menuSua(){
        System.out.println("---------------------------");
        System.out.println("1. Sua ma nhan vien:");
        System.out.println("2. Sua ma nha cung cap:");
        System.out.println("3. Sua tong tien:");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
    private void doiMaNhanVien(@NotNull PhieuNhap a){
        System.out.println("Doi ma nhan vien thanh:");
        String manv = Input.getString();
        a.setManv(manv);
    }
    private void doiMaNhacc(@NotNull PhieuNhap a){
        System.out.println("Doi ma nha cung cap thanh:");
        String manhacc = Input.getString();
        a.setManv(manhacc);
    }
    private void doiTongTien(@NotNull PhieuNhap a){
        System.out.println("Doi tong tien thanh:");
        double tongtien = Input.getDouble();
        a.setTongtien(tongtien);
    }
}
