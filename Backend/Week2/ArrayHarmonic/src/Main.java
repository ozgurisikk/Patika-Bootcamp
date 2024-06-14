public class Main {
    public static void main(String[] args) {
        //calculates the harmonic mean of numbers
        int[] list = {1,2,3,4,5};
        double harmonic = 0.0;

        for (int i = 0; i < list.length; i++) {
            harmonic += 1.0 / list[i];
        }

        System.out.println(list.length / harmonic);
    }
}