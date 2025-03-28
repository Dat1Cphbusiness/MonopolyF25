public class Card { // Card class

    // Attributes
    private String message;
    private int income;
    private int cost;
    private String event;

    // ______________________________________________

    public Card(String message, int income, int cost, String event){
        this.message = message;
        this.income = income;
        this.cost = cost;
        this.event = event;
    } // Constructor

    // ______________________________________________

    public String toString(){
        return "Message:\n" + this.message + "Income:\n" + this.income + "Cost:\n" + this.cost + "Event:\n" + this.event;
    }

    // ______________________________________________

    public int getCost(){
        return this.cost;
    }

    // ______________________________________________

    public int getIncome(){
        return this.income;
    }

    // ______________________________________________

    public String getEvent(){
        return this.event;
    }

    // ______________________________________________

    public String getMessage(){
        return this.message;
    }

} // Card class end
