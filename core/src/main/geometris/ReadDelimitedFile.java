package main.geometris;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDelimitedFile {

    private String fileDelimiter = ",";

    public void setFileDelimiter(String fileDelimiter){
        this.fileDelimiter = fileDelimiter;
    }

    public List<String[]> getFileData(String fileName){
        List<String[]> fileData = new ArrayList<String[]>();
        try {
            String filePathPrefix = "../core/src/main/resources/";
            File propertyFile = new File(filePathPrefix + fileName);
            Scanner propertyReader = new Scanner(propertyFile);
            while (propertyReader.hasNextLine()) {
                String fileRow = propertyReader.nextLine();
                fileData.add(fileRow.split(fileDelimiter));
            }
            propertyReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileData;
    }

    public void addNewPlayer(Player player) {
        String filePathPrefix = "../core/src/main/resources/";
        File file = new File(filePathPrefix + "players.csv");
        try {
            // add new player to csv file
            FileWriter playersFile = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(playersFile, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
            String[] newPlayer = { player.getEmailAddress(), player.getFirstName(), player.getLastName(), player.getPassword(), "0" };
            writer.writeNext(newPlayer);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
