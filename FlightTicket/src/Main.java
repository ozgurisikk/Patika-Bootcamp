import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double mesafe = 0, tutarTop=0 , indirimTutar, secimInd, indirimOran;
        int yas = 0, secim= 0;
        boolean gecerliMesafe =true, gecerliYas=true, gecerliType=true;

        Scanner input = new Scanner(System.in);

        System.out.println("Hosgeldiniz!");

        // Degerler alinip kontrol ediliyor
        while(gecerliMesafe) {

            System.out.print("Km cinsinden mesafe giriniz: ");
            mesafe = input.nextDouble();

            if (mesafe >= 1) {
                gecerliMesafe = false;

            } else {
                System.out.println("Hatali veri girdiniz!");

            }
        }

        while(gecerliYas){

            System.out.print("Yolcu yasini giriniz: ");
            yas = input.nextInt();

            if(yas >= 1 && yas <= 120){
                gecerliYas = false;

            }else {
                System.out.println("Gecerli bir yas giriniz!");
            }
        }

        while(gecerliType){

            System.out.println("Yolculuk tipini giriniz");
            System.out.println("1- Tek yon");
            System.out.println("2- Gidis donus");
            System.out.print("Seciminiz: ");
            secim = input.nextInt();

                if (secim == 1 || secim == 2){
                    gecerliType = false;

                }else{
                    System.out.println("Yanlis tuslama yaptiniz!");
                }
        }


    //yolcu tipinden indirim fiyatlari hesaplanir
        if (yas > 65){
            indirimOran = 0.30;
            tutarTop = mesafe * 0.10;
            indirimTutar = (tutarTop * indirimOran);
            tutarTop -= indirimTutar;
        }else if (yas <12){
            indirimOran = 0.50;
            tutarTop = mesafe * 0.10;
            indirimTutar = (tutarTop * indirimOran);
            tutarTop -= indirimTutar;

        }else if (yas <= 24 && yas >= 12){
            indirimOran = 0.10;
            tutarTop = mesafe * 0.10;
            indirimTutar = (tutarTop * indirimOran);
            tutarTop -= indirimTutar;

        }else {
            tutarTop = mesafe * 0.10;
        }
    //yolculuk tipinden total fiyat hesaplanir
        switch (secim){

            case 1:
                System.out.println("Bilet fiyatiniz : " + tutarTop + "TRY");
                break;
            case 2:
                secimInd = tutarTop * 0.20;
                tutarTop -= secimInd;
                tutarTop *= 2;
                System.out.println("Bilet fiyatiniz : " + tutarTop + "TRY");
                break;
        }


    }
    }
