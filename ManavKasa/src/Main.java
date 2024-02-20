import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double pear = 2.14;
        double apple = 3.67;
        double tomato = 1.11;
        double banana = 0.95;
        double eggplant = 5.00;
        double totalPayment = 0;

        double pearKg, appleKg, tomatoKg, bananaKg, eggplantKg;

        Scanner input = new Scanner(System.in);

        System.out.print("How many kilograms of pear: ");
        pearKg = input.nextDouble();
        totalPayment += pear * pearKg;

        System.out.print("How many kilograms of apple: ");
        appleKg = input.nextDouble();
        totalPayment += apple * appleKg;

        System.out.print("How many kilograms of tomato: ");
        tomatoKg = input.nextDouble();
        totalPayment += tomatoKg *tomato;

        System.out.print("How many kilograms of banana: ");
        bananaKg = input.nextDouble();
        totalPayment += bananaKg * banana;

        System.out.print("How many kilograms of eggplant: ");
        eggplantKg = input.nextDouble();
        totalPayment += eggplant * eggplantKg;

        System.out.println("Total payment is " + totalPayment + " TRY.");




    }
}