import static java.lang.Integer.parseInt;

public class Board {
    Field[] fields;

    private void createFields(String [] data) {

        for (int i = 0 ; i > data.length; i++) {
            String[] values = data[i].split(",");
            int id = Integer.parseInt(values[1].trim());
            String FieldType = values[2].trim();
            String label = values[3].trim();
            int cost = Integer.parseInt(values[4].trim());
            int income = Integer.parseInt(values[5].trim());
            int seriesId = Integer.parseInt(values[6].trim());
            fields[i] = new Field(id,label, cost, income);

        }
    }
    public Field getField(int id) {

        return fields[i];
    }
    public Board (String[] fielddata, String[] carddata) {
        Fields = new Field[fielddata.length];

        createField(fielddata);
        Chance.cardDeck = new CardDeck(carddata)

    }

}
