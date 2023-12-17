package Menu;
import Bill.ChiTietHoaDon;
import Bill.DSHD;
import Bill.HoaDon;
import CartContainer.Cart;
import CartContainer.CartManagement;
import InputManage.Input;
import ProductContainer.DSSP;
import Users.AccountManagement;
import Users.Customer;
import Users.Customerlist;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerMenu {
    public static boolean isExit = false;
    private Customerlist dskh;
    private DSHD billList;
    private Customer currentUser;

    public CustomerMenu(){};

    public CustomerMenu(Customer currentUser){
        this.currentUser = currentUser;
    }

    public CustomerMenu(Customerlist dskh){
        this.dskh = dskh;
    };
    public CustomerMenu(@NotNull CustomerMenu a){
        dskh = a.dskh;
    };

    public void showMenu(){
        int opt;

        if (currentUser == null){
            System.out.println("Chua dang nhap\n");
            return;
        }

        if (currentUser.getCart() == null){
            Cart cart = new Cart();
            currentUser.setCart(cart);
        }

        var userCart = currentUser.getCart();

        do {
            isExit = false;
            System.out.println("--------Chao mung " + currentUser.getTenkh() + "--------");
            System.out.println("----------Customer Menu---------");
            System.out.println("1. Xem gio hang:");
            System.out.println("2. Ds san pham trong shop:");
            System.out.println("3. Them san pham vao gio hang:");
            System.out.println("4. Xoa san pham khoi gio hang:");
            System.out.println("5. Chinh sua gio hang:");
            System.out.println("6. Xem thong tin ca nhan:");
            System.out.println("7. Chinh sua thong tin ca nhan:");
            System.out.println("8. Mua san pham trong gio hang:");
            System.out.println("9. Xem lich su mua hang: ");
            System.out.println("0. Exit.");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            opt = Input.getInt();
            System.out.println("=================================");

            DSSP ds = new DSSP(true);
            dskh = new Customerlist(true);
            billList = new DSHD(true);

            CartManagement cartManagement = new CartManagement(currentUser, userCart, dskh, billList);

            switch(opt) {
                case 1:
                    cartManagement.handlePrintCart();
                    break;
                case 2:
                    System.out.println(ds);
                    break;
                case 3:
                    System.out.println(ds);
                    cartManagement.handleAddToCart();
                    break;
                case 4:
                    cartManagement.handleDeleteCartProduct();
                    break;
                case 5:
                    cartManagement.handleAdjustCart();
                    break;
                case 6:
                    System.out.println(currentUser);
                    break;
                case 7:
                    dskh.sua(currentUser.getMakh());
                    break;
                case 8:
                    cartManagement.handleBuy();
                    break;
                case 9:
                    cartManagement.handleBuyHistory();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

            if (opt != 0 && !isExit){
                System.out.println("Nhan enter de tiep tuc");
                Input.getEnterKey();
            }

            currentUser.setCart(userCart);
            dskh.setCustomer(currentUser);

        }while (opt != 0);
    }


}
