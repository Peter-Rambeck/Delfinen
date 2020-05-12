package model;

import datamapper.MedlemMapper;

import java.util.ArrayList;
import static model.MedlemsLister.*;

public class Kontingenter {

    final int juniorKontingent = 1000;
    final int seniorKontingent = 1600;
    final int over60Kontingent = 1200;
    final int passivKontingent = 500;

        //udregner kontingent for medlemmer ud fra deres oprettede alder, og ovenstående kriterier
     public int udregnKontingent(Medlem medlem) {
        int kontingent = 0;
      if (!medlem.isSenior()) {
            kontingent = juniorKontingent;
        }
        if (medlem.isSenior()) {
            kontingent = seniorKontingent;
        }
        if (medlem.getAlder() > 60) {
            kontingent = over60Kontingent;
        }
        if (!medlem.isAktiv()) {
            kontingent = passivKontingent;
        }
        return kontingent;
    }

    // Finder medlem og updaterer balancen med 'indbetaling'
    public static void indbetalKontingent(int medlemID, int indbetaling) {
        int balance = 0;
        MedlemsLister medlemsLister=new MedlemsLister();
        Medlem medlem;
        medlem =  medlemsLister.medlemMap.get(medlemID);

        balance = medlem.getBalance();
        System.out.println(balance);
        medlem.setBalance(balance + indbetaling);
        System.out.println(medlem.getBalance());
        MedlemMapper mm=new MedlemMapper();
        mm.updateBalanceIDB(medlem);
        System.out.println(medlem);


    }
                //Finder medlem i hashmap og udskriver restancen
    public static void udskrivRestanceListe() {
       for ( Medlem rm : medlemMap.values()) {
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
        }

    }

