abstract class Training {
    abstract void name();
    abstract void email();
}

class Dhivya extends Training {
    @Override
    public void name(){
        System.out.println("dhivya here");
    }

    @Override
    public void email(){
        System.out.println("Email is Dhiya");
    }
}

class Priya extends Training{
    @Override
    public void name(){
        System.out.println("priyanka here");
    }

    @Override
    public void email(){
        System.out.println("Email is priyanka");
    }
}
class Leeza extends Training{
    @Override
    public void name(){
        System.out.println("Leeza here");
    }

    @Override
    public void email(){
        System.out.println("Email is leeza");
    }
}

public class AbsDemo {
    public static void main(String[] args) {
        Training[] arr = new Training[]{
            new Leeza(), new Dhivya(), new Priya()
        };
        
        for (Training t : arr){
         t.name();
         t.email();   
        }

        

    }
}