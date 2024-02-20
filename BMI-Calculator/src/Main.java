import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double length, weight, bmi;

        Scanner input = new Scanner(System.in);

        // Receiving values of variables ( It should be written as 1,80)
        System.out.print("Enter your length(in meters): ");
        length = input.nextDouble();

        System.out.print("Enter your weight: ");
        weight = input.nextDouble();

        // Using formula to obtain consequence
        bmi = weight / (length * length);

        System.out.println("Your BMI is " + bmi);



    }
}