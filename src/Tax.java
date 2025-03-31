public class Tax extends Field implements IOption{

    public Tax(int ID, String label, int cost) {

        super(ID, label, cost, 0);
    }

    @Override
    public String onLand(Player p) {
        this.setOption("Fixed");
        String s = super.onLand(p);
        s += "\nDu skal nu betale et beløb der svarer til 10% af dine aktiver. " +
                "Vil du hellere betale et fast beløb på " + this.getCost() + "kr? Y/N \n";

        return s;
    }

    @Override
    public String onAccept(Player p) {

        p.pay(this.getCost());

        return "Du har betalt " + this.getCost() + " kr. i skat. Din samlede værdi er nu " + p.getTotalWorth() + " kr.";
    }

    @Override
    public String onReject(Player p) {

        double tax = p.getTotalWorth() * 0.10;
        int roundedTax = (int) Math.round(tax);

        p.pay(roundedTax);

        return "Du har betalt " + roundedTax + " kr. i skat. Din samlede værdi er nu " + p.getTotalWorth() + " kr.";
    }
}
