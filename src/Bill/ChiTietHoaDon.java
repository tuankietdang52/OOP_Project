package Bill;

import InputManage.Input;

public class ChiTietHoaDon {
    private String mahd;
    private String masp;
    private int soluongmua;
    private double dongia;
    private double thanhtien;

    public ChiTietHoaDon() {
        mahd = "";
        masp = "";
        soluongmua = 0;
        dongia = 0;
        thanhtien = 0;
    }

    public ChiTietHoaDon(String mahd, String masp, int soluongmua, double dongia, double thanhtien) {
        this.mahd = mahd;
        this.masp = masp;
        this.soluongmua = soluongmua;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMasp() {
        return masp;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public double getDongia() {
        return dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }
    public void setByInput(){
        System.out.print("Nhap ma hoa don: ");
        mahd = Input.getString();
        System.out.print("Nhap ma san pham: ");
        masp = Input.getString();
        System.out.print("So luong mua: ");
        soluongmua = Input.getInt();
        System.out.print("Nhap Don gia: ");
        dongia = Input.getDouble();
    }
    @Override public String toString(){
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ma san pham: " + masp);
        System.out.println("So luong mua: " + soluongmua);
        System.out.println("Don gia: " + dongia);
        System.out.println("Thanh tien: " + thanhtien);
        return "";
    }
}
