package Menu;
import InputManage.Input;
import Users.AccountManagement;
import Users.Customerlist;
import org.jetbrains.annotations.NotNull;

public class CustomerMenu {
    Customerlist dskh = new Customerlist(true);
    public CustomerMenu(){};
    public CustomerMenu(Customerlist dskh){
        this.dskh = dskh;
    };
    public CustomerMenu(@NotNull CustomerMenu a){
        dskh = a.dskh;
    };
    public void showMenu(){
        int opt;
        do {
            System.out.println("--------Chao mung " + AccountManagement.currentUser.getTenkh() + "--------");
            System.out.println("----------Customer Menu---------");
            System.out.println("1. Xem gio hang:");
            System.out.println("2. Ds san pham trong shop:");
            System.out.println("3. Them san pham vao gio hang:");
            System.out.println("4. Xoa san pham khoi gio hang:");
            System.out.println("5. Chinh sua gio hang:");
            System.out.println("6. Xem thong tin ca nhan:");
            System.out.println("7. Chinh sua thong tin ca nhan:");
            System.out.println("8. Mua san pham trong gio hang:");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            switch(opt) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    AccountManagement.currentUser.toString();
                    break;
                case 7:
                    dskh.sua(AccountManagement.currentUser.getMakh());
                    break;
                case 8:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        }while (opt != 0);

    }
}
