package model;

public class Medlem {

    private boolean aktiv;
    private boolean mand;
    private boolean senior;
    private int medlemID; // (fra DB)
    private String forNavn;
    private String efterNavn;
    private int alder;
    private String email;
    private String tlfNr;
    private int balance;

    public Medlem(boolean aktiv, boolean mand, boolean senior, String forNavn, String efterNavn, int alder, String email, String tlfNr) {
        this.aktiv = aktiv;
        this.mand = mand;
        this.senior = senior;
        this.forNavn = forNavn;
        this.efterNavn = efterNavn;
        this.alder = alder;
        this.email = email;
        this.tlfNr = tlfNr;
        this.balance = 0;
    }

    public void setMedlemID(int medlemID) {
        this.medlemID = medlemID;
    }

    public void opretMedlem(boolean aktiv, boolean mand, boolean senior, String forNavn, String efterNavn, int alder, String email, String tlfNr) {

    }

}


