import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creating variables
        double cost, taxRatio, taxTotal, totalCost;

        //Identify Scanner class
        Scanner input = new Scanner(System.in);

        //Receiving price of product
        System.out.print("Enter the price of product: ");
        cost = input.nextDouble();

        //using if and else var determining exact tax ratio.

        if(cost <= 1000) {
            taxRatio = 0.18;
            taxTotal = cost * taxRatio;
            totalCost = cost + taxTotal;

            System.out.println("Price without tax is " + cost);
            System.out.println("The total tax is " + (taxTotal * 100));
            System.out.println("Grand total is " + totalCost);
        }

        else{
            taxRatio = 0.08;
            taxTotal = cost * taxRatio;
            totalCost = cost + taxTotal;

            System.out.println("Price without tax is " + cost);
            System.out.println("The total tax is " + (taxTotal * 100));
            System.out.println("Grand total is " + totalCost);
        }



    }
}



