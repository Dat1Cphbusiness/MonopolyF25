public class Field {

    // Attributes
    private String label;
    private int ID;
    private int cost;
    private int income;
    private String option;

    // ______________________________________________

    public Field(int ID, String label, int cost, int income){
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    // ______________________________________________

    @Override
    public String toString() {
        return this.ID + ", "  + this.label;
    }

    // ______________________________________________

    public String onLand(Player p){
       return p + " er landet på felt " + this.toString();
    }

    // ______________________________________________

    public String onAccept(Player p){
        return null;
    }

    // ______________________________________________

    public String onReject(Player p){
        return null;
    }

    // ______________________________________________

    public String getOption() {
        return option;
    }

    // ______________________________________________

    public int getCost() {
        return this.cost;
    }

} // Field class end
