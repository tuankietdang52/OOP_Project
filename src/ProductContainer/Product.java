package ProductContainer;

import org.jetbrains.annotations.NotNull;

public abstract class Product {
    private String masp;
    private String tensp;
    private ProductType loaisp;
    private int sltonkho;
    private double dongia;
    private String size;
    private String chatlieu;

    public Product(){
        masp = "";
        loaisp = new ProductType();
        sltonkho = 0;
        dongia = 0;
        size = "";
        chatlieu = "";
    }

    public Product(String masp, String tensp ,ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size){
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.sltonkho = sltonkho;
        this.dongia = dongia;
        this.chatlieu = chatlieu;
        this.size = size;
    }

    public Product(@NotNull Product product){
        masp = product.masp;
        tensp = product.tensp;
        loaisp = product.loaisp;
        sltonkho = product.sltonkho;
        dongia = product.dongia;
        chatlieu = product.chatlieu;
        size = product.size;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() { return tensp; }

    public ProductType getLoaisp(){
        return loaisp;
    }

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

    public void setLoaisp(ProductType loaisp) {
        this.loaisp = loaisp;
    }

    public void setLoaisp(String maloaisp, String tenloaisp, String gioitinh){
        loaisp = new ProductType(maloaisp, tenloaisp, gioitinh);
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
}
