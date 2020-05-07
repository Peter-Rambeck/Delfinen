import IOMenu.Menu;
import datamapper.MedlemMapper;
import model.Medlem;

import static model.Medlem.AldersKlasse.senior;
import static model.Medlem.Koen.mand;
import static model.Medlem.Status.passiv;


public class Main {

    public static void main(String[] args) {
     /*    Medlem medlem=new Medlem(passiv,mand, senior,"jens","gelbek",48,"fndslg@mflkr.com","3535353");
        MedlemMapper mm=new MedlemMapper();
         System.out.println( mm.createNewmedlem(medlem));
*/
       Menu menu = new Menu();
      menu.hovedMenu();


    }
}
