import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int month, date;
        String burc = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Dogdugunuz ay: ");
        month = input.nextInt();

        System.out.print("Dogdugunuz gun: ");
        date = input.nextInt();

        //

        if (month >= 1 && month <= 12) {

            if (month == 1) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 21) {
                    burc = "Oglak";
                } else if(date <= 31) {
                    burc = "Kova";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }
            if (month == 12) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 21) {
                    burc = "Yay";
                } else if(date <= 31) {
                    burc = "Oglak";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }
            if (month == 11) {
                if (date >= 1 && date <= 30) {
                }
                if (date <= 21) {
                    burc = "Akrep";
                } else if(date <= 30) {
                    burc = "Yay";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }
            if (month == 10) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 22) {
                    burc = "Terazi";
                } else if(date <= 31) {
                    burc = "Akrep";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }
            if (month == 9) {
                if (date >= 1 && date <= 30) {
                }
                if (date <= 22) {
                    burc = "Basak";
                } else if(date <= 30) {
                    burc = "Terazi";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 8) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 22) {
                    burc = "Aslan";
                } else if(date <= 31) {
                    burc = "Basak";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 7) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 22) {
                    burc = "Yengec";
                } else if(date <= 31) {
                    burc = "Aslan";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 6) {
                if (date >= 1 && date <= 30) {
                }
                if (date <= 22) {
                    burc = "Ikizler";
                } else if(date >= 23 && date <= 30) {
                    burc = "Yengec";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 5) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 21) {
                    burc = "Boga";
                } else if(date <= 31) {
                    burc = "Ikizler";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 4) {
                if (date >= 1 && date <= 30) {
                }
                if (date <= 20) {
                    burc = "Koc";
                } else if(date <= 30) {
                    burc = "Boga";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 3) {
                if (date >= 1 && date <= 31) {
                }
                if (date <= 20) {
                    burc = "Balik";
                } else if(date <= 31) {
                    burc = "Koc";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }if (month == 2) {
                if (date >= 1 && date <= 28) {
                }
                if (date <= 19) {
                    burc = "Kova";
                } else if(date <= 20) {
                    burc = "Balik";
                }else{
                    System.out.println("Hatali bilgi girdiniz!");
                }

            }System.out.println("Burcunuz: " + burc);


        }else{
            System.out.println("Hatali bilgi girdiniz!");
        }

    }
}
