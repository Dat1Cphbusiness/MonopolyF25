import java.util.ArrayList;

public class Property extends Field implements IOption{
    private Player owner;
    private int seriesID;
    protected boolean isMonopolized = false;

    public Property(int ID, String label, int cost, int income, int seriesID){
        super(ID,label,cost,income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.seriesID;
    }

    @Override
    public String onLand(Player p) {

        String msg = super.onLand(p);
        if (owner == null){
            msg += "\nVil du købe? (Y/N):";
            setOption ("buy");

        } else if (owner != null && !p.equals(owner)) {
            msg += "du skal betale " + getIncome();
            //p.pay(getIncome());

        }
        return msg;
    }
    protected boolean checkForMonopoly(Player p){

        int seriesSize = 3;
        seriesSize = getRequiredForMonopoly(this.seriesID);

        ArrayList<Property> deedsInSeries = new ArrayList<>();

        for(Property property: p.getDeeds()){
            if(property.seriesID == this.seriesID){
                deedsInSeries.add(property);
            }
        }

        if(deedsInSeries.size() == seriesSize){
            for(Property property: deedsInSeries){
                property.isMonopolized = true;
            }
            return true;
        }
        return false;

    }

    private int getRequiredForMonopoly(int seriesID) {

        switch(seriesID) {
            case 1: // Færger
                return 4;
            case 2: // Bryggerier
                return 2;
            case 3: // Blå
                return 2;
            case 10: // Lilla
                return 2;
            default: // For alle andre serier skal der bruges 3 for at opnå monopol
                return 3;
        }
    }
    @Override
    public String onAccept(Player p) {
        return super.onAccept(p);
    }

    @Override
    public String onReject(Player p) {
        return super.onReject(p);
    }

    public Player getOwner(){
        return this.owner;
    }

    public int getSeriesID() {

        return this.seriesID;
    }

}
