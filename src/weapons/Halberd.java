package weapons;

public class Halberd implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public Halberd() {
        name = "Halberd";
        damage = 26;
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
