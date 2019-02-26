import java.util.Scanner;
public class PosNeg {

    public void check(int a){
     if(a==0){
         System.out.println("Zero is neutral");
     }   

     else if(a>0){
            System.out.println("Number is positive");
        }
        else {
            System.out.println("number is negative");
        }
    }

public static void main(String[] args){
    int n;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number");
    n =sc.nextInt();
    PosNeg p = new PosNeg();
    p.check(n);
}

}