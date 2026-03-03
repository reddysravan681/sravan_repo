import java.util.Scanner;

public class GameEngine {

    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {

        System.out.print("Enter your hero name: ");
        String name = scanner.nextLine();

        player = new Player(name);

        System.out.println("Welcome, " + player.getName() + "!");

        while (player.isAlive()) {
            Enemy enemy = new Enemy("Goblin", 50, 15, 25);
            battle(enemy);
        }

        System.out.println("💀 Game Over!");
    }

    private void battle(Enemy enemy) {

        System.out.println("\n⚔ A wild " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("\n1. Attack");
            System.out.println("2. Run");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                player.attack(enemy);

                if (enemy.isAlive()) {
                    enemy.attack(player);
                } else {
                    player.gainXP(enemy.getXpReward());
                }

            } else if (choice == 2) {
                System.out.println("You ran away!");
                return;
            }
        }
    }
}
