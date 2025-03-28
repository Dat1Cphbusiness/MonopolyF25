public class Property extends Field {

    // Attributes
    private Player owner;
    private int seriesID;
    private boolean isMonopolized;

    // ______________________________________________

    public Property(int ID, String label, int cost, int income, int seriesID){
        super(ID, label, cost, income);
        this.seriesID = seriesID;
    }

    // ______________________________________________

    @Override
    public String toString(){
        return super.toString() + " Series ID: " + this.seriesID;
    }

    // ______________________________________________

    @Override
    public String onLand(Player p){
        // Placeholder for now
        return "";

        // Pseudocode as comments

    }

    // ______________________________________________

    @Override
    public String onAccept(Player p){
        return super.onAccept(p);
    }

    // ______________________________________________

    @Override
    public String onReject(Player p){
        return super.onReject(p);
    }



} // Property end
