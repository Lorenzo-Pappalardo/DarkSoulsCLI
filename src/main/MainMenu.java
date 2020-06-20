package main;

import java.util.Scanner;

public class MainMenu implements ActiveScreen {
    private void printContents() {
        System.out.println("Main Menu");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
        System.out.println("(1) New Game");
        System.out.println("(2) Show Scores");
        System.out.println("(3) Show Credits");
        System.out.println("(4) Exit");
    }

    private ActiveScreen getChoice() {
        System.out.print("\nYour choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1)
            return new Game();
        else if (choice == 2)
            return new Scores();
        else if (choice == 3)
            return new Credits();
        else if (choice == 4)
            return new Exit();
        else {
            System.err.println("Wrong choice, try again!");
            return getChoice();
        }
    }

    public void init(Context context) {
        printContents();
        context.switchActiveScreen(getChoice());
    }
}