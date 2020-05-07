package model;

import datamapper.MedlemMapper;

public class Medlem {
    public enum Status {
        aktiv,
        passiv
    }
    public enum Koen {
        mand,
        kvinde
    }
    public enum AldersKlasse {
        junior,
        senior
    }

    private Status status;
    private Koen koen;
    private AldersKlasse AldersKlasse;
    private int medlemID; // (fra DB)
    private String forNavn;
    private String efterNavn;
    private int alder;
    private String email;
    private String tlfNr;
    private int balance;

    public Medlem(Status status, Koen koen, AldersKlasse aldersKlasse, String forNavn, String efterNavn, int alder, String email, String tlfNr) {
        this.status = status;
        this.koen = koen;
        this.AldersKlasse = aldersKlasse;
        this.forNavn = forNavn;
        this.efterNavn = efterNavn;
        this.alder = alder;
        this.email = email;
        this.tlfNr = tlfNr;
        this.balance = 0;
    }
    public void gemIDB(){
        MedlemMapper medlemMapper = new MedlemMapper();
        int medlemID=medlemMapper.createNewmedlem(this);
        this.setMedlemID(medlemID);
    }


    public int getMedlemID() {
        return medlemID;
    }

    public String getForNavn() {
        return forNavn;
    }

    public String getEfterNavn() {
        return efterNavn;
    }

    public int getAlder() {
        return alder;
    }

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    public Koen getKoen() {
        return koen;
    }

    public Medlem.AldersKlasse getAldersKlasse() {
        return AldersKlasse;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public int getBalance() {
        return balance;
    }


    public void setMedlemID(int medlemID) {
        this.medlemID = medlemID;
    }

    //public void opretMedlem(boolean aktiv, boolean mand, boolean senior, String forNavn, String efterNavn, int alder, String email, String tlfNr) {
    // }


    @Override
    public String toString() {
        return "Medlem{" +
                "status=" + status +
                ", koen=" + koen +
                ", AldersKlasse=" + AldersKlasse +
                ", medlemID=" + medlemID +
                ", forNavn='" + forNavn + '\'' +
                ", efterNavn='" + efterNavn + '\'' +
                ", alder=" + alder +
                ", email='" + email + '\'' +
                ", tlfNr='" + tlfNr + '\'' +
                ", balance=" + balance +
                '}';
    }
}


