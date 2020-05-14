import IOMenu.Menu;
import datamapper.IndlaesAltFraDB;
import model.MedlemsLister;


public class Main {

    public static void main(String[] args) {

        //indlæs databasen
        IndlaesAltFraDB indlaesAltFraDB=new IndlaesAltFraDB();

        //kør menuen
        Menu menu = new Menu();
        menu.hovedMenu();


    }
}


