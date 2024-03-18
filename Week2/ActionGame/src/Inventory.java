public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean food;
    private boolean firewood;
    private boolean water;

    public Inventory(boolean water, boolean food, boolean firewood) {
        this.weapon = new Weapon("Fist", -1 , 0, 0);
        this.armor = new Armor(-1, "None", 0,0);
        this.water = water;
        this.food = food;
        this.firewood = firewood;

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean getFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean getFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean getWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
