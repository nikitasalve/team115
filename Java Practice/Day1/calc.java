import java.util.Scanner;
public class calc{
 public static void main(String[] args){
     int a,b;
     Scanner sc = new  Scanner(System.in);
     System.out.println("Enter the two numbers");
     a=sc.nextInt();
     b=sc.nextInt();
     int c = a+b;
     System.out.println("sum is " +c);
     
 }
}