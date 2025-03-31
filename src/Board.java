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
              switch (fieldtype) {
                  case "Chance" : f = new Chane(ID, label, income, cost);
                      break;
                  case "Start" : f = new Start(ID, label, income, cost);
                      break;
                  case : "Visit" : f = new Visit(ID, label, income, cost);
                      break;
                  case "Parking" : f = new Parking(ID, label, income, cost);
                          break;
                  case "Prison" : f = new Prison(ID, label, income, cost);
                      break;
                  case "Tax" : f = new Tax(ID, label, income, cost);
                      break;
                  case "Plot" : f = new Plot(ID, label, income, cost, seriesID);
                      break;
                  case "Brewery" : f = new Brewery(ID, label, income, cost, seriesID);
                      break;
                  case "ShippingLine" : f = new ShippingLine(ID, label, income, cost, seriesID);
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
