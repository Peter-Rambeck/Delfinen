import IOMenu.Menu;
import datamapper.KonkurrenceMapper;
import datamapper.MedlemMapper;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static model.Medlem.AldersKlasse.senior;
import static model.Medlem.Koen.mand;
import static model.Medlem.Status.passiv;


public class Main {

    public static void main(String[] args) {

        // MedlemMapper mm = new MedlemMapper();
        // MedlemsListe ml=new MedlemsListe();
        // mm.getMedlemmerFraDB(ml.medlemmer);
        Konkurrencer konkurrencer=new Konkurrencer();
        KonkurrenceMapper km=new KonkurrenceMapper();
        Konkurrence k=new Konkurrence();
        k.setDato(LocalDate.of(2017, 1, 13));
        k.setNavn("DM 2017");
        km.createKonkurrence(k);
        km.getKonkurrenceFraDB(konkurrencer.liste);
        for(Konkurrence ko:konkurrencer.liste){
            System.out.println(ko);
        }

        //Start hovedmenu I/O
       /* Menu menu = new Menu();
        menu.hovedMenu();
*/

    }
}
