package ProductContainer;
import java.util.Scanner;
public abstract class Product {
    private String masp;
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

    public Product(String masp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size){
        this.masp = masp;
        this.loaisp = loaisp;
        this.sltonkho = sltonkho;
        this.dongia = dongia;
        this.chatlieu = chatlieu;
        this.size = size;
    }


    public String getMasp() {
        return masp;
    }

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

    public String getChatlieu() { return chatlieu; }

    public void setMasp(String masp) {
        this.masp = masp;
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
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập masp: ");
        masp=input.nextLine();
        System.out.println("Nhập loại sp: ");
        loaisp.nhap();
        System.out.print("Nhập số lượng tồn: ");
        sltonkho=input.nextInt();
        System.out.print("Nhập đơn giá: ");
        dongia=input.nextDouble();
        input.nextLine();
        System.out.print("Nhập size: ");
        size=input.nextLine();
        System.out.print("Nhập chất liệu: ");
        chatlieu=input.nextLine();
    }
}
