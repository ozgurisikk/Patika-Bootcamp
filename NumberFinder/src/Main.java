import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int n;
        int toplam = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Sayi giriniz: ");
            n = scan.nextInt();
            if (n % 4 == 0 || n % 2 ==0){
                toplam += n;


            }else{
                System.out.println("Tek sayi girdiniz!");
            }
        }while (n % 2 == 0);

        System.out.println("Girdiginiz cift sayilarin topolami: " + toplam);


    }
}