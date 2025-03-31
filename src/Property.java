public class Property extends Field{
    private Player owner;
    private int seriesID;
    private boolean isMonopolized;

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
