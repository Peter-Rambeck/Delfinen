package datamapper;

import Util.DBConnector;
import model.Konkurrence;
import model.Konkurrencer;
import model.Medlem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;

public class KonkurrenceMapper {

    public int createKonkurrence(Konkurrence konkurrence) {

        int konkurenceID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        //laver ny ordre..
        sqlQuery = "Insert into konkurrence (navn,dato) " +
                "Values(\"" +
                konkurrence.getKonkurrenceNavn()+"\",\"" +

                konkurrence.getKonkurrenceDato()+"\"" +");";
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

    public void getKonkurrenceFraDB() {
        Konkurrencer konkurrencer=new Konkurrencer();
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


                tmpKonkurrence = new Konkurrence(navn,dato);
                tmpKonkurrence.setKonkurrenceID(konkurrenceID);
                Konkurrencer.konkurrenceMap.put(konkurrenceID,tmpKonkurrence);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
