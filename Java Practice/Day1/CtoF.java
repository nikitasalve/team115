import java.util.Scanner;
public class CtoF{
    //business logic should never write in main method
    public void calc(double c){
        double f;
        f=((9*c)/5)+32;
        System.out.println("Fahrenhiet value is " +f);
    }

    public static void main(String[] args){
        double c;
        System.out.println("Enter Centigrate value");
        Scanner sc = new Scanner(System.in);
        c=sc.nextDouble();
        CtoF obj =new CtoF();
        obj.calc(c);
    }
    
}