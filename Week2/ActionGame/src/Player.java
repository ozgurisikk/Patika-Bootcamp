import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String warriorType;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory(false, false,false);

    }

    public void selectWarrior(){
        System.out.println("Please select your character with its ID: ");
        WarriorClass[] warriorList = {new Samuray(), new Archer(), new Knight()};

        for (WarriorClass warrior : warriorList){
            System.out.println("Character ID: " + warrior.getId() + "\t" + " Type " + warrior.getName()+ " Damage: " + warrior.getDamage() + " Health: " + warrior.getHealth() + " Money: " + warrior.getMoney());
        }
        System.out.println("---------------------------");

        int choice = input.nextInt();
        switch(choice){
            case 1 :
                initPlayer(new Samuray());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default :
                initPlayer(new Samuray());
        }
        //System.out.println("Your fighter is " + this.getWarriorType() + " with stats: \t Damage " + this.getDamage() + " \t Health: "  + this.getHealth() + " \t Money: " + this.getMoney());
    }
 
    public void initPlayer(WarriorClass type){
        this.setDamage(type.getDamage());
        this.setHealth(type.getHealth());
        this.setOriginalHealth(type.getHealth());
        this.setMoney(type.getMoney());
        this.setWarriorType(type.getName());
    }

    public void printInfo(){
        System.out.println("Your fighter is " + this.getWarriorType() +
                " -- Your weapon is " + this.getInventory().getWeapon().getName() +
                " with stats: Damage " + this.getDamage() +
                " armor is " + this.getInventory().getArmor().getName() +
                " with block " + this.getInventory().getArmor().getBlock() +
                " == Health: "  + this.getHealth() +
                " == Money: " + this.getMoney());

    }

    public int getDamage() {
        return damage;
    }
    public int getTotalDamage(){
        return damage + getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 ){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarriorType() {
        return warriorType;
    }

    public void setWarriorType(String warriorType) {
        this.warriorType = warriorType;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
