import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n1, n2, ebob = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Sayi 1: ");
        n1 = input.nextInt();

        System.out.print("Sayi 2: ");
        n2 = input.nextInt();

        while (n1 < n2) {

            for (int i = 1; i <= n1; i++) {
                if (n1 % i == 0 && n2 % i == 0) {

                    ebob = i;
                }
            }
            System.out.println(ebob);
            break;
        }

        //if the n2 is smaller than n1

        while (n2 < n1) {
            for (int i = 1; i <= n2; i++) {
                if (n2 % i == 0 && n1 % i == 0) {
                    ebob = i;
                }
            }
            System.out.println(ebob);
            break;
        }



    }
}