public class Test {
    int x;

    public static void main(String[] args){
        Test obj1 = new Test();
        obj1.x =12;
        Test obj2 = obj1;
        
        obj2.x =13;
        System.out.println(obj1.x);
         System.out.println(obj1.hashCode());
         System.out.println(obj2.hashCode());

       // Strings are immutable and hence if we cannot store it will not print to java.
       // All string are stored into HEAP
         String s1 = "welcome";
         s1.concat("to Java");
         System.out.println(s1);
         String n1 = "welcome1",n2 = "welcome2",n3 = "welcome3",n4 = "welcome4";
         System.out.println(n1.hashCode());
         System.out.println(n2.hashCode());
         System.out.println(n3.hashCode());
         System.out.println(n4.hashCode());

    }
}