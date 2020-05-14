import IOMenu.Menu;
import datamapper.IndlaesAltFraDB;
import model.MedlemsLister;


public class Main {

    public static void main(String[] args) {

        //indlæs databasen
        IndlaesAltFraDB indlaesAltFraDB=new IndlaesAltFraDB();
        System.out.println(MedlemsLister.medlemMap.get(1));
        System.out.println(MedlemsLister.medlemMap.get(9));

        //kør menuen
        Menu menu = new Menu();
        menu.hovedMenu();


    }
}


