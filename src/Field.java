public class Field {

private String label;
private int ID;
private int cost;
private int income;
private String option;

public Field(int ID, String label, int cost, int income){
    this.ID = ID;
    this.label = label;
    this.cost = cost;
    this.income = income;

}

    @Override
    public String toString() {
        String s = this.ID + " " + this.label;
        return s;
    }
    public String onLand(Player p){
    String s = p.getName() + " er landet på felt " + this.ID + ", " + this.label;
    return s;

    }
    public String onAccept(Player p){
    return null; //Skal ændres
    }
    public String onReject(Player p){
    return null; //Skal ændres
    }
}

