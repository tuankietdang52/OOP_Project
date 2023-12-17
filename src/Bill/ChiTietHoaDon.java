package Bill;

import InputManage.Input;
import ProductContainer.DSSP;
import ProductContainer.Product;
import ProductContainer.Shirt;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class ChiTietHoaDon implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int stt;
    private String mahd;
    private String masp;
    private int soluongmua;
    private double thanhtien;
    private Product sanpham;

    public ChiTietHoaDon() {
        mahd = "";
        masp = "";
        soluongmua = 0;
        thanhtien = 0;
    }

    public ChiTietHoaDon(String mahd, String masp, Product sanpham, int soluongmua) {
        this.mahd = mahd;
        this.masp = masp;
        this.sanpham = sanpham;
        this.soluongmua = soluongmua;
        tinhTien();
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public void setSanpham(Product sanpham) {
        this.sanpham = sanpham;
    }

    public int getStt() {
        return stt;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMasp() {
        return masp;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public Product getSanpham() {
        return sanpham;
    }

    public void setByInput(){
        do{
            System.out.print("Nhap ma san pham: ");
            masp = Input.getString();
        }while (!getProduct());

        System.out.print("So luong mua: ");
        soluongmua = Input.getInt();

        // muon test thi comment getProduct() o tren r bo comment 2 dong duoi
        //sanpham = new Shirt();
        //sanpham.setByInput();

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
        thanhtien = sanpham.getDongia() * soluongmua;
    }

    public void sua(){
        System.out.println(this);
        System.out.println("Ban muon sua thong tin nao, Nhap ten thong tin:\n");
        String Detailname = Input.getString().toLowerCase();

        switch (Detailname){
            case "mahd":
                System.out.println("Khong the sua ma hoa don, vui long chon thong tin khac\n");
                sua();
                break;

            case "masp":
                System.out.println("Vui long ma san pham moi: ");
                setMasp(Input.getString());
                getProduct();
                break;

            case "soluongmua":
                System.out.println("Vui long nhap so luong mua moi: ");
                setSoluongmua(Input.getInt());
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
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ma san pham: " + masp);
        System.out.println("Ten san pham: " + sanpham.getTensp());
        System.out.println("So luong mua: " + soluongmua);
        System.out.println("Don gia: " + sanpham.getDongia());
        System.out.println("Thanh tien: " + thanhtien);
        return "";
    }
}
