import java.util.ArrayList;
import java.util.List;

public class ArrEmploy {
    public static void main(String[] args) {
        List lsEmploy = new ArrayList();
        lsEmploy.add(new Employ(1,"vinita",3245));
        lsEmploy.add(new Employ(2,"nita",32455));
        lsEmploy.add(new Employ(3,"vita",324215));
        lsEmploy.add(new Employ(1,"via",322545));
    

    for (Object ob : lsEmploy) {
        Employ e =(Employ) ob;
        System.out.println(e);
    }
}
}