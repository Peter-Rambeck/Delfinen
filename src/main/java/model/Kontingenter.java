package model;

import datamapper.MedlemMapper;

import java.util.ArrayList;

public class Kontingenter {

    final int juniorKontingent = 1000;
    final int seniorKontingent = 1600;
    final int over60Kontingent = 1200;
    final int passivKontingent = 500;


    public int udregnKontingent(Medlem medlem) {
        int kontingent = 0;
        if (medlem.getAldersKlasse() == Medlem.AldersKlasse.junior) {
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
    public void indbetalKontingent(ArrayList<Medlem> medlemmer, int medlemID, int indbetaling) {
        int balance = 0;
        MedlemMapper medlemMapper=new MedlemMapper();

        for ( Medlem mm : medlemmer) {
            if (mm.getMedlemID() == medlemID)  {
                balance = mm.getBalance();
                mm.setBalance(balance + indbetaling);
                medlemMapper.updateBalanceIDB(mm);
                System.out.println(mm);
            }
        }
    }

    public void udskrivRestanceListe(ArrayList<Medlem> medlemmer) {
        for ( Medlem rm : medlemmer ) {
            if ( rm.getBalance() < 0 ) {
                System.out.println(rm);
            }
        }

    }

    public void udskrivKontingent(ArrayList<Medlem> medlemmer) {
        int kontingent;
        MedlemMapper medlemMapper=new MedlemMapper();
        for ( Medlem km : medlemmer ) {
            kontingent = udregnKontingent(km);
            km.setBalance(km.getBalance()-kontingent);
            medlemMapper.updateBalanceIDB(km);
            }
        }

    }

