import IOMenu.Menu;
import datamapper.KonkurrenceMapper;
import datamapper.MedlemMapper;
import model.Konkurrence;
import model.KonkurrrenceMedlem;
import model.Medlem;
import model.MedlemsListe;

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
        KonkurrenceMapper km=new KonkurrenceMapper();
        Konkurrence k=new Konkurrence();
        k.setDato(LocalDate.of(2017, 1, 13));
        k.setNavn("DM 2017");
        km.createKonkurrence(k);

        //Start hovedmenu I/O
       /* Menu menu = new Menu();
        menu.hovedMenu();
*/

    }
}
