public class Tax extends Field implements IOption{

    public Tax(int ID, String label, int cost) {

        super(ID, label, cost, 0);
    }

    @Override
    public String onLand(Player p) {

        String s = super.onLand(p);
        s += "\n Du skal nu betale et beløb der svarer til 10% af dine aktiver. " +
                "Vil du hellere betale et fast beløb på" + this.cost + "kr? Y/N \n";

        return s;
    }

    @Override
    public String onAccept(Player p) {

        p.pay(cost);

        return "Du har betalt: " + cost + "kr";
    }

    @Override
    public String onReject(Player p) {

       // p.getTotalWorth() * 0.90;
        double newTotalWorth = p.getTotalWorth() * 0.90;
        double tax = p.getTotalWorth() * 0.10;

        p.pay((int)tax);

        return "Du har betalt: " + tax + "kr. og du har: " + newTotalWorth + " i værdi tilbage";
    }
}
