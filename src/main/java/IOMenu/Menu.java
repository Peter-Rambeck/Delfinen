package IOMenu;

import java.util.Scanner;

public class Menu {

    String[] hovedMenu = {"Formand", "Kasserer", "Træner", "Afslut program"};
    UnderMenu underMenu = new UnderMenu();

    public void hovedMenu() {

        Scanner input = new Scanner(System.in);

        int fLogIn = 1;
        int kLogIn = 2;
        int tLogIn = 3;

        System.out.println("passwords: formand 1,kassere 2 og træner 3");
        System.out.println("Vælg login");
        System.out.println("1.\t" + hovedMenu[0]);
        System.out.println("2.\t" + hovedMenu[1]);
        System.out.println("3.\t" + hovedMenu[2]);
        System.out.println("4.\t" + hovedMenu[3]);


        if (input.hasNextInt())  {
                int menuLogin = input.nextInt();
                if (menuLogin > 0 && menuLogin < 5) {

                    switch (menuLogin) {

                        case 1:
                            System.out.println(hovedMenu[0] + " Indtast login");
                            if (input.hasNextInt()) {
                                int formandLogIn = input.nextInt();
                                if (formandLogIn == fLogIn) {
                                    underMenu.formandUnderMenu();
                                } else {
                                    System.out.println("Indtast korrekt login");
                                    hovedMenu();
                                }
                            } else {
                                System.out.println("Indtast korrekt login");
                                hovedMenu();
                            }
                            break;


                        case 2:
                            System.out.println(hovedMenu[1] + " Indtast login");
                            if (input.hasNextInt()) {
                                int kassererLogIn = input.nextInt();
                                if (kassererLogIn == kLogIn) {
                                    underMenu.kassererUnderMenu();
                                } else {
                                    System.out.println("Indtast korrekt login");
                                    hovedMenu();
                                }
                            } else {
                                System.out.println("Indtast korrekt login");
                                hovedMenu();
                            }
                            break;

                        case 3:
                            System.out.println(hovedMenu[2] + " Indtast login");
                            if (input.hasNextInt()) {
                                int trænerLogIn = input.nextInt();
                                if (trænerLogIn == tLogIn) {
                                    underMenu.trænerUnderMenu();
                                } else {
                                    System.out.println("Indtast korrekt login");
                                    hovedMenu();
                                }
                            } else {
                                System.out.println("Indtast korrekt login");
                                hovedMenu();
                            }
                            break;

                        case 4:
                            System.out.println(hovedMenu[3] + " Tast 0");
                            if (input.hasNextInt()) {
                                int afslut = input.nextInt();
                                if (afslut == 0) {
                                    Runtime.getRuntime().exit(-1);
                                } else {
                                    System.out.println("Fejltastning");
                                    hovedMenu();
                                }
                                break;
                            }

                            default:
                                System.out.println("Funger ikke");
                                break;
                    }
                    // Switch end

                } else {
                    System.out.println("Indtast et tal mellem 1 & 3");
                    hovedMenu();
                }


            } else {
            System.out.println("Indtast et tal mellem 1 & 3");
            hovedMenu();
            }

        }





}
