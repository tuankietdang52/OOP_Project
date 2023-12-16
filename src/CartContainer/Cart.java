package CartContainer;

import Bill.ChiTietHoaDon;
import Interface.IList;
import Menu.CustomerMenu;
import ProductContainer.DSSP;
import ProductContainer.Product;
import Users.Employee;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Cart implements Serializable,IList<CartProduct> {
    @Serial
    private static final long serialVersionUID = 1L;
    private CartProduct[] cartProducts;
    private double tongtien;

    public Cart(){
        cartProducts = new CartProduct[0];
    }

    public Cart(CartProduct[] cartProduct){
        this.cartProducts = cartProduct;
    }

    public void setCartProducts(CartProduct[] cartProducts) {
        this.cartProducts = cartProducts;
    }

    public CartProduct[] getCartProducts() {
        return cartProducts;
    }

    public double getTongtien() {
        return tongtien;
    }

    private int convertToInt(String interger){
        try{
            return Integer.parseInt(interger);
        }
        catch (Exception ex){
            System.out.println("Tham so truyen vao kh phai la so\nError: " + ex);
            return -1;
        }
    }

    private void setCart(){
        tongtien = 0;

        for (int i = 0; i < cartProducts.length; i++){
            cartProducts[i].setStt(i + 1);
            tongtien += cartProducts[i].getThanhtien();
        }
    }

    private @Nullable CartProduct findProductinCart(int stt){
        for (int i = 0; i < cartProducts.length; i++){
            if (stt != cartProducts[i].getStt()) continue;

            return cartProducts[i];
        }

        return null;
    }

    @Override
    public CartProduct @NotNull [] increaseLength(){
        var temparray = new CartProduct[cartProducts.length + 1];
        System.arraycopy(cartProducts, 0, temparray, 0, cartProducts.length);
        return temparray;
    }

    public Boolean checkHavingProduct(CartProduct product){
        for (var item : cartProducts) {
            if (!Objects.equals(product.getProduct().getMasp(), item.getProduct().getMasp())) continue;

            // them so luong vao san pham da co san trong gio
            int amount = item.getAmount() + product.getAmount();

            item.setAmount(amount);
            setCart();
            return true;
        }

        return false;
    }

    public Boolean addToCart(String masp, int amount){
        DSSP ds = new DSSP(true);
        var product = ds.timkiemMasp_Product(masp);

        if (product == null){
            System.out.println("Khong tim thay san pham trung voi masp, Vui long nhap lai: ");
            return false;
        }

        if (product.getSltonkho() < amount){
            System.out.println("So luong san pham trong kho khong du voi so luong ban muon mua, Vui long chon mat hang khac hoac nhap so luong nho hon");
            return false;
        }

        CartProduct cartProduct = new CartProduct(product, amount);
        them(cartProduct);

        product.setSltonkho(product.getSltonkho() - amount);
        ds.save();
        return true;
    }

    @Override
    public void them(CartProduct product) {

        if (checkHavingProduct(product)) return;

        cartProducts = increaseLength();
        var index = cartProducts.length - 1;

        cartProducts[index] = product;
        cartProducts[index].setStt(index + 1);

        setCart();
    }

    public Boolean adjustCart(String stt){
        int number = convertToInt(stt);
        if (number > cartProducts.length){
            System.out.println("Stt khong nam trong gio hang cua ban, Vui long nhap lai: ");
            return false;
        }

        sua(stt);
        return true;
    }

    @Override
    public void sua(String stt) {
        int index = convertToInt(stt) - 1;

        if (index == -1) return;

        var isSucess = cartProducts[index].adjustAmount();

        if (!isSucess){
            CustomerMenu.isExit = true;
            return;
        }

        saveProductData(cartProducts[index].getProduct().getMasp(), index);
        setCart();
    }

    public Boolean deleteCartProduct(String stt){
        int number = convertToInt(stt);
        if (number > cartProducts.length){
            System.out.println("Stt khong nam trong gio hang cua ban, Vui long nhap lai: ");
            return false;
        }

        xoa(stt);
        return true;
    }

    private void returnProductRemain(int index){
        var removeProduct = cartProducts[index].getProduct();
        var returnAmount = cartProducts[index].getAmount();
        removeProduct.setSltonkho(removeProduct.getSltonkho() + returnAmount);

        saveProductData(cartProducts[index].getProduct().getMasp(), index);
    }

    @Override
    public void xoa(String stt) {
        int index = convertToInt(stt) - 1;

        if (index == -1) return;

        var temparray = new CartProduct[cartProducts.length - 1];
        var remainLength = cartProducts.length - index - 1;

        returnProductRemain(index);

        System.arraycopy(cartProducts, 0, temparray, 0, index);
        System.arraycopy(cartProducts, index + 1, temparray, index, remainLength);

        cartProducts = temparray;
        setCart();
    }

    public void clear(){
        cartProducts = new CartProduct[0];
    }

    private void saveProductData(String masp, int index){
        DSSP productList = new DSSP(true);

        var productIndex = productList.timkiemMasp(masp);

        productList.getDs()[productIndex] = cartProducts[index].getProduct();

        productList.save();
    }

    @Override
    public String toString() {
        setCart();

        System.out.println("Gio hang cua ban: ");
        for (var item : cartProducts){
            System.out.println(item);
            System.out.println("-------------------");
        }

        System.out.println("=========================");
        System.out.println("Tong tien: " + (int)tongtien);
        return "";
    }
}
