
import java.util.Scanner;
public class CaseDemo {
        public void show(int a) {
          switch(a) {
            case 1 : System.out.println("UNIX" );
                    break;
            case 2 : System.out.println("JAVA" );
                    break;
            case 3 : System.out.println("SQL" );
                    break;
            case 4 : System.out.println("GIT" );
                    break;  
            default :
                    System.out.println("Invalid Choice");
                    break;              
          }
          
        }

    public static void main(String[] args){
        int ch;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Choice");
        ch = sc.nextInt();
        new CaseDemo().show(ch);
    }

} 