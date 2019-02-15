import java.util.ArrayList;
import java.util.List;

public class ArrIntEx {
    public static void main(String[] args) {
        List lstData = new ArrayList();
        lstData.add(new Integer(52));
        lstData.add(new Integer(5));
        lstData.add(new Integer(22));
        lstData.add(new Integer(521));
        lstData.add(new Integer(50));
        lstData.add(new Integer(54));
        lstData.add(new Integer(42));
        lstData.add(new Integer(501));
        int sum=0;
        for (Object ob:lstData) {
            sum+=(Integer)ob;
        }
        System.out.println("sum is"+sum);
    }
     
    
}