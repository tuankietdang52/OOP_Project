package Menu;

import Bill.DSHD;
import EntrySlip.DSPN;
import InputManage.Input;
import ProductContainer.DSSP;
import Users.Customerlist;
import Users.Employee;
import Users.EmployeeList;
import org.jetbrains.annotations.NotNull;

public class EmployeeMenu {
    DSSP dssp = new DSSP(true);
    Customerlist dskh = new Customerlist(true);
    EmployeeList dsnv = new EmployeeList(true);
    DSHD dshd = new DSHD(true);
    DSPN dspn = new DSPN(true);

    private Employee currentEmployee;

    public EmployeeMenu(){};

    public EmployeeMenu(Employee currentEmployee){
        this.currentEmployee = currentEmployee;
    }

    public EmployeeMenu(DSSP dssp, Customerlist dskh, EmployeeList dsnv, DSHD dshd, DSPN dspn){
        this.dssp = dssp;
        this.dskh = dskh;
        this.dsnv = dsnv;
        this.dshd = dshd;
        this.dspn = dspn;
    };
    public EmployeeMenu(@NotNull EmployeeMenu a){
        dssp = a.dssp;
        dskh = a.dskh;
        dsnv = a.dsnv;
        dshd = a.dshd;
        dspn = a.dspn;
    };
    public void showMenu(){
        int opt;
        do {
            System.out.println("----------Employee Menu---------");
            System.out.println("1. Quan ly san pham:");
            System.out.println("2. Quan ly khach hang:");
            System.out.println("3. Quan ly nhan vien:");
            System.out.println("4. Quan ly hoa don:");
            System.out.println("5. Quan ly phieu nhap:");
            System.out.println("6. Tinh hinh kinh doanh:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch(opt) {
                case 1:
                    menuQLSP();
                    break;
                case 2:
                    menuQLKH();
                    break;
                case 3:
                    menuQLNV();
                    break;
                case 4:
                    menuQLHD();
                    break;
                case 5:
                    menuQLPN();
                    break;
                case 6:
                    menuThongKe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while (opt != 0);
    }
    public void menuQLSP(){
        int opt;
        do{
            System.out.println("--------Quan ly san pham--------");
            System.out.println("1. Nhap danh sach:");
            System.out.println("2. Xuat danh sach:");
            System.out.println("3. Them san pham:");
            System.out.println("4. Sua thong tin san pham:");
            System.out.println("5. Xoa san pham:");
            System.out.println("6. Tim kiem san pham:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dssp.nhap();
                    break;
                case 2:
                    dssp.toString();
                    break;
                case 3:
                    menuThemSp();
                    break;
                case 4:
                    dssp.sua();
                    break;
                case 5:
                    String masp;
                    System.out.print("Masp muon xoa: ");
                    masp = Input.getString();
                    dssp.xoa(masp);
                    break;
                case 6:
                    menuTimkiemSp();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuThemSp(){
        int opt;
        do{
            System.out.println("--------Quan ly san pham--------");
            System.out.println("1. Them mot san pham:");
            System.out.println("2. Them nhieu san pham:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dssp.them();
                    break;
                case 2:
                    int k;
                    System.out.print("So san pham muon them: ");
                    k=Input.getInt();
                    dssp.them(k);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuTimkiemSp(){
        int opt;
        do{
            System.out.println("--------Quan ly san pham--------");
            System.out.println("1. Tim kiem theo masp:");
            System.out.println("2. Tim kiem theo ten sp:");
            System.out.println("3. Tim kiem theo gioi tinh:");
            System.out.println("4. Tim kiem theo size:");
            System.out.println("5. Tim kiem theo chat lieu:");
            System.out.println("6. Tim kiem theo don gia:");
            System.out.println("7. Tim kiem theo khoang don gia:");
            System.out.println("8. Tim ao co mu trum dau hay khong:");
            System.out.println("9. Tim ao theo hoa tiet:");
            System.out.println("10. Tim quan co thun hay khong:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dssp.timkiemMasp_Product();
                    break;
                case 2:
                    dssp.timkiemTensp_DSSP().toString();
                    break;
                case 3:
                    dssp.timkiemGioitinh_DSSP().toString();
                    break;
                case 4:
                    dssp.timkiemSize_DSSP().toString();
                    break;
                case 5:
                    dssp.timkiemChatlieu_DSSP().toString();
                    break;
                case 6:
                    dssp.timkiemDongia_DSSP().toString();
                    break;
                case 7:
                    dssp.timkiemKhoangDongia_DSSP().toString();
                    break;
                case 8:
                    dssp.timkiemMutrumdau_DSSP().toString();
                    break;
                case 9:
                    dssp.timkiemHoatiet_DSSP().toString();
                    break;
                case 10:
                    dssp.timkiemThunquan_DSSP().toString();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuQLKH(){
        int opt;
        do{
            System.out.println("-------Quan ly khach hang-------");
            System.out.println("1. Xuat danh sach:");
            System.out.println("2. Tim kiem khach hang:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dskh.toString();
                    break;
                case 2:
                    menuTimkiemKh();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuTimkiemKh(){
        int opt;
        do{
            System.out.println("-------Quan ly khach hang-------");
            System.out.println("1. Tim kiem theo makh:");
            System.out.println("2. Tim kiem theo ten khach hang:");
            System.out.println("3. Tim kiem theo dia chi:");
            System.out.println("4. Tim kiem theo sdt:");
            System.out.println("5. Tim kiem theo email:");
            System.out.println("6. Tim kiem theo username:");
            System.out.println("7. Tim kiem theo password:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dskh.timkiemMakh();
                    break;
                case 2:
                    dskh.timkiemTenkh_CustomerList().toString();
                    break;
                case 3:
                    dskh.timkiemDiachi_CustomerList().toString();
                    break;
                case 4:
                    dskh.timkiemSdt_CustomerList().toString();
                    break;
                case 5:
                    dskh.timkiemEmail_CustomerList().toString();
                    break;
                case 6:
                    dskh.timkiemUsername();
                    break;
                case 7:
                    dskh.timkiemPassword_CustomerList().toString();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuQLNV(){
        int opt;
        do{
            System.out.println("--------Quan ly nhan vien-------");
            System.out.println("1. Xuat danh sach:");
            System.out.println("2. Them nhan vien:");
            System.out.println("3. Sua thong tin nhan vien:");
            System.out.println("4. Xoa nhan vien:");
            System.out.println("5. Tim kiem nhan vien:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dsnv.toString();
                    break;
                case 2:
                    menuThemNv();
                    break;
                case 3:
                    dsnv.sua();
                    break;
                case 4:
                    String manv;
                    System.out.println("Manv muon xoa:");
                    manv = Input.getString();
                    dsnv.xoa(manv);
                    break;
                case 5:
                    menuTimkiemNv();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuThemNv(){
        int opt;
        do{
            System.out.println("--------Quan ly nhan vien-------");
            System.out.println("1. Them mot nhan vien:");
            System.out.println("2. Them nhieu nhan vien:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dsnv.them();
                    break;
                case 2:
                    int k;
                    System.out.print("So nhan vien muon them: ");
                    k=Input.getInt();
                    dsnv.them(k);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuTimkiemNv(){
        int opt;
        do{
            System.out.println("--------Quan ly nhan vien-------");
            System.out.println("1. Tim kiem theo manv:");
            System.out.println("2. Tim kiem theo ten nhan vien:");
            System.out.println("3. Tim kiem theo CMND:");
            System.out.println("4. Tim kiem theo sdt:");
            System.out.println("5. Tim kiem theo email:");
            System.out.println("6. Tim kiem theo username:");
            System.out.println("7. Tim kiem theo password:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dsnv.timkiemManv();
                    break;
                case 2:
                    dsnv.timkiemTennv_EmployeeList().toString();
                    break;
                case 3:
                    dsnv.timkiemCMND();
                    break;
                case 4:
                    dsnv.timkiemSdt_EmployeeList().toString();
                    break;
                case 5:
                    dsnv.timkiemEmail_EmployeeList().toString();
                    break;
                case 6:
                    dsnv.timkiemUsername();
                    break;
                case 7:
                    dsnv.timkiemPassword_EmployeeList().toString();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuQLHD(){
        int opt;
        do{
            System.out.println("---------Quan ly hoa don--------");
            System.out.println("1. Xuat danh sach:");
            System.out.println("2. Sua thong tin hoa don:");
            System.out.println("3. Tim kiem hoa don:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dshd.xuat();
                    break;
                case 2:
                    dshd.sua();
                    break;
                case 3:
                    menuTimkiemHD();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuThemHD(){
        int opt;
        do{
            System.out.println("---------Quan ly hoa don--------");
            System.out.println("1. Them mot hoa don:");
            System.out.println("2. Them nhieu hoa don:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dshd.them();
                    break;
                case 2:
                    int k;
                    System.out.print("So hoa don muon them: ");
                    k=Input.getInt();
                    dshd.them(k);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuTimkiemHD(){
        int opt;
        do{
            System.out.println("---------Quan ly hoa don--------");
            System.out.println("1. Tim kiem theo mahd:");
            System.out.println("2. Tim kiem theo makh:");
            System.out.println("3. Tim kiem theo manv:");
            System.out.println("4. Tim kiem theo tong tien:");
            System.out.println("5. Tim kiem theo ngay lap:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dshd.timkiemMahd();
                    break;
                case 2:
                    dshd.timkiemMakh_DSHD().xuat();
                    break;
                case 3:
                    dshd.timkiemManv_DSHD().xuat();
                    break;
                case 4:
                    dshd.timkiemTongTien_DSHD().xuat();
                    break;
                case 5:
                    //System.out.println("5. Tim kiem theo ngay lap:");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuQLPN(){
        int opt;
        do{
            System.out.println("--------Quan ly phieu nhap------");
            System.out.println("1. Nhap danh sach:");
            System.out.println("2. Xuat danh sach:");
            System.out.println("3. Them phieu nhap:");
            System.out.println("4. Sua thong tin phieu nhap:");
            System.out.println("5. Xoa phieu nhap:");
            System.out.println("6. Tim kiem phieu nhap:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dspn.nhap();
                    break;
                case 2:
                    dspn.toString();
                    //dspn.xuat();
                    break;
                case 3:
                    menuThemPN();
                    break;
                case 4:
                    dspn.sua();
                    break;
                case 5:
                    String mapn;
                    System.out.println("Mapn muon xoa: ");
                    mapn = Input.getString();
                    dspn.xoa(mapn);
                    break;
                case 6:
                    menuTimkiemPN();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuThemPN(){
        int opt;
        do{
            System.out.println("--------Quan ly phieu nhap------");
            System.out.println("1. Them mot phieu nhap:");
            System.out.println("2. Them nhieu phieu nhap:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dspn.them();
                    break;
                case 2:
                    int k;
                    System.out.print("So phieu nhap muon them: ");
                    k=Input.getInt();
                    dspn.them(k);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuTimkiemPN(){
        int opt;
        do{
            System.out.println("--------Quan ly phieu nhap------");
            System.out.println("1. Tim kiem theo ma phieu nhap:");
            System.out.println("2. Tim kiem theo manv:");
            System.out.println("3. Tim kiem theo ma nha cung cap:");
            System.out.println("4. Tim kiem theo tong tien:");
            System.out.println("5. Tim kiem theo ngay lap:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dspn.timkiemMapn();
                    break;
                case 2:
                    dspn.timkiemManv_DSPN().toString();
                    break;
                case 3:
                    dspn.timkiemMaNhacc_DSPN().toString();
                    break;
                case 4:
                    dspn.timkiemTongTien_DSPN().toString();
                    break;
                case 5:
                    //System.out.println("5. Tim kiem theo ngay lap:");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
    public void menuThongKe(){
        int opt;
        do{
            System.out.println("-------------Thong ke-----------");
            System.out.println("1. Tinh hinh kinh doanh:");
            System.out.println("2. Top 3 khach hang mua nhieu nhat:");
            System.out.println("3. Top 3 san pham ban chay nhat:");
            System.out.println("4. Tong doanh thu:");
            System.out.println("5. Doanh thu hang thang:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    System.out.println("1. Tinh hinh kinh doanh:");
                    break;
                case 2:
                    System.out.println("2. Top 3 khach hang mua nhieu nhat:");
                    break;
                case 3:
                    System.out.println("3. Top 3 san pham ban chay nhat:");
                    break;
                case 4:
                    System.out.println("4. Tong doanh thu:");
                    break;
                case 5:
                    System.out.println("5. Doanh thu hang thang:");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while(opt != 0);
    }
}
