import java.util.List;
import java.util.ArrayList;

public class Gen1 {
    public static void main(String[] args) {
        List data = new ArrayList(); // for interger data we need to be List data<Integer>
        data.add(new Integer(42));
        data.add(new Integer(11));
        data.add(new Integer(8));
        data.add(new Integer(063));
        data.add(new Integer(03));
        int sum = 0;
        for (Object ob : data) // for each loop and for(Integer ob)
        {
            sum +=(Integer)ob;
        }
        System.out.println(sum);
    }

}