package main;

/**
 * Context for State design pattern
 */
public class Context {
    private ActiveScreen activeScreen;

    public Context(ActiveScreen activeScreen) {
        this.activeScreen = activeScreen;
    }

    /**
     * Calls init() for the current State
     */
    public void start() {
        activeScreen.init(this);
    }

    /**
     * Updates current State and calls start()
     */
    public void switchActiveScreen(ActiveScreen activeScreen) {
        this.activeScreen = activeScreen;
        System.out.println("\n\n");
        start();
    }
}