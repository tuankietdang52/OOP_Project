package EntrySlip;

import InputManage.Input;

import java.time.format.DateTimeFormatter;

public class PhieuNhap {
    private String maphieunhap;
    private String manv;
    private String manhacungcap;
    private String ngaylap;
    private double tongtien;
    public PhieuNhap(){
        maphieunhap = "";
        manv = "";
        manhacungcap = "";
        ngaylap = "";
        tongtien = 0;
    }
    public PhieuNhap(String maphieunhap, String manv, String manhacungcap, String ngaylap, Double tongtien){
        this.maphieunhap = maphieunhap;
        this.manv = manv;
        this.manhacungcap = manhacungcap;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
    }
    public PhieuNhap(PhieuNhap a){
        maphieunhap = a.maphieunhap;
        manv = a.manv;
        manhacungcap = a.manhacungcap;
        ngaylap = a.ngaylap;
        tongtien = a.tongtien;
    }
    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public void setNgaylap(String ngaylap) {
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

    public String getNgaylap() {
        return ngaylap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setByInput(){
        System.out.print("Nhap ma phieu nhap: ");
        maphieunhap = Input.getString();
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ma nha cung cap: ");
        manhacungcap = Input.getString();
        System.out.print("Nhap ngay lap: ");
        ngaylap = Input.getString();
    }
    @Override public String toString(){
        System.out.println("Ma phieu nhap: " + maphieunhap);
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ma nha cung cap: " + manhacungcap);
        System.out.println("Ngay lap: " + ngaylap);
        System.out.println("Tong tien: " + tongtien);
        return "";
    }
    public void xuat(){
//        int stt = 1;
//        String ngaymua = String.valueOf(ngaylap.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:s")));
//        System.out.println("+-----+------------------+---------------------+----------+-----------+------------+");
//        System.out.printf("| Ma phieu nhap: %10s |                                              |\n",mapn);
//        System.out.println("+-----+------------------+---------------------+----------+-----------+------------+");
//        System.out.println("| STT |      Ten sp      |       Ngay mua      | So luong |  Don gia  | Thanh tien |");
//        System.out.println("+-----+------------------+---------------------+----------+-----------+------------+");
//        for(int i=0;i<chitiet.length;i++){
//            System.out.printf("|  %d  | %-16s | %-16s | %-8d | %-8.2f | %-10.2f |\n"
//                    ,stt
//                    ,chitiet[i].getSanpham().getTensp()
//                    ,ngaymua
//                    ,chitiet[i].getSoluongmua()
//                    ,chitiet[i].getSanpham().getDongia()
//                    ,chitiet[i].getThanhtien());
//            stt +=1;
//        }
//        System.out.println("+-----+------------------+---------------------+----------+-----------+------------+");
//        System.out.printf("| %67s | %.2f |\n","Tong tien hoa don:",tongtien);
//        System.out.println("+-----+------------------+---------------------+----------+-----------+------------+");
    }
}
