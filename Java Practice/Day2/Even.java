import java.util.Scanner;
public class Even {
    public void show(int n){
        int i=0;
        while (i<n) {
            i=i+2;
            System.out.println("Even " +i);
        }
    }
    public static void main(String [] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n = sc.nextInt();
       // Even an = new Even();
       // an.show(n);
       new Even().show(n);
    }
}