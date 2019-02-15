//Fcator with for loop
import java.util.Scanner;
public class Factor {
        public void show(int a) {
            int fact =1,s=1;
            for(int i=1; i<a; i++){
                if(a%i== 0) {
                    System.out.println("Factor is" +i);
                }
                else{
                    while(s<=a){
                    fact = fact * s;
                    s++;
                    }
                    }
            }
            System.out.println("factorial is " + fact);
        }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n = sc.nextInt();
        new Factor().show(n);
    }

}