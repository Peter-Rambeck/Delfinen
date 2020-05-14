import IOMenu.Menu;
//import datamapper.KonkurrenceMapper;
import datamapper.KonkurrenceMapper;
import datamapper.MedlemMapper;
import datamapper.ResultatMapper;
import model.*;
//import datamapper.ResultatMapper;
//import model.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;


import static model.MedlemsLister.medlemMap;


public class Main {

    public static void main(String[] args) {

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

        //kør menuen
        Menu menu = new Menu();
        menu.hovedMenu();


    }
}


