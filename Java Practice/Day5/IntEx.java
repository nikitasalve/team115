interface IOne {
   default void display() {
       System.out.println("Interface Ione");
   } 
       
    
}

interface ITwo {
    default void display() {
        System.out.println("Interface ITwo");
    }
}

interface IThree {
    default void display() {
        System.out.println("Interface Two");
    } 
}

class Demo implements IOne, ITwo,IThree {
    public void display(){
    IOne.super.display();
    ITwo.super.display();
    IThree.super.display();
    }
}

public class IntEx {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.display();
    }
}