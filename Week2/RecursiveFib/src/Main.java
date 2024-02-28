import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Receiving input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = input.nextInt();

        // Printing input
        System.out.println(fib(a) + " fibonacci number.");

    }
    // calculating fibonacci number
    static int fib(int n){

        if(n == 1 || n == 2) {
            return 1;
        }
        return  fib(n - 1) + fib(n -2);
    }

}
