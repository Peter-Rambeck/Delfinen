package IOMenu;

import datamapper.MedlemMapper;
import model.Enum;
import model.Medlem;
import model.Medlem.*;
import model.KonkurrrenceMedlem;

import java.util.Scanner;

import static model.Enum.AldersKlasse.junior;
import static model.Enum.AldersKlasse.senior;
import static model.Enum.Koen.kvinde;
import static model.Enum.Koen.mand;
import static model.Enum.Status.aktiv;
import static model.Enum.Status.passiv;


public class IOOpretMedlem {

    public static void opretMedlem() {

            // Create Scanner object
            Scanner opretMedlemInput = new Scanner(System.in);

            // Aktivitetsform, Motionist / Konkurrencesvoemmer
            System.out.println("Aktivitetsform: ");
            System.out.println("Konkurrencesvoemmer: 1 ");
            System.out.println("Motionist: 2 ");
            // Indput
            int aktivitetsForm = opretMedlemInput.nextInt();
            opretMedlemInput.nextLine();

            // Aktiv eller passiv, Enum
            System.out.println("medlemstype: ");
            System.out.println("aktiv: 1 ");
            System.out.println("passiv: 2 ");
            // Indput
            int tmp = opretMedlemInput.nextInt();
            Enum.Status status;
            if ( tmp == 2 ) {
                    status = passiv;
            } else {
                    status = aktiv;
            };
            System.out.println();

            // Køn, Enum
            System.out.println("køn: ");
            System.out.println("mand: 1 ");
            System.out.println("kvinde: 2 ");
            // Indput
            tmp = opretMedlemInput.nextInt();
            Enum.Koen koen;
            if ( tmp==2 ) {
                    koen = kvinde;
            } else {
                    koen = mand;
            };
            System.out.println();

            // Aldersklasse, Enum
            System.out.println("aldersklasse: ");
            System.out.println("junior: 1 ");
            System.out.println("senior: 2 ");
            // Aktiv eller passiv
             tmp = opretMedlemInput.nextInt();
            Enum.AldersKlasse aldersKlasse;
            if(tmp==2){
                    aldersKlasse= senior;
            }else {aldersKlasse=junior;};
            System.out.println();


            System.out.println("Fornavn?: ");
            //
            String forNavn = opretMedlemInput.nextLine();
            forNavn = opretMedlemInput.nextLine();
            System.out.println();

            System.out.println("Efternavn?: ");
            //
            String efterNavn = opretMedlemInput.nextLine();
            System.out.println();

            System.out.println("Alder?: ");
            //
            int alder = opretMedlemInput.nextInt();
            System.out.println();
            opretMedlemInput.nextLine();

            System.out.println("email?: ");
            //
            String email = opretMedlemInput.nextLine();
            System.out.println();

            System.out.println("Telefon nr.?: ");
            //
            String tlfNr = opretMedlemInput.nextLine();

            if ( aktivitetsForm == 1 ) {
                    KonkurrrenceMedlem konkurrrenceMedlem = new KonkurrrenceMedlem(status, koen, aldersKlasse, forNavn, efterNavn, alder, email, tlfNr);
                    System.out.println(konkurrrenceMedlem);
            } else {
                    Medlem medlem = new Medlem(status, koen, aldersKlasse, forNavn, efterNavn, alder, email, tlfNr);
                    medlem.gem();
                    System.out.println(medlem);
            }

        }

    @Override
    public String toString() {
        return super.toString();
    }
}

