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
        KonkurrenceResultater konkurrenceResultater=new KonkurrenceResultater();

        // Create Scanner object
        Scanner opretResultatInput = new Scanner(System.in);

        System.out.println("Vælg konkurrence: ");
        System.out.println(konkurrencer);
        int konkurrenceID = opretResultatInput.nextInt();

        System.out.println("Vælg Medlem: ");
        System.out.println(ml.KortToString());
        int medlemID = opretResultatInput.nextInt();

        System.out.println("Vælg diciplin: ");
        System.out.println("brystsvoemning: 1 ");
        System.out.println("crawl: 2 ");
        System.out.println("rygcrawl: 3 ");
        System.out.println("butterfly: 4 ");
        System.out.println("Slut diciplin: 0 ");


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

        System.out.println("Indtast tid 'HH:mm:ss.SSS'");

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String tmpTid = opretResultatInput.next();
        LocalTime tid = LocalTime.parse(tmpTid, myFormat);
        KonkurrenceResultat konkurrenceResultat=new KonkurrenceResultat(ml.medlemMap.get(medlemID),
                                                                        konkurrencer.konkurrenceMap.get(konkurrenceID),
                                                                        svoemmediciplin,
                                                                        tid);

        konkurrenceResultat.gem();

        System.out.println(svoemmediciplin+" "+tid);

        }

}


