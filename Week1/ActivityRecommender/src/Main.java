import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating temperature variable and importing scanner
        double temperature;
        Scanner input = new Scanner(System.in);

        // Receiving temperature value
        System.out.print("Enter a temperature: ");
        temperature = input.nextDouble();

        //Checking and recommending as clean it could be
        if (temperature < 5) {System.out.println("You may go to ski!");}

        if (temperature > 25) {System.out.println("You may go to swim!");}

        if (temperature <= 15 && temperature >= 5){System.out.println("You may go to cinema!");}

        if (temperature >= 10 && temperature <= 25){System.out.println("You may go to picnic!");}


    }
}

