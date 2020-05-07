package datamapper;
import Util.DBConnector;
import model.Medlem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}


