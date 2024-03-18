public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int worth;
    private int originalHealth;
    public Obstacle(int id, String name, int damage, int health, int worth) {
        this.id = id;
        this.worth = worth;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.originalHealth = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
