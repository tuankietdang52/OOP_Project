import ProductContainer.Shirt;

public class Main {
    public static void main(String[] args) {
        Shirt ao = new Shirt();
        ao.setMasp("m1313");
        ao.setLoaisp("k312321", "ao", "nam");
        ao.setSltonkho(100);
        ao.setSize("M");
        ao.setDongia(100000);
        ao.setChatlieu("Vai cotton 100% :vv");
        ao.setMutrumdau(true);
        ao.setHoatiet("Hoa hong do");

        ao.PrintData();
    }
}