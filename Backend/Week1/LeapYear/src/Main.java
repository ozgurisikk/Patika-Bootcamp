import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int year;
        Scanner input = new Scanner(System.in);

        //Receiving values
        System.out.print("Please enter a year: ");
        year = input.nextInt();


        //Checking if it is leap year or not
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.print(year + " is a leapyear.");
                } else {
                    System.out.print(year + " is not a leapyear.");
                }
            } else {
                System.out.print(year + " is a leapyear.");
            }
        } else {
            System.out.print(year + " is not a leapyear.");
        }


    }
}