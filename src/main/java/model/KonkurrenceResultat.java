package model;

import datamapper.ResultatMapper;

public class KonkurrenceResultat {


    private int konkurrenceResultatID;
    private Medlem medlem;
    private Konkurrence konkurrence;
    //svømmedisciplin er int 1-4,som symboliserer 1:bryst 2:crawl 3:rygcrawl 4:butterfly
    public int svoemmediciplin;
    //i resultat gemmes tid i en int, tid omregnes til millisekunder...
    private int tid;

        //contructor hvor alt undtagen id gemmes, det kommer fra DB
    public KonkurrenceResultat(Medlem medlem, Konkurrence konkurrence, int svoemmediciplin, int tid) {
        this.medlem = medlem;
        this.konkurrence = konkurrence;
        this.svoemmediciplin = svoemmediciplin;
        this.tid = tid;
    }
    public void gem(){
        //gemmer resultat i DB og hashmap, tilføjer ID fra DB til resultatet
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
        //finder svømmedisciplin udfra int
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
        //finder senio/junior udfra boolean
        String senior="Senior";
        if (medlem.isSenior()==false){senior="junior";}
        return
                "ResultatID:" + konkurrenceResultatID +
                        ", "+ " "+konkurrence.getKonkurrenceNavn()+
                        ", "+ medlem.getForNavn()+" "+medlem.getEfterNavn() +
                        ", "+senior+
                        ", "  + disciplinstr +
                        " Tid:" + intToTimeString(tid) +"\n";
    }

    public String intToTimeString(int intTid){
        //laver en string med tiden ud fra int med millisekunder
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
        //metode der er true hvis resultat opfylder kriterie

        // er disciplinen rigtig
        boolean sammeDisciplin=(this.svoemmediciplin==disciplin);

        // er kønnet rigtig for det medlem der har sat resultatet
        boolean sammeKoen=(this.getMedlem().isMand()==mand);

        //er junior/senior rigtig for medlemmet der satte resultatet
        boolean sammeSenior=(this.getMedlem().isSenior()==senior);

        //returner kun true hvsi alle 3 er opfyldt
        return sammeDisciplin&&sammeKoen&&sammeSenior;
    }


}
