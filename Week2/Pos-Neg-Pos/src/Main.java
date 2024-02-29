import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int b = input.nextInt();
        int a = arrayMinus(b);
        arrayPlus(a, b);

    }

    static int arrayMinus(int a){

        if (a <= 0) return a;

        System.out.print(a + " ");
        return arrayMinus(a - 5);

    }

    static int arrayPlus(int a, int b) {

        if (b >= a)  System.out.print(a + " ");
        return arrayPlus(a + 5, b);

    }
}

