import static java.lang.Integer.parseInt;

public class Board {
    private Field[] fields;

    private void createFields(String [] data) {

        for (int i = 0; i < data.length; i++) {
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[0].trim());
            String FieldType = values[1];
            String label = values[2];
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            //int seriesId = Integer.parseInt(values[5].trim());
            fields[i] = new Field(id,label, cost, income);

        }
    }
    public Field getField(int id) {

        return fields[id];
    }
    public Board (String[] fielddata, String[] carddata) {
        fields = new Field[fielddata.length];

        createFields(fielddata);
        Chance.cardDeck = new CardDeck(carddata);

    }

}
