import java.util.Scanner;
public class Main {
    static boolean isPrime(int num,int div){
        if(div == num){
            return true;
        }
        if(num % div == 0){
            return false;
        }
        return isPrime(num,div+1);
    }


    public static void main(String[] args) {
        // Receiving input
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int userInp = input.nextInt();

        // Printing if it is prime or not
        boolean isPrimeResult = isPrime(userInp,2);
        if(isPrimeResult){
            System.out.println(userInp+" is  prime .");
        }else{
            System.out.println(userInp+" is not  prime.");
        }
    }
}

