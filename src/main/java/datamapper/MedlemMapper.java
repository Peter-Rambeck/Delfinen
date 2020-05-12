package datamapper;
import Util.DBConnector;
import model.Medlem;
import model.MedlemsLister;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MedlemMapper {

    public  int createNewmedlem(Medlem medlem) {

        int medlemID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver ny ordre..
        sqlQuery = "Insert into medlem (forNavn,efterNavn,fodselsaer,email,tlfnr,balance,statu,koen,aldersklasse) " +
                "Values(\"" +
                medlem.getForNavn()+"\",\"" +
                medlem.getEfterNavn()+"\",\"" +
                medlem.getFodselsaer()+"\",\"" +
                medlem.getEmail()+"\",\"" +
                medlem.getTlfNr()+"\",\"" +
                medlem.getBalance()+"\",\"" +
                boolToSql(medlem.isMotionist())+"\",\"" +
                boolToSql(medlem.isAktiv())+"\",\"" +
                boolToSql(medlem.isMand())+"\",\"" +
                boolToSql(medlem.isSenior())+"\"" +");";

        // lave statement
        try {
            Statement stmt = conn.createStatement();
            //opret i DB
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ordreID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            medlemID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return medlemID;
    }


    public void getMedlemmerFraDB(MedlemsLister medlemsLister) {
        String query = "";
        Medlem tmpMedlem = null;

        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM medlem";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while(res.next()) {
                // laver et medlem per iteration og gemmer i listen
                int medlemID=res.getInt("medlemID");

                String fornavn=res.getString("forNavn");

                String efternavn=res.getString("efterNavn");

                String traener=res.getString("traener");

                int fodselsaer=res.getInt("fodselsaer");

                String email=res.getString("email");

                String tlfnr=res.getString("tlfnr");

                int balance=res.getInt("balance");

                int intstatus=res.getInt("statu");
                boolean aktiv=true;
                if (intstatus>0)
                {aktiv= true;}else{aktiv=false;}

                int intkoen=res.getInt("koen");
                boolean mand=true;
                if (intkoen>0)
                {mand= true;}else{mand=false;}

                int intsenior=res.getInt("aldersklasse");
                boolean senior=true;
                if (intsenior>0)
                {senior= true;}else{senior=false;}

                int intmotionist=res.getInt("konkurrencemedlem");
                boolean motionist=true;
                if (intmotionist>0)
                {motionist= true;}else{motionist=false;}

                /*
                Medlem(Status status, Koen koen, AldersKlasse aldersKlasse, String forNavn, String efterNavn, int alder, String email, String tlfNr)
                */

                tmpMedlem = new Medlem(aktiv,mand, senior,motionist,fornavn,efternavn,traener,fodselsaer,email,tlfnr,balance);
                tmpMedlem.setMedlemID(medlemID);
                System.out.println(tmpMedlem);
                medlemsLister.medlemMap.put(medlemID,tmpMedlem);
                //medlemmer.add(tmpMedlem);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void updateBalanceIDB(Medlem medlem){
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();
        int nyBalance=medlem.getBalance();
        int medlemID=medlem.getMedlemID();
        sqlQuery = "UPDATE medlem SET balance ="+nyBalance+" WHERE medlemID="+medlemID+";";

        // lave statement
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int boolToSql(boolean bool) {
        int retVal = 0;
        if (bool == true) {
            retVal = 1;
        }
        return retVal;
    }

}


