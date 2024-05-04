package main.geometris;

import java.util.ArrayList;
import java.util.List;

public class AllPlayers {
    private List<Player> listOfPlayers = new ArrayList<Player>();
    private boolean playersLoaded = false;

    private List<String[]> loadRawPlayers(){
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        return readDelimitedFile.getFileData("players.csv");
    }

    private List<Player>  loadAsPlayers(){
        List<String[]> rawPlayers = loadRawPlayers();
        for (String[] rawPlayer : rawPlayers) {
            listOfPlayers.add( new Player(rawPlayer[0],rawPlayer[1],rawPlayer[2],rawPlayer[3], rawPlayer[4]));
        }
        playersLoaded = true;
        return listOfPlayers;
    }
    public List<Player>  getListOfPlayers() {
        if (! playersLoaded){
            loadAsPlayers();
        }
        return listOfPlayers;
    }

}
