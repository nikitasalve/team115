public class Demo2 {
    public int sum() {
        return 5;
    }

    public int sum(int x) {
        return 5+x;
    }

    public int sum(int x, int y) {
        return x+y;
    }

    public static void main(String[] args){
        Demo2 d = new Demo2();
        System.out.println(d.sum(2));

    }
 


}