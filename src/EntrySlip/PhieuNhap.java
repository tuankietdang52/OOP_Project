package EntrySlip;

import Bill.ChiTietHoaDon;
import InputManage.Input;
import ProductContainer.DSSP;
import Users.Employee;
import Users.EmployeeList;
import org.jetbrains.annotations.NotNull;
import Interface.IList;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class PhieuNhap implements Serializable, IList<ChiTietPhieuNhap> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String maphieunhap;
    private String manv;
    private String manhacungcap;
    private LocalDateTime ngaylap;
    private ChiTietPhieuNhap[] chitiet;
    private double tongtien;
    public PhieuNhap(){
        maphieunhap = "";
        manv = "";
        manhacungcap = "";
        ngaylap = null;
        tongtien = 0;
    }
    public PhieuNhap(String maphieunhap, String manv, String manhacungcap, LocalDateTime ngaylap, Double tongtien, ChiTietPhieuNhap[] chitiet){
        this.maphieunhap = maphieunhap;
        this.manv = manv;
        this.manhacungcap = manhacungcap;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
        this.chitiet = chitiet;
    }
    public PhieuNhap(@NotNull PhieuNhap a){
        maphieunhap = a.maphieunhap;
        manv = a.manv;
        manhacungcap = a.manhacungcap;
        ngaylap = a.ngaylap;
        tongtien = a.tongtien;
        chitiet = a.chitiet;
    }
    public void createMaphieunhap(){
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String code = "";

        Random random = new Random();
        for (int i = 0; i < 7; i++){
            int index = random.nextInt(character.length());
            code += character.charAt(index);
        }

        maphieunhap = code;
    }
    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public void setNgaylap(LocalDateTime ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public String getManv() {
        return manv;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public LocalDateTime getNgaylap() {
        return ngaylap;
    }

    public double getTongtien() {
        return tongtien;
    }
    public ChiTietPhieuNhap[] getChitiet(){return chitiet;}

    public void setByInput(){
        System.out.print("Nhap ma phieu nhap: ");
        maphieunhap = Input.getString();
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ma nha cung cap: ");
        manhacungcap = Input.getString();
        System.out.print("Nhap ngay lap: ");
        ngaylap = Input.getDateTime();
        System.out.print("Nhap chi tiet phieu nhap: ");
        them();
    }

    public Boolean checkEmployee(String manv){
        EmployeeList employeeList = new EmployeeList(true);

        int index = employeeList.timkiemManv(manv);

        return index != -1;
    }

    public Boolean setField(){
        do{
            System.out.print("Nhap ma nhan vien: ");
            manv = Input.getString();

            if (manv.equals("0")) return false;

        } while (!checkEmployee(manv));

        System.out.print("Nhap ma nha cung cap: ");
        manhacungcap = Input.getString();

        if (manhacungcap.equals("0")) return false;

        ngaylap = LocalDateTime.now();
        return true;
    }
    public ChiTietPhieuNhap findDetailProduct(int stt){
        for (var item : chitiet){
            if (item.getStt() != stt) continue;

            return item;
        }

        System.out.println("Khong tim thay san pham\n");
        return null;
    }

    private int convertToInt(String interger){
        try{
            return Integer.parseInt(interger);
        }
        catch (Exception ex){
            System.out.println("Tham so truyen vao kh phai la so\nError: " + ex);
            return -1;
        }
    }
    private void setPhieuNhapDetail(){
        tongtien = 0;

        for (int i = 0; i < chitiet.length; i++){
            chitiet[i].setMaphieunhap(this.maphieunhap);
            chitiet[i].setStt(i + 1);
            tongtien += chitiet[i].getThanhtien();
        }
    }
    private @NotNull Boolean isAppend(){
        System.out.println("Tiep tuc them ?\n 1. Co      2. Khong");
        int choice;

        do{
            choice = Input.getInt();
            if (choice != 1 && choice != 2){
                System.out.println("Lua chon 1 hoac 2, Vui long nhap lai:\n");
            }

        }while (choice != 1 && choice != 2);

        return choice == 1;
    }

    public void them(){
        if (chitiet == null) chitiet = new ChiTietPhieuNhap[0];
        do {
            System.out.println("Nhap chi tiet moi:\n");
            var detail = new ChiTietPhieuNhap();
            detail.setByInput();

            them(detail);

        }while (isAppend());

        setPhieuNhapDetail();
    }
    @Override
    public ChiTietPhieuNhap @NotNull [] increaseLength(){
        var temparray = new ChiTietPhieuNhap[chitiet.length + 1];
        System.arraycopy(chitiet, 0, temparray, 0, chitiet.length);
        return temparray;
    }
    @Override
    public void them(ChiTietPhieuNhap detail) {
        chitiet = increaseLength();
        chitiet[chitiet.length - 1] = detail;
        increaseProductRemain(detail);

        setPhieuNhapDetail();
    }

    public void increaseProductRemain(@NotNull ChiTietPhieuNhap detail){
        DSSP productList = new DSSP(true);
        var list = productList.getDs();
        var productDetail = detail.getSanpham();

        for (var product : list){
            if (!Objects.equals(product.getMasp(), productDetail.getMasp())) continue;

            int amount = detail.getSoluongnhap() + product.getSltonkho();
            product.setSltonkho(amount);
        }

        productList.save();
    }

    @Override
    public void sua(String Stt) {
        int index = convertToInt(Stt);

        if (index == -1) return;

        var product = findDetailProduct(index);
        // khong tim thay sp
        if (product == null) return;

        product.sua();
    }
    @Override
    public void xoa(String Stt) {
        int index = convertToInt(Stt) - 1;

        if (index == -1) return;

        var temparray = new ChiTietPhieuNhap[chitiet.length - 1];
        var remainLength = chitiet.length - index - 1;

        System.arraycopy(chitiet, 0, temparray, 0, index);
        System.arraycopy(chitiet, index + 1, temparray, index, remainLength);

        chitiet = temparray;
        setPhieuNhapDetail();
    }
    public void printDetailPhieuNhap(){
        for (var item : chitiet){
            System.out.println(item);
            System.out.println("-------------------");
        }
    }
    public void printDateTime(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date = ngaylap.format(dateFormat);

        System.out.println("Ngay lap phieu nhap: " + date);
    }
    @Override
    public String toString(){
        int stt = 1;
        String ngaymua = ngaylap.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("+-----+-------------------------------------+--------+-----------+----------+");
            System.out.printf("| Ma nhan vien : %s          Ma nha cung cap: %s                   |\n"
                    ,manv,manhacungcap);
        System.out.printf("| Ma phieu nhap: %s                                                           |\n"
                ,maphieunhap);
        System.out.println("+-----+-------------------------------------+--------+-----------+----------+");
        System.out.println("| STT |               Ten sp                |  Size  | Gioi tinh | So luong |");
        System.out.println("+-----+-------------------------------------+--------+-----------+----------+");
        for(int i=0;i<chitiet.length;i++){
            if (stt >= 10){
                System.out.printf("|  %d | %-35s | %-6s | %-9s | %-8d |\n"
                        ,stt
                        ,chitiet[i].getSanpham().getTensp()
                        ,chitiet[i].getSanpham().getSize()
                        ,chitiet[i].getSanpham().getGioitinh()
                        ,chitiet[i].getSoluongnhap());
                stt +=1;
                continue;
            }

            System.out.printf("|  %d  | %-35s | %-6s | %-9s | %-8d |\n"
                    ,stt
                    ,chitiet[i].getSanpham().getTensp()
                    ,chitiet[i].getSanpham().getSize()
                    ,chitiet[i].getSanpham().getGioitinh()
                    ,chitiet[i].getSoluongnhap());
            stt +=1;
        }
        System.out.println("+-----+-------------------------------------+--------+-----------+----------+");
        System.out.printf("|   Ngay lap: %s                    |           |          |\n",ngaymua);
        System.out.println("+-----+-------------------------------------+--------+-----------+----------+");
        return "";
    }
}
