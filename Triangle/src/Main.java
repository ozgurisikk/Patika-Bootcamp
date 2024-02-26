import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Satır sayısını girin: ");
        int satir = scanner.nextInt();

        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < 2 * (satir - i) - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }


    }
}
