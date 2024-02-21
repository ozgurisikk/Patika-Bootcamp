import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating variables
        int a, b, c, result;

        Scanner input = new Scanner(System.in);

        // Obtaining values from use

        System.out.print("Please enter first number : ");
        a = input.nextInt();
        System.out.print("Please enter second number: ");
        b = input.nextInt();
        System.out.print("Pleae enter third number: ");
        c = input.nextInt();

        // Using formula

        result = a + b * c - b;
        System.out.println("The result is: " + result + ".");
    }
}