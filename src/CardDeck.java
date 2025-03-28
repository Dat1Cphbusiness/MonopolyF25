import java.util.Arrays;
import java.util.Collections;

public class CardDeck { // CardDeck class

    // Attributes
    private Card[] cards;
    private int counter = 0;

    // ______________________________________________

    public CardDeck(String[] carddata){
        Card[] cards = new Card[carddata.length];
        createCards(carddata);
    }

    // ______________________________________________

    public Card getNext(){

        // To prevent out of bounds (starts at 0 and not 1)
        Card c = cards[counter];

        // Adds 1 each time it's called
        this.counter++;

        return c;

    }

    // ______________________________________________

    public void createCards(String[] carddata){

        for(int i = 0; i < carddata.length; i++) {

            String[] values = carddata[i].split(",");
            String cardMessage = values[0].trim();
            int cardIncome = Integer.parseInt(values[1].trim());
            int cardCost = Integer.parseInt(values[2].trim());
            String cardEvent = values [3].trim();

            // Instanciate our card
            Card c = new Card(cardMessage, cardIncome, cardCost, cardEvent);

            // 1...2..3....4...5...6
            // Each loop takes a new Card and inputs in our Array
            cards[i] = c;

        } // For-loop end

        // Shuffles our cards
        Collections.shuffle(Arrays.asList(cards));

    }

} // CardDeck class end
