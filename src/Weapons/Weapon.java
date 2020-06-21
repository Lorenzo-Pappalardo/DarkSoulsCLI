package weapons;

/**
 * Product interface for Factory Method design pattern
 */
public interface Weapon {
    /**
     * Returns a weapon's name
     */
    String getName();

    /**
     * Returns the damage dealt by a weapon
     *
     * @return damage : Integer
     */
    Integer getDamage();

    /**
     * Returns the crit multiplier to be applied to the basic damage of a weapon
     *
     * @return crit multiplier : Integer
     */
    Float getCritMultiplier();
}
