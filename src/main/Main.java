package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ActiveScreen activeScreen = new MainMenu();
        activeScreen.printTitle();
        activeScreen.printContents();
        int choice = setScreen();
        while (choice != 3) {
        }
        System.out.println("Quitting game...");
        System.exit(0);
    }

    private static int setScreen() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
