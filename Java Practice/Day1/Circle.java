import java.util.Scanner;
public class Circle{

    public void area(double ar){
       double area = 3.14 * ar *ar; 
       System.out.println("area of circle is " +area);
    }

    public static void main(String[] args){
        double r;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius");
        r=sc.nextDouble();
        Circle c = new Circle();
        c.area(r);

    }

}