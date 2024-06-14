import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("numbers.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        String line;
        FileReader readFile = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(readFile);

        int b = 0;
        while((line = buffRead.readLine()) != null){
            int a = Integer.parseInt(line);
            b += a;
        }
        buffRead.close();

        System.out.println(b);
    }


}
