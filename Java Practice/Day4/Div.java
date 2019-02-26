import java.util.InputMismatchException;
import java.util.Scanner;

public class Div {
    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any two numbers");
        try{
        a = sc.nextInt();
        b=sc.nextInt();
        c=a/b;
        System.out.println("Division " +c);
        }catch(InputMismatchException e) {
            System.out.println("Enter only number man");
        }  
        catch(ArithmeticException e) {
            System.out.println("impossible");
        }
        
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("error " );
        }

        finally {
            System.out.println("Program from FTP batch");
        }
        
    }
}