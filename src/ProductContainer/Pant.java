package ProductContainer;
import java.util.Scanner;
public class Pant extends Product {
    private boolean thunquan;
    public Pant() {
        this.thunquan = false;
    }
    public Pant(String masp, String tensp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean thunquan) {
        super(masp, tensp, loaisp, sltonkho, dongia, chatlieu, size);
        this.thunquan = thunquan;
    }
    public Pant(String masp, String tensp, String maloaisp, String tenloaisp, String gioitinh, int sltonkho, double dongia, String chatlieu, String size, boolean thunquan) {
        super(masp, tensp, maloaisp, tenloaisp, gioitinh, sltonkho, dongia, chatlieu, size);
        this.thunquan = thunquan;
    }
    public Pant(Pant a) {
        super(a);
        thunquan = a.thunquan;
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
    public boolean getThunquan() {
        return this.thunquan;
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
    public void setThunquan(boolean IsHave) {
        this.thunquan = IsHave;
    }
    public String toString() {
        System.out.println("Ma sp: " + this.getMasp());
        System.out.println("Ten sp: " + this.getTensp());
        this.getLoaisp().PrintData();
        System.out.println("So luong ton kho: " + this.getSltonkho());
        System.out.println("Don gia: " + this.getDongia());
        System.out.println("Size: " + this.getSize());
        System.out.println("Chat lieu: " + this.getChatlieu());
        System.out.println("Thun quan: " + this.getThunquan());
        return "";
    }
    public void nhap() {
        Scanner input = new Scanner(System.in);
        super.nhap();
        System.out.print("Co thun quan khong: ");
        this.thunquan = input.nextBoolean();
    }
}
