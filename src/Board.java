import java.io.StringReader;
import java.lang.reflect.Field;

public class Board {
    private Field[]fields;


    public Board (String[] fieldata, String[] cardData){
        fields = new Field[40];
        this.fields =  fields;
        createFields(fieldata);

        //Chance.cardeck = new CardData(carddata);
    }

    private void createFields(String[] data){
        for(int i = 0; i < fields.length; i++) {

            String[] values = data[i].split(",");

            int id = Integer.parseInt(values[0].trim());
            String  fieldtype = (values[1].trim());
            String label = (values[2].trim());
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());

            Field field = new Field(id, label,  cost, income);
        }

    }

    public Field getField(int i){



        return fields[i + 1];
    }
}
