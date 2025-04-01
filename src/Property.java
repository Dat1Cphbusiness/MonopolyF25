import java.lang.reflect.Array;
import java.util.ArrayList;

public class Property extends Field implements IOption {
    private Player owner;
    private int seriesID;
    protected boolean isMonopolized = false;

    public Property(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.seriesID;
    }

    @Override
    public String onLand(Player p) {

        /*
        p lands on property();
        check if property is owned
            -If yes, check if current player is the owner,
                --if no, player needs to pay the current owner
            -If no, ask if player wants to buy property
                --if yes, check for player complete series and set monopolized = true
         */

        // return super.onLand(p);

        String msg = super.onLand(p);
        if (owner == null) {
            msg += "Vil du købe? (Y/N):";
            setOption("buy");

        } else if (owner != null && !p.equals(owner)) {
            msg += "du skal betale " + getIncome();
            //p.pay(getIncome());

        }
        return msg;
    }

    protected void checkForMonopoly() {

        /*
         * WRITE YOUR PSEUDOCODE HERE
         * */
    }

    @Override
    public String onAccept(Player p) {
        return super.onAccept(p);
    }

    @Override
    public String onReject(Player p) {
        return super.onReject(p);
    }

    public Player getOwner() {
        return this.owner;
    }

    public boolean checkForMonopoly(Player p) {

        int seriesSize = 3;
        ArrayList<Property> deedsInSeries = new ArrayList<>();

        // Switchcase for seriesSize
        switch(seriesID){
            // Shippingline
            case 1:
                seriesSize = 4;
                break;

            // Brewery, Blue and Purple series
            case 2:
            case 3:
            case 10:
                seriesSize = 4;
                break;

            default:
                seriesSize = 3;
        }

        // Compare this seriesID to deeds - add to array if identical
        for (Property property : p.getDeeds()) {
            if (this.seriesID == property.seriesID) {
                deedsInSeries.add(property);
            }
        }

        // Compare deeds in series to series size
        if(deedsInSeries.size() == seriesSize){

            // If true set all propeties in series to true
            for (Property property: deedsInSeries){
                property.isMonopolized = true;

            }
            // Return true if monopolized
            return true;
        }
        // Return false if not monopolized
        return false;
    }
}

