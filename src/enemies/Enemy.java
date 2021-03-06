package enemies;

/**
 * Product interface for Factory Method design pattern
 */
public interface Enemy {
    /**
     * Prints Enemy name and health
     */
    void printInfo();

    /**
     * Returns an Enemy's current health
     *
     * @return health : Float
     */
    Float getHealth();

    /**
     * Decreases an Enemy's health by the amount of damage taken
     */
    void decreaseHealth(Float damage);

    /**
     * Checks if an Enemy is a Boss
     *
     * @return Boolean
     */
    Boolean isBoss();

    /**
     * Checks if an Enemy died and returns the result
     *
     * @return Boolean
     */
    Boolean isDead();

    /**
     * Returns the damage an Enemy has inflicted
     *
     * @return damage : Integer
     */
    Float attack();
}
