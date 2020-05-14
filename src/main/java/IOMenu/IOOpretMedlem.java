package IOMenu;

import datamapper.MedlemMapper;
import model.Medlem;
import java.util.Scanner;

public class IOOpretMedlem {

        public static void opretMedlem() {

                // Scanner
                Scanner opretMedlemInput = new Scanner(System.in);

                // Aktiv eller passiv, Bool
                boolean aktiv = false;
                while ( aktiv == false ) {
                        System.out.println("medlemstype: ");
                        System.out.println("Aktiv: 1 ");
                        System.out.println("Passiv: 2 ");

                        if (opretMedlemInput.hasNextInt()) {
                                int inputAktiv = opretMedlemInput.nextInt();
                                if (inputAktiv > 0 && inputAktiv < 3) {
                                        // boolean aktiv;
                                        if (inputAktiv == 1) {
                                                aktiv = true;
                                        } else {
                                                aktiv = false;
                                                break;
                                        }
                                } else {
                                        System.out.println("Fejltastning, 1 eller 2");
                                        opretMedlemInput.reset();
                                }
                        } else {
                                System.out.println("Fejltast");
                                opretMedlemInput.nextLine();
                        }
                }

                // Mand eller Kvinde, Bool
                boolean mand = false;
                while ( mand == false ) {
                        System.out.println("medlemstype: ");
                        System.out.println("Mand: 1 ");
                        System.out.println("Kvinde: 2 ");

                        if (opretMedlemInput.hasNextInt()) {
                                int inputMand = opretMedlemInput.nextInt();
                                if (inputMand > 0 && inputMand < 3) {
                                        // boolean mand;
                                        if (inputMand == 1) {
                                                mand = true;
                                        } else {
                                                mand = false;
                                                break;
                                        }
                                } else {
                                        System.out.println("Fejltastning, 1 eller 2");
                                        opretMedlemInput.reset();
                                }
                        } else {
                                System.out.println("Fejltast");
                                opretMedlemInput.nextLine();
                        }
                }

                // Senior eller Junior, Bool
                boolean senior = false;
                while ( senior == false ) {
                        System.out.println("medlemstype: ");
                        System.out.println("Senior: 1 ");
                        System.out.println("Junior: 2 ");

                        if (opretMedlemInput.hasNextInt()) {
                                int inputSenior = opretMedlemInput.nextInt();
                                if (inputSenior > 0 && inputSenior < 3) {
                                        if (inputSenior == 1) {
                                                senior = true;
                                        } else {
                                                senior = false;
                                                break;
                                        }
                                } else {
                                        System.out.println("Fejltastning, 1 eller 2");
                                        opretMedlemInput.reset();
                                }
                        } else {
                                System.out.println("Fejltast");
                                opretMedlemInput.nextLine();
                        }
                }

                // Motionist eller Konkurrence medlem, Bool
                boolean motionist = false;
                while ( motionist == false ) {
                        System.out.println("medlemstype: ");
                        System.out.println("Motionist: 1 ");
                        System.out.println("Konkurrencemedlem: 2 ");

                        if (opretMedlemInput.hasNextInt()) {
                                int inputMotionist = opretMedlemInput.nextInt();
                                if (inputMotionist > 0 && inputMotionist < 3) {

                                        if (inputMotionist == 1) {
                                                motionist = true;
                                                // opretMedlemInput.nextLine();
                                        } else {
                                                motionist = false;
                                                // opretMedlemInput.nextLine();
                                                break;
                                        }

                                } else {
                                        System.out.println("Fejltastning, 1 eller 2");
                                        //opretMedlemInput.nextLine();
                                }
                        } else {
                                System.out.println("Fejltast");
                                //opretMedlemInput.nextLine();
                        }
                }
                // String var = opretMedlemInput.nextLine();

                // Fornavn, String
                String forNavn = null;
                while ( forNavn == null ) {
                        opretMedlemInput.nextLine();
                        System.out.println("Fornavn?: ");
                        if( opretMedlemInput.hasNextLine()) {
                                forNavn = opretMedlemInput.nextLine();
                        } else {
                                System.out.println("Fejltastning");
                                //opretMedlemInput.reset();
                                }
                }

                // Efternavn, String
                String efterNavn = null;
                while ( efterNavn == null ) {
                        System.out.println("Efternavn?: ");
                        if( opretMedlemInput.hasNextLine()) {
                                efterNavn = opretMedlemInput.nextLine();
                        } else {
                                System.out.println("Fejltastning");
                                //opretMedlemInput.reset();
                        }
                }

                // Traener, String -> Hardcodet
                String traener;
                if (motionist == true) {
                        traener = "Bruce Lee";
                } else {
                        traener = "";
                }

                // Alder, int
                int fodselsaer = 0;
                while ( fodselsaer == 0 ) {
                        System.out.println("Fødselsår?: ");
                        if (opretMedlemInput.hasNextInt()) {
                                fodselsaer = opretMedlemInput.nextInt();
                                //System.out.println();
                                opretMedlemInput.nextLine();
                        } else {
                                System.out.println("Fejltastning");
                                opretMedlemInput.nextLine();
                        }
                }

                // Email, String
                String email = null;
                while ( email == null ) {
                        System.out.println("email?: ");
                        if (opretMedlemInput.hasNextLine()) {
                                email = opretMedlemInput.nextLine();

                        } else {
                                System.out.println("Fejltastning");
                               // opretMedlemInput.nextLine();
                        }
                }

                // Telefon, String
                String tlfNr = null;
                while ( tlfNr == null ) {
                        System.out.println("Telefon nr.?: ");
                        if (opretMedlemInput.hasNextLine()) {
                                tlfNr = opretMedlemInput.nextLine();
                                // opretMedlemInput.nextLine();
                        } else {
                                System.out.println("Fejltastning");
                                //opretMedlemInput.nextLine();
                        }
                }

                // Balance, int
                int balance = 0;

                Medlem medlem = new Medlem(aktiv, mand, senior, motionist, forNavn, efterNavn, traener, fodselsaer, email, tlfNr, balance);
                medlem.gem();
                System.out.println(medlem);

                }

                @Override
                public String toString () {
                        return super.toString();
                }
        }


