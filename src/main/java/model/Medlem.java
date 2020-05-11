package model;

import datamapper.MedlemMapper;

public class Medlem {

    /*

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

     */

    private Enum.Status status;
    private Enum.Koen koen;
    private static Enum.AldersKlasse AldersKlasse;
    private int medlemID; // (fra DB)
    private String forNavn;
    private String efterNavn;
    private int alder;
    private String email;
    private String tlfNr;
    private int balance;

    public Medlem(Enum.Status status, Enum.Koen koen, Enum.AldersKlasse aldersKlasse, String forNavn, String efterNavn, int alder, String email, String tlfNr) {
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

    public void gem(){
        MedlemsLister medlemsLister=new MedlemsLister();
        MedlemMapper medlemMapper = new MedlemMapper();
        int medlemID=medlemMapper.createNewmedlem(this);
        this.setMedlemID(medlemID);
        medlemsLister.medlemMap.put(medlemID,this);

    }


    public String balanceToString(){
        String retVal=medlemID+" "+forNavn+" "+efterNavn+" "+balance+"\n";
        return retVal;
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

    public Enum.Status getStatus() {
        return status;
    }

    public Enum.Koen getKoen() {
        return koen;
    }

    public Enum.AldersKlasse getAldersKlasse() {
        return AldersKlasse;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setMedlemID(int medlemID) {
        this.medlemID = medlemID;
    }

    //public void opretMedlem(boolean aktiv, boolean mand, boolean senior, String forNavn, String efterNavn, int alder, String email, String tlfNr) {
    // }

    public String kortToString(){
        String retVal=medlemID+" "+forNavn+" "+efterNavn;
        return retVal;
    }
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


