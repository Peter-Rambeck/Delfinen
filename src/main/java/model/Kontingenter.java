package model;

import datamapper.MedlemMapper;
import static model.MedlemsLister.*;

public class Kontingenter {
    //de 4 kontingent satser
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
        //henter medlem i medlemsliste
        medlem =  medlemsLister.medlemMap.get(medlemID);

        //finder nuværende balance for medlem
        balance = medlem.getBalance();

        //ændrer balance med indbetalt beløb
        medlem.setBalance(balance + indbetaling);

        //opdeterer ændring i DB
        MedlemMapper mm=new MedlemMapper();
        mm.updateBalanceIDB(medlem);
     }
     //gennemløber medlems hashmap og udskriver medlemmer der er i restance
    public static void udskrivRestanceListe() {
       for ( Medlem rm : medlemMap.values()) {
            if ( rm.getBalance() < 0 ) {
                System.out.println(rm.balanceToString());;
            }
        }


    }

    public static void udskrivKontingent() {
        //når det er tid udskriver kasseren kontingent, alle medlemmer får trukket
        //deres kontingent fra deres balance
        int kontingent;
        MedlemMapper mM=new MedlemMapper();
        //gennemløb alle medlemmer
        for ( Medlem km : medlemMap.values()) {
            //udregn kontingent for dette medlem
            kontingent = udregnKontingent(km);
            //træk kontingent fra i balance for medlemmet
            km.setBalance(km.getBalance()-kontingent);
            //opdater balancen i DB
            mM.updateBalanceIDB(km);

            }
        }

    }

