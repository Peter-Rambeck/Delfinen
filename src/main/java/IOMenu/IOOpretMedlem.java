package IOMenu;

import datamapper.MedlemMapper;
import model.Medlem;
import model.Medlem.*;

import java.util.Scanner;

import static model.Medlem.AldersKlasse.junior;
import static model.Medlem.AldersKlasse.senior;
import static model.Medlem.Koen.kvinde;
import static model.Medlem.Koen.mand;
import static model.Medlem.Status.aktiv;
import static model.Medlem.Status.passiv;

public class IOOpretMedlem {


    public static void opretMedlem() {

            // Create Scanner object
            Scanner opretMedlemInput = new Scanner(System.in);

            // Aktiv eller passiv
            System.out.println("medlemstype: ");
            System.out.println("aktiv: 1 ");
            System.out.println("passiv: 2 ");
            // Aktiv eller passiv
            int tmp = opretMedlemInput.nextInt();
            Status status;
            if(tmp==2){
                    status= passiv;
            }else {status=aktiv;};
            System.out.println();

            // Køn
            System.out.println("køn: ");
            System.out.println("mand: 1 ");
            System.out.println("kvinde: 2 ");
            // Aktiv eller passiv
            tmp = opretMedlemInput.nextInt();
            Koen koen;
            if(tmp==2){
                    koen= kvinde;
            }else {koen=mand;};
            System.out.println();

            // Aldersklasse
            System.out.println("aldersklasse: ");
            System.out.println("junior: 1 ");
            System.out.println("senior: 2 ");
            // Aktiv eller passiv
             tmp = opretMedlemInput.nextInt();
            AldersKlasse aldersKlasse;
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

            Medlem medlem = new Medlem(status, koen, aldersKlasse, forNavn, efterNavn, alder, email, tlfNr);
            MedlemMapper medlemMapper = new MedlemMapper();
            medlem.setMedlemID(medlemMapper.createNewmedlem(medlem));

            //Medlem medlem = new Medlem(aktiv, mand, senior, forNavn, efterNavn, alder, email, tlfNr);
            System.out.println(medlem);




        }

    @Override
    public String toString() {
        return super.toString();
    }
}

