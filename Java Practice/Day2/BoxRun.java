public class BoxRun {
    public void show(Object ob){
        String s=ob.getClass().getSimpleName();
        //System.out.println(s);
        if(s.equals("Integer")) {
            System.out.println("integer Casting");
            int x =(Integer)ob;
        }
        if(s.equals("Double")) {
            System.out.println("Double Casting");
            Double x =(Double)ob;
        }
        if(s.equals("String")) {
            System.out.println("String Casting");
            String x =(String)ob;
        }
    }
    public static void main(String[] args) {
        int x=12;
        double y=12.3;
        String name="Bhaskar";
        BoxRun b = new BoxRun();
        b.show(x);
        b.show(y);
        b.show(name);
    }
}