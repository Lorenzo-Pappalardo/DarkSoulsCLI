package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Storage {
    private Storage instance;
    private FileReader saveFile;

    private Storage() throws FileNotFoundException {
        if (instance == null)
            instance = new Storage();
        saveFile = new FileReader(new File("saveFile.txt"));
    }
}