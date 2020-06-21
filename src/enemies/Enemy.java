package enemies;

/**
 * Product interface for Factory Method design pattern
 */
public interface Enemy {
    /**
     * Prints info about an Enemy
     */
    String getName();

    /**
     * Returns current Enemy's health
     */
    Float getHealth();

    /**
     * Decreases Enemy's health by the amount of damage taken
     */
    void updateHealth(Float damage);

    /**
     * Checks if the Enemy died and returns the result
     */
    Boolean isDead();

    /**
     * Enemy attacks
     */
    Integer attack();

    /**
     * Enemy blocks
     */
    Boolean block();
}
