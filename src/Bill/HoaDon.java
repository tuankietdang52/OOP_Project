package Bill;
import CartContainer.Cart;
import InputManage.Input;
import Interface.IList;
import ProductContainer.Product;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class HoaDon implements IList<ChiTietHoaDon>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String mahd;
    private String makh;
    private String manv;
    private double tongtien;
    private LocalDateTime ngaylap;
    private ChiTietHoaDon[] chitiet;
    private String tinhtrang = "Chua duyet";
    public HoaDon(){
        mahd = "";
        makh = "";
        manv = "";
        tongtien = 0;
        ngaylap = null;
    }
    public HoaDon(String makh, String manv, LocalDateTime ngaylap, ChiTietHoaDon[] chitiet){
        createMahd();
        this.makh = makh;
        this.manv = manv;
        this.ngaylap = ngaylap;
        this.chitiet = chitiet;
    }
    public HoaDon(@NotNull HoaDon a){
        mahd = a.mahd;
        makh = a.makh;
        manv = a.manv;
        tongtien = a.tongtien;
        ngaylap = a.ngaylap;
        chitiet = a.chitiet;
        tinhtrang = a.tinhtrang;
    }

    public void createMahd(){
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String code = "";

        Random random = new Random();
        for (int i = 0; i < 7; i++){
            int index = random.nextInt(character.length());
            code += character.charAt(index);
        }

        mahd = code;
    }

    public void setMakh (String makh){
        this.makh = makh;
    }
    public void setManv(String manv){
        this.manv = manv;
    }
    public void setNgaylap (LocalDateTime ngaylap){
        this.ngaylap = ngaylap;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
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

    public LocalDateTime getNgaylap() {
        return ngaylap;
    }
    public ChiTietHoaDon[] getChitiet() {
        return chitiet;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public ChiTietHoaDon findDetailProduct(int stt){
        for (var item : chitiet){
            if (item.getStt() != stt) continue;

            return item;
        }

        System.out.println("Khong tim thay san pham\n");
        return null;
    }

    public void transformCartToBill(@NotNull Cart cart){
        // lay san pham tu gio hang cua nguoi dung them vao hoa don
        var cartProducts = cart.getCartProducts();

        for (var item : cartProducts){
            ChiTietHoaDon detail = new ChiTietHoaDon(mahd, item.getProduct().getMasp(), item.getProduct(), item.getAmount());
            them(detail);
        }
    }

    public void setByInput(){
        System.out.print("Nhap ma hoa don: ");
        mahd = Input.getString();
        System.out.print("Nhap ma khach hang: ");
        makh = Input.getString();
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ngay lap: ");
        ngaylap = Input.getDateTime();
        System.out.println("Nhap chi tiet hoa don: ");
        them();
    }

    private int convertToInt(String interger){
        try{
            return Integer.parseInt(interger);
        }
        catch (Exception ex){
            System.out.println("Tham so truyen vao kh phai la so\nError: " + ex);
            return -1;
        }
    }

    private void setBillDetail(){
        tongtien = 0;

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

        setBillDetail();
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
    public void sua(String Stt) {
        int index = convertToInt(Stt);

        if (index == -1) return;

        var product = findDetailProduct(index);
        // khong tim thay sp
        if (product == null) return;

        product.sua();
    }

    @Override
    public void xoa(String Stt) {
        int index = convertToInt(Stt) - 1;

        if (index == -1) return;

        var temparray = new ChiTietHoaDon[chitiet.length - 1];
        var remainLength = chitiet.length - index - 1;

        System.arraycopy(chitiet, 0, temparray, 0, index);
        System.arraycopy(chitiet, index + 1, temparray, index, remainLength);

        chitiet = temparray;
        setBillDetail();
    }

    public void printDetailBill(){
        for (var item : chitiet){
            System.out.println(item);
            System.out.println("-------------------");
        }
    }

    public void printDateTime(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date = ngaylap.format(dateFormat);

        System.out.println("Ngay lap hoa don: " + date);
    }

    @Override public String toString(){
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ma nhan vien: " + manv);
        printDateTime();
        System.out.println("==========================");
        printDetailBill();
        System.out.println("==========================");
        System.out.println("Tong tien hoa don: " + tongtien);
        System.out.println("Tinh trang: " + tinhtrang);
        System.out.println("==========================");
        return "";
    }
}