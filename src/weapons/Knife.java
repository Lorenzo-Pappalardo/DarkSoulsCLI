package weapons;

/**
 * Concrete Product for Factory Method design pattern
 */
public class Knife implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public Knife() {
        name = "Knife";
        damage = 18;
        critMultiplier = 2f;
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