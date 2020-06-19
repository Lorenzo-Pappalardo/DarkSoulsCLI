package main;

public class Context {
    private ActiveScreen activeScreen;

    public Context(ActiveScreen activeScreen) {
        this.activeScreen = activeScreen;
    }

    public void start() {
        activeScreen.init(this);
    }

    public void switchActiveScreen(ActiveScreen activeScreen) {
        this.activeScreen = activeScreen;
        start();
    }
}