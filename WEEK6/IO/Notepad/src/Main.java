import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        File file = new File("notepad.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String data = input.nextLine();



        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(data);
            printWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileReader fileReader = new FileReader("notepad.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String textToRead;

            while ((textToRead = bufferedReader.readLine()) != null){
                System.out.println(textToRead);
            }

            bufferedReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }






}
