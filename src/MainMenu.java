import com.sun.tools.javac.Main;

public class MainMenu {
    public static void main(String[] args) {
        MainMenu mm = new MainMenu();
        mm.exit();
    }

    public void start() {}

    public void exit() {
        System.out.println("Quitting game...");
        System.exit(0);
    }
}
