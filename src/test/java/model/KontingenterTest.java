package model;

import datamapper.MedlemMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KontingenterTest {


    @Before
    public void setUp() throws Exception {
        MedlemMapper mm = new MedlemMapper();
        MedlemsLister ml=new MedlemsLister();
        mm.getMedlemmerFraDB(ml);
    }

    @Test
    public void indbetalKontingent() {

        MedlemsLister medlemsLister=new MedlemsLister();
        Medlem medlem;
        medlem = medlemsLister.medlemMap.get(15);
        int balanceFor =  medlem.getBalance();

        Kontingenter.indbetalKontingent(15, 100);
        //henter medlem i medlemsliste
        int actual = medlem.getBalance();
        int expected = balanceFor +100;

        assertEquals(expected, actual);

        Kontingenter.indbetalKontingent(15, -100);

    }

    @Test
    public void udregnKontingent() {

    }
}