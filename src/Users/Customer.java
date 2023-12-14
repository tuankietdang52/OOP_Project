package Users;

import InputManage.Input;
import Interface.IAccount;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Customer implements Serializable, IAccount {
    private String makh;
    private String tenkh;
    private String diachi;
    private String sdt;
    private String email;
    private String username;
    private String password;

    public Customer(){
        makh = "";
        tenkh = "";
        diachi = "";
        sdt = "";
        email = "";
        username = "";
        password = "";
    }

    public Customer(String makh, String tenkh, String diachi, String sdt, String email, String username, String password){
        this.makh = makh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Customer(@NotNull Customer customer){
        makh = customer.makh;
        tenkh = customer.tenkh;
        diachi = customer.diachi;
        sdt = customer.sdt;
        email = customer.email;
        username = customer.username;
        password = customer.password;
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
    @Override
    public void setUsername(String username){
        this.username = username;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
        System.out.print("Nhap dia chi: ");
        diachi = Input.getString();
        System.out.print("Nhap sdt: ");
        sdt = Input.getString();
        System.out.print("Email: ");
        email = Input.getString();
    }

    public void userInput(){
        System.out.println("-----------Nhap thong tin ca nhan-----------");
        System.out.print("Nhap ten cua ban: ");
        tenkh = Input.getString();
        System.out.print("Nhap dia chi: ");
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