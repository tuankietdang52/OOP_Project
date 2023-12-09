package Menu;

import InputManage.Input;
import ProductContainer.DSSP;
import Users.Customerlist;
import Users.EmployeeList;

public class MainMenu {
    DSSP dssp = new DSSP();
    Customerlist dskh = new Customerlist();
    EmployeeList dsnv = new EmployeeList();
//  dsHoadon        DSHD();
//  dsPhieunhap     DSPN();
    public void showMenu(){
        int opt;
        do {
            System.out.println("------------Main Menu-----------");
            System.out.println("1. Quan ly san pham:");
            System.out.println("2. Quan ly khach hang:");
            System.out.println("3. Quan ly nhan vien:");
            System.out.println("4. Quan ly hoa don:");
            System.out.println("5. Quan ly phieu nhap:");
            System.out.println("6. Thong ke tinh hinh kinh doanh:");
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
            System.out.println("7. Tim ao co mu trum dau hay khong:");
            System.out.println("8. Tim ao theo hoa tiet:");
            System.out.println("9. Tim quan co thun hay khong:");
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
                    dssp.timkiemMutrumdau_DSSP().toString();
                    break;
                case 8:
                    dssp.timkiemHoatiet_DSSP().toString();
                    break;
                case 9:
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
            System.out.println("1. Nhap danh sach:");
            System.out.println("2. Xuat danh sach:");
            System.out.println("3. Them khach hang:");
            System.out.println("4. Sua thong tin khach hang:");
            System.out.println("5. Xoa khach hang:");
            System.out.println("6. Tim kiem khach hang:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dskh.nhap();
                    break;
                case 2:
                    dskh.toString();
                    break;
                case 3:
                    menuThemKh();
                    break;
                case 4:
                    dskh.sua();
                    break;
                case 5:
                    String makh;
                    System.out.println("Makh muon xoa:");
                    makh = Input.getString();
                    dskh.xoa(makh);
                    break;
                case 6:
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
    public void menuThemKh(){
        int opt;
        do{
            System.out.println("-------Quan ly khach hang-------");
            System.out.println("1. Them mot khach hang:");
            System.out.println("2. Them nhieu khach hang:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dskh.them();
                    break;
                case 2:
                    int k;
                    System.out.print("So khach hang muon them: ");
                    k=Input.getInt();
                    dskh.them(k);
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
            System.out.println("1. Nhap danh sach:");
            System.out.println("2. Xuat danh sach:");
            System.out.println("3. Them nhan vien:");
            System.out.println("4. Sua thong tin nhan vien:");
            System.out.println("5. Xoa nhan vien:");
            System.out.println("6. Tim kiem nhan vien:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    dsnv.nhap();
                    break;
                case 2:
                    dsnv.toString();
                    break;
                case 3:
                    menuThemNv();
                    break;
                case 4:
                    dsnv.sua();
                    break;
                case 5:
                    String manv;
                    System.out.println("MAnv muon xoa:");
                    manv = Input.getString();
                    dsnv.xoa(manv);
                    break;
                case 6:
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
            System.out.println("1. Nhap danh sach:");
            System.out.println("2. Xuat danh sach:");
            System.out.println("3. Them hoa don:");
            System.out.println("4. Sua thong tin hoa don:");
            System.out.println("5. Xoa hoa don:");
            System.out.println("6. Tim kiem hoa don:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch (opt){
                case 1:
                    System.out.println("1. Nhap danh sach:");
                    break;
                case 2:
                    System.out.println("2. Xuat danh sach:");
                    break;
                case 3:
                    System.out.println("3. Them hoa don:");
                    break;
                case 4:
                    System.out.println("4. Sua thong tin hoa don:");
                    break;
                case 5:
                    System.out.println("5. Xoa hoa don:");
                    break;
                case 6:
                    System.out.println("6. Tim kiem hoa don:");
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
                    System.out.println("1. Nhap danh sach:");
                    break;
                case 2:
                    System.out.println("2. Xuat danh sach:");
                    break;
                case 3:
                    System.out.println("3. Them phieu nhap:");
                    break;
                case 4:
                    System.out.println("4. Sua thong tin phieu nhap:");
                    break;
                case 5:
                    System.out.println("5. Xoa phieu nhap:");
                    break;
                case 6:
                    System.out.println("6. Tim kiem phieu nhap:");
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
