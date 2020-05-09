package model;

import java.sql.Time;
import java.time.LocalTime;

public class KonkurrenceResultat {

    public enum Svoemmediciplin {
        brystsvoemning,
        crawl,
        rygcrawl,
        butterfly
    }



    private int konkurrenceResultatID;
    private KonkurrrenceMedlem Medlem;
    private Konkurrence konkurrence;
    public Svoemmediciplin svoemmediciplin;
    private LocalTime tid;


    public void KonkurrenceResultat(Konkurrence konkurrence, KonkurrrenceMedlem medlem, Svoemmediciplin svoemmediciplin, LocalTime tid) {

    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    public void setKonkurrenceResultatID(int konkurrenceResultatID) {
        this.konkurrenceResultatID = konkurrenceResultatID;
    }
}
