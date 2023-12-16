package CartContainer;

import Bill.ChiTietHoaDon;
import Bill.DSHD;
import Bill.HoaDon;
import InputManage.Input;
import Menu.CustomerMenu;
import Users.Customer;
import Users.Customerlist;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class CartManagement {
    private Customer currentUser;
    private Cart userCart;
    private DSHD billList;
    private Customerlist customerlist;

    public CartManagement(){}

    public CartManagement(@NotNull Customer currentUser, Cart userCart, Customerlist customerlist, DSHD billList){
        this.currentUser = currentUser;
        this.userCart = userCart;
        this.customerlist = customerlist;
        this.billList = billList;
    }


    public @NotNull Boolean checkEmptyCart(){
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

    public void handleAddToCart(){
        String masp;
        int amount;

        boolean isSuccess = false;
        System.out.println("Nhap 0 de thoat");

        do{
            System.out.println("Nhap san pham ban muon them vao gio hang (masp): ");
            masp = Input.getString();

            if (masp.equals("0")){
                CustomerMenu.isExit = true;
                return;
            }

            System.out.println("Nhap so luong: ");
            amount = Input.getInt();

            if (amount == 0){
                CustomerMenu.isExit = true;
                return;
            }

            isSuccess = userCart.addToCart(masp, amount);

        } while (!isSuccess);

        if (CustomerMenu.isExit) return;

        System.out.println("Them thanh cong");
    }

    public void handleDeleteCartProduct(){
        if (checkEmptyCart()) return;

        System.out.println(userCart);

        System.out.println("Nhap 0 de thoat");
        System.out.println("Nhap stt cua mon hang ma ban muon xoa khoi gio hang: ");
        String stt;

        boolean isSuccess = false;

        do{
            stt = Input.getString();

            if (stt.equals("0")){
                CustomerMenu.isExit = true;
                return;
            }

            isSuccess = userCart.deleteCartProduct(stt);

        } while (!isSuccess);

        if (CustomerMenu.isExit) return;

        System.out.println("Xoa thanh cong");
    }

    public void handleAdjustCart(){
        if (checkEmptyCart()) return;

        System.out.println(userCart);
        System.out.println("Nhap stt cua mon hang ma ban muon chinh sua: ");
        String stt;

        boolean isSucess = false;

        do {
            stt = Input.getString();

            if (stt.equals("0")){
                CustomerMenu.isExit = true;
                return;
            }

            isSucess = currentUser.getCart().adjustCart(stt);

        } while (!isSucess);

        if (CustomerMenu.isExit) return;

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
        customerlist.setCustomer(currentUser);
    }

    public void handleBuyHistory(){
        var historyBill = billList.timkiemMakh_DSHD(currentUser.getMakh());
        System.out.println(historyBill);
    }
}
