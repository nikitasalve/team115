public class ObjEx {
    public void show(Object ob) {
        if(ob=="12") {
            System.out.println("hi");     
        } else {
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        String ob ="12";
        new ObjEx().show(ob);
    }
}