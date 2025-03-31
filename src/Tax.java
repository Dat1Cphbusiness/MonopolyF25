public class Tax extends Field implements IOption{

    public Tax(int ID, String label, int cost, int income) {

        super(ID, label, cost, income);
    }

    @Override
    public String onLand(Player p) {

        String s = super.onLand(p);
        s += "\n Du skal nu betale et beløb der svarer til 10% af dine aktiver. Vil du hellere betale et fast beløb på" + this.cost + "kr? Y/N \n";

        return s;
    }

    @Override
    public String onAccept(Player p) {

        p.payMetode(cost);

        return "Du har betalt: " + cost + "kr";
    }

    @Override
    public String onReject(Player p) {

        p.getTotalWorth() * 0.90;
        int i = p.getTotalWorth() * 0.90;

        return "Du har betalt: " + cost + "kr. og du har: " + i + " mængde penge tilbage";
    }
}
