package datamapper;
import Util.DBConnector;
import model.Medlem;
import model.MedlemsLister;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedlemMapper {

    public  int createNewmedlem(Medlem medlem) {
    // opretter medlem i DB og returnerer IDvfra DB
        int medlemID = 0;
        String sqlQuery;
        Connection conn = DBConnector.getInstance().getConnection();

        //Query der indsætter medlem i DB.
        sqlQuery = "Insert into medlem (forNavn,efterNavn,fodselsaer,email,tlfnr,balance,statu,konkurrencemedlem,koen,aldersklasse,traener) " +
                "Values(\"" +
                medlem.getForNavn()+"\",\"" +
                medlem.getEfterNavn()+"\",\"" +
                medlem.getFodselsaer()+"\",\"" +
                medlem.getEmail()+"\",\"" +
                medlem.getTlfNr()+"\",\"" +
                medlem.getBalance()+"\",\"" +
                boolToSql(!medlem.isMotionist())+"\",\"" +
                boolToSql(medlem.isAktiv())+"\",\"" +
                boolToSql(medlem.isMand())+"\",\"" +
                boolToSql(medlem.isSenior())+"\",\"" +
                medlem.getTraener()+"\"" +");";
        try {
            Statement stmt = conn.createStatement();
            //kør query...
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ID fra DB vha ResultSet
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            medlemID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return medlemID;
    }


    public void getMedlemmerFraDB(MedlemsLister medlemsLister) {
        String query = "";
        Medlem tmpMedlem;

        Connection conn = DBConnector.getInstance().getConnection();
        try {
            //query der vælger alle medlemmer i DB
            query = "SELECT * FROM medlem";
            Statement stmt = conn.createStatement();
            //kør query og gem resultat i res
            ResultSet res = stmt.executeQuery(query);

            while(res.next()) {
                // laver et medlem per iteration og gemmer i listen
                int medlemID=res.getInt("medlemID");
                String fornavn=res.getString("forNavn");
                String efternavn=res.getString("efterNavn");
                String traener=res.getString("traener");
                int fodselsaer=res.getInt("fodselsaer");
                String email=res.getString("email");
                String tlfnr=res.getString("tlfnr");
                int balance=res.getInt("balance");

                //aktiv er boolean i java og 0/1 i db
                int intstatus=res.getInt("statu");
                boolean aktiv=sqlToBool(intstatus);

                 //koen er boolean i java og 0/1 i DB OBS hedder mand i java og koen i DB
                int intkoen=res.getInt("koen");
                boolean mand=sqlToBool(intkoen);

                //senior er boolean i java og 0/1 i DB OBS hedder senior i java og aldersklasse i DB
                int intsenior=res.getInt("aldersklasse");
                boolean senior=sqlToBool(intsenior);
                //motionist er boolean i java og 0/1 i DB OBS hedder motionist i java og konkurrncemedlem i DB
                int konkurrencemedlem=res.getInt("konkurrencemedlem");
                boolean motionist=!sqlToBool(konkurrencemedlem);

                // laver medlem udfra det hentede
                tmpMedlem = new Medlem(aktiv,mand, senior,motionist,fornavn,efternavn,traener,fodselsaer,email,tlfnr,balance);
                tmpMedlem.setMedlemID(medlemID);

                //gemmer det hentde medlem i medlemsLister
                medlemsLister.medlemMap.put(medlemID,tmpMedlem);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public void updateBalanceIDB(Medlem medlem){
        //Bruges til at opdatere balance i medlemmer iDB når kasseeren roder med kontinger
        String sqlQuery;
        Connection conn = DBConnector.getInstance().getConnection();
        //den balance der skal gemmes i DB
        int nyBalance=medlem.getBalance();
        //medlemID på det medlem der skal ændres i
        int medlemID=medlem.getMedlemID();
        //query der ænrer balancen i medlem med medlemID
        sqlQuery = "UPDATE medlem SET balance ="+nyBalance+" WHERE medlemID="+medlemID+";";
       try {
            Statement stmt = conn.createStatement();
            //kør query
            stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int boolToSql(boolean bool) {
        //udregner værdi af boolean til brug i DB
        int retVal = 0;
        if (bool == true) {
            retVal = 1;
        }
        return retVal;
    }
    public boolean sqlToBool(int sqlint){
        //udregner boolean udfra int fra DB
        boolean retVal=false;
        if (sqlint>0)
        {retVal= true;}else{retVal=false;}
        return retVal;
    }

}


