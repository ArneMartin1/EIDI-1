import java.util.InputMismatchException;
import java.util.Scanner;

public class StringUtil {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String in = readStringFromConsole();
        System.out.println("Input: " + in);
        System.out.print("Output: ");
        int länge = in.length();    //Länge des Strings bestimmen
        for(int i=0;i<länge;i++)
        {
            char character = in.charAt(i); //Buchstaben an Position i bestimmen
            int ascii = (int) character;    //Buchstaben zu Unicode convertieren
            if(ascii>96 && ascii<123)
            {
                ascii = ascii-32;       //Klein zu Groß
            }
            char ausgabe = (char) ascii;    //Von unicode zurück
            System.out.print(ausgabe+"");

            }
        }



    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als String
     */
    public static String readStringFromConsole() {

        System.out.print("Please input a String: ");
        try {
            return scanner.nextLine();
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not valid!");
            scanner.next();
        }

        return readStringFromConsole();
    }
}