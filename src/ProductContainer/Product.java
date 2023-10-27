package ProductContainer;

public abstract class Product {
    private String masp;
    private ProductType loaisp;
    private int sltonkho;
    private double dongia;
    private String size;
    private String chatlieu;

    public void setDefaultValue(){
        masp = "";
        loaisp = new ProductType();
        sltonkho = 0;
        dongia = 0;
        size = "";
        chatlieu = "";
    }

    public abstract void PrintData();

    public String getMasp() {
        return masp;
    }

    public ProductType getLoaisp(){
        return loaisp;
    }

    public int getSltonkho(){
        return sltonkho;
    }

    public String getSize() {
        return size;
    }

    public double getDongia() {
        return dongia;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setLoaisp(ProductType loaisp) {
        this.loaisp = loaisp;
    }

    public void setLoaisp(String maloaisp, String tenloaisp, String gioitinh){
        loaisp = new ProductType(maloaisp, tenloaisp, gioitinh);
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSltonkho(int sltonkho) {
        this.sltonkho = sltonkho;
    }
}
