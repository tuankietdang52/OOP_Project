package ProductContainer;
import java.util.Scanner;
public class Shirt extends Product {
    private boolean mutrumdau;
    private String hoatiet;
    public Shirt() {
        this.mutrumdau = false;
        this.hoatiet = "";
    }
    public Shirt(String masp, String tensp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean mutrumdau, String hoatiet) {
        super(masp, tensp, loaisp, sltonkho, dongia, chatlieu, size);
        this.mutrumdau = mutrumdau;
        this.hoatiet = hoatiet;
    }
    public Shirt(String masp, String tensp, String maloaisp, String tenloaisp, String gioitinh, int sltonkho, double dongia, String chatlieu, String size, boolean mutrumdau, String hoatiet) {
        super(masp, tensp, maloaisp, tenloaisp, gioitinh, sltonkho, dongia, chatlieu, size);
        this.mutrumdau = mutrumdau;
        this.hoatiet = hoatiet;
    }
    public Shirt(Shirt a) {
        super(a);
        mutrumdau = a.mutrumdau;
        hoatiet = a.hoatiet;
    }
    public String getMasp() {
        return super.getMasp();
    }
    public String getTensp() {return super.getTensp();}
    public ProductType getLoaisp() {
        return super.getLoaisp();
    }
    public int getSltonkho() {
        return super.getSltonkho();
    }
    public String getSize() {
        return super.getSize();
    }
    public double getDongia() {
        return super.getDongia();
    }
    public String getChatlieu() {
        return super.getChatlieu();
    }
    public boolean getMutrumdau() {
        return this.mutrumdau;
    }
    public String getHoatiet() {
        return this.hoatiet;
    }
    public void setMasp(String masp) {
        super.setMasp(masp);
    }
    public void setTensp(String tensp) {super.setTensp(tensp);}
    public void setLoaisp(ProductType loaisp) {
        super.setLoaisp(loaisp);
    }
    public void setLoaisp(String maloaisp, String tenloaisp, String gioitinh) {
        this.getLoaisp().setMaloaisp(maloaisp);
        this.getLoaisp().setTenloaisp(tenloaisp);
        this.getLoaisp().setGioitinh(gioitinh);
    }
    public void setChatlieu(String chatlieu) {
        super.setChatlieu(chatlieu);
    }
    public void setDongia(double dongia) {
        super.setDongia(dongia);
    }
    public void setSize(String size) {
        super.setSize(size);
    }
    public void setSltonkho(int sltonkho) {
        super.setSltonkho(sltonkho);
    }
    public void setMutrumdau(boolean IsHave) {
        this.mutrumdau = IsHave;
    }
    public void setHoatiet(String hoatiet) {
        this.hoatiet = hoatiet;
    }
    public String toString() {
        System.out.println("Ma sp: " + this.getMasp());
        this.getLoaisp().PrintData();
        System.out.println("So luong ton kho: " + this.getSltonkho());
        System.out.println("Don gia: " + this.getDongia());
        System.out.println("Size: " + this.getSize());
        System.out.println("Chat lieu: " + this.getChatlieu());
        System.out.println("Mu trum dau: " + this.getMutrumdau());
        System.out.println("Hoa tiet: " + this.getHoatiet());
        return "";
    }
    public void nhap() {
        Scanner input = new Scanner(System.in);
        super.nhap();
        System.out.print("Có mũ trùm đầu không: ");
        this.mutrumdau = input.nextBoolean();
        System.out.print("Họa tiết: ");
        this.hoatiet = input.nextLine();
    }
}

