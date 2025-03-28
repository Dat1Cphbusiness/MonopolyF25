public class Property extends Field {
    private Player owner;
    private int seriesId;
    private int Id;
    private String label;
    private boolean isMonopolized;

    public Property(int Id, String label, int cost, int income, int seriesId) {

    }

    public String toString() {
        return this.Id + ", " + this.label;

    }
    public String onLand(Player p) {
        System.out.println("du landede på bla bla ");

        return p.getName() + "landede på grund " + toString();
    }
    public String onAccept(Player p) {
        System.out.println("Du accepterede");
    }
    public String onReject(Player p){
        System.out.println("Du afviste");
    }
}
