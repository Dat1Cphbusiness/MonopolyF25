public class Plot extends Property {
    public Plot(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    public Plot(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }

    @Override
    public String toString() {
        return super.toString();
        /*
        Spiller lander på en plot.
            Hvis spilleren er ejeren af plottet, så spørg om feltet er monopolized.
            Hvis feltet er monopolized, så spørg om spilleren vil acceptere muligheden at bygge.
            Hvis spilleren svarer ja, så byg.
         */
    }
}
