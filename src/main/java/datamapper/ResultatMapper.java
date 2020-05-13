package datamapper;

import Util.DBConnector;
import model.*;

import java.sql.*;



public class ResultatMapper {
    public int createKonkurrenceResultat(KonkurrenceResultat konkurrenceResultat) {

        int konkurenceresultatID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver nyt resultat..
        sqlQuery = "Insert into resultat (medlemID,konkurrenceID,disciplin,tid) " +
                "Values(\"" +
                konkurrenceResultat.getMedlem().getMedlemID()+"\",\"" +
                konkurrenceResultat.getKonkurrence().getKonkurrenceID()+"\",\""+
                konkurrenceResultat.getSvoemmediciplin()+"\",\""+
                konkurrenceResultat.getTid()+"\"" +");";
        System.out.println(sqlQuery);
        // lave statement
        try {
            Statement stmt = conn.createStatement();
            //opret i DB
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ordreID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            konkurenceresultatID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return konkurenceresultatID;
    }



    public void getResultaterFraDB() {
        String query = "";
        Konkurrence tmpResultat = null;
        KonkurrenceResultater konkurrenceResultater=new KonkurrenceResultater();

        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM resultat";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            Konkurrencer konkurrencer=new Konkurrencer();
            MedlemsLister medlemsLister=new MedlemsLister();
            KonkurrenceResultater resultatliste=new KonkurrenceResultater();
            int resultatID;
            while(res.next()) {
                // laver et resultat per iteration og gemmer i listen
                resultatID=res.getInt("resultatID");
                int medlemID=res.getInt("medlemID");
                int konkurrenceID=res.getInt("konkurrenceID");
                int svoemmediciplin=res.getInt("disciplin");
                int tid =res.getInt("tid");
                KonkurrenceResultat tmpKonkurrenceResultat=new KonkurrenceResultat(medlemsLister.medlemMap.get(medlemID),
                                                                                konkurrencer.konkurrenceMap.get(konkurrenceID),
                                                                                svoemmediciplin,
                                                                                tid);

                tmpKonkurrenceResultat.setKonkurrenceResultatID(resultatID);
                resultatliste.konkurrenceResultatMap.put(resultatID,tmpKonkurrenceResultat);


                }





        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
