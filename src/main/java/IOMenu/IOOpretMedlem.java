package IOMenu;

import model.Medlem;

import java.util.Scanner;

public class IOOpretMedlem {

        public static void opretMedlem() {

            // Create Scanner object
            Scanner opretMedlemInput = new Scanner(System.in);

            System.out.println("Aktiv eller Passiv medlem?: ");
            // Aktiv eller passiv
            boolean aktiv = opretMedlemInput.hasNextBoolean();

            System.out.println("Køn?: ");
            // Køn
            boolean mand = opretMedlemInput.hasNextBoolean();

            System.out.println("Senior eller jumior medlem?: ");
            // Senior eller junior
            boolean senior = opretMedlemInput.hasNextBoolean();

            System.out.println("Fornavn?: ");
            //
            String forNavn = opretMedlemInput.nextLine();

            System.out.println("Efternavn?: ");
            //
            String efterNavn = opretMedlemInput.nextLine();

            System.out.println("Alder?: ");
            //
            int alder = opretMedlemInput.nextInt();

            System.out.println("email?: ");
            //
            String email = opretMedlemInput.nextLine();

            System.out.println("Telefon nr.?: ");
            //
            String tlfNr = opretMedlemInput.nextLine();

            //Medlem medlem = new Medlem(aktiv,mand, senior, forNavn, efterNavn, alder, email, tlfNr);
            Medlem.opretMedlem(aktiv, senior, forNavn, efterNavn, alder, email, tlfNr );




        }

    }

