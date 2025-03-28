public class Property extends Field {
    private Player owner;
    private int seriesID;
    private boolean isMonopolized;

    public Property(int ID, String label, int cost, int income, int seriesID){
        super(ID,label,cost,income);
        this.seriesID = seriesID;
    }
    public String toString(){
        return super.toString() + " SerieID: " + this.seriesID;
    }
    public String onLand(){
        //Player landed on property
        //If not property is owned by anyone:
        //Do you want to buy or continue? Y/N
        //If yes, does players have enough on the account, if yes buy and pay property,
        //Check if player has monopoly (has all seriesID) If true isMonopolized = true;

        //If property is owned
        //Check if the player owns the property
        //If player property equals property landed on, then continue game

        //If player dont own the property
        //Calculate rent
        //Check if player can pay the rent. If no player loses or sell assets
        //If yes pay the other player. Continue to next player


        return null; //Skal ændres
    }
}
