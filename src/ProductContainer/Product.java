package ProductContainer;

import InputManage.Input;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public abstract class Product {
    private String masp;
    private String tensp;
    private int sltonkho;
    private double dongia;
    private String size;
    private String chatlieu;

    public Product(){
        masp = "";
        sltonkho = 0;
        dongia = 0;
        size = "";
        chatlieu = "";
    }

    public Product(String masp, String tensp, int sltonkho, double dongia, String chatlieu, String size){
        this.masp = masp;
        this.tensp = tensp;
        this.sltonkho = sltonkho;
        this.dongia = dongia;
        this.chatlieu = chatlieu;
        this.size = size;
    }

    public Product(@NotNull Product product){
        masp = product.masp;
        tensp = product.tensp;
        sltonkho = product.sltonkho;
        dongia = product.dongia;
        chatlieu = product.chatlieu;
        size = product.size;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() { return tensp; }

    public int getSltonkho(){
        return sltonkho;
    }

    public String getSize() {
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

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSltonkho(int sltonkho) {
        this.sltonkho = sltonkho;
    }

    public void setByInput(){
        Scanner scint = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        masp = Input.getString();
        System.out.print("Nhap ten san pham: ");
        tensp = Input.getString();
        System.out.print("Nhap so luong ton kho: ");
        sltonkho = Input.getInt();
        System.out.print("Nhap don gia: ");
        dongia = Input.getDouble();
        System.out.print("Nhap chat lieu: ");
        chatlieu = Input.getString();
        System.out.print("Nhap size: ");
        size = Input.getString();
    }

    public void PrintBasicElement(){
        System.out.println("Ma sp: " + masp);
        System.out.println("Ten sp: " + tensp);
        System.out.println("So luong ton kho: " + sltonkho);
        System.out.println("Don gia: " + dongia);
        System.out.println("Size: " + size);
        System.out.println("Chat lieu: " + chatlieu);
    }
}
