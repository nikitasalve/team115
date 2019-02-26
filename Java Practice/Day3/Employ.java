import java.util.Objects;
public class Employ {
    int empno;
    String name;
    double basic;


    @Override
    public final int hashCode() {
        return Objects.hash(empno,name, basic);
    }

    @Override
    public final String toString() {
        return "Empno" +empno+ " Name " +name+ " Basic "+basic;
    }

    public static void main(String [] args){
        Employ e1   = new Employ();
        Employ e2   = new Employ();
        
        e1.empno =1; e1.name="omkar"; e1.basic=346.34;
        e2.empno =1; e2.name="omkar"; e2.basic=346.34;
        e2.empno =2; e2.name="omkar2"; e2.basic=3464.34;
         
        System.out.println(e1 + "\n" +e2 + "\n" +e2 );
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
         System.out.println(e2.hashCode());
        
    }
}