import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double r,a,area,pi,perimeter,secArea;
        pi = 3.14;

        // Getting values for radius and center angle measure
        System.out.println("Enter radius: ");
        r = scanner.nextDouble();
        System.out.println("Enter center angle measure: ");
        a = scanner.nextDouble();

        // With the values, applying formulas
        area = pi * r * r;
        perimeter = 2 * pi * r;
        secArea = (pi * (r*r) * a) / 360;

        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area : " + area);
        System.out.println("Area of circle segment: " + secArea);
    }

}