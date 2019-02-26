public class Customer {
    int custId;
    String cname;
    double cost;

    @Override 
    public final String toString() {
        return "cust ID" +custId+ " Name " +cname+ " Cost " +cost;
    }

    public void show(Object ob) {
        Customer c1 =(Customer)ob;
        System.out.println(c1);
    }

    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.custId =1;
        c1.cname = "omkar";
        c1.cost =125.150;
        c1.show(c1);
    }

    
}