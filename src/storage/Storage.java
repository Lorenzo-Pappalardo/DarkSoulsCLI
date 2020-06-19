package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Storage {
    private Storage instance;
    private Reader scoresReader;

    private Storage() {
        try {
            scoresReader = new FileReader(new File("scores.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't open or create file");
            System.exit(1);
        }
    }

    public Storage getInstance() {
        if (instance == null)
            instance = new Storage();
        return instance;
    }
}