package main;

public class Exit implements ActiveScreen {
    @Override
    public void init() {
        System.out.println("Quitting Game...");
        System.exit(0);
    }
}