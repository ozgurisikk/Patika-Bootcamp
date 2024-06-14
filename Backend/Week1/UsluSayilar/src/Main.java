import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n,k;
        int toplam = 1;
        Scanner input = new Scanner(System.in);
        System.out.print("Ussu alinacak sayi: ");
        n = input.nextInt();
        System.out.print("Ussu olacak sayi: ");
        k = input.nextInt();

        for (int i = 1; i<=k; i++){

            toplam *= n;

        }System.out.println(toplam);

    }
}
