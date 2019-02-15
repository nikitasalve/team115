class Demo1 {
    
    public void show(){
        
        System.out.println("show from Demo1...");
    }
}

class Demo2 extends Demo1 {
    public void show(){
       // super.show();
        System.out.println("show from Demo2 ...");
    }
}

public class Sup1 {

    public static void main(String[] args) {
        Demo1 t = new Demo1();
        Demo2 obj = new Demo2();
        obj.show();
        Demo1 obj1 = new Demo2();
        obj1.show();
        Demo1 obj3 =(Demo1) new Demo2();
        obj3.show();

        Demo1 x =(Demo1)t;
        x.show();

       
    }
}