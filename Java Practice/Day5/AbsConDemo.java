abstract class Employ {
    int empno;
    String name;
    double basic;

    public Employ(int empno,String name, double basic){
        this.empno=empno;
        this.name=name;
        this.basic =basic;
    }
 
    @Override 
    public final String toString(){
        return "Empno " +empno+ " Name " +name+ " Basic "+basic;
    }
}

class Sahil extends Employ {
    public Sahil(int empno,String name, double basic) {
        super(empno,name,basic);
    }
}

class Akash extends Employ {
    public Akash(int empno,String name, double basic) {
        super(empno,name,basic);
    }
}
public class AbsConDemo {
    public static void main(String[] args) {
        Employ [] arr = new Employ[]{
            new Sahil(1,"sahil",56223),
            new Akash(2,"Akash",5562)
        };

        for(Employ e : arr){
            System.out.println(e);
        }
    }


}