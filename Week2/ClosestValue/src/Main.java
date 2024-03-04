import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = {15,12,788,1,-1,-778,2,0};
        Arrays.sort(list);
        int minClose = 0, maxClose = 0;

        System.out.print("Enter a number: ");
        int value = input.nextInt();

        for (int i = 0; i < list.length; i++){
            if (list[i] < value){
                minClose = list[i];
            }else {
                maxClose = list[i];
                break;
            }

        }
        System.out.println("The value is: " + value);
        System.out.println("The closest minimum number to value is: " + minClose);
        System.out.println("The closest maximum number to value is: " + maxClose);

    }
}
