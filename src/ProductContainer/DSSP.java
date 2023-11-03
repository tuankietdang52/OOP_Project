package ProductContainer;
import java.util.Scanner;
public class DSSP {
    private Product ds[];
    private int n;
    public void nhap(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng sản phẩm: ");
        n=input.nextInt();
        ds=new Product[n];
        for(int i=0;i<n;i++){
            System.out.println("Sản phẩm thứ "+(i+1));
            System.out.print("Đây là quần(0) hay áo(1)?: ");
            int opt=input.nextInt();
            if(opt==0) 	{ds[i]=new Pant();}
            else 		{ds[i]=new Shirt();}
            ds[i].nhap();
        }
    }
    @Override public String toString(){
        for(int i=0;i<n;i++) {
            System.out.println("\nSinh vien thu "+(i+1)+":");
            ds[i].toString();
        }
        return "";
    }
    public DSSP() {}
    public DSSP(Product ds[],int n) {
        this.n=n;
        this.ds=new Product[n];
        for(int i=0;i<n;i++) {
            this.ds[i]=ds[i];
        }
    }
    public DSSP(DSSP a) {
        n=a.n;
        this.ds=new Product[n];
        for(int i=0;i<n;i++) {
            this.ds[i]=a.ds[i];
        }
    }
}