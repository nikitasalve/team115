public class Student {
    int sno;
    String firstName;
    String lastName;
    double cgp;

    public int getSno(){
        return sno;
    }

    public void setSno(int sno){
        this.sno =sno;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName =firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName =lastName;
    }

    public double getCgp(){
        return cgp;
    }

    public void setCgp(Double cgp){
        this.cgp=cgp;
    }
    @Override
    public final String toString(){
        return "sno"+sno+ " name "+ firstName+ " "+lastName +" CGP "+ cgp;
    }
    public static void main(String[] args) {
         Student st = new Student();
        st.setSno(20);
        st.setFirstName("omkar");
        st.setLastName("waghe");
        st.setCgp(12.45);
        syso
    }

}