class Data<T>{
    public void swap(T a, T b) {
        T t =a;
        a=b;
        b=t;
        System.out.println("A value "+ a + " B value " +b);
    }
}

public class SwapDemo {
    public static void main(String[] args) {
        //code bloat - JVM automatically creates the program.
       new Data().swap(12, 5);
       new Data().swap(12.5, 5.5);
       new Data().swap("omkar","sahil");
       new Data().swap(true, false);
    }
}