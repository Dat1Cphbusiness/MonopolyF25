import java.util.ArrayList;
import java.util.Collections;


public class Game {
    static TextUI ui = new TextUI();
    static FileIO io = new FileIO();

    Dice dice = new Dice();
    private String name;
    private int maxPlayers ;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private String cardDataPath = "data/carddata.csv";
    private String fieldDataPath = "data/fielddata.csv";
    private Board board;

    public Game(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }


    public void startSession(){
        ArrayList<String> data = io.readData("data/playerData.csv");
        ui.displayMessage("Velkommen til "+ this.name);

        if (!data.isEmpty() && ui.promptBinary("Gammel data fundet, vil du fortsætte herfra?: Y/N")) {
            for(String s : data){
              String[] values =  s.split(",");//  "tess, 0"
                int score = Integer.parseInt(values[1].trim());
               createPlayer(values[0],score);
            }

        }else{

            registerPlayers();
        }
        displayPlayers();
        //BUILD THE BOARD
        buildBoard();
    }

    public void buildBoard(){
        //
        currentPlayer = players.get(0);
        String[] fielddata = io.readData("data/fielddata.csv",40);
        String[] carddata = io.readData("data/carddata.csv",44);
        board = new Board(fielddata,carddata);
        Field f = board.getField(11);
        System.out.println(f.onLand(currentPlayer));
        System.out.println(Chance.cardDeck.getNext().getMessage());
    }
    public void registerPlayers(){

        int totalPlayers = 0;

        totalPlayers = ui.promptNumeric("Tast antal spillere:");       //Konvertere svaret til et tal

    if(totalPlayers > this.maxPlayers || totalPlayers < 2){ // vi kan evt. udvide promptNumeric med parametre til og min og max værdier (eller bruge overloading)
        ui.displayMessage("Antal spillere skal være mindst 2 og højest "+ this.maxPlayers);
        registerPlayers();
        return;
    }

     while(this.players.size() < totalPlayers) {
        String playerName = ui.promptText("Tast spiller navn");
        this.createPlayer(playerName, 0);
     }

     Collections.shuffle(this.players);
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

    public void runGameLoop() {
        int count = 0;
        boolean continueGame = true;

        while (continueGame) {
            if (count == players.size()) {
                count=0;
            }
            currentPlayer = players.get(count);
            this.throwAndMove();
            count++;
            continueGame = ui.promptBinary("Fortsæt? (Y/N): ");
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
        ui.displayMessage("Spillet er gemt og afsluttet.");
    }

    private void throwAndMove() {
        ui.displayMessage("Det er: " + currentPlayer.getName() + "s tur");
        int result = dice.rollDiceSum();
        ui.displayMessage(currentPlayer.getName()+" slog "+result );
        int newPosition = currentPlayer.updatePostion(result);
         Field f = board.getField(newPosition);
        System.out.println(f.onLand(currentPlayer));


    }

    private void landAndAct() {

    }

}
