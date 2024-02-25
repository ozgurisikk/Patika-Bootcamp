import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n değerini giriniz: ");
        int n = scanner.nextInt();

        System.out.print("r değerini giriniz: ");
        int r = scanner.nextInt();


        if (n < r) {
            System.out.println("Hatalı giriş! n, r'den küçük olmalıdır.");
        } else {

            int kombinasyon = 1;
            for (int i = 1; i <= r; i++) {
                kombinasyon *= n - i + 1;
                kombinasyon /= i;
            }

            System.out.println("C(" + n + ", " + r + ") = " + kombinasyon);
        }


    }
}