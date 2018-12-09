public class FactorialWithMethods {

    public static void main(String[] args) {
       
        //System.out.println(factorial(5));
        //System.out.println(binom(10,5));



        //Musterloesung zu Blatt 4, Aufgabe 3
        
/**
        //Testen der Methode factorial (muss erst noch implementiert werden)
        int erg1 = factorial(5); //120
        System.out.println(erg1);

        //Man kann die Rückgabe auch direkt ausgeben
        System.out.println(factorial(10));

        //Testen der Methode binom (muss erst noch implementiert werden)
        System.out.println(binom(5, 2)); //=10
        System.out.println(binom(10, 5)); //=252

        */
    }

    //TODO: Methode factorial implementieren a)
    
    public static int factorial(int Eingabe)
    {
        int n = Eingabe;

            int m = n;
            int f = m;

            while (m > 2) 
            {
                m--;
                f = f * m;

            }
            return f;  
        }
        /*
        ich habe die Zeilen die abfragen ob n positiv ist weggelassen, da aus der Aufgabenstellung nicht 
        hervorgeht was dann gehschehen soll. Denn da die Methode nur ein int zurückgeben kann hätten die 
        zuvor enthaltenen Strings die ausgegebn werden falls n <1 ist nicht funktioniert. 
        */
        
        //TODO: Methode binom implementieren b) & c)
        public static int binom (int n, int k)
        {
         if (n>=k && k>=0)
        {
            int x = factorial(n);
            int y = factorial(k);
            int z= factorial(n-k);
            int binom = x/(y*(z));
            return binom;
        }
        else 
        {
            int binom = -1;
            return binom;
        }   
        }
    }

    

