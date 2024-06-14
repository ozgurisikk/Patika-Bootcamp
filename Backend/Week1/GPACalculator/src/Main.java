import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Create variables.
        int math, literature, music, history, english, biology;

        //Identify Scanner class.
        Scanner studentScore = new Scanner(System.in);

        //Take the values of scores from student.
        System.out.print("Math score : ");
        math = studentScore.nextInt();

        System.out.print("Literature score: ");
        literature = studentScore.nextInt();

        System.out.print("Music score: ");
        music =  studentScore.nextInt();

        System.out.print("History score: ");
        history = studentScore.nextInt();

        System.out.print("English score: ");
        english = studentScore.nextInt();

        System.out.print("Biology score: ");
        biology = studentScore.nextInt();

        //Collecting scores and calculating gpa.
        int totalScore = (math + literature + music + history + english + biology);
        double gpa = (totalScore / 6.0);
        System.out.println("Your GPA is: " + gpa );

        //Created variable about the student passed or not
        String result = "";

        //With gpa result, letting student know about passed or not.
        result = gpa >= 60 ? "You have passed!" : "You have failed!";
        System.out.println(result);


    }
}
