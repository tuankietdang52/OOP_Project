package ProductContainer;

public class Shirt extends Product {

    private boolean mutrumdau;
    private String hoatiet;

    public Shirt(){
        setDefaultValue();
        mutrumdau = false;
        hoatiet = "";
    }

    // THIS CONSTRUCTOR IS SUCK //
    public Shirt(String masp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean mutrumdau, String hoatiet){
        setMasp(masp);
        setLoaisp(loaisp);
        setSltonkho(sltonkho);
        setDongia(dongia);
        setChatlieu(chatlieu);
        setSize(size);
        setMutrumdau(mutrumdau);
        setHoatiet(hoatiet);
    }

    @Override
    public void PrintData() {
        System.out.println("Ma sp: " + getMasp());
        getLoaisp().PrintData();
        System.out.println("So luong ton kho: " + getSltonkho());
        System.out.println("Don gia: " + getDongia());
        System.out.println("Size: " + getSize());
        System.out.println("Chat lieu: " + getChatlieu());
        System.out.println("Mu trum dau: " + getMutrumdau());
        System.out.println("Hoa tiet: " + getHoatiet());
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
}
