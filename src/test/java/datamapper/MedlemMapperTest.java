package datamapper;

import junit.framework.TestCase;
import model.Medlem;
import model.MedlemsLister;

public class MedlemMapperTest extends TestCase {

    Medlem medlem = new Medlem(Medlem.Status.aktiv,
            Medlem.Koen.kvinde,
            Medlem.AldersKlasse.junior,
            "Gunnar",
            "Nu",
            99,
            "GN",
            "123456");


    public void setUp() throws Exception {
        super.setUp();
    }

    public void testCreateNewmedlem() {
        int actual = MedlemMapper.createNewmedlem(medlem);

        int expected = 8;
        assertEquals(expected, actual);
        }


    public void testGetMedlemmerFraDB() {
    }

    public void testUpdateBalanceIDB() {
    }
}