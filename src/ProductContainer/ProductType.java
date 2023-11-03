package ProductContainer;
import java.util.Scanner;
public class ProductType {
    private String maloaisp;
    private String tenloaisp;
    private String gioitinh;
    public ProductType() {
        this.maloaisp = "";
        this.tenloaisp = "";
        this.gioitinh = "";
    }
    public ProductType(String maloaisp, String tenloaisp, String gioitinh) {
        this.maloaisp = maloaisp;
        this.tenloaisp = tenloaisp;
        this.gioitinh = gioitinh;
    }
    public void PrintData() {
        System.out.println("Ma loai sp: " + this.maloaisp);
        System.out.println("Ten loai sp: " + this.tenloaisp);
        System.out.println("Danh cho gioi tinh: " + this.gioitinh);
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
        return this.gioitinh;
    }
    public String getMaloaisp() {
        return this.maloaisp;
    }
    public String getTenloaisp() {
        return this.tenloaisp;
    }
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma loai sp: ");
        this.maloaisp = input.nextLine();
        System.out.print("Nhap ten loai sp: ");
        this.tenloaisp = input.nextLine();
        System.out.print("Sp cho gioi tinh: ");
        this.gioitinh = input.nextLine();
    }
}
