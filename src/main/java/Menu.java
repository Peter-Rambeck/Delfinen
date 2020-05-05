import java.util.Scanner;

public class Menu {

    String[] hovedMenu = {"Formand", "Kasserer", "Træner"};
    String[] formandUnderMenu = {"Opret medlem", "Rediger medlem"};
    String[] kassrerUnderMenu = {"Kontingentbetaling", "Restanceliste"};
    String[] trænerUnderMenu = {"Registrerer resultat", "vis Top 5 liste", "Udtag til konkurrence"};


    public void hovedMenu() {

        Scanner input = new Scanner(System.in);

        int fLogIn = 123;
        int kLogIn = 456;
        int tLogIn = 456;


        System.out.println("Vælg login");
        System.out.println("1.\t" + hovedMenu[0]);
        System.out.println("2.\t" + hovedMenu[1]);
        System.out.println("3.\t" + hovedMenu[2]);


        if (input.hasNextInt())  {
                int menuLogin = input.nextInt();
                if (menuLogin > 0 && menuLogin < 4) {

                    switch (menuLogin) {

                        case 1:
                            System.out.println(hovedMenu[0] + " Indtast login");
                            if (input.hasNextInt()) {
                                int formandLogIn = input.nextInt();
                                if (formandLogIn == fLogIn) {
                                    formandUnderMenu();
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
                                    kassererUnderMenu();
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
                                    trænerUnderMenu();
                                } else {
                                    System.out.println("Indtast korrekt login");
                                    hovedMenu();
                                }
                            } else {
                                System.out.println("Indtast korrekt login");
                                hovedMenu();
                            }
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


    public void formandUnderMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("Vælg ");
        System.out.println("1.\t"+ formandUnderMenu[0]);
        System.out.println("2.\t"+ formandUnderMenu[1]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 3) {
                switch (menuLogin) {

                    case 1:
                        System.out.println(formandUnderMenu[0]);
                        // TODO call Opret medlem method
                        break;

                    case 2:
                        System.out.println(formandUnderMenu[1]);
                        // TODO call Rediger medlem method
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
        System.out.println("1.\t"+kassrerUnderMenu[0]);
        System.out.println("2.\t" +kassrerUnderMenu[1]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 3) {
                switch (menuLogin) {

                    case 1:
                        System.out.println(kassrerUnderMenu[0]);
                        // TODO call Kontingentbetaling method
                        break;

                    case 2:
                        System.out.println("Vis restance medlemmer");
                        // TODO call Restanceliste method
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
        System.out.println("3.\t" +trænerUnderMenu[3]);

        if (input.hasNextInt()) {
            int menuLogin = input.nextInt();
            if (menuLogin > 0 && menuLogin < 4) {
                switch (menuLogin) {

                    case 1:
                        System.out.println(trænerUnderMenu[0]);
                        // TODO call Registrer resultat method
                        break;

                    case 2:
                        System.out.println(trænerUnderMenu[1]);
                        // TODO call Vis Top 5 liste method
                        break;

                    case 3:
                        System.out.println(trænerUnderMenu[3]);
                        // TODO call Udtag til konkurrence method
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