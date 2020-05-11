package model;

import java.util.ArrayList;
import java.util.HashMap;

public class KonkurrenceMedlemListe {

    ArrayList<KonkurrrenceMedlem> konkurrrenceMedlemmer = new ArrayList<>();

    public KonkurrenceMedlemListe() {
    }

    public void gem(KonkurrrenceMedlem konkurrrenceMedlem) {
        konkurrrenceMedlemmer.add(konkurrrenceMedlem);
    }

}
