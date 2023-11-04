package Users;

import InputManage.Input;
import org.jetbrains.annotations.NotNull;

public class Employee {
    private String manv;
    private String tennv;
    private String cmnd;
    private String sdt;
    private String email;
    private String usernames;
    private String password;
    private Permission permission;

    public Employee(){
        manv = "";
        tennv = "";
        cmnd = "";
        sdt = "";
        email = "";
        usernames = "";
        password = "";
        permission = new Permission();
    }

    public Employee(String manv, String tennv, String cmnd, String sdt, String usernames, String password, Permission permission){
        this.manv = manv;
        this.tennv = tennv;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.usernames = usernames;
        this.password = password;
        this.permission = permission;
    }

    public Employee(@NotNull Employee employee){
        manv = employee.manv;
        tennv = employee.tennv;
        cmnd = employee.cmnd;
        sdt = employee.sdt;
        usernames = employee.usernames;
        password = employee.password;
        permission = employee.permission;
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

    public void setUsernames(String usernames) {
        this.usernames = usernames;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setPermission(String maquyen, String tenquyen, String mota){
        permission = new Permission(maquyen, tenquyen, mota);
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

    public String getUsernames() {
        return usernames;
    }

    public String getPassword() {
        return password;
    }

    public Permission getPermission() {return permission;}

    public void setByInput(){
        System.out.print("Nhap ma nhan vien: ");
        manv = Input.getString();
        System.out.print("Nhap ten nhan vien: ");
        tennv = Input.getString();
        System.out.print("CMND: ");
        cmnd = Input.getString();
        System.out.print("Nhap sdt: ");
        sdt = Input.getString();
        System.out.print("Email: ");
        email = Input.getString();
        permission.setByInput();
    }

    @Override public String toString() {
        System.out.println("Ma nhan vien: " + manv);
        System.out.println("Ten nhan vien: " + tennv);
        System.out.println("CMND: " + cmnd);
        System.out.println("SDT: " + sdt);
        System.out.println("Email: " + email);
        System.out.println(permission);
        return "";
    }

    public static class Permission {
        private String maquyen;
        private String tenquyen;
        private String mota;

        public Permission(){
            maquyen = "none";
            tenquyen = "none";
            mota = "";
        }

        public Permission(String maquyen, String tenquyen, String mota){
            this.maquyen = maquyen;
            this.tenquyen = tenquyen;
            this.mota = mota;
        }

        public Permission(@NotNull Permission permission){
            maquyen = permission.maquyen;
            tenquyen = permission.tenquyen;
            mota = permission.mota;
        }

        public void setMaquyen(String maquyen) {
            this.maquyen = maquyen;
        }

        public void setTenquyen(String tenquyen) {
            this.tenquyen = tenquyen;
        }

        public void setMota(String mota) {
            this.mota = mota;
        }

        public String getMaquyen() {
            return maquyen;
        }

        public String getTenquyen() {
            return tenquyen;
        }

        public String getMota() {
            return mota;
        }

        public void setByInput(){
            System.out.print("Nhap ma quyen: ");
            maquyen = Input.getString();
            System.out.print("Nhap ten quyen: ");
            tenquyen = Input.getString();
            System.out.print("Nhap mo ta: ");
            mota = Input.getString();
        }

        @Override public @NotNull String toString() {
            System.out.println("Ma quyen: " + maquyen);
            System.out.println("Ten quyen: " + tenquyen);
            System.out.println("Mo ta: " + mota);
            return "";
        }
    }
}
