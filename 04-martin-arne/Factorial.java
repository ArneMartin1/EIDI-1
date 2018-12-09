import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readIntFromConsole();

        //TODO: a)
        if(n<=1)
        {
            System.out.println(1);
        }
        else
        {
            long f=n;
            while (n>2)
            {
                n=n-1;
                f=n*f;
            }
            System.out.println(f);
        }

    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please input a natural number or 0: ");
        try {
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("[Error] Input is not a natural number or 0!");
                return readIntFromConsole();
            } else {
                return n;
            }
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}
