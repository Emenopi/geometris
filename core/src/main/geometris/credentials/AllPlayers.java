package main.geometris.credentials;

import main.geometris.credentials.Player;
import main.geometris.credentials.ReadDelimitedFile;

import java.util.*;

public class AllPlayers {
    private final List<Player> listOfPlayers = new ArrayList<Player>();
    private boolean playersLoaded = false;

    private List<String[]> loadRawPlayers(){
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        return readDelimitedFile.getFileData("players.csv");

    }

    private void loadAsPlayers(){
        List<String[]> rawPlayers = loadRawPlayers();
        for (String[] rawPlayer : rawPlayers) {
            listOfPlayers.add( new Player(rawPlayer[0],rawPlayer[1],rawPlayer[2],rawPlayer[3], rawPlayer[4]));
        }
        playersLoaded = true;
    }
    public List<Player>  getListOfPlayers() {
        if (! playersLoaded){
            loadAsPlayers();
        }
        return listOfPlayers;
    }

    public Map<String, Integer> getScoreList() {
        Map<String, Integer> scoreList = new HashMap<>();
        if (! playersLoaded) {
            loadAsPlayers();
        }
        for (Player player : listOfPlayers) {
            scoreList.put(player.getName(), Integer.valueOf(player.getScore()));
        }
        return scoreList;
    }

}