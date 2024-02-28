import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Receiving input
        Scanner input = new Scanner(System.in);

        System.out.print("Taban sayi: ");
        int taban = input.nextInt();
        System.out.print("Us sayi: ");
        int us = input.nextInt();

        int sonuc = power(taban, us);

        // printing conc
        System.out.println("Sonuc: " + sonuc);

    }

    static int power(int taban, int us){

        // calculating power
        if(us == 0){
            return 1;
        }else {
            return taban * power(taban, us-1);
        }


    }
}
