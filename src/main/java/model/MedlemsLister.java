package model;

import java.util.ArrayList;

public class MedlemsLister {

    public static ArrayList<Medlem> medlemmer = new ArrayList<>();

    // Subliste med konkurrencemedlemmer
    public static ArrayList<Medlem> konkurrenceMedlemmer = new ArrayList<>();



    //public MedlemsListe() {}

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    // Subliste
    public ArrayList<Medlem> getKonkurrenceMedlemmer() {
        return konkurrenceMedlemmer;
    }



}
