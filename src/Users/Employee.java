package Users;

import InputManage.Input;
import Interface.IAccount;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.security.Permission;

public class Employee implements Serializable, IAccount {
    private String manv;
    private String tennv;
    private String cmnd;
    private String sdt;
    private String email;
    private String usernames;
    private String password;

    public Employee(){
        manv = "";
        tennv = "";
        cmnd = "";
        sdt = "";
        email = "";
        usernames = "";
        password = "";
    }

    public Employee(String manv, String tennv, String cmnd, String sdt, String usernames, String password, Permission permission){
        this.manv = manv;
        this.tennv = tennv;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.usernames = usernames;
        this.password = password;
    }

    public Employee(@NotNull Employee employee){
        manv = employee.manv;
        tennv = employee.tennv;
        cmnd = employee.cmnd;
        sdt = employee.sdt;
        usernames = employee.usernames;
        password = employee.password;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setUsername(String usernames) {
        this.usernames = usernames;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getManv() {
        return manv;
    }

    public String getTennv() {
        return tennv;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return usernames;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setByInput(){
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ten nhan vien: ");
        tennv = Input.getString();
        TrimName();
        System.out.print("CMND: ");
        cmnd = Input.getString();
        System.out.print("Nhap sdt: ");
        sdt = Input.getString();
        System.out.print("Email: ");
        email = Input.getString();
    }

    public void TrimName(){
        tennv = tennv.trim();
        tennv = tennv.replaceAll("\\s+", " ");
    }

    @Override public String toString() {
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ten nhan vien: " + tennv);
        System.out.println("CMND: " + cmnd);
        System.out.println("SDT: " + sdt);
        System.out.println("Email: " + email);
        return "";
    }
}
