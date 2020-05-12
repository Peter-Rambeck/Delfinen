package IOMenu;

import datamapper.MedlemMapper;
import model.Medlem;
import java.util.Scanner;

public class IOOpretMedlem {

    public static void opretMedlem() {

            // Scanner
            Scanner opretMedlemInput = new Scanner(System.in);

            // Aktiv eller passiv, Bool
            System.out.println("medlemstype: ");
            System.out.println("Aktiv: 1 ");
            System.out.println("Passiv: 2 ");
            int InputAktiv = opretMedlemInput.nextInt();
            boolean aktiv;
            if (InputAktiv == 1) {
                    aktiv = true;
            } else {
                    aktiv = false;
            }

            // Mand eller Kvinde, Bool
            System.out.println("medlemstype: ");
            System.out.println("Mand: 1 ");
            System.out.println("Kvinde: 2 ");
            int InputMand = opretMedlemInput.nextInt();
            boolean mand;
            if (InputAktiv == 1) {
                    mand = true;
            } else {
                    mand = false;
            }

            // Senior eller Junior, Bool
            System.out.println("medlemstype: ");
            System.out.println("Senior: 1 ");
            System.out.println("Junior: 2 ");
            int InputSenior = opretMedlemInput.nextInt();
            boolean senior;
            if (InputAktiv == 1) {
                    senior = true;
            } else {
                    senior = false;
            }

            // Motionist eller Konkurrence medlem, Bool
            System.out.println("medlemstype: ");
            System.out.println("Motionist: 1 ");
            System.out.println("Konkurrencemedlem: 2 ");
            int InputMotionist = opretMedlemInput.nextInt();
            boolean motionist;
            if (InputAktiv == 1) {
                    motionist = true;
            } else {
                    motionist = false;
            }

            // Fornavn, String
            System.out.println("Fornavn?: ");
            String forNavn = opretMedlemInput.nextLine();
            forNavn = opretMedlemInput.nextLine();
            System.out.println();

            // Efternavn, String
            System.out.println("Efternavn?: ");
            String efterNavn = opretMedlemInput.nextLine();
            System.out.println();

            // Traener, String
            // System.out.println("Efternavn?: ");
            String traener = "Bruce Lee";
            // System.out.println();

            // Alder, int
            System.out.println("Fødselsår?: ");
            int fodselsaer = opretMedlemInput.nextInt();
            System.out.println();
            opretMedlemInput.nextLine();

            // Email, String
            System.out.println("email?: ");
            String email = opretMedlemInput.nextLine();
            System.out.println();

            // Telefon, String
            System.out.println("Telefon nr.?: ");
            String tlfNr = opretMedlemInput.nextLine();

            // Balance, int
            int balance = 0;


            Medlem medlem = new Medlem(aktiv, mand, senior, motionist, forNavn, efterNavn, traener, fodselsaer, email, tlfNr, balance);
            medlem.gem();
            System.out.println(medlem);

        }

    @Override
    public String toString() {
        return super.toString();
    }
}

