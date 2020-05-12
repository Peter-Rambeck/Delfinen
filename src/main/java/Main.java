import IOMenu.Menu;
import datamapper.KonkurrenceMapper;
import datamapper.MedlemMapper;
import datamapper.ResultatMapper;
import model.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import static model.Medlem.AldersKlasse.senior;
import static model.Medlem.Koen.mand;
import static model.Medlem.Status.passiv;
import static model.MedlemsLister.medlemMap;


public class Main {

    public static void main(String[] args) {

         MedlemMapper mm = new MedlemMapper();
         MedlemsLister ml=new MedlemsLister();
         mm.getMedlemmerFraDB(ml);
         System.out.println();
         ml.getElementByIndex(medlemMap, medlemMap.size()-1);



        /*
        Konkurrencer konkurrencer=new Konkurrencer();
        KonkurrenceMapper km=new KonkurrenceMapper();
        km.getKonkurrenceFraDB(konkurrencer.liste);
       //1 Konkurrence k=new Konkurrence("DM 2016",LocalDate.of(2017, 7, 13));


        System.out.println(konkurrencer);
        }

         */

        //Start hovedmenu I/O
        Konkurrencer konkurrencer=new Konkurrencer();

        KonkurrenceMapper km=new KonkurrenceMapper();
        km.getKonkurrenceFraDB(konkurrencer);
        System.out.println(konkurrencer);

       // KonkurrenceResultat konkurrenceResultat=new KonkurrenceResultat();x
        KonkurrenceResultater konkurrenceResultater=new KonkurrenceResultater();
        ResultatMapper resultatMapper=new ResultatMapper();
        resultatMapper.getResultaterFraDB();

        System.out.println(konkurrenceResultater);

       Menu menu = new Menu();
        menu.hovedMenu();
        System.out.println(konkurrenceResultater);



    }
}


