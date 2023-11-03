package ProductContainer;

import java.util.Scanner;

public class Shirt extends Product {

    private boolean mutrumdau;
    private String hoatiet;

    public Shirt(){
        mutrumdau = false;
        hoatiet = "";
    }

    public Shirt(String masp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean mutrumdau, String hoatiet){
        super(masp, loaisp, sltonkho, dongia, chatlieu, size);
        this.mutrumdau = mutrumdau;
        this.hoatiet = hoatiet;
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
    public boolean getMutrumdau(){
        return mutrumdau;
    }
    public String getHoatiet(){
        return hoatiet;
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
    public void setMutrumdau(boolean IsHave){
        mutrumdau = IsHave;
    }
    public void setHoatiet(String hoatiet){
        this.hoatiet = hoatiet;
    }
     @Override public String toString(){
         System.out.println("Ma sp: " + getMasp());
         getLoaisp().PrintData();
         System.out.println("So luong ton kho: " + getSltonkho());
         System.out.println("Don gia: " + getDongia());
         System.out.println("Size: " + getSize());
         System.out.println("Chat lieu: " + getChatlieu());
         System.out.println("Mu trum dau: " + getMutrumdau());
         System.out.println("Hoa tiet: " + getHoatiet());
         return "";
     }
    public void nhap() {
        Scanner input =new Scanner(System.in);
        super.nhap();
        System.out.print("Có mũ trùm đầu không: ");
        mutrumdau=input.nextBoolean();
        System.out.print("Họa tiết: ");
        hoatiet=input.nextLine();
    }
}
