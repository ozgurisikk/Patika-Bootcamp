import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int n = String.valueOf(number).length();
        int result = 0;

        while (originalNumber != 0) {
            int remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }

        if (result == number) {
            System.out.println(number + " bir Armstrong sayısıdır.");
        } else {
            System.out.println(number + " bir Armstrong sayısı değildir.");
        }


    }
}