package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Storage {
    private Storage instance;
    private FileReader scores;

    private Storage() throws FileNotFoundException {
        if (instance == null)
            instance = new Storage();
        scores = new FileReader(new File("scores.txt"));
    }
}