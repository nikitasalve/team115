import java.util.Scanner;
public class Fact {

        public void show(int a){
            int f =1, i=1;
            while(i<=a){
                f =f*i;
                i++;
            }
            System.out.println("Fact is "+f);
        }
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for factorial");
        n = sc.nextInt();
        new Fact().show(n);
    }
}