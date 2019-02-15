public class EvenOdd {

    public void check(int n){
        boolean flag = true;
        if(n<0) {
            flag = false;
            throw new ArithmeticException("Negative Nos. not allowed...");
        }
        if(n== 0){
            flag = false;
            throw new ArrayIndexOutOfBoundsException("zero is Invalid value...");
        }
        if(flag==true) {
            if(n%2==0){
                System.out.println("Even Number...");
            } else {
                System.out.println("Odd Number...");
            }
        }
    }
    public static void main(String[] args) {
        EvenOdd obj = new EvenOdd();
        try {
        obj.check(0);
        } catch(ArithmeticException e) {
            e.printStackTrace();
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}