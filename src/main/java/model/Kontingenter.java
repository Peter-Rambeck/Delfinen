package model;

import datamapper.MedlemMapper;

import java.util.ArrayList;
import static model.MedlemsLister.*;

public class Kontingenter {

    final static int juniorKontingent = 1000;
    final static int seniorKontingent = 1600;
    final static int over60Kontingent = 1200;
    final static int passivKontingent = 500;

        //udregner kontingent for medlemmer ud fra deres oprettede alder, og ovenstående kriterier
     public static int udregnKontingent(Medlem medlem) {
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
        medlem.setBalance(balance + indbetaling);
        MedlemMapper mm=new MedlemMapper();
        mm.updateBalanceIDB(medlem);


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
    public static void udskrivKontingent() {
        int kontingent;
        MedlemMapper mM=new MedlemMapper();
        for ( Medlem km : medlemMap.values()) {
            kontingent = udregnKontingent(km);
            km.setBalance(km.getBalance()-kontingent);
            System.out.println(km.getBalance());
            mM.updateBalanceIDB(km);

            }
        }

    }

