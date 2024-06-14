public class ToolStore extends NormalLocation{

    public ToolStore(Player p) {
        super(p, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the ToolStore Shop!");
        boolean showMenu = true;
        while(showMenu){System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Leave");
            System.out.print("Your choice: ");
            int locChoice = input.nextInt();
            while(locChoice < 1 || locChoice > 3){
                System.out.print("Please enter a valid value: ");
                locChoice = input.nextInt();
            }
            switch (locChoice){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("You are leaving the shop.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("------------WEAPONS------------");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + " || Damage: " + w.getDamage() + " Price: " + w.getPrice());
        }
        System.out.println("0 - Leave ");
    }

    public void buyWeapon(){
        System.out.print("Your choice ID: ");
        int  selectWeaponID= input.nextInt();
        while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.print("Please enter a valid value: ");
            selectWeaponID= input.nextInt();
        }
        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if(selectedWeapon != null ){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You don't have enough money");
                }else{
                    System.out.println(selectedWeapon.getName() + " is bought.");
                    int updateMoney = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(updateMoney);
                    System.out.println("Your new balance is: " + this.getPlayer().getMoney());
                    System.out.println("The old weapon was: " + getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("The new equipped weapon is: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("------------ARMORS------------");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + " || Block: " + a.getBlock() + " Price: " + a.getPrice());
        }
        System.out.println("0 - Leave ");

    }

    public void buyArmor(){
        System.out.print("Your choice ID: ");
        int selectArmorID = input.nextInt();
        while(selectArmorID < 0 || selectArmorID > Armor.armors().length){
            System.out.print("Please enter a valid value: ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You don't have enough money");
                }else{
                    System.out.println(selectedArmor.getName() + " is bought.");
                    int updateMoney = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(updateMoney);
                    System.out.println("Your new balance is: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new equipped armor is " + this.getPlayer().getInventory().getArmor().getName() + " and adds " + this.getPlayer().getInventory().getArmor().getBlock() + " protection");
                }
            }
        }



    }

}
