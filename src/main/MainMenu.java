package main;

public class MainMenu {
    public static void main(String[] args) {
        MainMenu mm = new MainMenu();
        Player player = Player.getInstance();
        player.printInfo();
        mm.exit();
    }

    public void start() {
    }

    public void exit() {
        System.out.println("Quitting game...");
        System.exit(0);
    }
}
