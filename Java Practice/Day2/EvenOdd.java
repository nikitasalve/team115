import java.util.Scanner;
public class EvenOdd {
    public void check(int n){
        if(n%2==0){
            System.out.println("Even number...");
        } else {
            System.out.println("odd number...");
    
        }
    }

 public static void main(String[] args){
     int n;
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a number");
     n = sc.nextInt();
     EvenOdd a = new EvenOdd();
     a.check(n);
 }

}