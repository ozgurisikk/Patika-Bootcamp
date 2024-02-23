import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int math, music, english, history, biology;
        double average;
        int count = 5;

        Scanner input = new Scanner(System.in);

        // Receiving values and checking wheter it is between 0-100 or not

        System.out.print("Your math grade: ");
        math = input.nextInt();
        if (math < 0 || math > 100) {
            math = 0;
            count -= 1;
        }

        System.out.print("Your music grade: ");
        music = input.nextInt();
        if (music < 0 || music > 100) {
            music = 0;
            count -= 1;
        }

        System.out.print("Your english grade: ");
        english = input.nextInt();
        if (english < 0 || english > 100) {
            english = 0;
            count -= 1;
        }

        System.out.print("Your history grade: ");
        history = input.nextInt();
        if (history < 0 || history > 100) {
            history = 0;
            count -= 1;
        }

        System.out.print("Your biology grade: ");
        biology = input.nextInt();
        if (biology < 0 || biology > 100) {
            biology = 0;
            count -= 1;
        }

        // Calculating average

        if (count == 0) {
            average = (math + music + english + history + biology);
        } else {
            average = (math + music + english + history + biology) / count;
        }

        // Printing result
        
        if (average <= 55) {
            System.out.println("You have failed the term!");

        } else {
            System.out.println("You have completed the term successfully!");

        }

        System.out.println("Score Average is " + average);
    }
}