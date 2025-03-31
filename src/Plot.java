public class Plot extends Property{

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String onLand(Player p) {
      /*

            p lands on plot
            if p is owner
            check if monopolized
            give option to build
            if accepted = build;

       */

        //return super.onLand(p);

        String msg = super.onLand(p);

        if(getOwner()!=null && getOwner()==p && isMonopolized){
            setOption("build");
            msg += "\n Vil du bygge? (Y/N):";
        }

        return msg;
    }

    @Override
    public String onAccept(Player p) {


        //checkForMonopoly();//tjekker om købet skabte et monopol og sætter isMonopolized til true
        return super.onAccept(p);
    }

    @Override
    public String onReject(Player p) {
        return super.onReject(p);
    }
}
