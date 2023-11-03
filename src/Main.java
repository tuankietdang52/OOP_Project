
import Users.Customer;
import Users.Employee;
import ProductContainer.DSSP;
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setManv("adsa31");
        employee.setTennv("adu lmao");
        employee.setCmnd("231231312");
        employee.setSdt("031031203");
        employee.setEmail("gotdam@gmail.com");
        employee.setUsernames("lmao13123");
        employee.setPassword("dadada");
        employee.setPermission("ad", "admin", "god");

        System.out.println(employee);

        System.out.println();

        System.out.println(employee.getPermission());

        Customer customer = new Customer();
        customer.setMakh("dada");
        customer.setTenkh("allala");
        customer.setDiachi("313 31");
        customer.setEmail("dad@dad.com");
        customer.setSdt("0310310");

        System.out.println(customer);
        DSSP a = new DSSP();
        a.nhap();
        System.out.print(a);
    }
}