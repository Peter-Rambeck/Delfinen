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
        String disciplinstr="";
        switch (svoemmediciplin){
            case 1:disciplinstr="Brystsvømning";
                    break;
            case 2:disciplinstr="Crawl";
                break;
            case 3:disciplinstr="Rygcrawl";
                break;
            case 4:disciplinstr="Butterfly";
                break;

        }



        return
                "ResultatID:" + konkurrenceResultatID +
                        " "+ " "+konkurrence.getKonkurrenceNavn()+
                        " "+ medlem.getForNavn()+" "+medlem.getEfterNavn() +
                        " "  + disciplinstr +
                        " Tid:" + intToTimeString(tid) +"\n";
    }

    public String intToTimeString(int intTid){
        String retVal="";
        int minutes;
        int seconds;
        int milliseconds;

        minutes=intTid/60000;
        intTid=intTid%60000;
        String minutuesString=String.format("%2d",minutes);

        seconds=intTid/1000;
        intTid=intTid%1000;
        String seconsString=String.format("%02d",seconds);

        milliseconds=intTid;
        String mSecondsString=String.format("%03d",milliseconds);

        retVal=retVal+minutuesString+":"+seconsString+"."+mSecondsString;
        return retVal;


    }

    public boolean opfylderKriterie(int disciplin,boolean mand, boolean senior){
        boolean sammeDisciplin=(this.svoemmediciplin==disciplin);
        boolean sammeKoen=(this.getMedlem().isMand()==mand);
        boolean sammeSenior=(this.getMedlem().isSenior()==senior);
        return sammeDisciplin&&sammeKoen&&sammeSenior;
    }


}
