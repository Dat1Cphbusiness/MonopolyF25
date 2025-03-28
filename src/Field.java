public class Field {
    private String label;
    private int Id;
    private int cost;
    private int income;
    public Field(int Id, String label, int cost, int income) {

    }
    public String toString() {
        return this.Id + ", " + this.label;

    }
    public String onLand(Player p) {
        System.out.println("du landede på bla bla ");

        return p.getName() + "landede på felt " + toString();
    }
    public String onAccept(Player p) {
        System.out.println("Du accepterede");
    }
    public String onReject(Player p){
        System.out.println("Du afviste");
    }
}
