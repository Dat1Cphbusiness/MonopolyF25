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

            int id = Integer.parseInt(values[i].trim());
            String  fieldtype = (values[i].trim());
            String label = (values[i].trim());
            int cost = Integer.parseInt(values[i].trim());
            int income = Integer.parseInt(values[i].trim());
            int seriesID = Integer.parseInt(values[i].trim());

            Field field = new Field(int ID, String label,  int cost, int income);
        }

    }

    public Field getField(int i){



        return fields[i + 1];
    }
}
