package datamapper;

import Util.DBConnector;
import model.Konkurrence;
import model.Konkurrencer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class KonkurrenceMapperTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createKonkurrence() {
        KonkurrenceMapper km=new KonkurrenceMapper();
        Konkurrencer konkurrencer=new Konkurrencer();
        //slet konkurrencelist
        konkurrencer.konkurrenceMap.clear();
        //indlæs fra DB
        km.getKonkurrencerFraDB(konkurrencer);
         //antal konkurrencer i Konkurrence list
        int antalkonkurrncerInden= Konkurrencer.konkurrenceMap.size();
        int konkurrenceID;
        String konkurrenceNavn="TestKonkurrence";
        LocalDate konkurrenceDato = LocalDate.of(2019, 12, 25);
        //opretter konkurrence objekt
        Konkurrence konkurrence=new Konkurrence(konkurrenceNavn,konkurrenceDato);
        // læg konkurrence over i DB og liste
        konkurrence.gem();
        konkurrenceID=konkurrence.getKonkurrenceID();
        System.out.println(konkurrence+"gjoie");
        //slet konkurrencelist
        konkurrencer.konkurrenceMap.clear();
        //indlæs fra DB igen
        km.getKonkurrencerFraDB(konkurrencer);
        //antal konkurrencer i Konkurrence list
        int antalkonkurrncerefter= Konkurrencer.konkurrenceMap.size();
        //er der en konkurrence mere nu
        assertEquals((antalkonkurrncerInden+1),antalkonkurrncerefter);
        //findes konkurence som er gemt i DB og hentet, i listen
         assertEquals(true,Konkurrencer.konkurrenceMap.containsKey(konkurrenceID));
        //er datoen også kommet rigtig tilbage
        assertEquals(Konkurrencer.konkurrenceMap.get(konkurrenceID).getKonkurrenceDato(),konkurrenceDato);


        //slet oprettet konkurrence fra DB
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();
        sqlQuery = "DELETE FROM konkurrence WHERE konkurrenceID="+konkurrenceID+";";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //slet konkurrencelist
        konkurrencer.konkurrenceMap.clear();
        //indlæs fra DB
        km.getKonkurrencerFraDB(konkurrencer);
    }

    @Test
    public void getKonkurrencerFraDB() {
    }
}