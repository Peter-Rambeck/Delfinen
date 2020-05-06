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

    public boolean isMand() {
        return mand;
    }

    public boolean isSenior() {
        return senior;
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

    public String getTlfNr() {
        return tlfNr;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setMedlemID(int medlemID) {
        this.medlemID = medlemID;
    }
}


