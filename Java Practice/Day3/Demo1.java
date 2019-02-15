public class Demo1 {
 public void show(int x) {
     System.out.println("Show Method w.r.t. Int " +x);
 }


 public void show(double x) {
     System.out.println("Show Method w.r.t. double " +x);
 }

 
 public void show(String x) {
     System.out.println("Show Method w.r.t. String " +x);
 }


 public void show(boolean x) {
     System.out.println("Show Method w.r.t. Boolean " +x);
 }

    public static void main(String[] args) {
     Demo1 d = new Demo1();
     d.show(1);
     d.show("hello");
 }
}