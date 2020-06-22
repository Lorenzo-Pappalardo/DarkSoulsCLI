package enemies;

/**
 * Product interface for Factory Method design pattern
 */
public interface Enemy {
    /**
     * Returns an Enemy's name
     *
     * @return name : String
     */
    String getName();

    /**
     * Checks if an Enemy is a Boss
     *
     * @return Boolean
     */
    Boolean isBoss();

    /**
     * Returns an Enemy's current health
     *
     * @return health : Float
     */
    Float getHealth();

    /**
     * Decreases an Enemy's health by the amount of damage taken
     */
    void updateHealth(Float damage);

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
    Integer attack();

    /**
     * Checks if a Enemy blocks
     *
     * @return Boolean
     */
    Boolean block();
}
