public class ArrEx {
    public static void main(String[] args) {
        int [] a = new int [] {12,5};
        try {
            a[10] =63;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array size is full");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

