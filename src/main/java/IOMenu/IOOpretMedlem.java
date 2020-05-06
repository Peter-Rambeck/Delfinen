package IOMenu;

import datamapper.MedlemMapper;
import model.Medlem;

import java.util.Scanner;

public class IOOpretMedlem {


    public static void opretMedlem() {

            // Create Scanner object
            Scanner opretMedlemInput = new Scanner(System.in);


            System.out.println("Aktiv eller Passiv medlem?: ");
            // Aktiv eller passiv
            boolean aktiv = opretMedlemInput.nextBoolean();
            System.out.println();

            System.out.println("Køn?: ");
            // Køn
            boolean mand = opretMedlemInput.nextBoolean();
            System.out.println();

            System.out.println("Senior eller jumior medlem?: ");
            // Senior eller junior
            boolean senior = opretMedlemInput.nextBoolean();
            System.out.println();
            opretMedlemInput.nextLine();

            System.out.println("Fornavn?: ");
            //

            String forNavn = opretMedlemInput.nextLine();
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

            Medlem medlem = new Medlem(aktiv, mand, senior, forNavn, efterNavn, alder, email, tlfNr);
            MedlemMapper medlemMapper = new MedlemMapper();
            medlemMapper.createNewmedlem(medlem);

            //Medlem medlem = new Medlem(aktiv, mand, senior, forNavn, efterNavn, alder, email, tlfNr);
            System.out.println(medlem);




        }

    @Override
    public String toString() {
        return super.toString();
    }
}

