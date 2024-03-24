
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PatikaStore store = new PatikaStore();
        Scanner input = new Scanner(System.in);


        while (true){
            System.out.println("Patika Store Admin Dashboard");
            System.out.println("----------------------------");
            System.out.println("1- Notebook options");
            System.out.println("2- Mobile Phone options");
            System.out.println("3- List of brands");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");

            int choice = input.nextInt();

            switch (choice){
                case 1:
                    store.notebookOptions();
                    break;
                case 2:
                    store.phoneOptions();
                    break;
                case 3:
                    store.listOfBrands();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Something went wrong");
            }
        }
    }

}
