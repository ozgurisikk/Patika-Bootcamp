import java.util.Scanner;

public class Main {

    static int plus(int a, int b) {
        int result = a+b;
        System.out.println("Toplam: " + result);
        return result;
    }

    static int minus(int a, int b) {
        int result = a-b;
        System.out.println("Toplam: " + result);
        return result;
    }

    static int times(int a, int b) {
        int result = a*b;
        System.out.println("Toplam: " + result);
        return result;
    }

    static int divided(int a, int b) {
        int result;
        if (a == 0 || b == 0){
            System.out.println("Bolme isleminde 0 kullanamazsiniz!");
        }
        result = a / b;
        System.out.println("Sonuc: " + result);

        return result;
    }

    static int power(int a, int b) {
        int result = 1;
        for (int i = 1; i <= b; i++){
            result *= a;
        }
        System.out.println("Sonuc: " + result);
        return result;
    }

    static int factorial(int a) {

        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }

        System.out.println("Sonuç : " + result);
        return result;
    }

    static int cevreAlan(int a, int b){
        System.out.println("Cevre: " + 2 * (a+b));
        System.out.println("Alan: " + a*b);
        int result = 0;
        return result;

    }

    static int mod(int a, int b){
        System.out.println("Mod: " + a % b);
        int result = 0;
        return result;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int select;
        String menu = "1- Toplama İşlemi\n"
                + "2- Çıkarma İşlemi\n"
                + "3- Çarpma İşlemi\n"
                + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n"
                + "6- Faktoriyel Hesaplama\n"
                + "7- Dikdörtgen Alan ve Çevre Hesabı\n"
                + "8- Mod Alma\n"
                + "0- Çıkış Yap";

        do {
            System.out.println(menu);
            System.out.print("Lütfen bir işlem seçiniz :");
            select = scan.nextInt();
            System.out.print("Sayi giriniz : ");
            int a = scan.nextInt();
            System.out.print("Sayi giriniz : ");
            int b = input.nextInt();

            switch (select) {
                case 1:
                    plus(a, b);
                    break;
                case 2:
                    minus(a, b);
                    break;
                case 3:
                    times(a, b);
                    break;
                case 4:
                    divided(a, b);
                    break;
                case 5:
                    power(a,b);
                    break;
                case 6:
                    factorial(a);
                    break;
                case 7:
                    cevreAlan(a,b);
                    break;
                case 8:
                    mod(a,b);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");
            }
        } while (select != 0);


    }
}