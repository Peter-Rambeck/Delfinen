package datamapper;

import Util.DBConnector;
import model.*;
import java.sql.*;

public class ResultatMapper {
    public int createKonkurrenceResultat(KonkurrenceResultat konkurrenceResultat) {
    //opretter resultat i DB og returnerer det tildelte ID
        int konkurenceresultatID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //query der insætter resultat i DB
        sqlQuery = "Insert into resultat (medlemID,konkurrenceID,disciplin,tid) " +
                "Values(\"" +
                konkurrenceResultat.getMedlem().getMedlemID()+"\",\"" +
                konkurrenceResultat.getKonkurrence().getKonkurrenceID()+"\",\""+
                konkurrenceResultat.getSvoemmediciplin()+"\",\""+
                konkurrenceResultat.getTid()+"\"" +");";
        try {
            Statement stmt = conn.createStatement();
            //kør query der opretter i DB
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ordreID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            //gem ID i resultat
            konkurenceresultatID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return konkurenceresultatID;
    }



    public void getResultaterFraDB(KonkurrenceResultater resultatliste) {
        //hent alle resultater fra DB og gem i konkurrenceResultater
        String query = "";
        Konkurrence tmpResultat = null;

        Connection conn = DBConnector.getInstance().getConnection();
        try {
            //query der vælger alle resultater i DB
            query = "SELECT * FROM resultat";
            Statement stmt = conn.createStatement();

            //kør query og gem resultat i res
            ResultSet res = stmt.executeQuery(query);

            //konkurrence lister til at hente konkurrencer i
            Konkurrencer konkurrencer=new Konkurrencer();

            //medlemsliste til at hente medlemmer
            MedlemsLister medlemsLister=new MedlemsLister();

            int resultatID;
            while(res.next()) {
                // laver et resultat per iteration og gemmer i listen
                resultatID=res.getInt("resultatID");
                int medlemID=res.getInt("medlemID");
                int konkurrenceID=res.getInt("konkurrenceID");
                int svoemmediciplin=res.getInt("disciplin");
                int tid =res.getInt("tid");
                //gem det hentede i tmpresultat, konkurrence og medlem hentes i lister udfraID
                KonkurrenceResultat tmpKonkurrenceResultat=new KonkurrenceResultat(medlemsLister.medlemMap.get(medlemID),
                                                                                konkurrencer.konkurrenceMap.get(konkurrenceID),
                                                                                svoemmediciplin,
                                                                                tid);
                //sær ID på resultatet
                tmpKonkurrenceResultat.setKonkurrenceResultatID(resultatID);
                //gem resultatet i resultatlisten
                resultatliste.konkurrenceResultatMap.put(resultatID,tmpKonkurrenceResultat);
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
