import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 1, total = 0, counter =0;
        int number;


        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = input.nextInt();

        while(i <= number){
            i++;
            if (i % 3 == 0 || i % 4 == 0){

                total += i;
                counter++;

            }
        }
        double average = total / counter;
        System.out.println("The average is: " + average);
        

    }
}
