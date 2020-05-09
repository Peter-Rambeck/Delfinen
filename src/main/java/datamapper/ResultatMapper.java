package datamapper;

import Util.DBConnector;
import model.Konkurrence;
import model.KonkurrenceResultat;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ResultatMapper {
    public void getResultaterFraDB(ArrayList<KonkurrenceResultat> konkurrenceResultats) {
        String query = "";
        Konkurrence tmpResultat = null;

        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM konkurrenceresultat";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while(res.next()) {
                // laver et resultat per iteration og gemmer i listen
                int medlemID=res.getInt("medlemID");
                int konkurrenceID=res.getInt("konkurrenceID");
                String stDisciplin=res.getString("disciplin");

                // to enum
                Time sqlTid = res.getTime("tid");
                LocalTime tid=sqlTid.toLocalTime();

         //       KonkurrenceResultat tmpRes=new KonkurrenceResultat()


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
