import javax.print.DocFlavor.STRING;

public class Emp {
    private int empno;
    private String name;
    private double basic;

    public int getEmpno(){
        return empno;
    }

    public void setEmpno(int empno){
        this.empno=empno;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
 
    public double getBasic(){
        return basic;
    }

    
 
    public void setBasic(double basic){
        this.basic=basic;
    }

    @Override 
    public final String toString(){
        return "Empno " +empno+ " name "+name+ " Basic "+ basic;
    }
    public static void main(String[] args) {
        Emp obj = new Emp();
        obj.setEmpno(12);
        obj.setName("omkar");
        obj.setBasic(458);
        System.out.println(obj);
    }
}