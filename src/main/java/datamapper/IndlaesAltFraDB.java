package datamapper;

import model.KonkurrenceResultater;
import model.Konkurrencer;
import model.MedlemsLister;

public class IndlaesAltFraDB {

    public IndlaesAltFraDB() {
        //indlæs medlemmer fra DB
        MedlemMapper mm = new MedlemMapper();
        MedlemsLister ml=new MedlemsLister();
        mm.getMedlemmerFraDB(ml);


        //indlæs konkurrencer fra DB
        KonkurrenceMapper km=new KonkurrenceMapper();
        Konkurrencer kl=new Konkurrencer();
        km.getKonkurrencerFraDB(kl);

        //indlæs alle resultater fra DB
        ResultatMapper rm=new ResultatMapper();
        KonkurrenceResultater kr=new KonkurrenceResultater();
        rm.getResultaterFraDB(kr);
    }
}
