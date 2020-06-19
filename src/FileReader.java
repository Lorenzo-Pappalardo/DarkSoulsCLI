import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private FileReader instance;
    private Scanner players;

    private FileReader() {
        if (instance == null)
            instance = new FileReader();
    }

    public void getPlayersProfiles() throws FileNotFoundException {
        if (players == null)
            players = new Scanner(new File("players.txt"));
    }
}
