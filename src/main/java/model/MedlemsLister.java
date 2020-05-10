package model;

import java.util.ArrayList;
import java.util.HashMap;

public class MedlemsLister {

   // public static ArrayList<Medlem> medlemmer = new ArrayList<>();Medlem>();
    public static HashMap<Integer, Medlem> medlemMap = new HashMap<Integer, Medlem>();

//    public static HashMap<Integer, Medlem> medlemMap = new HashMap<Integer, Medlem>();

    @Override
    public String toString() {
        String retVal="Medlemmer";
        for (Medlem medlem:medlemMap.values()) {
            retVal=retVal+medlem.toString()+"\n";
        }
        return retVal;
    }


    public String KortToString() {
        String retVal="Medlemmer\n";
        for (Medlem medlem:medlemMap.values()) {
            retVal=retVal+medlem.kortToString()+"\n";
        }
        return retVal;
    }



// Subliste med konkurrencemedlemmer
   // public static ArrayList<Medlem> konkurrenceMedlemmer = new ArrayList<>();



    //public MedlemsListe() {}
/*
    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }
*/
    // Subliste
  /*  public ArrayList<Medlem> getKonkurrenceMedlemmer() {
        return konkurrenceMedlemmer;
    }
*/


}
