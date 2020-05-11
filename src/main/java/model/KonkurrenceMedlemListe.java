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





    /*
    public static HashMap <Integer, KonkurrrenceMedlem> konkurrrenceMedlemMap = new HashMap <Integer, KonkurrrenceMedlem>();


    @Override
    public String toString() {
        String retVal = "konkurrenceMedlemmer";
        for (Medlem konkurrenceMedlem : konkurrrenceMedlemMap.values()) {
            retVal = retVal + konkurrenceMedlem.toString() + "\n";
        }
        return retVal;
    }
     */


}
