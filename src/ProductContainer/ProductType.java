package ProductContainer;

public class ProductType {
    private String maloaisp;
    private String tenloaisp;
    private String gioitinh;

    public ProductType(){
        maloaisp = "";
        tenloaisp = "";
        gioitinh = "";
    }

    public ProductType(String maloaisp, String tenloaisp, String gioitinh){
        this.maloaisp = maloaisp;
        this.tenloaisp = tenloaisp;
        this.gioitinh = gioitinh;
    }

    public void PrintData(){
        System.out.println("Ma loai sp: " + maloaisp);
        System.out.println("Ten loai sp: " + tenloaisp);
        System.out.println("Danh cho gioi tinh: " + gioitinh);
    }

    public void setMaloaisp(String maloaisp) {
        this.maloaisp = maloaisp;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setTenloaisp(String tenloaisp) {
        this.tenloaisp = tenloaisp;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getMaloaisp() {
        return maloaisp;
    }

    public String getTenloaisp() {
        return tenloaisp;
    }
}