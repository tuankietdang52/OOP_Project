package Users;

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

    @Override public String toString(){
        System.out.println("Ma khach hang: " + makh);
        System.out.println("Ten khach hang: " + tenkh);
        System.out.println("Dia chi: " + diachi);
        System.out.println("SDT: " + sdt);
        System.out.println("Email: " + email);
        return "";
    }
}
