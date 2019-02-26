public class Student {
    int sno;
    String name;
    double cgp;
    String city;

    public Student(){

    }

    public Student(int sno,String name, double cgp, String city) {
        this.sno =sno;
        this.name =name;
        this.cgp=cgp;
        this.city=city;
    }
    @Override
    public final String toString(){
        return "Sno " +sno+ " Name " +name+ " Cgp " +cgp+ " City " +city;
    }
}