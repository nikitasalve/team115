public class BoxDemo {
public static void main(String[] args) {
    int x=12;
    double y=12.5;
    String name ="16";

    Object obj1 =x;
    Object obj2 =y;
    Object obj3 =name;
    
    int z =(Integer)obj1;
    System.out.println(++z);
    
    float y1 =(int)obj1;
    System.out.println(++y1);
        
    String s1 =(String)obj3;
    int s2 = Integer.parseInt(name);
    System.out.println(s2);
    
  
    }
}