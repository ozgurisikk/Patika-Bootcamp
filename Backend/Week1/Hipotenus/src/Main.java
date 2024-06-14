import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b;
        double c;

        //Creating Scanner class
        Scanner input = new Scanner(System.in);

        //Receiving values
        System.out.print("Birinci kenar uzunlugunu giriniz: ");
        a = input.nextInt();

        System.out.print("Ikinci kenar uzunlugunu giriniz: ");
        b = input.nextInt();

        //Printing hipotenus value
        c = Math.sqrt((a*a) + (b*b));
        System.out.println("Hipotenus " + c);

    }
}