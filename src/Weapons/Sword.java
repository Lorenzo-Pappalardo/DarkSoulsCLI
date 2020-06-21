package Weapons;

/**
 * Concrete Product for Factory Method design pattern
 */
public class Sword implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public Sword() {
        name = "Sword";
        damage = 25;
        critMultiplier = 1.5f;
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