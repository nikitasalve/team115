import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;
public class SortStudent {

    public static void main(String[] args) {
        Comparator c = new CgpComparator();
        Comparator e = new CityComparator();
        SortedSet<Student> s = new TreeSet<Student>(c,e);
        s.add(new Student(1,"omkar",8.5,"pune"));
        s.add(new Student(1,"or",6.5,"fufhe"));
        s.add(new Student(1,"ollr",7.5,"cfh"));
    
    for(Student et : s){
    System.out.println(et);
    }
}
}