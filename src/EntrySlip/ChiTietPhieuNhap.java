package EntrySlip;

import InputManage.Input;

import javax.print.attribute.standard.DocumentName;

public class ChiTietPhieuNhap {
    private String maphieunhap;
    private String masp;
    private int soluongnhap;
    private double dongia;
    private double thanhtien;
    public ChiTietPhieuNhap(){
        maphieunhap = "";
        masp = "";
        soluongnhap = 0;
        dongia = 0;
        thanhtien = 0;
    }
    public ChiTietPhieuNhap(String maphieunhap, String masp, int soluongnhap, double dongia, double thanhtien){
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluongnhap = soluongnhap;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public String getMasp() {
        return masp;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public double getDongia() {
        return dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void setByInput(){
        System.out.print("Nhap ma phieu nhap: ");
        maphieunhap = Input.getString();
        System.out.print("Nhap ma san pham: ");
        masp = Input.getString();
        System.out.print("So luong nhap: ");
        soluongnhap = Input.getInt();
        System.out.print("Nhap don gia: ");
        dongia = Input.getDouble();
    }
    @Override public String toString(){
        System.out.println("Ma phieu nhap: " + maphieunhap);
        System.out.println("Ma san pham: " + masp);
        System.out.println("So luong nhap: " + soluongnhap);
        System.out.println("Don gia: " + dongia);
        System.out.println("Thanh tien: " + thanhtien);
        return "";
    }
}

