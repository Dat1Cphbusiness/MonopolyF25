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
    protected void checkForMonopoly(Player p){
        int seriesSize = 3;



        switch(seriesSize) {
            case 0:
            case 1:
            case 9:
                seriesSize = 2;
                break;
            case 3:
                seriesSize = 4;
                break;
        }
        ArrayList<Property> deedsInSeries = new ArrayList<Property>();
        for(Property f: p.getDeeds()){


            if(this.seriesID == f.seriesID){
                deedsInSeries.add(f);


            }


            }if(deedsInSeries.size() == seriesSize){
            for(Property f : deedsInSeries){
                f.isMonopolized = true;

            }

        }

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

    public Player getOwner(){
        return this.owner;
    }
}
