package datamapper;

import Util.DBConnector;
import model.Konkurrence;
import model.Medlem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
