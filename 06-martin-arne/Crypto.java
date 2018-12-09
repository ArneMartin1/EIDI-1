class Crypto{

    public static void main(String[] args) {
        System.out.println("[TEST] charShift");

        System.out.println(charShift('a', 3)); //'d'
        System.out.println(charShift('z', 3)); //'c'
        System.out.println(charShift('Z', 2)); //'B'

        System.out.println("\n[TEST] caesar");

        System.out.println(caesar("AB CDE", 3)); //DE FGH
        System.out.println(caesar("AB XyZ", 3)); //DE AbC
        System.out.println(caesar("Hallo", 5)); //Mfqqt

        System.out.println("\n[TEST] brutus");
        brutus(caesar("Hallo", 5));

        System.out.println("\n[TEST] vignere");
        System.out.println(vigenere("Wikipedia", "Vigenere")); //RQQM CIUM V
        System.out.println(vigenere("EidI ist toll!", "Selber")); //WMOJ MJLX ZMP
        
    }

    public static String toUpperCase(String in){

        String out = "";

        for (int i = 0; i < in.length(); i++){
            char c = in.charAt(i);

            if (c >= 'a' && c <= 'z'){
                c = (char) (c - 'a' + 'A');
                out += c;
            }
            else if(c >= 'A' && c <= 'Z'){
                out += c;
            }
            else{
                
            }   
        }
        return out;
    }

    private static char charShift(char in, int shift) {
        //TODO: a)
        int buchstabe = (int) in;

        if (buchstabe >= 97 && buchstabe <=122) // kümmert sich um Großbuchstaben
        {
        	buchstabe = buchstabe + shift;
        	while (buchstabe > 122)            
        	{
        		buchstabe = buchstabe - 26;
        	}
        	while (buchstabe < 97)
        	{
        		buchstabe = buchstabe + 26;
        	}
        }
        else if (buchstabe >= 65 && buchstabe <=90) // kümmert sich um kleine Buchstaben
        {
        	buchstabe = buchstabe + shift;
        	while (buchstabe > 90)
        	{
        		buchstabe = buchstabe - 26;
        	}
        	while (buchstabe < 65)
        	{
        		buchstabe = buchstabe + 26;
        	}
        }
        else 
        {
        	in = (char) buchstabe; 
        }
        in = (char) buchstabe;

        return in;
    }

    private static String caesar(String in, int shift) {
        //TODO: b)
    	String out ="";

    	for (int i=0; i<in.length(); i++)
    	{
    		char verschoben = charShift(in.charAt(i), shift); // verschiebt den Charakter an Position i um shift
    		out = out + verschoben;
    	}
        return out;
    }

    private static void brutus(String in) {
        //TODO: c)
        String out = "";
        for (int j=0; j<26; j++)    //Geht das Alphabet durch
        {
        	out = "";
        	for (int i =0; i<in.length(); i++) //Geht "in" durch
        	{
        		char verschoben = charShift(in.charAt(i),j); //decodiert jeden einzelnen Charakter
        		out = out + verschoben;
        	}
        	System.out.println(out + ", Shift: "+j);
    	}	
    }

    private static String vigenere(String in, String password) {
        //TODO: d) + e)
        in = toUpperCase(in);
        password = toUpperCase(password);
        int x = password.length();

        int z = 0; 		//Zählvariable fürs Passwort
        String out = "";
        for (int i=0; i<in.length(); i++)	//geht den String "in" durch
        {
        	char buchstabe = in.charAt(i);	//Charakter von "in" der verschlüsselt wird
        	int shift = (int) password.charAt(z);//Charakter von "Passwort" zum codieren 
        	shift = shift - 65;        	
        	char ausgabe = charShift(buchstabe, shift);
        	out = out + ausgabe; //Ausgabe des codierten Charakters
        	z++;								 	
        	if (z == x)	//schaut dass die Länge des passworts nicht überschritten wird 
        	{
        		z = 0;
        	}	
    	}
        String vierer = "";

        for (int i =0; i<out.length(); i++)  // Schleife zur Vierergruppierung
        {
            if ((i % 4 == 0))
            {
                vierer = vierer + " ";  // macht an jeder vierten Stelle ein Leerzeichen
            }
            char position = out.charAt(i);
            vierer = vierer + position;
        }
        
        return vierer;
    }

}
