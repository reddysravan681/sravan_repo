public class Enemy extends Character {

    private int xpReward;

    public Enemy(String name, int health, int attackPower, int xpReward) {
        super(name, health, attackPower);
        this.xpReward = xpReward;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks!");
        target.takeDamage(attackPower);
    }

    public int getXpReward() {
        return xpReward;
    }
}
