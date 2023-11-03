package ProductContainer;
import java.util.Scanner;
public class Pant extends Product{
    private boolean thunquan;
    public Pant(){
        thunquan = false;
    }

    public Pant(String masp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean thunquan){
        super(masp, loaisp, sltonkho, dongia, chatlieu, size);
        this.thunquan = thunquan;
    }
    public String getMasp() {
        return super.getMasp();
    }
    public ProductType getLoaisp(){
        return super.getLoaisp();
    }
    public int getSltonkho(){
        return super.getSltonkho();
    }
    public String getSize() {
        return super.getSize();
    }
    public double getDongia() {
        return super.getDongia();
    }
    public String getChatlieu() { return super.getChatlieu(); }
    public boolean getThunquan(){
        return thunquan;
    }
    public void setMasp(String masp) { super.setMasp(masp); }
    public void setLoaisp(ProductType loaisp) {super.setLoaisp(loaisp);}
    public void setLoaisp(String maloaisp, String tenloaisp, String gioitinh){
        getLoaisp().setMaloaisp(maloaisp);
        getLoaisp().setTenloaisp(tenloaisp);
        getLoaisp().setGioitinh(gioitinh);
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
        thunquan = IsHave;
    }
    @Override public String toString(){
        System.out.println("Ma sp: " + getMasp());
        getLoaisp().PrintData();
        System.out.println("So luong ton kho: " + getSltonkho());
        System.out.println("Don gia: " + getDongia());
        System.out.println("Size: " + getSize());
        System.out.println("Chat lieu: " + getChatlieu());
        System.out.println("Thun quan: " + getThunquan());
        return "";
    }
    public void nhap() {
        Scanner input =new Scanner(System.in);
        super.nhap();
        System.out.print("Có thun quần không: ");
        thunquan=input.nextBoolean();
    }
}
