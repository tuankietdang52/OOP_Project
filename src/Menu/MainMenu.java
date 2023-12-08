package Menu;

import InputManage.Input;

public class MainMenu {
    int opt;
    public void showMenu(){
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
                System.out.println("1. Nhap danh sach:");
                break;
            case 2:
                System.out.println("2. Xuat danh sach:");
                break;
            case 3:
                System.out.println("3. Them san pham:");
                break;
            case 4:
                System.out.println("4. Sua thong tin san pham:");
                break;
            case 5:
                System.out.println("5. Xoa san pham:");
                break;
            case 6:
                System.out.println("6. Tim kiem san pham:");
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
                    System.out.println("1. Nhap danh sach:");
                    break;
                case 2:
                    System.out.println("2. Xuat danh sach:");
                    break;
                case 3:
                    System.out.println("3. Them khach hang:");
                    break;
                case 4:
                    System.out.println("4. Sua thong tin khach hang:");
                    break;
                case 5:
                    System.out.println("5. Xoa khach hang:");
                    break;
                case 6:
                    System.out.println("6. Tim kiem khach hang:");
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
                    System.out.println("1. Nhap danh sach:");
                    break;
                case 2:
                    System.out.println("2. Xuat danh sach:");
                    break;
                case 3:
                    System.out.println("3. Them nhan vien:");
                    break;
                case 4:
                    System.out.println("4. Sua thong tin nhan vien:");
                    break;
                case 5:
                    System.out.println("5. Xoa nhan vien:");
                    break;
                case 6:
                    System.out.println("6. Tim kiem nhan vien:");
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
