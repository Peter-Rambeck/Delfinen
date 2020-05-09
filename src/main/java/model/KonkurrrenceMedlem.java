package model;

import java.util.ArrayList;

public class KonkurrrenceMedlem extends Medlem {

    private String Traener;

    ArrayList<KonkurrrenceMedlem> konkurrrenceMedlemmer = new ArrayList<>();

    public KonkurrrenceMedlem(Status status,
                              Koen koen,
                              AldersKlasse aldersKlasse,
                              String forNavn,
                              String efterNavn,
                              int alder,
                              String email,
                              String tlfNr) {
        super(status, koen, aldersKlasse, forNavn, efterNavn, alder, email, tlfNr);
    }

}
