package ProductContainer;

import InputManage.Input;
import org.jetbrains.annotations.NotNull;

public class Shirt extends Product {

    private boolean mutrumdau;
    private String hoatiet;

    public Shirt(){
        mutrumdau = false;
        hoatiet = "";
    }

    public Shirt(String masp, String tensp, String gioitinh, int sltonkho, double dongia, String chatlieu, String size, boolean mutrumdau, String hoatiet){
        super(masp, tensp, gioitinh, sltonkho, dongia, chatlieu, size);
        this.mutrumdau = mutrumdau;
        this.hoatiet = hoatiet;
    }

    public Shirt(@NotNull Shirt shirt){
        super(shirt.getMasp(), shirt.getTensp(), shirt.getGioitinh(), shirt.getSltonkho(), shirt.getDongia(), shirt.getChatlieu(), shirt.getSize());
        mutrumdau = shirt.mutrumdau;
        hoatiet = shirt.hoatiet;
    }

    public void setMutrumdau(boolean IsHave){
        mutrumdau = IsHave;
    }

    public void setHoatiet(String hoatiet){
        this.hoatiet = hoatiet;
    }

    public boolean getMutrumdau(){
        return mutrumdau;
    }

    public String getHoatiet(){
        return hoatiet;
    }

    @Override
    public void setByInput() {
        super.setByInput();
        System.out.print("Mu trum dau: ");
        mutrumdau = Input.getBoolean();
        System.out.print("Hoa tiet: ");
        hoatiet = Input.getString();
    }

    @Override public String toString(){
        PrintBasicElement();
        System.out.println("Mu trum dau: " + getMutrumdau());
        System.out.println("Hoa tiet: " + getHoatiet());
        return "";
    }
}