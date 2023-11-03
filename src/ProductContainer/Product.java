package ProductContainer;
import java.util.Scanner;
public abstract class Product {
    private String masp;
    private String tensp;
    private ProductType loaisp;
    private int sltonkho;
    private double dongia;
    private String size;
    private String chatlieu;
    public Product() {
        this.masp = "";
        this.tensp = "";
        this.loaisp = new ProductType();
        this.sltonkho = 0;
        this.dongia = 0.0;
        this.size = "";
        this.chatlieu = "";
    }
    public Product(String masp, String tensp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.sltonkho = sltonkho;
        this.dongia = dongia;
        this.chatlieu = chatlieu;
        this.size = size;
    }
    public Product(String masp, String tensp, String maloaisp, String tenloaisp, String gioitinh, int sltonkho, double dongia, String chatlieu, String size) {
        this.masp = masp;
        this.tensp = tensp;
        loaisp=new ProductType(maloaisp,tenloaisp,gioitinh);
        this.sltonkho = sltonkho;
        this.dongia = dongia;
        this.chatlieu = chatlieu;
        this.size = size;
    }
    public Product(Product a){
        this.masp = a.masp;
        this.tensp = a.tensp;
        this.loaisp = a.loaisp;
        this.sltonkho = a.sltonkho;
        this.dongia = a.dongia;
        this.chatlieu = a.chatlieu;
        this.size = a.size;
    }
    public String getMasp() {
        return this.masp;
    }
    public String getTensp() {
        return this.tensp;
    }
    public ProductType getLoaisp() {
        return this.loaisp;
    }
    public int getSltonkho() {
        return this.sltonkho;
    }
    public String getSize() {
        return this.size;
    }
    public double getDongia() {
        return this.dongia;
    }
    public String getChatlieu() {
        return this.chatlieu;
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
    public void setLoaisp(String maloaisp, String tenloaisp, String gioitinh) {
        this.loaisp = new ProductType(maloaisp, tenloaisp, gioitinh);
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
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap masp: ");
        this.masp = input.nextLine();
        System.out.print("Nhap ten sp: ");
        this.tensp = input.nextLine();
        System.out.println("Nhap loai sp: ");
        this.loaisp.nhap();
        System.out.print("Nhap so luong ton: ");
        this.sltonkho = input.nextInt();
        System.out.print("Nhap don gia: ");
        this.dongia = input.nextDouble();
        input.nextLine();
        System.out.println("Nhap size: ");
        this.size = input.nextLine();
        System.out.println("Nhap chat lieu: ");
        this.chatlieu = input.nextLine();
    }
}
