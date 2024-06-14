import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // receiving input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = input.nextInt();

        //checking if true or not and printing result
        if (isPalindrom(a)){
            System.out.println("It is a palindrom number");
        }else{
            System.out.println("It is not a palindrom number");
        }
    }

    static boolean isPalindrom(int n){

        int temp = n, reverseNum = 0, lastNum;

        //rewriting number as reverse
        while (temp != 0){
            lastNum = temp % 10;
            reverseNum = (reverseNum * 10) + lastNum;
            temp /= 10;
        }
        // conq
        if (reverseNum == n)
        return true;

        else return false;
    }
}
