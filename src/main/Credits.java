package main;

public class Credits implements ActiveScreen {
    private void printContents() {
        System.out.println("Credits");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    @Override
    public void init() {
        printContents();
    }
}