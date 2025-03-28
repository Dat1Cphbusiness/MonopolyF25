public class Property extends Field {
    private Player owner;
    private int seriesID;
    private boolean isMonopolized;

    public Property(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    public Property(int ID, String label, int cost, int income, int seriesID){
        super(ID, label, cost, income);
        this.seriesID = seriesID;
    }
    @Override
    public String toString(){
        return super.toString() +", "+ this.seriesID;
    }

    @Override
    public String onLand(Player p) {
        return super.onLand(p);
        //Spiller lander på ejendom. Hvis ejendommen er eget af nogen, så bliver spørg hvis
        // spilleren er ejeren af ejendommen, hvis nej, så skal spilleren betale.
        //hvis ingen ejer ejendommen, så spørg: acceptere købtet, hvis ja, køb. ejeren har fuldført series
    }
}
