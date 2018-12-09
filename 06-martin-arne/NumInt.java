class NumInt{

    public static void main(String[] args) {
    
        System.out.println("f(0)\t= " + f(0));
        System.out.println("f(0.5)\t= " + f(0.5));
        System.out.println("f(1)\t= " + f(1));

        System.out.println("\nGood approximation: \t" + 0.7468);

        System.out.println("");

        System.out.println("Monte-Carlo (1000): \t" + monteCarlo(1000));
        System.out.println("Monte-Carlo (10000): \t" + monteCarlo(10000));
        System.out.println("Monte-Carlo (100000): \t" + monteCarlo(100000));
        System.out.println("Monte-Carlo (1000000): \t" + monteCarlo(1000000));

        System.out.println("");

        System.out.println("Rectangular approximation (1000): \t" + rectApprox(1000));
        System.out.println("Rectangular approximation (10000): \t" + rectApprox(10000));
        System.out.println("Rectangular approximation (100000): \t" + rectApprox(100000));
        System.out.println("Rectangular approximation (1000000): \t" + rectApprox(1000000));

        System.out.println("");

        System.out.println("Trapezoidal approximation (1000): \t" + trapezApprox(1000));
        System.out.println("Trapezoidal approximation (10000): \t" + trapezApprox(10000));
        System.out.println("Trapezoidal approximation (100000): \t" + trapezApprox(100000));
        System.out.println("Trapezoidal approximation (1000000): \t" + trapezApprox(1000000));

    }

    public static double monteCarlo(int n){
        //TODO a)
        double treffer = 0.0;
        for (int i =0; i<n; i++)
        {
            double xpfeil = Math.random();
            double ypfeil = Math.random();
            if(ypfeil<= Math.exp(-(xpfeil)*(xpfeil))) //vergeicht die y werte des Wurfs und der Funktion miteinander
            {
                treffer = treffer +1;
            }
        }

        return (treffer/n);
    }

    public static double rectApprox(int n){
        //TODO b)
        double summe = 0.0;
        double m = n;
        for (int i =0; i<n; i++)
        {
            double s = Math.exp(-(((m-i)/m)*((m-i)/m)))*(1/m); //berechnet die Rechtecke 
            summe = summe + s;
        }
        return summe;
    }

    public static double trapezApprox(int n){
        //TODO c)
        double summe = 0.0;
        double m = n;
        double dreieck = 0.0;

        for(int i=0; i<n; i++)
        {
            double d = (Math.exp(-(m-i/m)*((m-i/m))) * Math.exp(-((m-i-1)/m)*(((m-1-i)/m)))) * 1/(2*m); //berechnet die Dreiecke
            double s = Math.exp(-((m-1-i)/m)*(((m-1-i)/m))) * (1/m); //berechnet die rechtecke 
            dreieck = dreieck +d;
            summe = summe + s;
        }
        return (summe+dreieck);
    }

    public static double f(double x){
        return Math.exp(-(x*x));
    }
}