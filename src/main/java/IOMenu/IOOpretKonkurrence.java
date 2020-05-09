package IOMenu;

import model.Konkurrence;
import model.Konkurrencer;
import model.Medlem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class IOOpretKonkurrence {

    String konkurrenceNavn;
    LocalDate konkurrenceDato;

    String dateFormat = "dd/MM/yyyy";


    public static void opretKonkurrence() {

        // Create Scanner object
        Scanner opretKonkurrenceInput = new Scanner(System.in);
        System.out.println("Konkurrence: ");
        String konkurrenceNavn = opretKonkurrenceInput.nextLine();

        System.out.println("Dato (\"DD/MM/YYYY\"): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String x = opretKonkurrenceInput.next();
        LocalDate konkurrenceDato = LocalDate.parse(x, formatter);


        Konkurrence konkurrence = new Konkurrence(konkurrenceNavn, konkurrenceDato);
        Konkurrencer.liste.add(konkurrence);
        konkurrence.gemIDB();

        // medlem.gemIDB();


        System.out.println(konkurrence);


    }

}





