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

    public static int createNewmedlem(Medlem medlem) {

        int medlemID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver ny ordre..
        sqlQuery = "Insert into medlem (forNavn,efterNavn,alder,email,tlfnr,balance,statu,koen,aldersklasse) " +
                "Values(\"" +
                medlem.getForNavn()+"\",\"" +
                medlem.getEfterNavn()+"\",\"" +
                medlem.getAlder()+"\",\"" +
                medlem.getEmail()+"\",\"" +
                medlem.getTlfNr()+"\",\"" +
                medlem.getBalance()+"\",\"" +
                medlem.getStatus()+"\",\"" +
                medlem.getKoen()+"\",\"" +
                medlem.getAldersKlasse()+"\"" +");";

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

                int alder=res.getInt("alder");

                String email=res.getString("email");

                String tlfnr=res.getString("tlfnr");

                int balance=res.getInt("balance");

                String ststatus=res.getString("statu");

                Medlem.Status status;
                if (ststatus.equals("passiv"))
                {status= Medlem.Status.passiv;}else{status= Medlem.Status.aktiv;}
                // System.out.println(ststatus);

                String stkoen=res.getString("koen");
                Medlem.Koen koen;
                if(stkoen.equalsIgnoreCase("mand")){koen= Medlem.Koen.mand;}else{koen= Medlem.Koen.kvinde;};

                String staldersKlasse=res.getString("aldersKlasse");
                Medlem.AldersKlasse aldersKlasse;
                if(staldersKlasse.equalsIgnoreCase( "junior")){aldersKlasse= Medlem.AldersKlasse.junior;}else {aldersKlasse= Medlem.AldersKlasse.senior;};

                /*
                Medlem(Status status, Koen koen, AldersKlasse aldersKlasse, String forNavn, String efterNavn, int alder, String email, String tlfNr)
                */

                tmpMedlem = new Medlem(status,koen, aldersKlasse,fornavn,efternavn,alder,email,tlfnr);
                tmpMedlem.setMedlemID(medlemID);
                tmpMedlem.setBalance(balance);
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

}


