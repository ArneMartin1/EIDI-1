import java.util.InputMismatchException;
        import java.util.Scanner;

import static java.lang.Math.abs;

public class Loops {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        //TODO: a)
        /** int n = readIntFromConsole();
         for (int i=1;i<=n;i++)
         {
         System.out.print(i+" ");
         }
         */
        //TODO: b)
        //i)
        /**int n = readIntFromConsole();
         for (int i=1;i<=n;i++)
         {
         if (i % 2 ==0) {
         System.out.print(i + " ");
         }
         }
         */
        //ii)
        /**int n = readIntFromConsole();
         for (int i=2;i<=n;i++)
         {
         //if (i % 2 ==0) {
         System.out.print(i + " ");
         }
         }

         */
        //iii)
        /**
         int n = readIntFromConsole();
         for (int i=1;i<=n/2;i++)
         {
         //if (i % 2 ==0) {
         System.out.print(i*2 + " ");
         }
         }
         */
        //TODO: c)
        int n = readIntFromConsole();
        for (int i = n; i >= -n; i=i-1) {
            //if (i % 2 ==0) {
            System.out.print(i + " ");
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

        System.out.print("Please input a natural number: ");
        try {
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("[Error] Input is not a natural number!");
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