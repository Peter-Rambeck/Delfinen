package IOMenu;

import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class IOOpretResultat {

    public static void opretResultat() {
        Konkurrencer konkurrencer = new Konkurrencer();
        MedlemsLister ml = new MedlemsLister();

        // Create Scanner object
        Scanner opretResultatInput = new Scanner(System.in);

        System.out.println("Vælg konkurrence: ");
        System.out.println(konkurrencer);
        int konkurrence = opretResultatInput.nextInt();

        System.out.println("Vælg Medlem: ");
        System.out.println(ml.getKonkurrenceMedlemmer());
        int medlemID = opretResultatInput.nextInt();

        System.out.println("Vælg diciplin: ");
        System.out.println("brystsvoemning: 1 ");
        System.out.println("crawl: 2 ");
        System.out.println("rygcrawl: 3 ");
        System.out.println("butterfly: 4 ");
        System.out.println("Slut diciplin: 0 ");


        int tmp = opretResultatInput.nextInt();
        KonkurrenceResultat.Svoemmediciplin svoemmediciplin;

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
            System.out.println();

        System.out.println("Indtast tid");

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String tmpTid = opretResultatInput.next();
        LocalTime tid = LocalTime.parse(tmpTid, myFormat);
        System.out.println(tid);

        }

}


