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


        } else if (p != owner) {
            msg += "du skal betale " + getIncome();
            p.pay(this.getIncome(), this.owner);
            setOption (null);

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

        String msg = "";

        if (this.getOption().equals("buy")) {
            p.buyProperty(this);
            this.owner = p;
            msg+= "Du har købt " + super.getLabel();

            if (checkForMonopoly(p)) {
                msg += "\n Du har nu monopol";

            }
            return msg;
        }
        return msg;
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
