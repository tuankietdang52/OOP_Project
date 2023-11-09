package Users;

import InputManage.Input;
import org.jetbrains.annotations.NotNull;

public class Customer {
    private String makh;
    private String tenkh;
    private String diachi;
    private String sdt;
    private String email;

    public Customer(){
        makh = "";
        tenkh = "";
        diachi = "";
        sdt = "";
        email = "";
    }

    public Customer(String makh, String tenkh, String diachi, String sdt, String email){
        this.makh = makh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public Customer(@NotNull Customer customer){
        makh = customer.makh;
        tenkh = customer.tenkh;
        diachi = customer.diachi;
        sdt = customer.sdt;
        email = customer.email;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMakh() {
        return makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public void TrimName(){
        tenkh = tenkh.trim();
        tenkh = tenkh.replaceAll("\\s+", " ");
    }
    public void setByInput(){
        System.out.print("Nhap ma khach hang: ");
        makh = Input.getString();
        System.out.print("Nhap ten khach hang: ");
        tenkh = Input.getString();
        System.out.print("Nhap Dia chi: ");
        diachi = Input.getString();
        System.out.print("Nhap sdt: ");
        sdt = Input.getString();
        System.out.print("Email: ");
        email = Input.getString();
    }

    @Override public String toString(){
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ten khach hang: " + tenkh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("SDT: " + sdt);
        System.out.println("Email: " + email);
        return "";
    }
}