import IOMenu.Menu;
import datamapper.MedlemMapper;
import model.KonkurrrenceMedlem;
import model.Medlem;
import model.MedlemsListe;

import java.util.ArrayList;

import static model.Medlem.AldersKlasse.senior;
import static model.Medlem.Koen.mand;
import static model.Medlem.Status.passiv;


public class Main {

    public static void main(String[] args) {

        // MedlemMapper mm = new MedlemMapper();
        // MedlemsListe ml=new MedlemsListe();
        // mm.getMedlemmerFraDB(ml.medlemmer);

        //Start hovedmenu I/O
        Menu menu = new Menu();
        menu.hovedMenu();


    }
}
