import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;
public class SortEmp {
    public static void main(String[] args) {
        Comparator c = new BasicComparator();
        SortedSet<Employ> s = new TreeSet<Employ>(c);
        s.add(new Employ(1,"kalpana",67223));
        s.add(new Employ(2,"bhuvana",88145));
        s.add(new Employ(3,"Akash",67725));
        s.add(new Employ(4,"fantasy",67223));
        s.add(new Employ(5,"fantasy",67223));
        for(Employ e : s) {
            System.out.println(e);
        }
    }
}