public class Emp{
    int empno;
    String name;
    double basic;

    @Override 
    public final String toString() {
        return "Empno " +empno + " Name " +name+ " salary " +basic;
    }
    public static void main(String[] args) {
        Emp e1 = new Emp();
        e1.empno=1; e1.name ="Bhaskar"; e1.basic =6111;
        Emp e2 = new Emp();
        e2.empno=2; e2.name ="Badar"; e2.basic =6442;
         Emp e3 = new Emp();
        e3.empno=3; e3.name ="padar"; e3.basic =644233;
        Emp arr[] =new Emp[] {e1, e2, e3};

        for(Emp e : arr) {
            // System.out.println(e.empno + " " +e.name + " " +e.basic);
            System.out.println(e);
        }
    }
}


