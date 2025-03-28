public class Field { // Field class (superclass)

    // Attributes
    private String label;
    private String option;
    private int ID;
    private int cost;
    private int income;

    // ______________________________________________

    public Field(int ID, String label, int cost, int income){
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    // ______________________________________________

    public String toString(){
        return "ID:" + this.ID + "\nLabel:" + this.label;
    }

    // ______________________________________________

    public String onLand(Player p){
        return "User:" + p.getName() + " has landed on " + this.ID + ", " + this.label;
    }

    // ______________________________________________

    public String onAccept(Player p){
        return "User: " + p.getName() + " has accepted.";
    }

    // ______________________________________________

    public String onReject(Player p){
        return "User: " + p.getName() + " has rejected.";
    }

}
