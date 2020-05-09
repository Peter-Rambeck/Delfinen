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
        km.getKonkurrenceFraDB(konkurrencer.liste);
        Konkurrence k=new Konkurrence("DM 2016",LocalDate.of(2017, 7, 13));
        System.out.println(k);
        km.createKonkurrence(k);

        System.out.println(konkurrencer);
        }

        //Start hovedmenu I/O
       /* Menu menu = new Menu();
        menu.hovedMenu();
*/

    }

