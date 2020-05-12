package model;


import datamapper.ResultatMapper;


public class KonkurrenceResultat {


    private int konkurrenceResultatID;
    private Medlem medlem;
    private Konkurrence konkurrence;
    public int svoemmediciplin;
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

    public void setTid(int tid) {
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

    public int getSvoemmediciplin() {
        return svoemmediciplin;
    }

    public int getTid() {
        return tid;
    }

    @Override
    public String toString() {

        return
                "ResultatID:" + konkurrenceResultatID +
                " Medlem: "+ medlem.getMedlemID()+" "+ medlem.getForNavn()+" "+medlem.getEfterNavn() +
                " Konkurrence: " + konkurrence.getKonkurrenceID()+" "+konkurrence.getKonkurrenceNavn()+" " +
                " Disciplin: " + svoemmediciplin +
                " Tid:" + tid +"\n";
    }
}
