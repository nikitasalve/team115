public class ConEx {
    static {
        System.out.println("Static constructor...");
    }

    ConEx() {
        System.out.println("General Constructor...");
    }

    public static void main(String[] args){
            ConEx e = new ConEx();
    }

}