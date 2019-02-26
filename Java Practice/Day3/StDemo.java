public class StDemo {
    public void show(){
        System.out.println("From show Method..");
    }

    public static void display() {
        System.out.println("From Display method");
    }

    public static void name(String[] args) {
        StDemo.display();
        new StDemo.show();
    }
 }