import java.io.FileReader;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to the game!");
        System.out.print("Enter a name: ");
        String playerName = input.nextLine();
        Player p1 = new Player(playerName);
        System.out.println(p1.getName() + " HAS STARTED ADVENTURE !");

        p1.selectWarrior();

        Location location = null;
            while (true) {
                p1.printInfo();
                System.out.println();
                System.out.println("--------------------Areas--------------------");
                System.out.println();
                System.out.println("0- Quit Game \n" +
                        "1- Safe House \n" +
                        "2- Shop \n" +
                        "3- Cave (food) \n" +
                        "4- Forest (firewood)\n" +
                        "5- River (water)\n" +
                        "6- Mines");
                System.out.println(p1.getInventory().getFood());
                System.out.println(p1.getInventory().getWater());
                System.out.println(p1.getInventory().getFirewood());
                System.out.print("Please select the are that you are going: ");
                int selectedLocation = input.nextInt();

                switch (selectedLocation) {
                    case 0:
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(p1);
                        break;
                    case 2:
                        location = new ToolStore(p1);
                        break;
                    case 3:
                        if (!p1.getInventory().getFood()) {
                            location = new Cave(p1);
                            break;
                        } else {
                            System.out.println("--------------------------------------------------");
                            System.out.println("You have already cleaned here and can not re-enter!");
                            System.out.println("--------------------------------------------------");
                            location = new SafeHouse(p1);
                            break;
                        }

                    case 4:
                        if (!p1.getInventory().getFirewood()) {
                            location = new Forest(p1);
                            break;
                        } else {
                            System.out.println("--------------------------------------------------");
                            System.out.println("You have already cleaned here and can not re-enter!");
                            System.out.println("--------------------------------------------------");
                            location = new SafeHouse(p1);
                            break;
                        }
                    case 5:
                        if (!p1.getInventory().getWater()) {
                            location = new River(p1);
                            break;
                        } else {
                            System.out.println("--------------------------------------------------");
                            System.out.println("You have already cleaned here and can not re-enter!");
                            System.out.println("--------------------------------------------------");
                            location = new SafeHouse(p1);
                            break;
                        }
                    case 6:
                        location = new Mines(p1);
                        break;

                    default:
                        location = new SafeHouse(p1);
                }

                if (location == null) {
                    System.out.println("Journey has ended.");
                    break;
                }

                if (!location.onLocation()) {
                    System.out.println("GAME OVER!");
                    break;
                }
            }
    }


}
