package model;

import datamapper.MedlemMapper;

import java.util.ArrayList;

public class KonkurrrenceMedlem extends Medlem {

    private String Traener = "Tom";




    public KonkurrrenceMedlem(
                              Enum.Status status,
                              Enum.Koen koen,
                              Enum.AldersKlasse aldersKlasse,
                              String forNavn,
                              String efterNavn,
                              int alder,
                              String email,
                              String tlfNr) {
        super(status, koen, aldersKlasse, forNavn, efterNavn, alder, email, tlfNr);
    }

    public String toString()
    {
        return (super.toString()+
                "\" Traener: "+ Traener);
    }


}
