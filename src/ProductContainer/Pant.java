package ProductContainer;

public class Pant extends Product{
    private boolean thunquan;
    public Pant(){
        setDefaultValue();
        thunquan = false;
    }

    // THIS CONSTRUCTOR IS SUCK //
    public Pant(String masp, ProductType loaisp, int sltonkho, double dongia, String chatlieu, String size, boolean thunquan){
        setMasp(masp);
        setLoaisp(loaisp);
        setSltonkho(sltonkho);
        setDongia(dongia);
        setChatlieu(chatlieu);
        setSize(size);
        setThunquan(thunquan);
    }

    @Override
    public void PrintData() {
        System.out.println("Ma sp: " + getMasp());
        getLoaisp().PrintData();
        System.out.println("So luong ton kho: " + getSltonkho());
        System.out.println("Don gia: " + getDongia());
        System.out.println("Size: " + getSize());
        System.out.println("Chat lieu: " + getChatlieu());
        System.out.println("Thun quan: " + getThunquan());
    }

    public void setThunquan(boolean IsHave) {
        thunquan = IsHave;
    }

    public boolean getThunquan(){
        return thunquan;
    }
}
