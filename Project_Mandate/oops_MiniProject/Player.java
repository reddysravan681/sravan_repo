public class Player extends Character {

    private int level;
    private int experience;

    public Player(String name) {
        super(name, 100, 20);
        this.level = 1;
        this.experience = 0;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks!");
        target.takeDamage(attackPower);
    }

    public void gainXP(int xp) {
        experience += xp;
        System.out.println(name + " gained " + xp + " XP!");

        if (experience >= 50) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        attackPower += 5;
        health += 20;
        experience = 0;

        System.out.println("🔥 LEVEL UP! Now Level " + level);
    }
}
