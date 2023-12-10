package Bill;
import InputManage.Input;
public class HoaDon{
    private String mahd;
    private String makh;
    private String manv;
    private double tongtien;
    private String ngaylap;
    public HoaDon(){
        mahd = "";
        makh = "";
        manv = "";
        tongtien = 0;
        ngaylap = "";
    }
    public HoaDon(String mahd, String makh, String manv, double tongtien, String ngaylap){
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.tongtien = tongtien;
        this.ngaylap = ngaylap;
    }
    public HoaDon(HoaDon a){
        mahd = a.mahd;
        makh = a.makh;
        manv = a.manv;
        tongtien = a.tongtien;
        ngaylap = a.ngaylap;
    }
    public void setMahd (String mahd){
        this.mahd = mahd;
    }
    public void setMakh (String makh){
        this.makh = makh;
    }
    public void setManv(String manv){
        this.manv = manv;
    }
    public void setTongtien(double tongtien){
        this.tongtien = tongtien;
    }
    public void setNgaylap (String ngaylap){
        this.ngaylap = ngaylap;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMakh() {
        return makh;
    }

    public String getManv() {
        return manv;
    }

    public double getTongtien() {
        return tongtien;
    }

    public String getNgaylap() {
        return ngaylap;
    }
    public void setByInput(){
        System.out.print("Nhap ma hoa don: ");
        mahd = Input.getString();
        System.out.print("Nhap ma khach hang: ");
        makh = Input.getString();
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ngay lap: ");
        ngaylap = Input.getString();
    }
    @Override public String toString(){
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Tong tien: " + tongtien);
        System.out.println("Ngay lap: " + ngaylap);
        return "";
    }
}