import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        System.out.println("4'ün ve 5'in kuvvetleri:");

        int maxKuvvet = 1;
        int carpim4 = 1;
        int carpim5 = 1;

        while (carpim4 <= sayi || carpim5 <= sayi) {
            if (carpim4 <= sayi)
                System.out.println("4^" + maxKuvvet + " = " + carpim4);
            if (carpim5 <= sayi)
                System.out.println("5^" + maxKuvvet + " = " + carpim5);

            maxKuvvet++;
            carpim4 *= 4;
            carpim5 *= 5;
        }
    }
}