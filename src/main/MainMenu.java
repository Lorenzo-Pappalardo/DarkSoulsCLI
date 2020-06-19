package main;

public class MainMenu implements ActiveScreen {
    @Override
    public void printTitle() {
        System.out.println("Main Menu");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    @Override
    public void printContents() {
        System.out.println("(1) New Game");
        System.out.println("(2) Show Credits");
        System.out.println("(3) Quit");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
    }

    public void init() {
        Player player = Player.getInstance();
        player.printInfo();
    }
}