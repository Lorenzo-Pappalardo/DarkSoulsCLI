package main;

public class Exit implements ActiveScreen {
    @Override
    public void init(Context context) {
        System.out.println("Quitting Game...");
        System.exit(0);
    }
}