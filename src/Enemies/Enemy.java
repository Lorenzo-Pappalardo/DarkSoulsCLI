package Enemies;

/**
 * Product interface for Factory Method design pattern
 */
public interface Enemy {
    /**
     * Prints info about an Enemy
     */
    void printInfo();

    /**
     * Enemy attacks
     */
    void attack();

    /**
     * Enemy blocks
     */
    void block();
}
