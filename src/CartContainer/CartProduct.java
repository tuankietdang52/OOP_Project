package CartContainer;

import InputManage.Input;
import Menu.CustomerMenu;
import ProductContainer.Product;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class CartProduct implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Product product;
    private int amount;
    private double thanhtien;
    private int stt;

    public CartProduct(Product product, int amount){
        this.product = product;
        this.amount = amount;
        calPrice();
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        calPrice();
    }

    public double getThanhtien() {
        return thanhtien;
    }

    private void calPrice(){
        thanhtien = product.getDongia() * amount;
    }

    public Boolean adjustAmount(){
        System.out.println("Nhap 0 de thoat");
        System.out.println("Ban muon them hay giam so luong cua san pham " + product.getTensp() + ": ");
        String choice;

        boolean isValid;

        do{
            choice = Input.getString().toLowerCase();
            switch (choice){
                case "them":
                    isValid = true;
                    if (!themSoluong()){
                        System.out.println("Ban muon them hay giam so luong cua san pham " + product.getTensp() + ": ");
                        isValid = false;
                    }
                    break;

                case "giam":
                    isValid = true;
                    if (!giamSoluong()){
                        System.out.println("Ban muon them hay giam so luong cua san pham " + product.getTensp() + ": ");
                        isValid = false;
                    }
                    break;

                case "0":
                    return false;

                default:
                    isValid = false;
                    System.out.println("Chi duoc nhap 'them' hoac 'giam', Nhap lai: ");
                    break;
            }
        } while (!isValid);

        calPrice();
        return true;
    }

    private @NotNull Boolean themSoluong(){
        boolean isSucess = true;

        do{
            System.out.println("Ban muon them bao nhieu: ");
            int plusAmount = Input.getInt();

            if (plusAmount == 0) return false;

            amount += plusAmount;
            isSucess = true;

            if (product.getSltonkho() < amount){
                System.out.println("Khong the them du so luong do da het hang, Nhap lai: ");
                amount -= plusAmount;
                isSucess = false;
            }
        } while (!isSucess);

        return true;
    }

    private @NotNull Boolean giamSoluong(){
        boolean isSucess = true;
        do{
            System.out.println("Ban muon giam bao nhieu: ");
            int minusAmount = Input.getInt();

            if (minusAmount == 0) return false;

            amount -= minusAmount;
            isSucess = true;

            if (amount < 0){
                System.out.println("Khong du so luong san pham de giam");
                amount += minusAmount;
                isSucess = false;
            }
        } while (!isSucess);

        return true;
    }

    @Override
    public String toString() {
        System.out.println("STT: " + stt);
        System.out.println("Ten sp: " + product.getTensp());
        System.out.println("Ma sp: " + product.getMasp());
        System.out.println("Don gia: " + product.getDongia());
        System.out.println("So luong mua: " + (int)amount);
        System.out.println("Thanh tien: " + (int)thanhtien);
        return "";
    }
}
