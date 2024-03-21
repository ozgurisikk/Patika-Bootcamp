import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int size = arr.length;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a index value: "); // Receiving input

        int userInp = input.nextInt();

        inRange(arr, userInp);


    }


    public static void inRange(int[] arr , int index){
        try {
            System.out.println(arr[index]); //if value is valid, prints the index num. Else throws exception
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.print(e.getClass().getName());
            System.out.println("You are out of list length!");
        }
    }
}
