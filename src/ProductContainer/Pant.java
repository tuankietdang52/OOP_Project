package ProductContainer;

import InputManage.Input;
import Interface.IList;
import org.jetbrains.annotations.NotNull;

public class Pant extends Product {
    private boolean thunquan;
    public Pant(){
        thunquan = false;
    }

    public Pant(String masp, String tensp, ESex gioitinh, int sltonkho, double dongia, String chatlieu, ESize size, boolean thunquan){
        super(masp, tensp, gioitinh, sltonkho, dongia, chatlieu, size);
        this.thunquan = thunquan;
    }
    public Pant(@NotNull Pant pant){
        super(pant.getMasp(), pant.getTensp(), pant.getGioitinh(), pant.getSltonkho(), pant.getDongia(), pant.getChatlieu(), pant.getSize());
        thunquan = pant.thunquan;
    }
    public void setThunquan(boolean IsHave) {
        thunquan = IsHave;
    }

    public boolean getThunquan(){
        return thunquan;
    }

    @Override public void setByInput(){
        super.setByInput();
        System.out.print("Thun quan (true/false): ");
        thunquan = Input.getBoolean();
    }

    @Override public String toString(){
        PrintBasicElement();
        System.out.println("Thun quan: " + getThunquan());
        return "";
    }
}
