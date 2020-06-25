package weapons;

public class GreatHammer implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public GreatHammer() {
        name = "Great Hammer";
        damage = 27;
        critMultiplier = 1f;
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
