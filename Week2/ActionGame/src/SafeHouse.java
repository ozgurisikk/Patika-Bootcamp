public class SafeHouse extends NormalLocation{

    public SafeHouse(Player p) {
        super(p, "Safe House");
    }

    @Override
    public boolean onLocation() {
        if ((this.getPlayer().getInventory().getWater() == true) && (this.getPlayer().getInventory().getFirewood() == true ) && (this.getPlayer().getInventory().getFood() == true)) {
            System.out.println("You have completed the journey with success. Regards...");
            System.exit(0);
            return false;
        }else {

            System.out.println("You are in the safe house and your health have replenished!");
            this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
            return true;
        }
    }

}
