package IOMenu;

import model.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static model.MedlemsLister.medlemMap;

public class IOOpretResultat {

    public static void opretResultat() {
        Konkurrencer konkurrencer = new Konkurrencer();
        MedlemsLister ml = new MedlemsLister();
        KonkurrenceResultater konkurrenceResultater = new KonkurrenceResultater();

        // Create Scanner object
        Scanner opretResultatInput = new Scanner(System.in);

        // Medlem
        Medlem medlem = null;
        while (medlem == null) {
            System.out.println("Vælg medlem: ");
            System.out.println(ml.KortToStringkonkurrencemedlem());
            // Korrigerer for fejltastning
            if (opretResultatInput.hasNextInt()) {
                int medlemID = opretResultatInput.nextInt();
                // Korrigerer hvis medlemID ikke er på listen
                if ((medlemMap.containsKey(medlemID)&&(!medlemMap.get(medlemID).isMotionist()))) {
                    medlem = ml.medlemMap.get(medlemID);
                    ml.medlemMap.get(medlemID);
                } else {
                    System.out.println("Indtast et nummer fra listen");
                }
            } else {
                System.out.println("Fejltast");
                opretResultatInput.nextLine();
            }
        }

        // Konkurrence eller træningsresultat
        Konkurrence konkurrence = null;

        while (konkurrence == null) {
            System.out.println("Træningsresultat tast: 1 \nkonkurrenceresultat tast 2: ");
            if (opretResultatInput.hasNextInt()) {

                int konkurrenceInput = opretResultatInput.nextInt();
                if (konkurrenceInput == 1) {
                    konkurrence = konkurrencer.konkurrenceMap.get(1);

                } else if (konkurrenceInput == 2) {
                    System.out.println("Vælg konkurrence");
                    System.out.println(konkurrencer);

                    if (opretResultatInput.hasNextInt()) {
                        int konkurrenceID = opretResultatInput.nextInt();
                        konkurrence = konkurrencer.konkurrenceMap.get(konkurrenceID);

                    }
                } else {
                    System.out.println("Fejltastning");
                    opretResultatInput.nextLine();
                }
            } else {
                System.out.println("Fejltast, skal være et tal");
                opretResultatInput.nextLine();
            }
        }

        // svoemmediciplin, int
        int svoemmediciplin = 0;
        while (svoemmediciplin == 0) {
            System.out.println("Vælg diciplin: ");
            System.out.println("brystsvoemning: 1 ");
            System.out.println("crawl: 2 ");
            System.out.println("rygcrawl: 3 ");
            System.out.println("butterfly: 4 ");
            if (opretResultatInput.hasNextInt()) {
                svoemmediciplin=opretResultatInput.nextInt();
                if (svoemmediciplin <= 4) {

                } } else {
                System.out.println("Fejltastning: 1 - 4");
                opretResultatInput.nextLine();
            }
        }

            // Tid
            // System.out.println("Indtast tid: 00,00,00 ");
            int intTid = 0;
            while (intTid == 0) {

                System.out.println("Indtast tid 'HH:mm:ss.SSS'");

                String tmpTid = opretResultatInput.nextLine();
                tmpTid = opretResultatInput.nextLine();

                DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
                LocalTime tid = LocalTime.parse(tmpTid, myFormat);
                intTid = omRegner(tid);

            }
            KonkurrenceResultat konkurrenceResultat = new KonkurrenceResultat(medlem, konkurrence, svoemmediciplin, intTid);
            konkurrenceResultat.gem();
            System.out.println(konkurrenceResultat);
        }


        public static int omRegner (LocalTime tid){
            int sekunder;
            int minutter;
            int nanosekunder;

            sekunder = tid.getSecond();
            minutter = tid.getMinute();
            nanosekunder = tid.getNano();

            return nanosekunder / 1000000 + sekunder * 1000 + minutter * 60000;
        }
    }



