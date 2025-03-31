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
    protected boolean checkForMonopoly(ArrayList<Property> playerProperties){

        if(this.owner == null){
            this.isMonopolized = false;
            return false;
        }

        int requiredForMonopoly = getRequiredForMonopoly(this.seriesID);
        int ownedCount = 0;

        //Gennemgå playerens ejendomme og tjekker om de har samme serieID og ejer
        for(Property p: playerProperties ){
            if(p.seriesID == this.seriesID && p.owner.equals(this.owner)){
                ownedCount++;
            }
        }

        if(ownedCount == requiredForMonopoly){
            this.isMonopolized = true;
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
}
