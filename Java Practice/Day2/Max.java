import java.util.Scanner;
public class Max {
    public void check(int a, int b, int c){
        int max = a;
        if(max<b){
            max=b;
        }
        if (max<c){
            max =c;
            }
        System.out.println(max+" is max");
       
    }

    public static void main(String[] args){
        int n1,n2,n3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers");
        n1=sc.nextInt();
        n2=sc.nextInt();
        n3=sc.nextInt();
        Max m = new Max();
        m.check(n1,n2,n3);
    }
}