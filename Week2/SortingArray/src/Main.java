import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers you will use for array?: ");
        int n = input.nextInt();
        int elements;

        int[] array = new int[n];

        System.out.println("Please enter the numbers: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ". Element: ");
            elements = input.nextInt();
            array[i - 1] = elements;
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
