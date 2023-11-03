package ProductContainer;
import java.util.Scanner;
import java.util.*;
public class DSSP {
    private Product[] ds;
    private int n;
    public void nhap() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so luong san pham: ");
        this.n = input.nextInt();
        this.ds = new Product[this.n];
        for(int i = 0; i < this.n; ++i) {
            System.out.println("San pham thu " + (i + 1));
            System.out.print("Day la quan(0) hay ao(1)?: ");
            int opt = input.nextInt();
            if (opt == 0) {
                this.ds[i] = new Pant();
            } else {
                this.ds[i] = new Shirt();
            }
            this.ds[i].nhap();
        }
    }
    public String toString() {
        for(int i = 0; i < this.n; ++i) {
            System.out.println("\nSan pham thu " + (i + 1) + ":");
            System.out.println(ds[i]);
        }
        return "";
    }
    public DSSP() {
    }
    public DSSP(Product[] ds, int n) {
        this.n = n;
        this.ds = Arrays.copyOf(ds, n);
    }
    public DSSP(DSSP a) {
        this.n = a.n;
        this.ds = Arrays.copyOf(a.ds,a.n);
    }
    public void them() {
        ds=Arrays.copyOf(ds, n+1);
        Scanner input = new Scanner(System.in);
        int opt = input.nextInt();
        if(opt==0) 	{ds[n]=new Pant();}
        else 		{ds[n]=new Shirt();}
        ds[n].nhap();
        ++n;
    }
    public void them(Pant a) {
        ds=Arrays.copyOf(ds, n+1);
        ds[n]=new Pant(a);
        ++n;
    }
    public void them(Shirt a) {
        ds=Arrays.copyOf(ds, n+1);
        ds[n]=new Shirt(a);
        ++n;
    }
    public void them(int k) {
        ds=Arrays.copyOf(ds, n+k);
        int i=0;
        while(i<k) {
            Scanner input = new Scanner(System.in);
            System.out.print("Day la quan hay ao?: ");
            int opt = input.nextInt();
            if(opt==0) 	{ds[n]=new Pant();}
            else 		{ds[n]=new Shirt();}
            ds[n].nhap();
            ++i;
            ++n;
        }
    }
    public void xoaMa(String masp) {
        for(int i=0;i<n;++i) {
            if(ds[i].getMasp().equals(masp)) {
                for(int j=i;j<n-1;j++) {ds[j]=ds[j+1];}
                i--;
                n--;
                ds=Arrays.copyOf(ds,n);
            }}
    }
    public String Xoa_khoang_trang_thua(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return s;
    }
    public void xoaTen(String tensp) {
        for(int i=0;i<n;++i) {
            if(ds[i].getMasp().contains(Xoa_khoang_trang_thua(tensp))) {
                for(int j=i;j<n-1;j++) {ds[j]=ds[j+1];}
                i--;
                n--;
                ds=Arrays.copyOf(ds,n);
            }}
    }
}
