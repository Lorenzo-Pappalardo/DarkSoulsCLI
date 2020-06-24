package screens;

import storage.Storage;

public class Exit implements ActiveScreen {
    private void save() {
        Storage.getInstance().save();
    }

    @Override
    public void init() {
        System.out.println("Saving scores...");
        save();
        System.out.println("Quitting Game...");
        System.exit(0);
    }
}