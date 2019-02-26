class Employ {
    int empno;
    String name;
    double basic;

    public Employ(int empno, String name, double basic) {
        this.empno =empno;
        this.name = name;
        this.basic = basic;
    }

    @Override
    public final String toString(){
        return "Empno " +empno+ " Name " +name+ " Basic "+basic;
    }
}

    class onkar extends Employ {
        public onkar(int empno, String name,double basic) {
            super(empno,name,basic);
        }
    }

public class SupDemo {
    public static void main(String[] args) {
        Employ obj = new onkar(2,"omkar",6562);
        System.out.println(obj);
    }

}