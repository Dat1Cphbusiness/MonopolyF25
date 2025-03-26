import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private String name;
    private int maxPlayers;
    private ArrayList<Player> players;
    static TextUI ui = new TextUI();
    static FileIO io = new FileIO();
    private Player currentPlayer;

    // Our own local attribute
    private int totalPlayers; // To fix recursion error

    // _______________________________________________________________

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }

    // _______________________________________________________________

    public void startSession(){
        ArrayList<String> data = io.readData("data/playerData.csv");
        ui.displayMessage("Velkommen til "+ this.name);

        if(!data.isEmpty() && ui.promptBinary("would your like to continue previous game: Y/N")){
            for(String s : data){
              String[] values =  s.split(",");//  "tess, 0"
                int score = Integer.parseInt(values[1].trim());
               createPlayer(values[0],score);
            }

        }else{

            registerPlayers();
        }
        displayPlayers();
    }

    // _______________________________________________________________

    public void registerPlayers(){

        try {
            totalPlayers = ui.promptNumeric("Number of players:");       //Konvertere svaret til et tal
        } catch (NumberFormatException e) {
            ui.displayMessage("Wrong input.. Please try again.");
            registerPlayers();
        }

        if(totalPlayers > this.maxPlayers || totalPlayers < 2){
            System.out.println("Your input number was higher or lower than the allowed " + this.maxPlayers + " players");
            registerPlayers();
        }

         while(this.players.size() < totalPlayers) {
            String playerName = ui.promptText("Tast spiller navn");
            this.createPlayer(playerName, 0);
         }

         Collections.shuffle(this.players);
        }

    // _______________________________________________________________

    private void createPlayer(String name, int score){
        Player p = new Player(name, score);
        players.add(p);
    }

    // _______________________________________________________________

    public void displayPlayers(){
        for(Player p:players){
            System.out.println(p);
        }

    }

    // _______________________________________________________________

    public void endSession() {
        ArrayList<String> playerData = new ArrayList<>();

        System.out.println("\nSpillet afsluttes.. Tak for spillet!");

        //serialiserer player objekterner
        for(Player p: players){

          String s = p.toString();
          playerData.add(s);

      }
        //Test om promptChoice virker
        //ui.displayList(ui.promptChoice(playerData, 3, "vælg en spiller"), "Din spiller liste");
        io.saveData(playerData, "data/playerData.csv", "Name, Score");
    }

    // _______________________________________________________________

    public void runGameLoop(){
        int counter = 0;
        boolean continueGame = true;

        while(continueGame){
            currentPlayer=players.get(counter);
            ui.displayMessage("It's this players turn to pick: "+currentPlayer.getName());
            this.throwAndMove();
            // true : false
            counter = counter == players.size()-1 ? 0 : counter+1;

            continueGame = ui.promptBinary("Fortsæt..? Y/N");

        }

    }

    // _______________________________________________________________

    private void throwAndMove(){


    }

    // _______________________________________________________________

    private void landAndAct(){

    }


}
