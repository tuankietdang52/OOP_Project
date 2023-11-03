package ProductContainer;

import org.jetbrains.annotations.NotNull;

public class Pant extends Product{
    private boolean thunquan;
    public Pant(){
        thunquan = false;
    }

    public Pant(String masp, String tensp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean thunquan){
        super(masp, tensp, loaisp, sltonkho, dongia, chatlieu, size);
        this.thunquan = thunquan;
    }
    public Pant(@NotNull Pant pant){
        super(pant.getMasp(), pant.getTensp(), pant.getLoaisp(), pant.getSltonkho(), pant.getDongia(), pant.getChatlieu(), pant.getSize());
        thunquan = pant.thunquan;
    }
    public void setThunquan(boolean IsHave) {
        thunquan = IsHave;
    }

    public boolean getThunquan(){
        return thunquan;
    }

    @Override public String toString(){
        System.out.println("Ma sp: " + getMasp());
        System.out.println("Ten sp: " + getTensp());
        getLoaisp().PrintData();
        System.out.println("So luong ton kho: " + getSltonkho());
        System.out.println("Don gia: " + getDongia());
        System.out.println("Size: " + getSize());
        System.out.println("Chat lieu: " + getChatlieu());
        System.out.println("Thun quan: " + getThunquan());
        return "";
    }
}
