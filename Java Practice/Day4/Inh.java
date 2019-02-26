class First {  //base class
    public int sum() {
        return 5;
    }

    public void show(){
        System.out.println("show from first class");
    }
}

class Second extends First {  //derived class
    public void display(){
        System.out.println("Display from class Second...");
    }

    public int sum() {
        return 6;
    }
}

public class Inh {
    public static void main(String[] args) {
        Second s1 = new Second();
        // First f1 = new First();
        s1.show();
        s1.display();
        System.out.println(s1.sum());
    }
}