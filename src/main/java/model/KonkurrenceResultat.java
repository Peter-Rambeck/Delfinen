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
    private Medlem medlem;
    private Konkurrence konkurrence;
    public Svoemmediciplin svoemmediciplin;
    private LocalTime tid;
        //contructor
    public KonkurrenceResultat(Medlem medlem, Konkurrence konkurrence, Svoemmediciplin svoemmediciplin, LocalTime tid) {
        this.medlem = medlem;
        this.konkurrence = konkurrence;
        this.svoemmediciplin = svoemmediciplin;
        this.tid = tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    public void setKonkurrenceResultatID(int konkurrenceResultatID) {
        this.konkurrenceResultatID = konkurrenceResultatID;
    }
}
