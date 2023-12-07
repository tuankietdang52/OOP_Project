package ProductContainer;

import InputManage.Input;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String masp;
    private String tensp;
    private ESex gioitinh;
    private int sltonkho;
    private double dongia;
    private ESize size;
    private String chatlieu;

    public Product(){
        masp = "";
        tensp = "";
        gioitinh = null;
        sltonkho = 0;
        dongia = 0;
        size = null;
        chatlieu = "";
    }

    public Product(String masp, String tensp, ESex gioitinh, int sltonkho, double dongia, String chatlieu, ESize size){
        this.masp = masp;
        this.tensp = tensp;
        this.gioitinh = gioitinh;
        this.sltonkho = sltonkho;
        this.dongia = dongia;
        this.chatlieu = chatlieu;
        this.size = size;
    }

    public Product(@NotNull Product product){
        masp = product.masp;
        tensp = product.tensp;
        gioitinh = product.gioitinh;
        sltonkho = product.sltonkho;
        dongia = product.dongia;
        chatlieu = product.chatlieu;
        size = product.size;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() { return tensp; }

    public ESex getGioitinh() {
        return gioitinh;
    }

    public int getSltonkho(){
        return sltonkho;
    }

    public ESize getSize() {
        return size;
    }

    public double getDongia() {
        return dongia;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setGioitinh(ESex gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setSize(ESize size) {
        this.size = size;
    }

    public void setSltonkho(int sltonkho) {
        this.sltonkho = sltonkho;
    }

    public void setByInput(){
        System.out.print("Nhap ma san pham: ");
        masp = Input.getString();
        System.out.print("Nhap ten san pham: ");
        tensp = Input.getString();
        TrimName();
        System.out.print("Nhap gioi tinh: ");
        gioitinh = Input.getSex();
        System.out.print("Nhap so luong ton kho: ");
        sltonkho = Input.getInt();
        System.out.print("Nhap don gia: ");
        dongia = Input.getDouble();
        System.out.print("Nhap chat lieu: ");
        chatlieu = Input.getString();
        System.out.print("Nhap size (S, M, L, XL): ");
        size = Input.getSize();
    }

    public void TrimName(){
        tensp = tensp.trim();
        tensp = tensp.replaceAll("\\s+", " ");
    }

    public void PrintBasicElement(){
        System.out.println("Ma sp: " + masp);
        System.out.println("Ten sp: " + tensp);
        System.out.println("Gioi tinh: " + gioitinh);
        System.out.println("So luong ton kho: " + sltonkho);
        System.out.println("Don gia: " + dongia);
        System.out.println("Size: " + size);
        System.out.println("Chat lieu: " + chatlieu);
    }
}