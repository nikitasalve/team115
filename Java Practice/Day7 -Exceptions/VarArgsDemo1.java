public class VarArgsDemo1 {
    public void show (String ...s) {
        for (String e : s) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        VarArgsDemo1 obj = new VarArgsDemo1();
        obj.show();
        obj.show("sahil");
        obj.show("ramesh","suresh");
        obj.show("sahil","kalpana","meghana");
    }
}