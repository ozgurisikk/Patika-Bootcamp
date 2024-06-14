import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = input.nextInt();

        //satir sayisi bulur
        for (int i = 1; i <= n; i++){
            //bosluk sayisi bulur
            for (int b = 1; b <= (n-i); b++){
                System.out.print(" ");
            }
            //satira kac yildiz yazilcagini bulur
            for (int y = 1; y <= (2*i-1); y++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {

            for (int b = 1; b <= n - i; b++) {
                System.out.print(" ");
            }


            for (int y = 1; y <= (2 * i - 1); y++) {
                System.out.print("*");
            }


            System.out.println();
        }

    }
}

