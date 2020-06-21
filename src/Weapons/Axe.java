package weapons;

/**
 * Concrete Product for Factory Method design pattern
 */
public class Axe implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public Axe() {
        name = "Axe";
        damage = 22;
        critMultiplier = 1.3f;
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
