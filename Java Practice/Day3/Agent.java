public class Agent
{
    private int agentId;
    private String firstName;
    private String lastName;
    private String city;
    private double premium;

public Agent(){

}

public Agent(int argAgentId,
            String argFirstName,
            String arglastName,
            String argCity,
            double argPremium) {

this.agentId=argAgentId;
this.firstName=argFirstName;
this.lastName=arglastName;
this.city=argCity; 
this.premium =argPremium;
            }

            public int getAgentId(){
                return agentId;
            }
        
            public void setAgentId(int argAgentId){
                this.agentId =argAgentId;
            }
        
            public String getFirstName(){
                return firstName;
            }
        
            public void setFirstName(String argFirstName){
                this.firstName =argFirstName;
            }
        
            public String getLastName(){
                return lastName;
            }
        
            public void setLastName(String arglastName){
                this.lastName =arglastName;
            }
        
            public String getCity(){
                return city;
            }
        
            public void setCity(String argCity){
                this.city=argCity;
            }     

            public double getPremium(){
                return premium;
            }
        
            public void setPremium(Double argPremium){
                this.premium=argPremium;
            } 

            @Override
            public final String toString(){
                return "AgentID"+ agentId + " Firstname "+ firstName+ " "+lastName +" City "+ city+" premium " +premium;
            }



    public static void main(String[] args) {
        Agent obj1 = new Agent(1,"Omkar","K","Pune",54545);
        System.out.println(obj1);
        Agent obj2 = new Agent();
        obj2.setAgentId(14);
        obj2.setFirstName("Akash");
        obj2.setLastName("N");
        obj2.setPremium(254.5);
        System.out.println(obj2);
    }
}