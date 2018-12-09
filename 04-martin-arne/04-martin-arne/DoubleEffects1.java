public class DoubleEffects1 {
    public static void main(String[] args)
    {
        double d = 10.0;
        while (d>0)
        {
            System.out.println();
            d=d-0.1;
            System.out.println(d);
        }
    }

/**
 a)
 Die Ausgabe ist damit zu erklären, dass die Zahl 0.1 als
 Floating Point Number nicht exakt darstellbar ist.
 Nur Zweierpotenzen sind wirklich genau darstellbar.
 Bei der Darstellung der 0.1 tritt in der Mantisse
 (diese ist:10011001100110011001101) eine periodische
 Wiederholung der Zahlen auf und nach 23 Stellen wird
 sie einfach abgeschnitten, daher ist sie ungenau.
 Der dadurch entstehende Rundungsfehler ist klein (ca. 1.4*10^(-9)),
 aber bei mehreren Subtraktionen schließlich doch bemerkbar.
 */
}