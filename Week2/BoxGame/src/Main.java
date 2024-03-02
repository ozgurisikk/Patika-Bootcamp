public class Main {
    public static void main(String[] args) {

        Fighter f1 = new Fighter("Tyson", 10, 120, 100, 14);
        Fighter f2 = new Fighter("Ali", 20, 85, 86, 25);

        Match match = new Match(f1, f2, 85, 100);

        match.run();
    }
}
