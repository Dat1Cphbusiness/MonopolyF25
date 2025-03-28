public class Board {

    private Field[] fields;


    public Board(String[] fielddata, String[] carddata){
        fields = new Field[fielddata.length];
        createFields(fielddata);

        // Chance.cardDeck = new CardDeck(cardData);
    }

    private void createFields(String[] data){
        for(int i = 0; i < data.length; i++){
            String[] values = data[i].split(",");
            int fieldId = Integer.parseInt(values[0].trim());
            String fieldName = values[1];
            String fieldProperty = values[2];
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());

            fields[i] = new Field(fieldId,fieldProperty,cost,income);

        }
    }

    public Field getField(int id){
        return fields[id];

    }


}
