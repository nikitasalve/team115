public class EqDemo {
    public static void main(String[] args) {
         String s1 ="hello";
         String s2="hello";
         String s3 = new String("hello");
        
         System.out.println(s1==s2);
         System.out.println(s1.equals(s2));
         System.out.println(s1==s3);
         System.out.println(s1.equals(s3));

         Employee e1 = new Employee();
         Employee e2 = new Employee();  

         e1.empno=1;e1.name="Nikita";e1.basic=88211;
         e2.empno=3;e2.name="Bhuvana";e2.basic=88211;

         System.out.println(e1==e2); 
         System.out.println(e1.equals(e2));
    }
}