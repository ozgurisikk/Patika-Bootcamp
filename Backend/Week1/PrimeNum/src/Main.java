public class Main {
    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {
            boolean prime = true;
            for (int k = 2; k < i; k++) {
                if (i % k == 0) {
                    prime = false;
                    break;
                }
            }if (prime){
                System.out.print(i + ", ");
            }

        }
    }
}