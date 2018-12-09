

import java.util.InputMismatchException;
        import java.util.Scanner;

public class Addition {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int Eingabe1 = readIntFromConsole();
        int Eingabe2 = readIntFromConsole();
        int Summe = Eingabe1+Eingabe2;
        System.out.println("Die Summer Ihrer Eingaben ist: " + Summe);
        System.out.println("Ihre erste Eingabe : " + Eingabe1);
        System.out.println("Ihre zweite Eingabe: " + Eingabe2);

/**
 * Aufgabe 1c) [int Eingabe1] ist eine Deklarierung, ich deklarirere damit eine
 * neue Variable des Typs int, [...= readIntFromConsol;] ist die Initialisierung dieser Variable, also der "Startwert"
 * der ihr zugewiesen wird.
 */

        //System.out.println("Ihre Eingabe: " + readIntFromConsole());
    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please insert a whole number: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a whole number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}
