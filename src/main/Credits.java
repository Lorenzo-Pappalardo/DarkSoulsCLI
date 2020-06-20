package main;

public class Credits implements ActiveScreen {
    private void printContents() {
        System.out.println("Credits");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void getBackToMainMenu(Context context) {
        context.switchActiveScreen(new MainMenu());
    }

    @Override
    public void init(Context context) {
        printContents();
        getBackToMainMenu(context);
    }
}