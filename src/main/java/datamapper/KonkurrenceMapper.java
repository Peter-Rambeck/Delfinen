package datamapper;

import Util.DBConnector;
import model.Konkurrence;
import model.Konkurrencer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class KonkurrenceMapper {

    public int createKonkurrence(Konkurrence konkurrence) {
        //opretter Konkurrence i DB og det ID den får i DB

        int konkurenceID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver Query der opretter konkurrence DB..
        sqlQuery = "Insert into konkurrence (navn,dato) " +
                "Values(\"" +
                konkurrence.getKonkurrenceNavn()+"\",\"" +
                konkurrence.getKonkurrenceDato()+"\"" +");";
        try {
            Statement stmt = conn.createStatement();
            //kør query
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            //giv det modtagene id til objektet
            konkurenceID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return konkurenceID;
    }

    public void getKonkurrencerFraDB(Konkurrencer konkurrencer) {
        //hent alle konkurrencer fra DB og gem dem i Konkurrencer
        String query = "";
        Konkurrence tmpKonkurrence;

        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            //lav query der henter alle konkurrncer fra DB
            query = "SELECT * FROM konkurrence";
            Statement stmt = conn.createStatement();
            //Kør query og gem resultat i res
            ResultSet res = stmt.executeQuery(query);
            while(res.next()) {
                // laver konkurrence per iteration og gemmer i Konkurrencer
                int konkurrenceID=res.getInt("konkurrenceID");
                String navn=res.getString("navn");
                LocalDate dato = res.getDate("dato").toLocalDate();
                //gem de hentede data i ny konkurrence
                tmpKonkurrence = new Konkurrence(navn,dato);
                //sæt ID i konkurrencen til det fra DB
                tmpKonkurrence.setKonkurrenceID(konkurrenceID);
                //tilføj kokurrencen til konkurrencer
                Konkurrencer.konkurrenceMap.put(konkurrenceID,tmpKonkurrence);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
