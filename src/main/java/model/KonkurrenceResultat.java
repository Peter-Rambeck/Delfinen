package model;

import datamapper.MedlemMapper;
import datamapper.ResultatMapper;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class KonkurrenceResultat {

/*
    public enum Svoemmediciplin {
        brystsvoemning,
        crawl,
        rygcrawl,
        butterfly
    }
*/

    int svoemmedisciplin;


    private int konkurrenceResultatID;
    private Medlem medlem;
    private Konkurrence konkurrence;
    public Svoemmediciplin svoemmediciplin;
    private int tid;

        //contructor
    public KonkurrenceResultat(Medlem medlem, Konkurrence konkurrence, int svoemmediciplin, int tid) {
        this.medlem = medlem;
        this.konkurrence = konkurrence;


        this.svoemmediciplin = svoemmediciplin;

        this.tid = tid;
    }
    public void gem(){
        KonkurrenceResultater konkurrenceResultater=new KonkurrenceResultater();
        ResultatMapper resultatMapper=new ResultatMapper();
        int resultatID=resultatMapper.createKonkurrenceResultat(this);
        this.setKonkurrenceResultatID(resultatID);
        KonkurrenceResultater.konkurrenceResultatMap.put(resultatID,this);
    }

    public void setTid(Local tid) {
        this.tid = tid;
    }

    public void setKonkurrenceResultatID(int konkurrenceResultatID) {
        this.konkurrenceResultatID = konkurrenceResultatID;
    }

    public int getKonkurrenceResultatID() {
        return konkurrenceResultatID;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public Konkurrence getKonkurrence() {
        return konkurrence;
    }

    public Svoemmediciplin getSvoemmediciplin() {
        return svoemmediciplin;
    }

    public LocalTime getTid() {
        return tid;
    }

    @Override
    public String toString() {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        return
                "ResultatID:" + konkurrenceResultatID +
                " Medlem: "+ medlem.getMedlemID()+" "+ medlem.getForNavn()+" "+medlem.getEfterNavn() +
                " Konkurrence: " + konkurrence.getKonkurrenceID()+" "+konkurrence.getKonkurrenceNavn()+" " +
                " Disciplin: " + svoemmediciplin +
                " Tid:" + tid.format(myFormat) +"\n";
    }
}
