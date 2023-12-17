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
                    System.out.println(dssp);
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
                    System.out.println(dssp.timkiemTensp_DSSP());
                    break;
                case 3:
                    System.out.println(dssp.timkiemGioitinh_DSSP());
                    break;
                case 4:
                    System.out.println(dssp.timkiemSize_DSSP());
                    break;
                case 5:
                    System.out.println(dssp.timkiemChatlieu_DSSP());
                    break;
                case 6:
                    System.out.println(dssp.timkiemDongia_DSSP());
                    break;
                case 7:
                    System.out.println(dssp.timkiemKhoangDongia_DSSP());
                    break;
                case 8:
                    System.out.println(dssp.timkiemMutrumdau_DSSP());
                    break;
                case 9:
                    System.out.println(dssp.timkiemHoatiet_DSSP());
                    break;
                case 10:
                    System.out.println(dssp.timkiemThunquan_DSSP());
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
                    System.out.println(dskh);
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
                    System.out.println(dskh.timkiemTenkh_CustomerList());
                    break;
                case 3:
                    System.out.println(dskh.timkiemDiachi_CustomerList());
                    break;
                case 4:
                    System.out.println(dskh.timkiemSdt_CustomerList());
                    break;
                case 5:
                    System.out.println(dskh.timkiemEmail_CustomerList());
                    break;
                case 6:
                    dskh.timkiemUsername();
                    break;
                case 7:
                    System.out.println(dskh.timkiemPassword_CustomerList());
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
                    System.out.println(dsnv);
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
                    System.out.println(dsnv.timkiemTennv_EmployeeList());
                    break;
                case 3:
                    dsnv.timkiemCMND();
                    break;
                case 4:
                    System.out.println(dsnv.timkiemSdt_EmployeeList());
                    break;
                case 5:
                    System.out.println(dsnv.timkiemEmail_EmployeeList());
                    break;
                case 6:
                    dsnv.timkiemUsername();
                    break;
                case 7:
                    System.out.println(dsnv.timkiemPassword_EmployeeList());
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
            System.out.println("2. Hoa don chua duyet:");
            System.out.println("3. Hoa don da xac nhan:");
            System.out.println("4. Hoa don da huy:");
            System.out.println("5. Duyet hoa don:");
            System.out.println("6. Sua thong tin hoa don:");
            System.out.println("7. Tim kiem hoa don:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    System.out.println(dshd);
                    break;
                case 2:
                    dshd.xuatHDChuaduyet();
                    break;
                case 3:
                    dshd.xuatHDDaXacNhan();
                    break;
                case 4:
                    dshd.xuatHDDaHuy();
                    break;
                case 5:
                    dshd.duyet(currentEmployee.getManv());
                    break;
                case 6:
                    dshd.sua();
                    break;
                case 7:
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
                    System.out.println(dshd.timkiemMakh_DSHD());
                    break;
                case 3:
                    System.out.println(dshd.timkiemManv_DSHD());
                    break;
                case 4:
                    System.out.println(dshd.timkiemTongTien_DSHD());
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
            System.out.println("1. Xuat danh sach:");
            System.out.println("2. Them phieu nhap:");
            System.out.println("3. Sua thong tin phieu nhap:");
            System.out.println("4. Xoa phieu nhap:");
            System.out.println("5. Tim kiem phieu nhap:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    System.out.println(dspn);
                    break;
                case 2:
                    menuThemPN();
                    break;
                case 3:
                    dspn.sua();
                    break;
                case 4:
                    String mapn;
                    System.out.println("Mapn muon xoa: ");
                    mapn = Input.getString();
                    dspn.xoa(mapn);
                    break;
                case 5:
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
                    System.out.println(dspn.timkiemManv_DSPN());
                    break;
                case 3:
                    System.out.println(dspn.timkiemMaNhacc_DSPN());
                    break;
                case 4:
                    System.out.println(dspn.timkiemTongTien_DSPN());
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
