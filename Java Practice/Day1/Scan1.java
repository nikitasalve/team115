import java.util.Scanner;
public class Scan1 {
    public static void main(String[] args){
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        name = sc.nextLine();
        System.out.println("Name is "+ name);
    }
    
}