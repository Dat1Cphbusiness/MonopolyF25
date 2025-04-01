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
    protected void checkForMonopoly(){

        /*
        * WRITE YOUR PSEUDOCODE HERE
        * */
    }
    @Override
    public String onAccept(Player p) {

        p.buyProperty(Property.this);
        this.owner = p;
        if(checkForMonopoly(p)){
            String msg = "Du har nu monopol";
            return "Du har købt " + super.getLabel() + " og " + msg;
        }
        return "Du har købt " + super.getLabel();
    }

    @Override
    public String onReject(Player p) {

        String s = p.getName() + " afviste at købe " + super.getLabel();
        return s;
    }

    public Player getOwner(){
        return this.owner;
    }
}
