package screens;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Concrete State for design pattern State
 */
public class Scores implements ActiveScreen {
    private void printContents() {
        System.out.println();
        System.out.println("Scores");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void readScores() {
        File saveFile = new File("saveFile.txt");
        if (saveFile.exists()) {
            try {
                FileReader reader = new FileReader(saveFile);
                LineNumberReader lineNumberReader = new LineNumberReader(reader);
                while (lineNumberReader.ready())
                    System.out.println(lineNumberReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            System.err.println("No saveFile found!");
    }

    @Override
    public void init() {
        printContents();
        readScores();
    }
}