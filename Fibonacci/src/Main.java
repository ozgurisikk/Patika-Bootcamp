import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Fibonacci serisi için eleman sayısını girin: ");
        int n = scanner.nextInt();

        int a = 0, b = 1;

        System.out.println("Fibonacci Serisi:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            // a ve b değerleri takas
            b = a + b;
            a = b - a;
        }


    }
}
