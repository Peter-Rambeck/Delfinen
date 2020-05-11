package model;

import datamapper.KonkurrenceMapper;

import java.time.LocalDate;

public class Konkurrence {

    int konkurrenceID;
    String konkurrenceNavn;
    LocalDate konkurrenceDato;
    // Contructor
    public Konkurrence(String konkurrenceNavn, LocalDate konkurrenceDato) {
        this.konkurrenceNavn = konkurrenceNavn;
        this.konkurrenceDato = konkurrenceDato;

    }
        //Opretter ID for ny konkurrence
    public int getKonkurrenceID() {
        return konkurrenceID;
    }

                //Sætter ID for konkurrencen
    public void setKonkurrenceID(int konkurrenceID) {
        this.konkurrenceID = konkurrenceID;
    }

                    //Henter navnet på konkurrencen
    public String getKonkurrenceNavn() {
        return konkurrenceNavn;
    }

                    //Henter datoen for konkurrencen
    public LocalDate getKonkurrenceDato() {
        return konkurrenceDato;
    }

    @Override
    //Udskriver ID, navn og dato
    public String toString() {
        return  "nr:" + konkurrenceID +" "+
                konkurrenceNavn +" "+
                konkurrenceDato;
    }

    public void setKonkurrenceNavn(String konkurrenceNavn) {
        this.konkurrenceNavn = konkurrenceNavn;
    }

    public void setKonkurrenceDato(LocalDate konkurrenceDato) {
        this.konkurrenceDato = konkurrenceDato;
    }
        //Gemmer konkurrencen i databasen, modtager ID fra databasen og gemmer det i konkurrencemappet
    public void gem(){
        KonkurrenceMapper konkurrenceMapper = new KonkurrenceMapper();
        int konkurrenceID=konkurrenceMapper.createKonkurrence(this);
        this.setKonkurrenceID(konkurrenceID);
        Konkurrencer.konkurrenceMap.put(konkurrenceID,this);
    }

}
