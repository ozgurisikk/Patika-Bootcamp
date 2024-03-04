import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] list = {1, 10, 12 , 14, 10 , 12 , 25 , 11, 11};
        int[] dup = new int[list.length];
        int startIndex = 0;
        for (int i = 0 ; i < list.length; i++){
            for (int j = 0; j < list.length; j++){
                if ((i != j) && (list[i] == list[j] && (list[i] % 2 == 0))){
                    if (!isThere(dup, list[i])){
                        dup[startIndex++] = list[i];
                    }
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dup));
    }
    static boolean isThere(int[] arr, int value) {
        for (int i : arr){
            if (i == value){
                return true;
            }
        }
        return false;
    }
}
