import util.TextUI;
import java.util.ArrayList;


public class Property extends Field implements IOption{
    private Player owner;
    private int seriesID;
    protected boolean isMonopolized = false;
    private TextUI ui = new TextUI();
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
        if (owner == null){
            msg += "Vil du købe? (Y/N):";
            setOption ("buy");

        } else if (owner != null && !p.equals(owner)) {
            msg += "du skal betale " + getIncome();
            //p.pay(getIncome());

        }
        return msg;
    }
    protected void checkForMonopoly(Player p){
        int seriesSize = 3;
        switch (this.seriesID) {
            case 0:
            case 1:
            case 9:
                seriesSize = 2;
                break;
            case 3:
                seriesSize = 4;
                break;
            default:
                break;

        }
        ArrayList<Property> deedsInSeries = new ArrayList<>();

        for(Property pr: p.deeds) {
        if(pr.seriesID == this.seriesID) {
            deedsInSeries.add(pr);
            }
        }

        if(deedsInSeries.size() == seriesSize) {
            for(Property pr: deedsInSeries) {
                pr.isMonopolized = true;
                ui.displayMessage("Du har monopoly!");

            }
        }
    }


        /*
        * WRITE YOUR PSEUDOCODE HERE
        * */

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
}
