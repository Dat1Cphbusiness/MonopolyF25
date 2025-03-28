public class Plot extends Property { // subclass from superclass Property

    // Attributes

    // ______________________________________________

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    // ______________________________________________

    @Override
    public String toString(){
        return super.toString();
    }

    // ______________________________________________

    @Override
    public String onLand(Player p){
        return super.onLand(p);
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



}
