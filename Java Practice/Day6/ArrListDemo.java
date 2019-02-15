import java.util.ArrayList;
import java.util.List;

public class ArrListDemo {
    public static void main(String[] args) {
        List lstNames = new ArrayList();
        lstNames.add("vinita");
        lstNames.add("Ram");
        lstNames.add("pushkar");
        lstNames.add("Gaurav");
        System.out.println("Enter the ArrayList are ");

        for(Object ob : lstNames){
            System.out.println(ob);
        }

        lstNames.add(2,"Kalyan");
        System.out.println("List after adding new element");
        for(Object ob: lstNames){
            System.out.println(ob);
        }

        lstNames.set(2,"Kalyan");
        System.out.println("List after modify new element");
        for(Object ob: lstNames){
            System.out.println(ob);
        }

        lstNames.remove(0);
        System.out.println("List after removing new element by index");
        for(Object ob: lstNames){
            System.out.println(ob);
        }
        System.out.println("List after removing new element by name");
        lstNames.remove("Gaurav");
        System.out.println("List after modify new element");
        for(Object ob: lstNames){
            System.out.println(ob);
        }

    }
}