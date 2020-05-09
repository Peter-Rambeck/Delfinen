package model;

import datamapper.KonkurrenceMapper;
import datamapper.MedlemMapper;

import java.time.LocalDate;

public class Konkurrence {
    int konkurrenceID;
    private String navn;
    private LocalDate dato;



    public void konkurrence(String navn, LocalDate dato) {
        this.navn = navn;
        this.dato = dato;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getKonkurrenceID() {
        return konkurrenceID;
    }

    public void setKonkurrenceID(int konkurrenceID) {
        this.konkurrenceID = konkurrenceID;
    }

    @Override
    public String toString() {
        return "Konkurrence{" +
                "konkurrenceID=" + konkurrenceID +
                ", navn='" + navn + '\'' +
                ", dato=" + dato +
                '}';
    }
/*
    public void gemIDB(){
        KonkurrenceMapper konkurrenceMapper = new KonkurrenceMapper();
        int konkurrenceID = konkurrenceMapper.opretKonkurrence(this);
        this.setKonkurrenceID(konkurrenceID);

     */

}
