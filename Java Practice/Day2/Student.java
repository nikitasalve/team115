public class Student {
    int sno;
    String firstName;
    String LastName;
    double cgp;

    @Override 
    public final String toString() {
        return sno + " ID "+ " Name: "+ firstName + " " +LastName + " cgp is " +cgp;
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.sno =1; s1.firstName="nikita"; s1.LastName="salve"; s1.cgp= 7.215;
        
        Student s2 = new Student();
        s2.sno =2; s2.firstName="omkar"; s2.LastName="waghe"; s2.cgp= 6.215;
        
        Student s3 = new Student();
        s3.sno =1; s3.firstName="nikita"; s3.LastName="salve"; s3.cgp= 7.215;
        
        Student s4 = new Student();
        s4.sno =1; s4.firstName="nikita"; s4.LastName="salve"; s4.cgp= 7.215;
        
        Student arr[] =new Student[] {s1, s2, s3,s4};
        
        for(Student s : arr){
        System.out.println(s);
        }

    }

    

}