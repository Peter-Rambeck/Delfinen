package model;

import java.util.ArrayList;

public class Kontingenter {

    private int medlemID;
    private String forNavn;
    private int indbetaling;

    ArrayList<Medlem> x = new ArrayList<>();


    public int kontingent(ArrayList x, int medlemID, String forNavn, int indbetaling) {
        int balance = 0;

        for ( Object mm : x) {
            if ( x.contains(medlemID) ) {
                Object o = x;
                System.out.println(o);
            }

            int curentBalance = o.balance;
            balance = curentBalance + indbetaling;

        }
        System.out.println();
        return balance;
    }

    public void nyBalance() {

    }

    public void udskrivRestance(ArrayList x) {

        for ( Object y : x) {
            if ( x.balance < 0 ) {
                System.out.println(x);
            }
        }

    }


}
