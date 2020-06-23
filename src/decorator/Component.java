package decorator;

/**
 * Component for Decorator design pattern
 */
public interface Component {
    /**
     * Increases Player's health
     */
    void upgradeHealth(Integer defeatedEnemies);

    /**
     * Increases Player's damage output
     */
    void upgradeDamageOutput(Integer defeatedEnemies);

    /**
     * Increases Player's souls
     */
    void upgradeSouls(Integer defeatedEnemies);
}
