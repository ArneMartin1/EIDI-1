public class IntString
{
	public static void main (String[] args)
	{
		
		//Test b
		System.out.println(intToIntString(43)); //erwarte 43

		//Test c
		System.out.println(isDigit('5')); //erwarte true

		//Test d
		System.out.println(digitCharToInt('4')); //erwarte 4

		//Test e
		
		System.out.println(isIntString("45678"));  //erwarte true
		System.out.println(isIntString("00000"));	//erwarte false
		System.out.println(isIntString("ab-78"));	//erwarte false
		System.out.println(isIntString(""));	//erwarte false
		

		
		//Test f
		System.out.println(add("5", "120"));	//erwarte 125
		System.out.println(add("a", "13"));		//erwarte NaN
		System.out.println(add("", "13"));		//erwarte NaN
		System.out.println(add("10", "13"));	//erwarte 23
		


		//Test g
		
		System.out.println(mul("12", "12"));	//erwarte 144
		System.out.println(mul("11", "7"));		//erwarte 77
		
	}
	//Aufgabe b
	public static String intToIntString (int n)
	{
		String output = "" + n;
		return output;
	}
	//Aufgabe c
	public static boolean isDigit (char x)
	{
		int ascii = (int) x;
		boolean antwort = false;
		if(ascii>= 48 && ascii<= 57)
		{
			antwort = true;
		}
		return antwort;
	}
	//Aufgabe d
	public static int digitCharToInt (char x)
	{
		if(x>= '0' && x<= '9')
		{
			int antwort = ((x+2) % 10);
			return antwort;
		}
		return 0;
	}

	//Aufgabe e
	public static boolean isIntString (String s)
	{
		if(s.length() == 0 && s != null) // prüft dass der String nicht leer ist
		{
			return false;
		}
		else
		{
			for(int i = 0; i<s.length(); i++) //prüft ob er nur aus Ziffern besteht
			{
				char position = s.charAt(i);
				if(position < '0' || position > '9')
				{
					return false;
				}
			}
			for(int i = 0; i<s.length(); i++) //prüft ob der String nur aus Nullen besteht
			{
				char position = s.charAt(i);
				if(position != '0')
				{
					return true;
				}
				return false;
			}
		}
		return true;
	}

	//Aufgabe f
	public static double add(String summand1, String summand2) 
	{
		double summe = 0.0;
		//Prüft ob es sich um "wohlgeformte" Strings handelt
		if (isIntString(summand1) == false || isIntString(summand2) == false)
		{
			return ( 0.0/0.0);
		}
		else
		{	
			int laenge1 = summand1.length();
			int laenge2 = summand2.length();
			int unterschied = Math.abs(laenge2 - laenge1);


			if(laenge1 == laenge2)
			{}
			//füllt den kürzeren String mit Nullen auf
			else if (laenge1 > laenge2) 
			{	
				for(int i = 0; i<unterschied; i++)
				{
				summand2 = "0" + summand2;
				}
				
			}
			////füllt den kürzeren String mit Nullen auf
			else if (laenge2 > laenge1) 
			{	
				for(int i = 0; i<unterschied; i++)
				{
				summand1 = "0" + summand1;
				}
				
			}
			
			//Addition der einzelnen Stellen
			for(int i = 0; i<summand1.length(); i++)
			{
				double stelle1 = (int) summand1.charAt(i);
				stelle1  = Math.pow(10, (summand1.length() - 1) - i) * (stelle1 - 48);
				

				double stelle2 = (int) summand2.charAt(i);
				stelle2  = Math.pow(10, (summand1.length() - 1) - i) * (stelle2 - 48);
			

				summe =  summe + stelle1 + stelle2;
			}
		}
		return summe;
	}

	//Aufgabe g
	public static double mul(String faktor1, String faktor2) 
	{
		double produkt = 0.0;
		//Prüft ob es sich um "wohlgeformte" Strings handelt
		if (isIntString(faktor1) == false || isIntString(faktor2) == false)
		{
			return ( 0.0/0.0);
		}
		else
		{	
			int laenge1 = faktor1.length();
			int laenge2 = faktor2.length();
			int unterschied = Math.abs(laenge2 - laenge1);


			if(laenge1 == laenge2)
			{}
			//füllt den kürzeren String mit Nullen auf
			else if (laenge1 > laenge2) 
			{	
				for(int i = 0; i<unterschied; i++)
				{
				faktor2 = "0" + faktor2;
				}
				
			}
			////füllt den kürzeren String mit Nullen auf
			else if (laenge2 > laenge1) 
			{	
				for(int i = 0; i<unterschied; i++)
				{
				faktor1 = "0" + faktor1;
				}
				
			}
			
			//Gleiches Prinzip wie in Aufgabe f, nur noch diese äußere Schleife zusätzllich
			for(int j = 0; j< faktor1.length(); j++)
			{
				double stelle1 = (int) faktor1.charAt(j);
				stelle1  = Math.pow(10, (faktor1.length() - 1) - j) * (stelle1 - 48);
					

				for(int i = 0; i<faktor2.length(); i++)
				{
					double stelle2 = (int) faktor2.charAt(i);
					stelle2  = Math.pow(10, (faktor1.length() - 1) - i) * (stelle2 - 48);
	
					produkt =  produkt + stelle1 * stelle2;
				}
			}
		}
		return produkt;
	}
}