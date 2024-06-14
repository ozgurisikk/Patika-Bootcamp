import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int sum=1;

        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayi giriniz: ");
        int number = input.nextInt();

        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                sum+=i;

            }

        }
        if(sum==number) {
            System.out.println(number + " mukkemmel bir sayidir.");
        }else {
            System.out.println(number + " mukkemmel bir sayi degildir.");
        }

    }
}