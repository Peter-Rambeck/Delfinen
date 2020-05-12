package model;

import datamapper.MedlemMapper;

import java.util.ArrayList;
import static model.MedlemsLister.*;

public class Kontingenter {
/*
    final int juniorKontingent = 1000;
    final int seniorKontingent = 1600;
    final int over60Kontingent = 1200;
    final int passivKontingent = 500;

        //udregner kontingent for medlemmer ud fra deres oprettede alder, og ovenstående kriterier
    public int udregnKontingent(Medlem medlem) {
        int kontingent = 0;
     /*  if (medlem.getAldersKlasse() == Medlem.AldersKlasse.junior) {
            kontingent = juniorKontingent;
        }
        if (medlem.getAldersKlasse() == Medlem.AldersKlasse.senior) {
            kontingent = seniorKontingent;
        }
        if (medlem.getAlder() > 60) {
            kontingent = over60Kontingent;
        }
        if (medlem.getStatus() == Medlem.Status.passiv) {
            kontingent = passivKontingent;
        }
        return kontingent;
    }

    // Finder medlem og updaterer balancen med 'indbetaling'
    public static void indbetalKontingent(int medlemID, int indbetaling) {
        int balance = 0;
        MedlemsLister medlemsLister=new MedlemsLister();
        Medlem medlem;/*
        if (medlemID<1000) {
            medlem = medlemMap.get(medlemID);
        }else {
            medlem = konkurrrenceMedlemHashMap.get(medlemID);
        }
        balance = medlem.getBalance();
        medlem.setBalance(balance + indbetaling);
        MedlemMapper mm=new MedlemMapper();
        mm.updateBalanceIDB(medlem);
/*
        for ( Medlem mm : medlemsLister.medlemMap.values()) {
            if (mm.getMedlemID() == medlemID)  {
                balance = mm.getBalance();
                mm.setBalance(balance + indbetaling);
                System.out.println(mm);
            }
        }
    }/*
                //Finder medlem i hashmap og udskriver restancen
    public static void udskrivRestanceListe() {
       /* for ( Medlem rm : medlemMap.values()) {
            if ( rm.getBalance() < 0 ) {
                System.out.println(rm.balanceToString());;
            }
        }
        for ( Medlem rm : konkurrrenceMedlemHashMap.values()) {
            if ( rm.getBalance() < 0 ) {
                System.out.println(rm.balanceToString());;
            }
        }

    }
        //???
    public void udskrivKontingent() {
        int kontingent;
        for ( Medlem km : medlemMap.values()) {
            kontingent = udregnKontingent(km);
            km.setBalance(km.getBalance()-kontingent);
            }
        for ( Medlem km : konkurrrenceMedlemHashMap.values()) {
        kontingent = udregnKontingent(km);
        km.setBalance(km.getBalance()-kontingent);
    }
}
*/
    }

