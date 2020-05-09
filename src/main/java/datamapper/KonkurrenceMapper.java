package datamapper;

import Util.DBConnector;
import model.Konkurrence;
import model.KonkurrrenceMedlem;
import model.Medlem;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class KonkurrenceMapper {

    public int createKonkurrence(Konkurrence konkurrence) {

        int konkurenceID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver ny ordre..
        sqlQuery = "Insert into konkurrence (navn,dato) " +
                "Values(\"" +
                konkurrence.getNavn()+"\",\"" +

                konkurrence.getDato()+"\"" +");";
        System.out.println(sqlQuery);
        // lave statement
        try {
            Statement stmt = conn.createStatement();
            //opret i DB
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ordreID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            konkurenceID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return konkurenceID;
    }
    public void getKonkurrenceFraDB(ArrayList<Konkurrence> konkurrencer) {
        String query = "";
        Konkurrence tmpKonkurrence = null;

        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM konkurrence";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while(res.next()) {
                // laver et medlem per iteration og gemmer i listen
                int konkurrenceID=res.getInt("konkurrenceID");
                String navn=res.getString("navn");
                LocalDate dato = res.getDate("dato").toLocalDate();


                tmpKonkurrence = new Konkurrence();
                tmpKonkurrence.setKonkurrenceID(konkurrenceID);
                tmpKonkurrence.setDato(dato);
                tmpKonkurrence.setNavn(navn);
                konkurrencer.add(tmpKonkurrence);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}