public class Board {

    private Field[] fields;


    public Board(String[] fielddata, String[] carddata){
        fields = new Field[fielddata.length];
        createFields(fielddata);

         Chance.cardDeck = new CardDeck(carddata);
    }

    private void createFields(String[] data){
        for(int i = 0; i < data.length; i++){
            String[] values = data[i].split(",");
            int fieldId = Integer.parseInt(values[0].trim());
            String fieldType = values[1];
            String fieldLabel = values[2];
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());
            Field f =null;
              switch (fieldType) {
                  case "Chance" : f = new Chance(fieldId, fieldLabel, income, cost);
                      break;
                  case "Start" : f = new Start(fieldId, fieldLabel, income, cost);
                      break;
                  case : "Visit" : f = new Visit(fieldId, fieldLabel, income, cost);
                      break;
                  case "Parking" : f = new Parking(fieldId, fieldLabel, income, cost);
                          break;
                  case "Prison" : f = new Prison(fieldId, fieldLabel, income, cost);
                      break;
                  case "Tax" : f = new Tax(fieldId, fieldLabel, income, cost);
                      break;
                  case "Plot" : f = new Plot(fieldId, fieldLabel, income, cost, seriesID);
                      break;
                  case "Brewery" : f = new Brewery(fieldId, fieldLabel, income, cost, seriesID);
                      break;
                  case "ShippingLine" : f = new ShippingLine(fieldId, fieldLabel, income, cost, seriesID);
                      break;


                  default: System.out.println("No such type available");
              }



            fields[i] = f;

        }
    }

    public Field getField(int id){
        return fields[id-1];
    }


}
