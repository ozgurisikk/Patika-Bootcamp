import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating variables
        double km, cost;

        // Importing Scanner class and receiving travelled km value
        Scanner input = new Scanner(System.in);
        System.out.print("How many kilometers are travelled: ");
        km = input.nextDouble(); // If the value is double, like 22,2 km, it should be entered as COMMA (,) not with PERIOD (.)!

        // Calculating cost
        cost = (km * 2.20) + 10;


        // Pricing the journey
        if (cost < 20) {
            System.out.println("Total payment is 2o TRY.");
        }
        else {
            System.out.println("Total payment is " + cost + "TRY.");
        }


    }
}

