package Bill;
import InputManage.Input;
import Interface.IList;
import ProductContainer.Product;
import org.jetbrains.annotations.NotNull;

public class HoaDon implements IList<ChiTietHoaDon> {
    private String mahd;
    private String makh;
    private String manv;
    private double tongtien;
    private String ngaylap;
    private ChiTietHoaDon[] chitiet;
    public HoaDon(){
        mahd = "";
        makh = "";
        manv = "";
        tongtien = 0;
        ngaylap = "";
    }
    public HoaDon(String mahd, String makh, String manv, double tongtien, String ngaylap, ChiTietHoaDon[] chitiet){
        this.mahd = mahd;
        this.makh = makh;
        this.manv = manv;
        this.tongtien = tongtien;
        this.ngaylap = ngaylap;
        this.chitiet = chitiet;
    }
    public HoaDon(HoaDon a){
        mahd = a.mahd;
        makh = a.makh;
        manv = a.manv;
        tongtien = a.tongtien;
        ngaylap = a.ngaylap;
    }
    public void setMahd (String mahd){
        this.mahd = mahd;
    }
    public void setMakh (String makh){
        this.makh = makh;
    }
    public void setManv(String manv){
        this.manv = manv;
    }
    public void setNgaylap (String ngaylap){
        this.ngaylap = ngaylap;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getMahd() {
        return mahd;
    }

    public String getMakh() {
        return makh;
    }

    public String getManv() {
        return manv;
    }

    public double getTongtien() {
        return tongtien;
    }

    public String getNgaylap() {
        return ngaylap;
    }
    public ChiTietHoaDon[] getChitiet() {
        return chitiet;
    }

    public ChiTietHoaDon findDetailProduct(int stt){
        for (var item : chitiet){
            if (item.getStt() != stt) continue;

            return item;
        }

        System.out.println("Khong tim thay san pham\n");
        return null;
    }

    public void setByInput(){
        System.out.print("Nhap ma hoa don: ");
        mahd = Input.getString();
        System.out.print("Nhap ma khach hang: ");
        makh = Input.getString();
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ngay lap: ");
        ngaylap = Input.getString();
        System.out.println("Nhap chi tiet hoa don: ");
        them();
    }

    private void setBillDetail(){
        for (int i = 0; i < chitiet.length; i++){
            chitiet[i].setMahd(this.mahd);
            chitiet[i].setStt(i + 1);
            tongtien += chitiet[i].getThanhtien();
        }
    }

    private @NotNull Boolean isAppend(){
        System.out.println("Tiep tuc them ?\n 1. Co      2. Khong");
        int choice;

        do{
            choice = Input.getInt();
            if (choice != 1 && choice != 2){
                System.out.println("Lua chon 1 hoac 2, Vui long nhap lai:\n");
            }

        }while (choice != 1 && choice != 2);

        return choice == 1;
    }

    public void them(){
        if (chitiet == null) chitiet = new ChiTietHoaDon[0];
        do {
            System.out.println("Nhap chi tiet moi:\n");
            var detail = new ChiTietHoaDon();
            detail.setByInput();

            them(detail);

        }while (isAppend());
    }

    @Override
    public ChiTietHoaDon @NotNull [] increaseLength(){
        var temparray = new ChiTietHoaDon[chitiet.length + 1];
        System.arraycopy(chitiet, 0, temparray, 0, chitiet.length);
        return temparray;
    }

    @Override
    public void them(ChiTietHoaDon detail) {
        chitiet = increaseLength();
        chitiet[chitiet.length - 1] = detail;

        setBillDetail();
    }

    @Override
    public void sua(String strStt) {
        int stt = -1;
        try{
            stt = Integer.parseInt(strStt);
        }
        catch (Exception e){
            System.out.println("Truyen vao tham so co dang la String\nError: " + e);
        }

        var product = findDetailProduct(stt);
        // khong tim thay sp
        if (product == null) return;

        product.sua();
    }

    @Override
    public void xoa(String strStt) {
        int stt = -1;
        try{
            stt = Integer.parseInt(strStt) - 1;
        }
        catch (Exception e){
            System.out.println("Truyen vao tham so co dang la String\nError: " + e);
        }

        var temparray = new ChiTietHoaDon[chitiet.length - 1];
        var remainLength = chitiet.length - stt - 1;

        System.arraycopy(chitiet, 0, temparray, 0, stt);
        System.arraycopy(chitiet, stt + 1, temparray, stt, remainLength);

        chitiet = temparray;
        setBillDetail();
    }

    public void printDetailBill(){
        for (var item : chitiet){
            System.out.println(item);
            System.out.println("-------------------");
        }
    }

    @Override public String toString(){
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ngay lap: " + ngaylap);
        System.out.println("==========================");
        printDetailBill();
        System.out.println("==========================");
        System.out.println("Tong tien hoa don: " + tongtien);
        System.out.println("==========================");
        return "";
    }
}