import java.util.SortedSet;
import java.util.TreeSet;
public class SortDemo {
    public static void main(String[] args) {
        SortedSet s = new TreeSet();
        s.add("sahil");
        s.add("karthiga");
        s.add("divya");
        s.add("omkar");
        s.add("krishna");
        s.add("kara");
        for(Object ob : s) {
            System.out.println(ob);
        }
    }
}