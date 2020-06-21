package weapons;

/**
 * Concrete Product for Factory Method design pattern
 */
public class Club implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public Club() {
        name = "Club";
        damage = 20;
        critMultiplier = 1.1f;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getDamage() {
        return damage;
    }

    @Override
    public Float getCritMultiplier() {
        return critMultiplier;
    }
}
