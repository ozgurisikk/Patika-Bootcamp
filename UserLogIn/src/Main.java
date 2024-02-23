import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String username, password, response, newPassword;

        Scanner input = new Scanner(System.in);

        // Receiving values

        System.out.print("Username: ");
        username = input.nextLine();

        System.out.print("Password: ");
        password = input.nextLine();

        // Checking if the data matches or not
        if (username.equals("patika") && password.equals("java123")) {
            System.out.println("You have logged in successfully!");
        } else {     // if wrong, asking for the choice
            System.out.print("You have entered wrong password! Would you like to reset your password? Type yes or no ");
            response = input.nextLine();
            if (response.equals("yes")) {
                System.out.print("Please enter your new password: "); // creating new password
                newPassword = input.nextLine();
                if (newPassword.equals("java123")) {
                    System.out.println("You can not use an old password.");
                } else {
                    if (newPassword.equals(password)) {
                        System.out.println("Wrong password can not be choosen again.");

                    } else {
                        System.out.println("You have successfully changed your password!");

                    }
                }
            }else{
                System.out.println("Login failed.");
            }
        }

    }
}



