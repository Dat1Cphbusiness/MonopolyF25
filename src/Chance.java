public class Chance extends Field { // Chance class (subclass)

    // Attributes
    private CardDeck cd;

    // ______________________________________________

    // int cost, int income aren't added as we hardcode the 0, 0 values
    public Chance(int ID, String label){
        super(ID, label, 0, 0);
    } // Constructor

} // Chance end
