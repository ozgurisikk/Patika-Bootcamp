import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player p, String locationName, Obstacle obstacle, String award, int maxObstacle) {
        super(p, locationName);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    public boolean onLocation() {

        int obsNum = randomObstacleNum();
        System.out.println("You are at " + this.getLocationName());
        System.out.println("There are " + obsNum + " " + this.getObstacle().getName() + "s on this area!");
        System.out.println("(F)ight or (E)scape ?");
        String combatChoice = input.nextLine().toUpperCase();
        if (combatChoice.equals("F")){
            if (combat(obsNum)){

                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println("You are dead.");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNum){

            for (int i = 1; i <= obsNum; i++) {
                this.getObstacle().setHealth((this.getObstacle().getOriginalHealth()));
                playerStats();
                obstacleStats(i);
                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                    System.out.println("(H)it or (E)scape");
                    String combatChoice = input.nextLine().toUpperCase();

                    if (combatChoice.equals("H")) {
                        if (Math.random() < 0.5) {
                            System.out.println("Player hit!");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                            if (this.getObstacle().getHealth() > 0) {
                                System.out.println();
                                System.out.println(this.getObstacle().getName() + " hit you!");
                                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                                if (obstacleDamage < 0) {
                                    obstacleDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                                afterHit();
                            }

                        } else {
                            System.out.println(this.getObstacle().getName() + " hit you!");

                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                            if (this.getPlayer().getHealth() > 0) {
                                System.out.println();
                                System.out.println("Player hit!");
                                this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                                afterHit();

                            }
                        }
                    }
                }
                if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                    System.out.println("------------------");
                    System.out.println(this.getLocationName() + " is clean now.");
                    System.out.println((this.getObstacle().getWorth() * obsNum) + " Coin earned.");
                    this.getPlayer().setMoney(this.getObstacle().getWorth() + this.getPlayer().getMoney());
                    System.out.println("New balance is: " + this.getPlayer().getMoney());



                }
                checkReward();
            }
        return false;
    }

    public void checkReward(){
        if (this.getObstacle().getName().equals("Zombie")){
            this.getPlayer().getInventory().setFood(true);
        }
        if (this.getObstacle().getName().equals("Vampire")){
            this.getPlayer().getInventory().setFirewood(true);
        }
        if (this.getObstacle().getName().equals("Bear")){
            this.getPlayer().getInventory().setWater(true);
        }
        if (this.getObstacle().getName().equals("Snake")){
            int loopOne = (int)(Math.random() * 100);
            int loopTwo = (int)(Math.random() * 100);
            int loopThree = (int)(Math.random() * 100);

            if (loopOne <= 45 ){
                System.out.println("You could not win anything!");
            }else if (loopTwo > 45 && loopTwo < 60){
                if (loopThree < 20 ){
                    this.getPlayer().getInventory().setWeapon(new Weapon("Shotgun", 3,7,45));
                    System.out.println("You won weapon ! Your new weapon is " + this.getPlayer().getInventory().getWeapon().getName());
                }
                if (loopThree > 20 && loopThree <= 50){
                    this.getPlayer().getInventory().setWeapon(new Weapon("Sword", 2,3,35));
                    System.out.println("You won weapon ! Your new weapon is " + this.getPlayer().getInventory().getWeapon().getName());
                }
                if (loopThree > 50){
                    this.getPlayer().getInventory().setWeapon(new Weapon("Pistol", 1,2,5));
                    System.out.println("You won weapon ! Your new weapon is " + this.getPlayer().getInventory().getWeapon().getName());

                }
            }else if (loopTwo > 60 && loopTwo < 75){
                if (loopThree < 20 ){
                    this.getPlayer().getInventory().setArmor(new Armor(3, "Heavy",5,40));
                    System.out.println("You won armor ! Your new armor is " + this.getPlayer().getInventory().getArmor().getName());
                }
                if (loopThree > 20 && loopThree <= 50){
                    this.getPlayer().getInventory().setArmor(new Armor(2, "Medium",3,25));
                    System.out.println("You won armor ! Your new armor is " + this.getPlayer().getInventory().getArmor().getName());

                }
                if (loopThree > 50){
                    this.getPlayer().getInventory().setArmor(new Armor(1, "Light",1,5));
                    System.out.println("You won armor ! Your new armor is " + this.getPlayer().getInventory().getArmor().getName());

                }
            }else {
                if (loopThree < 20){
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                    System.out.println("You won 10 coins ! Your new balance is " + this.getPlayer().getMoney());
                }
                if (loopThree > 20 && loopThree < 50){
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                    System.out.println("You won 5 coins ! Your new balance is " + this.getPlayer().getMoney());

                }
                if (loopThree > 50){
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                    System.out.println("You won 1 coin ! Your new balance is " + this.getPlayer().getMoney());
                }
            }
        }
    }

    public void afterHit(){
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Health is " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Player Stats");
        System.out.println("-------------");
        System.out.println("Health: " + getPlayer().getHealth());
        System.out.println("Damage: " + getPlayer().getTotalDamage());
        System.out.println("Armor : " + getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : " + getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i){
        System.out.println(i + "." + this.getObstacle().getName() + " Stats:");
        System.out.println("-----------------");
        System.out.println("Health : " + getObstacle().getHealth());
        System.out.println("Damage : " + getObstacle().getDamage());
        System.out.println("Worth  : " + getObstacle().getWorth());

    }
    public int randomObstacleNum(){
        Random r = new Random();
        return r.nextInt(getMaxObstacle()) + 1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
