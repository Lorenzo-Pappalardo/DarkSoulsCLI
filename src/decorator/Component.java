package decorator;

import enemies.Enemy;

/**
 * Component for Decorator design pattern
 */
public interface Component {
    /**
     * Gets user input and sets Player's name
     *
     * @return name : String
     */
    String inputName();

    /**
     * Return Player's name
     *
     * @return name : String
     */
    String getName();

    /**
     * Prints information about a Player
     */
    void printInfo();

    /**
     * Return Player's health
     *
     * @return health : Float
     */
    Float getHealth();

    /**
     * Decreases Player's health
     */
    void decreaseHealth(Float value);

    /**
     * Checks id the Player died
     *
     * @return Boolean
     */
    Boolean isDead();

    /**
     * Executes attack
     */
    void attack(Enemy enemy, Float damage);

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
