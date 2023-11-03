package ProductContainer;

import org.jetbrains.annotations.NotNull;

public class Shirt extends Product {

    private boolean mutrumdau;
    private String hoatiet;

    public Shirt(){
        mutrumdau = false;
        hoatiet = "";
    }

    public Shirt(String masp, String tensp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean mutrumdau, String hoatiet){
        super(masp, tensp, loaisp, sltonkho, dongia, chatlieu, size);
        this.mutrumdau = mutrumdau;
        this.hoatiet = hoatiet;
    }

    public Shirt(@NotNull Shirt shirt){
        super(shirt.getMasp(), shirt.getTensp(), shirt.getLoaisp(), shirt.getSltonkho(), shirt.getDongia(), shirt.getChatlieu(), shirt.getSize());
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

     @Override public String toString(){
         System.out.println("Ma sp: " + getMasp());
         System.out.println("Ten sp: " + getTensp());
         getLoaisp().PrintData();
         System.out.println("So luong ton kho: " + getSltonkho());
         System.out.println("Don gia: " + getDongia());
         System.out.println("Size: " + getSize());
         System.out.println("Chat lieu: " + getChatlieu());
         System.out.println("Mu trum dau: " + getMutrumdau());
         System.out.println("Hoa tiet: " + getHoatiet());
         return "";
     }
}
