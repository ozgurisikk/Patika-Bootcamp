import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double n1, n2;

        Scanner input = new Scanner(System.in);

        // Receiving values
        System.out.print("Please enter the first number: ");
        n1 = input.nextInt();
        System.out.print("Please enter the second number: ");
        n2 = input.nextInt();

        // Receiving operator choice
        System.out.println("Please choose a method:\n1-Addition\n2-Substraction\n3-Multiplication\n4-Division");
        System.out.print("Method is: ");

        int choice = input.nextInt();

            // Operator code section
        switch (choice) {
            case 1:
                System.out.println("Total is: " + (n1 + n2));
                break;
            case 2:
                System.out.println("Total is: " + (n1 - n2));
                break;
            case 3:
                System.out.println("Total is: " + (n1 * n2));
                break;
            case 4:
                // The section in case of checking for if one of the values is equals to zero or not.
                if (n1 == 0 || n2 == 0) ;
            {
                System.out.println("A number can not be divided to zero!");
            }
            if (n1 != 0 && n2 != 0) {
                System.out.println("Total is: " + (n1 / n2));
            }
            break;

            default:
                System.out.println("You have entered a wrong operator!");


        }


    }
}