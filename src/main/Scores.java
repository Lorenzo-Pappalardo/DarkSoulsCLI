package main;

public class Scores implements ActiveScreen {
    private void printContents() {
        System.out.println("Scores");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    @Override
    public void init(Context context) {
        printContents();
    }
}