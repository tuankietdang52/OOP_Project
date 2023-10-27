package ProductContainer;

public class Pant extends Product{
    private boolean thunquan;
    public Pant(){
        thunquan = false;
    }

    public Pant(String masp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean thunquan){
        super(masp, loaisp, sltonkho, dongia, chatlieu, size);
        this.thunquan = thunquan;
    }

    public void setThunquan(boolean IsHave) {
        thunquan = IsHave;
    }

    public boolean getThunquan(){
        return thunquan;
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
}
