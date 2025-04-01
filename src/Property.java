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
            msg += "\nVil du købe? (Y/N): ";
            setOption("buy");

        } else if (owner != null && !p.equals(owner)) {
            msg += "\nDu skal betale " + getIncome() + " til " + owner.getName();
            p.pay(getIncome(), owner);
            setOption(null);
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
        if(getOption().equals("buy")){
            p.buyProperty(Property.this);
            this.owner = p;
            //checkForMonopoly();
            return "Du har nu købt " + super.toString();
        }
        return super.onAccept(p);
    }

    @Override
    public String onReject(Player p) {
        return p + " afvist at købe " + super.toString();
    }

    public Player getOwner(){
        return this.owner;
    }
}
