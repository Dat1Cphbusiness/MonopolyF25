import java.util.ArrayList;
import java.util.Collections;


public class Game {
    static TextUI ui = new TextUI();
    static FileIO io = new FileIO();
    private String name;
    private int maxPlayers;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private int minPlayers;

    public Game(String name, int minPlayers, int maxPlayers) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>();

    }


    public void startSession() {
        ArrayList<String> data = io.readData("data/playerData.csv");
        ui.displayMessage("Velkommen til " + this.name);

        if (!data.isEmpty() && ui.promptBinary("Vil du fortsætte fra sidste gemte spil: Y/N")) {
            for (String s : data) {
                String[] values = s.split(",");//  "tess, 0"
                int score = Integer.parseInt(values[1].trim());
                createPlayer(values[0], score);
            }

        } else {

            registerPlayers();
        }
        displayPlayers();
    }


    public void registerPlayers() {

        int totalPlayers = 0;

        try {
            totalPlayers = ui.promptNumeric("Indtast antal spillere:");       //Konvertere svaret til et tal
        } catch (NumberFormatException e) {
            ui.displayMessage("Vær venlig at skrive et tal imellem " + minPlayers + " og " + maxPlayers);
            registerPlayers();
            return;
        }


        if (totalPlayers > this.maxPlayers || totalPlayers < this.minPlayers) {
            System.out.println("Vær venlig at skrive et tal imellem" + minPlayers + " og " + maxPlayers);
            registerPlayers();
        }

        while (this.players.size() < totalPlayers) {
            String playerName = ui.promptText("Tast spillernavn");
            this.createPlayer(playerName, 0);
        }

        Collections.shuffle(this.players);
    }


    private void createPlayer(String name, int score) {
        Player p = new Player(name, score);
        players.add(p);
    }

    public void displayPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }

    }

    public void endSession() {
        ArrayList<String> playerData = new ArrayList<>();

        //serialiserer player objekterner
        for (Player p : players) {

            String s = p.toString();
            playerData.add(s);

        }
        //Test om promptChoice virker
        //ui.displayList(ui.promptChoice(playerData, 3, "vælg en spiller"), "Din spiller liste");
        io.saveData(playerData, "data/playerData.csv", "Name, Score");
        ui.displayMessage("Spillet afsluttes");
    }


    public void runGameLoop() {
        int count = 0;
        boolean continueGame = true;

        while (continueGame) {
            if (count == players.size()) {
                count = 0;
            }

            currentPlayer = players.get(count);
            throwAndMove();
            count++;
            continueGame = ui.promptBinary("Fortsæt? (Y/N)");
        }

    }

    private void throwAndMove() {
        ui.displayMessage("Det er " + currentPlayer.getName() + "'s tur");
    }

    private void landAndAct() {

    }

}
