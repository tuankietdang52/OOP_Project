package Bill;

import InputManage.Input;
import Interface.IFile;
import Interface.IList;
import ProductContainer.DSSP;
import Users.Customerlist;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class DSHD implements IFile, IList<HoaDon>{
    private HoaDon[] ds;
    private int n;
    public void nhap() {
        System.out.print("Nhap so luong hoa don: ");
        n = Input.getInt();
        ds = new HoaDon[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Hoa don thu " + (i + 1));
            ds[i] = new HoaDon();
            ds[i].setByInput();
        }
        save();
    }
    public String toString() {
        for (int i = 0; i < n; ++i) {
            System.out.println("\nHoa don thu " + (i + 1) + ":");
            System.out.println(ds[i]);
            System.out.println("============================");
        }
        return "";
    }

    public Boolean xuatHDChuaduyet(){
        boolean isHaveBill = false;
        int stt = 1;

        for(int i =0;i<ds.length;i++){
            if(ds[i].getTinhtrang().contains("Chua duyet")) {
                System.out.println("\nHoa don thu " + (stt) + ":");
                System.out.println(ds[i]);
                System.out.println("============================");
                isHaveBill = true;
                stt++;
            }
        }

        return isHaveBill;
    }
    public void xuatHDDaXacNhan(){
        for(int i =0;i<ds.length;i++){
            if(ds[i].getTinhtrang().contains("Da duyet")) {
                System.out.println("\nHoa don thu " + (i + 1) + ":");
                System.out.println(ds[i]);
                System.out.println("============================");
            }
        }
    }
    public void xuatHDDaHuy(){
        for(int i =0;i<ds.length;i++){
            if(ds[i].getTinhtrang().contains("Huy")) {
                System.out.println("\nHoa don thu " + (i + 1) + ":");
                System.out.println(ds[i]);
                System.out.println("============================");
            }
        }
    }
    public DSHD() {
        ds = new HoaDon[0];
    }

    public DSHD(Boolean isGetData){
        if (!isGetData) return;

        try{
            read();
        }
        catch (Exception ex){
            if (ds.length == 0){
                ds = new HoaDon[0];
                return;
            }
            System.out.println("Cant get data from file\nError: " + ex);
        }

    }

    public DSHD(HoaDon[] ds, int n) {
        this.n = n;
        this.ds = ds;
    }

    public DSHD(@NotNull DSHD a) {
        n = a.n;
        ds = a.ds;
    }

    public HoaDon[] getDs() {
        return ds;
    }

    public void setDs(HoaDon[] ds) {
        this.ds = ds;
    }


    public void setElementofDs(int pos, HoaDon hoadon){
        ds[pos] = hoadon;
    }

    public HoaDon @NotNull [] increaseLength(){
        var temparray = new HoaDon[ds.length + 1];
        System.arraycopy(ds, 0, temparray, 0, ds.length);
        return temparray;
    }

    @Override
    public void read() throws Exception {
        ds = new HoaDon[0];
        var i = 0;

        File customerdata = new File("./src/Data/Bill.bin");
        FileInputStream stream = new FileInputStream(customerdata);
        ObjectInputStream read = new ObjectInputStream(stream);
        try{
            while (true){
                var bill = (HoaDon) read.readObject();
                if (bill == null) break;

                if (i >= ds.length) ds = increaseLength();

                ds[i] = bill;
                i++;
            }
        }
        catch (EOFException ex){
            read.close();
        }
        n = ds.length;
    }

    @Override
    public void save() {
        File customerdata = new File("./src/Data/Bill.bin");
        try{
            FileOutputStream stream = new FileOutputStream(customerdata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            for (var item : ds) {
                write.writeObject(item);
            }
            write.close();

            read();
        }
        catch (Exception ex){
            System.out.println("Cant write data from file\nError: " + ex);
        }
    }

    @Override
    public void clear(){
        File customerdata = new File("./src/Data/Bill.bin");
        try{
            FileOutputStream stream = new FileOutputStream(customerdata);
            ObjectOutputStream write = new ObjectOutputStream(stream);
            write.writeChars("");
            write.close();

            read();
        }
        catch (Exception ex){
            System.out.println("Cant write data from file\nError: " + ex);
        }
    }

    public void them() {
        ds = Arrays.copyOf(ds, n + 1);
        ds[n] = new HoaDon();
        ds[n].setByInput();
        ++n;
        save();
    }

      @Override
      public void them(HoaDon hoadon) {
          ds = Arrays.copyOf(ds, n + 1);
          ds[n] = new HoaDon(hoadon);
          ++n;
          save();
      }

    public void them(int k) {
        ds = Arrays.copyOf(ds, n + k);
        int i = 0;
        while (i < k) {
            ds[n] = new HoaDon();
            ds[n].setByInput();
            ++i;
            ++n;
        }
        save();
    }

    @Override
    public void xoa(String mahd) {
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMahd().equals(mahd)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                i--;
                n--;
                ds = Arrays.copyOf(ds, n);
            }
        }
        save();
    }
    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }

    public void timkiemMahd() {
        System.out.println("Ma hoa don can tim: ");
        String mahd = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equals(mahd))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public int timkiemMahd(String mahd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(mahd))
                return i;
        }
        return -1;
    }

    public void timkiemMahd_HoaDon() {
        System.out.println("Ma hoa don can tim: ");
        String mahd = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equals(mahd))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }

    public HoaDon timkiemMahd_HoaDon(String mahd) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMahd().equals(mahd))
                return ds[i];
        }
        return null;
    }
    public void timkiemMakh() {
        System.out.println("Ma khach hang can tim: ");
        String makh = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemMakh(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                return i;
        }
        return -1;
    }
    public void timkiemMakh_HoaDon() {
        System.out.println("Ma khach hang can tim: ");
        String makh = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public HoaDon timkiemMakh_HoaDon(String makh) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh))
                return ds[i];
        }
        return null;
    }
    public DSHD timkiemMakh_DSHD() {
        System.out.print("Ma khach hang can tim: ");
        String makh = Input.getString();
        DSHD a = new DSHD();
        a.ds=new HoaDon[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new HoaDon(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public DSHD timkiemMakh_DSHD(String makh) {
        DSHD a = new DSHD();
        a.ds=new HoaDon[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getMakh().equals(makh)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new HoaDon(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemManv() {
        System.out.println("Ma nhan vien can tim: ");
        String manv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemManv(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                return i;
        }
        return -1;
    }
    public void timkiemManv_HoaDon() {
        System.out.println("Ma nhan vien can tim: ");
        String manv = Input.getString();
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public HoaDon timkiemManv_HoaDon(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv))
                return ds[i];
        }
        return null;
    }
    public DSHD timkiemManv_DSHD() {
        System.out.print("Ma nhan vien can tim: ");
        String manv = Input.getString();
        DSHD a = new DSHD();
        a.ds=new HoaDon[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new HoaDon(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public DSHD timkiemManv_DSHD(String manv) {
        DSHD a = new DSHD();
        a.ds=new HoaDon[a.n];
        for (int i = 0; i < n; i++) {
            if (ds[i].getManv().equals(manv)) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new HoaDon(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public void timkiemTongTien() {
        System.out.println("Tong tien can tim: ");
        double tongtien = Input.getDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    public int timkiemTongTien(double tongtien) {
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                return i;
        }
        return -1;
    }
    public void timkiemTongTien_HoaDon() {
        System.out.println("Tong tien can tim: ");
        double tongtien = Input.getDouble();
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                System.out.print(ds[i] + "\n");
        }
        System.out.println("\n");
    }
    public HoaDon timkiemTongTienh_HoaDon(double tongtien) {
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0)
                return ds[i];
        }
        return null;
    }
    public DSHD timkiemTongTien_DSHD() {
        System.out.print("Tong tien can tim: ");
        double tongtien = Input.getDouble();
        DSHD a = new DSHD();
        a.ds=new HoaDon[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new HoaDon(ds[i]);
                ++a.n;
            }
        }
        return a;
    }
    public DSHD timkiemTongTien_DSHD(double tongtien) {
        DSHD a = new DSHD();
        a.ds=new HoaDon[a.n];
        for (int i = 0; i < n; i++) {
            if (Double.compare(ds[i].getTongtien(),tongtien) == 0) {
                a.ds = Arrays.copyOf(a.ds, a.n + 1);
                a.ds[a.n] = new HoaDon(ds[i]);
                ++a.n;
            }
        }
        return a;
    }

    public void showFindByDay(){
        System.out.println("Nhap ngay thang nam (dd/MM/yyyy): ");
        var date = Input.getDate();

        var sortList = findByDay(date);

        if (sortList == null){
            System.out.println("Khong tim thay hoa don nao");
            return;
        }

        for (var item : sortList.ds){
            System.out.println(item);
        }
    }

    private @NotNull Boolean compareDate(@NotNull LocalDate date1, @NotNull LocalDate date2){
        if (date1.getYear() != date2.getYear()) return false;
        else if (date1.getMonth() != date2.getMonth()) return false;

        return date1.getDayOfMonth() == date2.getDayOfMonth();

    }

    public DSHD findByDay(LocalDate date){
        DSHD sortList = new DSHD();

        for (var item : ds){
            var billDate = item.getNgaylap();

            if (!compareDate(date, billDate.toLocalDate())) continue;

            sortList.ds = sortList.increaseLength();
            sortList.ds[sortList.ds.length - 1] = item;
        }

        if (sortList.ds.length == 0) return null;

        return sortList;
    }


    @Override
    public void sua(String mahd) {
        int flag=0;
        int opt;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMahd().equals(mahd)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            for(int i=0;i<n;i++) {
                if(ds[i].getMahd().equals(mahd)) {
                    do {
                        menuSua();
                        opt=Input.getInt();
                        switch(opt) {
                            case 1:
                                doiMaKhachHang(ds[i]);
                                break;
                            case 2:
                                doiMaNhanVien(ds[i]);
                                break;
                            case 3:
                                doiTongTien(ds[i]);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                    }
                    while(opt!=0);
                }
            }
            save();
        }
        else System.out.println("Ma hoa don khong ton tai!");
    }
    public void sua() {
        System.out.print("Nhap ma hoa don muon sua thong tin: ");
        String mahd = Input.getString();
        int flag = 0;
        int opt;
        for (int i = 0; i < n; ++i) {
            if (ds[i].getMahd().equals(mahd)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                if (ds[i].getMahd().equals(mahd)) {
                    do {
                        menuSua();
                        opt = Input.getInt();
                        switch (opt) {
                            case 1:
                                doiMaKhachHang(ds[i]);
                                break;
                            case 2:
                                doiMaNhanVien(ds[i]);
                                break;
                            case 3:
                                doiTongTien(ds[i]);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le!");
                                break;
                        }
                    }
                    while (opt != 0);
                }
            }
            save();
        } else System.out.println("Ma hoa don khong ton tai!");
    }
    private void menuSua(){
        System.out.println("---------------------------");
        System.out.println("1. Sua ma khach hang:");
        System.out.println("2. Sua ma nhan vien:");
        System.out.println("3. Sua tong tien:");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
    private void doiMaKhachHang(@NotNull HoaDon a){
        System.out.println("Doi ma khach hang thanh:");
        String makh = Input.getString();
        a.setMakh(makh);
    }
    private void doiMaNhanVien(@NotNull HoaDon a){
        System.out.println("Doi ma nhan vien thanh:");
        String manv = Input.getString();
        a.setManv(manv);
    }
    private void doiTongTien(@NotNull HoaDon a){
        System.out.println("Doi tong tien thanh:");
        double tongtien = Input.getDouble();
        a.setTongtien(tongtien);
    }
    public void duyet(String manv){
        System.out.println("------Cac hoa don chua duyet------");
        if (!xuatHDChuaduyet()){
            System.out.println("Tat ca hoa don da duoc duyet");
            return;
        }

        System.out.print("Ma hd muon duyet: ");
        String mahd = Input.getString();
        int flag=0;
        for(int i=0;i<n;++i) 	{
            if (ds[i].getMahd().equals(mahd)) {
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            int opt;
            System.out.println("1.Xac nhan            2.Huy");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    for(int i=0;i<n;i++){
                        if(ds[i].getMahd().equals(mahd) && ds[i].getTinhtrang().equals("Chua duyet")){
                            xacNhan(ds[i],manv);
                            break;
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<n;i++){
                        if(ds[i].getMahd().equals(mahd) && ds[i].getTinhtrang().equals("Chua duyet")){
                            huy(ds[i],manv);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Quay lai");
                    break;
            }
        }
        else{
            System.out.println("Hoa don da duoc duyet hoac khong ton tai!");
        }
    }

    private void setProductFrequency(ChiTietHoaDon detail){
        DSSP productList = new DSSP(true);

        for (var product : productList.getDs()){
            String masp = detail.getMasp();
            if (!Objects.equals(product.getMasp(), masp)) continue;

            int soldAmount = detail.getSoluongmua() + product.getSoldamount();
            product.setSoldamount(soldAmount);
        }

        productList.save();
    }

    private void handleSetProductFrequency(@NotNull HoaDon bill){
        for (var detail : bill.getChitiet()){
            setProductFrequency(detail);
        }
    }


    public void xacNhan(@NotNull HoaDon a, String manv){
        a.setTinhtrang("Xac nhan  ");
        a.setManv(manv);
        Customerlist customerlist = new Customerlist(true);
        customerlist.tangChiTieu(a.getMakh(),a.getTongtien());

        handleSetProductFrequency(a);

        save();
        customerlist.save();
        System.out.println("Da xac nhan!");
    }

    public void returnProductAmount(@NotNull HoaDon bill){
        DSSP productList = new DSSP(true);

        var list = productList.getDs();
        var billdetail = bill.getChitiet();

        for (var product : list){
            for (var detail : billdetail){
                var productBill = detail.getSanpham();
                if (!Objects.equals(product.getMasp(), productBill.getMasp())) continue;

                int buyAmount = detail.getSoluongmua();
                int returnAmount = buyAmount + product.getSltonkho();

                product.setSltonkho(returnAmount);
            }
        }

        productList.save();

    }

    public void huy(@NotNull HoaDon a,String manv){
        a.setTinhtrang("Huy       ");
        a.setManv(manv);

        returnProductAmount(a);

        Customerlist customerlist = new Customerlist(true);

        save();
        customerlist.save();
        System.out.println("Da huy!");
    }
}
