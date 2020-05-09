package model;

import datamapper.KonkurrenceMapper;
import datamapper.MedlemMapper;

import java.time.LocalDate;

public class Konkurrence {

    int konkurrenceID;
    String konkurrenceNavn;
    LocalDate konkurrenceDato;

    public Konkurrence(String konkurrenceNavn, LocalDate konkurrenceDato) {
        this.konkurrenceNavn = konkurrenceNavn;
        this.konkurrenceDato = konkurrenceDato;
    }

    public int getKonkurrenceID() {
        return konkurrenceID;
    }

    public void setKonkurrenceID(int medlemID) {
        this.konkurrenceID = konkurrenceID;
    }

    @Override
    public String toString() {
        return "Konkurrence{" +
                "konkurrenceID=" + konkurrenceID +
                ", konkurrenceNavn='" + konkurrenceNavn + '\'' +
                ", konkurrenceDato=" + konkurrenceDato +
                '}';
    }

    /*
    public void gemIDB(){
        KonkurrenceMapper konkurrenceMapper = new KonkurrenceMapper();
        int konkurrenceID = konkurrenceMapper.opretKonkurrence(this);
        this.setKonkurrenceID(konkurrenceID);

     */

}
