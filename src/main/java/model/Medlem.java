package model;

import datamapper.MedlemMapper;

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
            //constructor


    public Medlem(boolean aktiv, boolean mand, boolean senior, boolean motionist, String forNavn, String efterNavn, String traener, int fodselsaer, String email, String tlfNr, int balance) {
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
    public void gem(){
        MedlemsLister medlemsLister=new MedlemsLister();
        MedlemMapper medlemMapper = new MedlemMapper();
        int medlemID=medlemMapper.createNewmedlem(this);
        this.setMedlemID(medlemID);
        medlemsLister.medlemMap.put(medlemID,this);

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

    public void setAlder(int alder) {
        this.alder = alder;
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

    //public void opretMedlem(boolean aktiv, boolean mand, boolean senior, String forNavn, String efterNavn, int alder, String email, String tlfNr) {
    // }

    public String kortToString(){
        String retVal=medlemID+" "+forNavn+" "+efterNavn;
        return retVal;
    }
    @Override

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
                ", alder=" + alder +
                ", email='" + email + '\'' +
                ", tlfNr='" + tlfNr + '\'' +
                ", balance=" + balance +
                '}';
    }
}


