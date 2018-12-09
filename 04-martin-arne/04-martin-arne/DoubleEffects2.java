public class DoubleEffects2 {
    public static void main(String[] args)
    {
        double d = 10;
        while (d!=d+1)
        {
            d=d*10;
        }
        if (d-1 ==d) {
            System.out.println(d);
        }
    }
}

/**
 * Eine solche Zahl existiert, sie lautet 1.0E16
 * Begründung: Obiger Code ist der Beweis.
 *
 */
