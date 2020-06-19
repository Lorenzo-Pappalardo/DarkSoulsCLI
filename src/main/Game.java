package main;

public class Game implements ActiveScreen {
    private void printContents() {
        System.out.println("Game");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    @Override
    public void init(Context context) {
        printContents();
        // Player player = Player.getInstance();
        // player.printInfo();
    }
}