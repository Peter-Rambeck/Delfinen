package datamapper;

import Util.DBConnector;
import model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
                Time sqlTid = res.getTime("tid");
                LocalTime tid=sqlTid.toLocalTime();

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
