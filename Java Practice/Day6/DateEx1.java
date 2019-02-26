import java.text.SimpleDateFormat;
import java.util.Date;
public class DateEx1 {
    public static void main(String[] args) {
        Date dt = new Date();
        System.out.println(dt);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(dt));
    }
}