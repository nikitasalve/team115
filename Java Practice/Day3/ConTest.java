public class ConTest {
    int a,b;
    public ConTest() {
        a=5;
        b=6;
    }

    public ConTest(int a) {
        this.a=a;
        b=6;
    }

    
    public ConTest(int a,int b) {
        this.a=a;
        this.b=a;
    }

@Override
public final String toString(){
    return " A value " +a+ " B value " +b;
}

public static void main(String[] args){
    ConTest obj1 =new ConTest();
    ConTest obj2 = new ConTest(2);
    ConTest obj3 = new ConTest(2,4);
    System.out.println(obj1);
     System.out.println(obj2);
     System.out.println(obj3);
}
}