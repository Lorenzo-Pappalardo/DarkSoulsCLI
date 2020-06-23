package decorator;

public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void upgradeHealth(Integer defeatedEnemies) {
        component.upgradeHealth(defeatedEnemies);
    }

    @Override
    public void upgradeDamageOutput(Integer defeatedEnemies) {
        component.upgradeDamageOutput(defeatedEnemies);
    }

    @Override
    public void upgradeSouls(Integer defeatedEnemies) {
        component.upgradeSouls(defeatedEnemies);
    }
}
