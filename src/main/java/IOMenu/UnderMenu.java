package IOMenu;
import IOMenu.Menu;
import model.KonkurrenceResultater;
import model.Kontingenter;

import java.util.Scanner;

public class UnderMenu {


    String[] formandUnderMenu = {"Opret medlem", "Hovedmenu"};
    String[] kassererUnderMenu = {"Kontingentbetaling", "Restanceliste", "Udskriv kontingent", "Hovedmenu"};
    String[] trænerUnderMenu = {"Opret konkurrence", "Registrer resultat", "Vis Top 5 liste", "Hovedmenu"};



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

                    case 2:
                        System.out.println(formandUnderMenu[1]);
                        Menu menu = new Menu();
                        menu.hovedMenu();
                        break;

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
        System.out.println("3.\t" +kassererUnderMenu[2]);
        System.out.println("4.\t" +kassererUnderMenu[3]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 5) {
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

                    case 4:
                        System.out.println(kassererUnderMenu[3]);
                        Menu menu = new Menu();
                        menu.hovedMenu();
                        break;

                    default:
                        System.out.println("Funger ikke");
                        break;

                }
            } else {
                System.out.println("Indtast et tal mellem 1 & 5");
                kassererUnderMenu();
            }
        } else {
            System.out.println("Indtast et tal mellem 1 & 5");
            kassererUnderMenu();
        }
    }

    public void trænerUnderMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Vælg ");
        System.out.println("1.\t" +trænerUnderMenu[0]);
        System.out.println("2.\t" +trænerUnderMenu[1]);
        System.out.println("3.\t" +trænerUnderMenu[2]);
        System.out.println("4.\t" +trænerUnderMenu[3]);

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
                        top5UnderMenu();
                        break;

                    case 4:
                        System.out.println(trænerUnderMenu[3]);
                        Menu menu = new Menu();
                        menu.hovedMenu();
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

    private void top5UnderMenu() {
        Scanner input = new Scanner(System.in);
        int svoemmediciplin = 0;
        while ( svoemmediciplin == 0 ) {
            System.out.println("Vælg diciplin: ");
            System.out.println("brystsvoemning: 1 ");
            System.out.println("crawl: 2 ");
            System.out.println("rygcrawl: 3 ");
            System.out.println("butterfly: 4 ");
            if (input.hasNextInt()) {
                // if (opretResultatInput.nextInt() <= 4) {
                svoemmediciplin = input.nextInt();
            } else {
                System.out.println("Fejltastning: 1 - 4");
                input.nextLine();
            }
        }
        boolean senior = true;
        int ok=-1;
        while ( ok == -1 ) {
            System.out.println("Vælg junior/senior: ");
            System.out.println("junior: 1 ");
            System.out.println("senior: 2 ");
            if (input.hasNextInt()) {
                // if (opretResultatInput.nextInt() <= 4) {
                ok = input.nextInt();
                if (ok==1){senior=false;}else{senior=true;}
            } else {
                System.out.println("Fejltastning: 1 eller 2");
                input.nextLine();
            }
        }
        boolean mand= true;
        ok=-1;
        while ( ok == -1 ) {
            System.out.println("Vælg kvinde/mand: ");
            System.out.println("kvinde: 1 ");
            System.out.println("mand: 2 ");
            if (input.hasNextInt()) {
                // if (opretResultatInput.nextInt() <= 4) {
                ok = input.nextInt();
                if (ok==1){mand=false;}else{mand=true;}

            } else {
                System.out.println("Fejltastning: 1 eller 2");
                input.nextLine();
            }
            KonkurrenceResultater konkurrenceResultater=new KonkurrenceResultater();
            konkurrenceResultater.udskrivTop5(svoemmediciplin,mand,senior);
        }

    }


}
