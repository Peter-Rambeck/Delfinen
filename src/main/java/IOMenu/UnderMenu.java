package IOMenu;

import model.Kontingenter;

import java.util.Scanner;

public class UnderMenu {


    String[] formandUnderMenu = {"Opret medlem"};
    String[] kassererUnderMenu = {"Kontingentbetaling", "Restanceliste", "Udskriv kontingent"};
    String[] trænerUnderMenu = {"Opret konkurrence", "Registrer resultat", "Vis Top 5 liste"};


    public void formandUnderMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Vælg ");
        System.out.println("1.\t"+ formandUnderMenu[0]);
        // System.out.println("2.\t"+ formandUnderMenu[1]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 3) {
                switch (menuLogin) {

                    case 1:
                        System.out.println(formandUnderMenu[0]);
                        // TODO call Opret medlem method
                        IOOpretMedlem.opretMedlem();
                        break;

                        /*

                    case 2:
                        System.out.println(formandUnderMenu[1]);
                        // TODO call Rediger medlem method
                        break;

                         */

                    default:
                        System.out.println("Funger ikke");
                        break;



                }
            } else {
                System.out.println("Indtast et tal mellem 1 & 2");
                formandUnderMenu();
            }
        } else {
            System.out.println("Indtast et tal mellem 1 & 2");
            System.out.println();
            formandUnderMenu();
        }
    }

    public void kassererUnderMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Vælg ");
        System.out.println("1.\t"+kassererUnderMenu[0]);
        System.out.println("2.\t" +kassererUnderMenu[1]);
        System.out.println("2.\t" +kassererUnderMenu[2]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 3) {
                switch (menuLogin) {

                    case 1:
                        System.out.println(kassererUnderMenu[0]);
                        // TODO call Kontingentbetaling method
                        Scanner in = new Scanner(System.in);
                        System.out.println("Indtast medlems ID");
                        int medlemID = in.nextInt();
                        System.out.println("Indtast indbetaling");
                        int indbetaling = in.nextInt();
                        Kontingenter.indbetalKontingent(medlemID, indbetaling);

                        break;

                    case 2:
                        System.out.println("Vis restance medlemmer");
                         Kontingenter.udskrivRestanceListe();
                        break;

                    case 3:
                        System.out.println("Udskrivkontingent");
                        Kontingenter.udskrivKontingent();
                        break;

                    default:
                        System.out.println("Funger ikke");
                        break;

                }
            } else {
                System.out.println("Indtast et tal mellem 1 & 2");
                kassererUnderMenu();
            }
        } else {
            System.out.println("Indtast et tal mellem 1 & 2");
            kassererUnderMenu();
        }
    }

    public void trænerUnderMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Vælg ");
        System.out.println("1.\t" +trænerUnderMenu[0]);
        System.out.println("2.\t" +trænerUnderMenu[1]);
        System.out.println("3.\t" +trænerUnderMenu[2]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 4) {
                switch (menuLogin) {

                    case 1:
                        System.out.println(trænerUnderMenu[0]);
                        // TODO call Registrer resultat method
                        IOOpretKonkurrence.opretKonkurrence();
                        break;

                    case 2:
                        System.out.println(trænerUnderMenu[1]);
                        IOOpretResultat.opretResultat();
                        break;

                    case 3:
                        System.out.println(trænerUnderMenu[2]);
                        // TODO call Vis Top 5 liste method
                        break;


                    default:
                        System.out.println("Funger ikke");
                        break;

                }
            } else {
                System.out.println("Indtast et tal mellem 1 & 3");
                trænerUnderMenu();
            }
        } else {
            System.out.println("Indtast et tal mellem 1 & 3");
            trænerUnderMenu();
        }
    }



}
