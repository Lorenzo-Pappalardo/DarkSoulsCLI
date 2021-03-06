package screens;

public class Credits implements ActiveScreen {
    private void printScreenTitle() {
        System.out.println();
        System.out.println("Credits");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void creditsBody() {
        System.out.println("Game developed by Lorenzo Pappalardo");
        System.out.println("Inspired by Dark Souls, a game by FromSoftware");
    }

    @Override
    public void init() {
        printScreenTitle();
        creditsBody();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}