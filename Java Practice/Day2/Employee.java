public class Employee {
    int empno;
    String name;
    double basic;

    @Override 
    public final boolean equals(Object ob) {
        Employee e1 = (Employee) ob; 

        if (e1.basic == basic && e1.name==name) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override 
    public final String toString() {
        return "Empno" +empno + "Name" +name+ "salary" +basic;
    }
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.empno=1; e1.name ="Bhaskar"; e1.basic =6111;
        Employee e2 = new Employee();
        e2.empno=2; e2.name ="Badar"; e2.basic =6442;
         Employee e3 = new Employee();
        e3.empno=3; e3.name ="padar"; e3.basic =644233;  
        Employee arr[] =new Employee[] {e1, e2, e3};

        for(Employee e : arr) {
            // System.out.println(e.empno + " " +e.name + " " +e.basic);
            System.out.println(e);
        }
    }
}

