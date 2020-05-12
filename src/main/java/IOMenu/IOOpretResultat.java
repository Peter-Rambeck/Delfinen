package IOMenu;

import model.*;
import model.Enum;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class IOOpretResultat {

    public static void opretResultat() {
        Konkurrencer konkurrencer = new Konkurrencer();
        MedlemsLister ml = new MedlemsLister();
        KonkurrenceResultater konkurrenceResultater = new KonkurrenceResultater();

        // Create Scanner object
        Scanner opretResultatInput = new Scanner(System.in);


        // Medlem
        System.out.println("Vælg Medlem: ");
        System.out.println(ml.KortToString());
        int medlemID = opretResultatInput.nextInt();
        Medlem medlem = ml.medlemMap.get(medlemID);


        // Konkurrence eller træningsresultat
        System.out.println("Vælg konkurrence tast 1, ellers 2: ");
        System.out.println("Vælg konkurrence: ");
        int konkurrenceInput = opretResultatInput.nextInt();
        Konkurrence konkurrence = null;
        if (konkurrenceInput == 1) {
            System.out.println(konkurrencer);
            // TODO Test retur værdi
            int konkurrenceID = opretResultatInput.nextInt();
            konkurrence = konkurrencer.konkurrenceMap.get(konkurrenceID);
        }


        // Konkurrence eller træningsresultat
        System.out.println("Vælg diciplin: ");
        System.out.println("brystsvoemning: 1 ");
        System.out.println("crawl: 2 ");
        System.out.println("rygcrawl: 3 ");
        System.out.println("butterfly: 4 ");
        // System.out.println("Slut diciplin: 0 ");
        int svoemmediciplin = opretResultatInput.nextInt();


        // Tid
        // System.out.println("Indtast tid: 00,00,00 ");
        System.out.println("Indtast tid 'HH:mm:ss.SSS'");
        String tmpTid = opretResultatInput.nextLine();
         tmpTid = opretResultatInput.nextLine();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalTime tid = LocalTime.parse(tmpTid, myFormat);
        int intTid = omRegner(tid);




        KonkurrenceResultat konkurrenceResultat = new KonkurrenceResultat(medlem, konkurrence, svoemmediciplin, intTid);
        konkurrenceResultat.gem();
        System.out.println(konkurrenceResultat);


                /*
                (ml.medlemMap.get(medlemID)
                konkurrencer.konkurrenceMap.get(konkurrenceID),
                svoemmediciplin,
                tid);

                 */





/*
        int tmp = opretResultatInput.nextInt();
        KonkurrenceResultat.Svoemmediciplin svoemmediciplin = null;
      
            if (tmp == 1) {
                svoemmediciplin = KonkurrenceResultat.Svoemmediciplin.brystsvoemning;
            }
            if (tmp == 2) {
                svoemmediciplin = KonkurrenceResultat.Svoemmediciplin.crawl;
            }
            if (tmp == 3) {
                svoemmediciplin = KonkurrenceResultat.Svoemmediciplin.rygcrawl;
            }
            if (tmp == 4) {
                svoemmediciplin = KonkurrenceResultat.Svoemmediciplin.butterfly;
            }

 */


    }

    public static int omRegner(LocalTime tid) {
        int sekunder;
        int minutter;
        int nanosekunder;

        sekunder = tid.getSecond();
        minutter = tid.getMinute();
        nanosekunder = tid.getNano();

        return nanosekunder / 1000000 + sekunder * 1000 + minutter * 60000;
    }
}

