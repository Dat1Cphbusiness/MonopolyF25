import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
   static TextUI ui = new TextUI();
   static FileIO io = new FileIO();

    private String name;
    private String currentPlayer;
    private int maxPlayers;
    private ArrayList<Player> players;

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }

    public void startSession(){
        ArrayList<String> data = io.readData("data/playerData.csv");
        ui.displayMessage("Velkommen til "+ this.name);

        if(!data.isEmpty() && ui.promptBinary("Would your like to continue previous game: Y/N")){
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



    public void registerPlayers(){
        int playerNum = 0;
        try {
            playerNum = ui.promptNumeric("Tast antal deltagere: 2-6");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
            registerPlayers();
        }

     if(playerNum>=2&&playerNum<=this.maxPlayers){
         while(this.players.size() < playerNum) {

             String playerName = ui.promptText("Tast spiller navn");
             this.createPlayer(playerName, 0);
         }
     } else {
         ui.displayMessage("Ugyldigt antal deltagere, prøv igen!");
         registerPlayers();
     }
        Collections.shuffle(players);


    }


    private void createPlayer(String name, int score){
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers(){
        for(Player p:players){
            System.out.println(p);
        }

    }

    public void endSession() {
        ArrayList<String> playerData = new ArrayList<>();

     //serialiserer player objekterner
        for(Player p: players){

          String s = p.toString();
          playerData.add(s);

      }
        //Test om promptChoice virker
        //ui.displayList(ui.promptChoice(playerData, 3, "vælg en spiller"), "Din spiller liste");
        io.saveData(playerData, "data/playerData.csv", "Name, Score");
    }
    public void runGameLoop(){
        currentPlayer = players.get(0).getName();
        ui.displayMessage("Det er "+ currentPlayer+"'s tur");
    }

}
