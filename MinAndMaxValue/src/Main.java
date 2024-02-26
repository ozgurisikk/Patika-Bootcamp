import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int n, numCount, firstNum, smallNum, bigNum;

        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers you will enter?: ");
         numCount = input.nextInt();
        System.out.print("Please enter the first number: ");
        firstNum = input.nextInt();
        smallNum = firstNum;
        bigNum = firstNum;


        for (int i = 2; i <= numCount; i++) {

            System.out.print("Please enter " + i +". number");

            n = input.nextInt();

            if(n>bigNum){
                bigNum=n;

            }
            if (n<smallNum){
                smallNum = n;

            }
        }
        System.out.println("Big number is " + bigNum);
        System.out.println("Small number is " + smallNum);
    }
}