package model;

import datamapper.MedlemMapper;
import java.time.Year;

public class Medlem {
    private boolean aktiv;
    private boolean mand;
    private boolean senior;
    private boolean motionist;
    private int medlemID; // (fra DB)
    private String forNavn;
    private String efterNavn;
    private String traener;
    private int fodselsaer;
    private String email;
    private String tlfNr;
    private int balance;

    public Medlem(boolean aktiv, boolean mand, boolean senior, boolean motionist, String forNavn, String efterNavn, String traener, int fodselsaer, String email, String tlfNr, int balance) {
        //constructor med alt undtagen ID, som skal komme fra DB
        this.aktiv = aktiv;
        this.mand = mand;
        this.senior = senior;
        this.motionist = motionist;
        this.forNavn = forNavn;
        this.efterNavn = efterNavn;
        this.traener = traener;
        this.fodselsaer = fodselsaer;
        this.email = email;
        this.tlfNr = tlfNr;
        this.balance = balance;
    }

    //Opretter medlem i databasen, modtager id fra databasen og gemmer det i hashmap
    public void gem() {
        MedlemsLister medlemsLister = new MedlemsLister();
        MedlemMapper medlemMapper = new MedlemMapper();
        //opretter medlem i DB og modtager ID
        int medlemID = medlemMapper.createNewmedlem(this);
        //gem ID i medelm
        this.setMedlemID(medlemID);
        //tilføj medlem til hashmap, med id som nøgle
        medlemsLister.medlemMap.put(medlemID, this);

    }
    public int getAlder (){
        //find alder udfra fødselsår (bruges af kontingent)
        Year y=Year.now();
        return this.fodselsaer-y.getValue();
    }

    public int getFodselsaer() {
        return fodselsaer;
    }

    public void setFodselsaer(int fodselsaer) {
        this.fodselsaer = fodselsaer;
    }

    public String getTraener() {
        return traener;
    }

    public void setTraener(String traener) {
        this.traener = traener;
    }

    public String balanceToString() {
        //toString der bruges af restance udskrivningen
        String retVal = medlemID + " " + forNavn + " " + efterNavn + " " + balance + "\n";
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


    public String getEmail() {
        return email;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean isMand() {
        return mand;
    }

    public void setMand(boolean mand) {
        this.mand = mand;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    public boolean isMotionist() {
        return motionist;
    }

    public void setMotionist(boolean motionist) {
        this.motionist = motionist;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public void setEfterNavn(String efterNavn) {
        this.efterNavn = efterNavn;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
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



    public String kortToString() {
        //en toString som ikke indeholdr noget overflødigt, kunid og navn
        String retVal = medlemID + " " + forNavn + " " + efterNavn;
        return retVal;
    }

    @Override
    public String toString() {
        return "Medlem{" +
                "aktiv=" + aktiv +
                ", mand=" + mand +
                ", senior=" + senior +
                ", motionist=" + motionist +
                ", medlemID=" + medlemID +
                ", forNavn='" + forNavn + '\'' +
                ", efterNavn='" + efterNavn + '\'' +
                ", traener='" + traener + '\'' +
                ", fodselsaer=" + fodselsaer +
                ", email='" + email + '\'' +
                ", tlfNr='" + tlfNr + '\'' +
                ", balance=" + balance +
                '}';
    }
}


