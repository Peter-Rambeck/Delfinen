package model;

import datamapper.MedlemMapper;

import java.util.ArrayList;

public class KonkurrrenceMedlem extends Medlem {

    private String traener = "Tom";
    // Enum.Svoemmediciplin svoemmediciplin;

    public KonkurrrenceMedlem(
                              Status status,
                              Koen koen,
                              AldersKlasse aldersKlasse,
                              String forNavn,
                              String efterNavn,
                              int alder,
                              String email,
                              String tlfNr,
                              String traener) {
        super(status, koen, aldersKlasse, forNavn, efterNavn, alder, email, tlfNr);
        this.traener = traener;
    }

    public String toString()
    {
        return (super.toString()+
                "\" traener: "+ traener
                );
    }


}
