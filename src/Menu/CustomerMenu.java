package Menu;
import Bill.ChiTietHoaDon;
import Bill.DSHD;
import Bill.HoaDon;
import CartContainer.Cart;
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
    private Customerlist dskh = new Customerlist(true);
    private final DSHD billList = new DSHD(true);
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
            switch(opt) {
                case 1:
                    handlePrintCart();
                    break;
                case 2:
                    DSSP ds = new DSSP(true);
                    System.out.println(ds);
                    break;
                case 3:
                    handleAddToCart(userCart);
                    break;
                case 4:
                    handleDeleteCartProduct(userCart);
                    break;
                case 5:
                    handleAdjustCart(userCart);
                    break;
                case 6:
                    System.out.println(currentUser);
                    break;
                case 7:
                    dskh.sua(currentUser.getMakh());
                    break;
                case 8:
                    handleBuy();
                    break;
                case 9:
                    handleBuyHistory();
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

    public Boolean checkEmptyCart(){
        var userCart = currentUser.getCart().getCartProducts();
        if (userCart.length == 0){
            System.out.println("Ban chua mua don hang nao");
            return true;
        }

        return false;
    }

    public void handlePrintCart(){
        if (checkEmptyCart()) return;

        System.out.println(currentUser.getCart());
    }

    public void handleAddToCart(Cart userCart){
        String masp;
        int amount;

        boolean isSuccess = false;
        System.out.println("Nhap 0 de thoat");

        do{
            System.out.println("Nhap san pham ban muon them vao gio hang (masp): ");
            masp = Input.getString();

            if (masp.equals("0")){
                isExit = true;
                return;
            }

            System.out.println("Nhap so luong: ");
            amount = Input.getInt();

            if (amount == 0){
                isExit = true;
                return;
            }

            isSuccess = userCart.addToCart(masp, amount);

        } while (!isSuccess);

        if (isExit) return;

        System.out.println("Them thanh cong");
    }

    public void handleDeleteCartProduct(@NotNull Cart userCart){
        if (checkEmptyCart()) return;

        System.out.println(userCart);

        System.out.println("Nhap 0 de thoat");
        System.out.println("Nhap stt cua mon hang ma ban muon xoa khoi gio hang: ");
        String stt;

        boolean isSuccess = false;

        do{
            stt = Input.getString();

            if (stt.equals("0")){
                isExit = true;
                return;
            }

            isSuccess = userCart.deleteCartProduct(stt);

        } while (!isSuccess);

        if (isExit) return;

        System.out.println("Xoa thanh cong");
    }

    public void handleAdjustCart(@NotNull Cart userCart){
        if (checkEmptyCart()) return;

        System.out.println(userCart);
        System.out.println("Nhap stt cua mon hang ma ban muon chinh sua: ");
        String stt;

        boolean isSucess = false;

        do {
            stt = Input.getString();

            if (stt.equals("0")){
                isExit = true;
                return;
            }

            isSucess = currentUser.getCart().adjustCart(stt);

        } while (!isSucess);

        if (isExit) return;

        System.out.println("Chinh sua thanh cong");
    }

    public void handleBuy(){
        LocalDateTime time = LocalDateTime.now();
        ChiTietHoaDon[] detail = new ChiTietHoaDon[0];

        HoaDon bill = new HoaDon(currentUser.getMakh(), "", time, detail);
        bill.transformCartToBill(currentUser.getCart());

        billList.them(bill);
        billList.save();

        System.out.println("Mua hang thanh cong");

        currentUser.getCart().clear();
        dskh.setCustomer(currentUser);
    }

    public void handleBuyHistory(){
        var historyBill = billList.timkiemMakh_DSHD(currentUser.getMakh());
        historyBill.xuat();
    }
}
