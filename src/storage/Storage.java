package storage;

import main.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton
 */
public class Storage {
    private static Storage instance;
    private final File saveFile = new File("saveFile.txt");
    private final List<String> newRecords;

    private Storage() {
        newRecords = new ArrayList<>();
    }

    public void save() {
        try {
            FileWriter fileWriter = new FileWriter(saveFile, true);
            for (String record : newRecords)
                fileWriter.write(record);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(Player player, Integer defeatedEnemies) {
        newRecords.add("Name: " + player.getName() + ", Defeated Enemies: " + defeatedEnemies + ", Acquired Souls: " + player.getTotalAcquiredSouls() + "\n");
    }

    /**
     * Returns the only existing instance
     *
     * @return instance : Storage
     */
    public static Storage getInstance() {
        if (instance == null)
            instance = new Storage();
        return instance;
    }
}