import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a;
        int b;

        //values
        System.out.print("Ondalikli sayi giriniz: ");
        a = input.nextDouble();
        System.out.print("Tam sayi giriniz: ");
        b = input.nextInt();


        //casting
        double bCast = b;
        int aCast = (int) a;

        //printing
        System.out.println(aCast);
        System.out.println(bCast);

    }
}
