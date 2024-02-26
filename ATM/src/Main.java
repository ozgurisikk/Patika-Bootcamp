
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3, balance = 1500;
        int action, deposit, withdraw, choose;

        while (right > 0) {

            System.out.print("Enter your user name: ");
            userName = input.nextLine();
            System.out.print("Enter your password: ");
            password = input.nextLine();

            //login match
            if (userName.equals("patika") && password.equals("patika123")) {
                System.out.println("Login Successful");

                //action deter
                do {

                    System.out.println("Please enter the line number of the action you want to perform: ");
                    System.out.println("1-Deposit cash");
                    System.out.println("2-Withdraw cash");
                    System.out.println("3-Check balance");
                    System.out.println("4-Exit");
                    action = input.nextInt();

                    //action codes
                    switch (action) {

                        case 1:
                            System.out.print("Enter the deposit amount: ");
                            deposit = input.nextInt();
                            balance += deposit;
                            System.out.println("Deposit proccess success!");
                            break;

                        case 2:
                            System.out.println("Enter the withdraw amount: ");
                            withdraw = input.nextInt();
                            balance -= withdraw;
                            System.out.println("Withdraw proccess success!");
                            break;

                        case 3:
                            System.out.println("Your balance is: " + balance);
                            break;

                        case 4:
                            System.out.println("See you next time!");
                            break;

                        default:
                            System.out.println("Invalid selection");
                    }

                    //quits program
                } while (action != 4);
                break;


                //false login
            } else {
                right--;
                System.out.println("Username or password is wrong, please try again.");

                if (right == 0) {
                    System.out.println("Your account is blocked, please contact with us. ");

                } else {
                    System.out.println("Your remaining rights are: " + right);

                }

            }

        }

    }
}