class C1 {
    static {
        System.out.println("Static from C1");
    }
    public C1(){
        System.out.println("Base class constructor...");
    }
}

class C2 extends C1 {
    static {
        System.out.println("Static from C2");
    }
    public C2(){
        System.out.println("Derived class Constructor...");
    }
}

public class Inhc {
    public static void main(String[] args) {
        C2 obj = new C2();
        
    }
}