package datamapper;

import Util.DBConnector;
import model.*;

import java.sql.*;
import java.time.LocalTime;

import static model.KonkurrenceResultat.*;
import static model.KonkurrenceResultat.Svoemmediciplin.*;

/*
private int konkurrenceResultatID;
    private KonkurrrenceMedlem Medlem;
    private Konkurrence konkurrence;
    public Svoemmediciplin svoemmediciplin;
    private LocalTime tid;

 */
public class ResultatMapper {
    public int createKonkurrenceResultat(KonkurrenceResultat konkurrenceResultat) {

        int konkurenceresultatID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver ny ordre..
        sqlQuery = "Insert into konkurrenceresultat (medlemID,konkurrenceID,disciplin,tid) " +
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
            query = "SELECT * FROM konkurrenceresultat";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            Konkurrencer konkurrencer=new Konkurrencer();
            MedlemsLister medlemsLister=new MedlemsLister();
            int resultatID;
            while(res.next()) {
                // laver et resultat per iteration og gemmer i listen
                resultatID=res.getInt("resultatID");
                System.out.println(resultatID);
                int medlemID=res.getInt("medlemID");
                int konkurrenceID=res.getInt("konkurrenceID");
                String stDisciplin=res.getString("disciplin");
                Svoemmediciplin svoemmediciplin;
                switch (stDisciplin){
                    case "bryst":
                        svoemmediciplin= brystsvoemning;break;
                    case "crawl":
                        svoemmediciplin=crawl;break;
                    case "butterfly":
                        svoemmediciplin=butterfly;break;
                    case "rygcrawl":
                        svoemmediciplin=rygcrawl;break;
                    default:
                        svoemmediciplin=crawl;

                }
                // to enum
                Timestamp sqlTid = res.getTimestamp("tid");
                System.out.println("sql"+sqlTid);
                LocalTime tid=sqlTid.toLocalDateTime().toLocalTime();
                System.out.println("java"+tid);

                // sæt resultatet sammen
                KonkurrenceResultat tmpRes=new KonkurrenceResultat( medlemsLister.medlemMap.get(medlemID),
                                                                    konkurrencer.konkurrenceMap.get(konkurrenceID),
                                                                   svoemmediciplin,
                                                                   tid);
                // tilføj resultat til resultat map..med reultatID som key
                System.out.println(resultatID);
                tmpRes.setKonkurrenceResultatID(resultatID);
                KonkurrenceResultater.konkurrenceResultatMap.put(resultatID,tmpRes);





            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
