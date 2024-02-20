import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double birinciKenar, ikinciKenar, ucuncuKenar;
        double cevre, alan, u;

        Scanner input = new Scanner(System.in);

        System.out.print("Birinci kenar uzunlugunu giriniz: ");
        birinciKenar = input.nextInt();

        System.out.print("Ikinci kenar uzunlugunu giriniz: ");
        ikinciKenar = input.nextInt();

        System.out.print("Ucuncu kenar uzunlugunu giriniz: ");
        ucuncuKenar = input.nextInt();

        cevre = (birinciKenar + ikinciKenar + ucuncuKenar);
        u = ((birinciKenar + ikinciKenar + ucuncuKenar) / 2.0);
        alan = Math.sqrt(u * (u - birinciKenar) * (u - ikinciKenar) * (u - ucuncuKenar));

        System.out.println("Ucgenin cevresi: " + cevre);
        System.out.println("Ucgenin alani: " + alan);


    }
}