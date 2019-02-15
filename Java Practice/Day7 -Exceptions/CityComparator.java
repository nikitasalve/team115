import java.util.Comparator;
public class CityComparator implements Comparator<Student>{
    public int compare(Student e1, Student e2){
        return e1.city.compareTo(e2.city);
    }
}
 class CgpComparator implements Comparator<Student>{
   public int compare(Student c1, Student c2){
       // return c1.cgp.compareTo(c2.cgp);
        if(c1.cgp <= c2.cgp){
             return -1;
        } else {
            return 1;
         }
    }
}