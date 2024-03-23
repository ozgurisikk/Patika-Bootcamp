import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int count = 0;
        String check = null;


        System.out.print("Enter a text: ");
        Scanner input = new Scanner(System.in);

        String text = input.nextLine().toLowerCase();

        String[] list = text.split(" "); // Splitting text to words


        Map<String, Integer> wordList = new HashMap<>();

        for (String gez : list){  // Adding words to hashMap with values
            if(wordList.containsKey(gez)){

                wordList.put(gez, wordList.get(gez) + 1);

            }else wordList.put(gez, 1);
        }

        System.out.println(wordList);

        // Finding the most used word

        for (Map.Entry<String, Integer> gezTwo : wordList.entrySet()){
            if (gezTwo.getValue() > count){
                count = gezTwo.getValue();
                check = gezTwo.getKey();
            }

        }

        System.out.println("Most used word is " + check + " with " +  count);

    }
}
