package EntrySlip;

import InputManage.Input;
import ProductContainer.DSSP;
import ProductContainer.Product;
import org.jetbrains.annotations.NotNull;

import javax.print.attribute.standard.DocumentName;
import java.io.Serial;
import java.io.Serializable;

public class ChiTietPhieuNhap implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int stt;
    private String maphieunhap;
    private String masp;
    private int soluongnhap;
    private double thanhtien;
    private Product sanpham;
    public ChiTietPhieuNhap(){
        maphieunhap = "";
        masp = "";
        soluongnhap = 0;
        thanhtien = 0;
    }
    public ChiTietPhieuNhap(String maphieunhap, String masp, int soluongnhap, Product sanpham){
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluongnhap = soluongnhap;
        this.sanpham =sanpham;
        tinhTien();
    }
    public int getStt() {
        return stt;
    }
    public String getMaphieunhap() {
        return maphieunhap;
    }
    public String getMasp() {
        return masp;
    }
    public int getSoluongnhap() {
        return soluongnhap;
    }
    public double getThanhtien() {
        return thanhtien;
    }
    public Product getSanpham() {
        return sanpham;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public void setSanpham(Product sanpham){this.sanpham = sanpham;}

    public void setByInput(){
        do{
            System.out.print("Nhap ma san pham: ");
            masp = Input.getString();
        }while (!getProduct());

        System.out.print("So luong nhap: ");
        soluongnhap = Input.getInt();

        tinhTien();
    }
    private @NotNull Boolean getProduct(){
        DSSP ds = new DSSP(true);

        this.sanpham = ds.timkiemMasp_Product(this.masp);

        if (this.sanpham == null){
            System.out.println("Khong tim thay san pham, Nhap lai:");
            return false;
        }

        return true;
    }

    private void tinhTien(){
        thanhtien = sanpham.getDongia() * soluongnhap;
    }
    public void sua(){
        System.out.println(this);
        System.out.println("Ban muon sua thong tin nao, Nhap ten thong tin:\n");
        String Detailname = Input.getString().toLowerCase();

        switch (Detailname){
            case "mapnieunhap":
                System.out.println("Khong the sua ma phieu nhap, vui long chon thong tin khac\n");
                sua();
                break;

            case "masp":
                System.out.println("Vui long ma san pham moi: ");
                setMasp(Input.getString());
                getProduct();
                break;

            case "soluongnhap":
                System.out.println("Vui long nhap so luong nhap hang: ");
                setSoluongnhap(Input.getInt());
                tinhTien();
                break;

            default:
                System.out.println("Vui long nhap dung ten thong tin:\n");
                sua();
                break;
        }
    }
    @Override public String toString(){
        System.out.println("STT: " + stt);
        System.out.println("Ma phieu nhap: " + maphieunhap);
        System.out.println("Ma san pham: " + masp);
        System.out.println("Ten san pham: " + sanpham.getTensp());
        System.out.println("So luong nhap: " + soluongnhap);
        System.out.println("Don gia: " + sanpham.getDongia());
        System.out.println("Thanh tien: " + thanhtien);
        return "";
    }
}

