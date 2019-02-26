class NegativeException extends Exception {
    NegativeException(String error) {
        super(error);
    }
}

class NumberZeroException extends Exception {
    NumberZeroException(String error) {
        super(error);
    }
}

public class Custom {
    public void sum (int a, int b) throws NegativeException, NumberZeroException {
        boolean flag = true;
        if (a<0 || b<0) {
            flag = false;
            throw new NegativeException("Negative Nos. Not Allowed");
        }
        if(a==0 || b ==0){
            flag = false;
            throw new NumberZeroException("Zero is Invalid Value");
        }
        if(flag==true){
            int c = a+b;
            System.out.println("Sum is "+c);
        }
    }

    public static void main(String[] args) {
        try {
            new Custom().sum(12,5);
        } catch (NegativeException e) {
            e.printStackTrace();
        } catch(NumberZeroException e) {
            e.printStackTrace();
        }
    }
}