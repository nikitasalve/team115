public class Cricket {
   static int score;
    public void incr(int x){
        score+=x;
    }

    public static void main(String[] args) {
        Cricket cr = new Cricket();
        Cricket cd = new Cricket();
        Cricket ce = new Cricket();
        cr.incr(12);
        cr.incr(12);
        cr.incr(8);
        System.out.println("Total Score" + Cricket.score);
    }
    
    
}