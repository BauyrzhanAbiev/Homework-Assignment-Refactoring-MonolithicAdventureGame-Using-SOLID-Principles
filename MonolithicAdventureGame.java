import java.util.ArrayList;
import java.util.List;

public class MonolithicAdventureGameRefactored {
    public static void main(String[] args) {
        Player player = new Player();
        Enemy monster = new Enemy("Ghoul", 10);
        Item sword = new Item("Katana");
        CombatManager combatManager = new CombatManager();
        LevelManager levelManager = new LevelManager();
        levelManager.loadLevel(1);
        player.pickUpItem(sword);
        combatManager.engageCombat(player,monster);
    }
}
public class Player implements IDamageable, IItemInteractable {
    private int health;
    private int experience;
    private List<Item> inventory;
    public Player() {
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("Player has died");
        }
    }
    public void pickUpItem(Item item) {
        inventory.add(item);
        System.out.println("Picked up: " + item.getName());
    }
}
class Enemy implements IAttackable {
    private String type;
    private int damage;
    public Enemy(String type, int damage) {
        this.type = type;
        this.damage = damage;
    }
    public void attack(Player player) {
        player.takeDamage(damage);
        System.out.println(type + " attacked the player " + damage + " damage");
    }
}
public class Item {
    private String name;
    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class CombatManager {
    public void engageCombat(Player player, IAttackable enemy) {
        enemy.attack(player);
    }
}
public class LevelManager {
    public void loadLevel(int level) {
        System.out.println("Loading level " + level);
    }
}
public interface IAttackable {
    void attack(Player player);
}
public interface IDamageable {
    void takeDamage(int damage);
}
public interface IItemInteractable {
    void pickUpItem(Item item);
}
