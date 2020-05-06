import datamapper.MedlemMapper;
import model.Medlem;

public class Main {

    public static void main(String[] args) {
        Medlem medlem=new Medlem(true,true,true,"jens","gelbek",48,"fndslg@mflkr.com","3535353");
        MedlemMapper mm=new MedlemMapper();
        System.out.println( mm.createNewmedlem(medlem));

        Menu menu = new Menu();
        menu.hovedMenu();


    }
}
