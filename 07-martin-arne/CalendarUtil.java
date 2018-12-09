
class CalendarUtil
{
	public static void main (String[] args)
	{
		
		//Test b
		System.out.println(getNthWeekday(7));

		//Test c
		System.out.println(isLeapYear(2004)); 	//erwarte true
		System.out.println(isLeapYear(2003));		//erwarte false

		//Test d
		System.out.println(getDaysInMonth(Month.FEB, 2004)); //erwarte 29
		System.out.println(getDaysInMonth(Month.AUG, 2004)); //erwarte 31

		//Test e
		System.out.println(dayInYear(10, 1994, Month.DEC)); //erwarte 343
		System.out.println(dayInYear(31, 1994, Month.DEC)); //erwarte 364


		//Test f
		System.out.println(daysBetween(10, 1994, Month.DEC, 25, 1900, Month.FEB)); //erwarte 34 621
		System.out.println(daysBetween(23, 1800, Month.FEB, 28, 1800, Month.FEB));	//erwarte 5

		//Test g
		System.out.println(getWeekdayFromDate(10, 1994, Month.DEC)); //erwarte SATURDAY
		System.out.println(getWeekdayFromDate(28, 1800, Month.FEB)); //erwarte FRIDAY
		System.out.println(getWeekdayFromDate(26, 2050, Month.MAR)); //erwarte SATURDAY
		System.out.println(getWeekdayFromDate(10, 2110, Month.NOV)); //erwarte MONDAY
		System.out.println(getWeekdayFromDate(22, 2203, Month.MAY)); //erwarte SUNDAY

	}

	//Aufgabe a
	enum Day   { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
	
	enum Month { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC }


	//Aufgabe b
	public static Day getNthWeekday (int n)
	{	
		n = n % 7;
		switch(n)
		{
			case 0:
				return Day.SUNDAY;

			case 1:
				return Day.MONDAY;

			case 2:
				return Day.TUESDAY;

			case 3:
				return Day.WEDNESDAY;

			case 4:
				return Day.THURSDAY;

			case 5:
				return Day.FRIDAY;

			case 6:
				return Day.SATURDAY;
		}
		return null;
	}

	//Aufgabe c
	public static boolean isLeapYear (int jahr)
	{
		if (jahr % 400 == 0 || jahr % 4 == 0 && jahr % 100 != 0)
		{
			return true;
		}
		return false;
	}

	//Aufgabe d
	public static int getDaysInMonth (Month monat, int jahr)
	{
		int tage;

		if (monat.equals(Month.FEB) && isLeapYear(jahr) == true)
		{
			tage = 29;
			return tage;
		}
		else
		{
			switch (monat)
			{
				case JAN:
				case MAR:
				case MAY:
				case JUL:
				case AUG:
				case OCT:
				case DEC:
					tage = 31;
					return tage;

				case APR:
				case JUN:
				case SEP:
				case NOV:
					tage = 30;
					return tage;

				case FEB:
					tage = 28;
					return tage;
			}
		}
		return 0;
	}

	//Aufgabe e 
	public static int dayInYear (int tag , int jahr, Month monat)
	{
		int summeMonat = -1; //Summe der Tage bis zum gesuchten Monat

		if (monat.equals(Month.JAN))
		{
			summeMonat = summeMonat + tag;
			return summeMonat;
		}
		else
		{
			for(Month aktuellerMonat : Month.values()) //Geht alles Monate bis zum gegebenen Monat durch
			{
				if(aktuellerMonat.equals(monat))
				{
					break;
				}
				summeMonat = summeMonat + getDaysInMonth(aktuellerMonat, jahr); //summiert die Tage der Monate
			}
		}

		summeMonat = summeMonat + tag; //addiert die Anzahl der Tage "des Tages" hinzu
		return summeMonat;
	}

	//Aufgabe f 
	public static int daysBetween (int tag1, int jahr1, Month monat1, int tag2, int jahr2, Month monat2)
	{
		int zweiterTag = dayInYear(tag2, jahr2, monat2);
		int tageDazwischen;
		int ersterTag = dayInYear(tag1, jahr1, monat1); 

		if (jahr1 < jahr2) //erstes Datum älter als zweites Datum?
		{
			tageDazwischen = zweiterTag + 365 - ersterTag; //Abstand der Tage
			for(int i = jahr1 + 1; i < jahr2; i++) //summiert Tage der Jahre dazwischen auf
			{
				tageDazwischen = tageDazwischen + dayInYear(31, i, Month.DEC) + 1; // +1 da dayInYear von 0 bis 364 zählt

			}
			return tageDazwischen;
		}
		else if (jahr1 == jahr2) //Jahre sind gleich ?!
		{	
				tageDazwischen = Math.abs(zweiterTag - ersterTag); //Abstand der Tage
				return tageDazwischen;
			
		}
		else if ( jahr2 < jahr1) //Daten verdreht ? 
		{
			tageDazwischen = daysBetween(tag2, jahr2, monat2, tag1, jahr1, monat1); //andersrum eingeben
			return tageDazwischen;
		}
		return 0;
	}

	//Aufgabe g 
	public static Day getWeekdayFromDate (int tag, int jahr, Month monat)
	{
		int wochentag;
		int ankerTag = 28;
		Month ankerMonat = Month.FEB;
		int ankerJahr = 1800;
		int tageDifferenz;
		int jahrhundert = jahr % 400;
	

		String tagDerWoche;

		//Ankerdatum bestimmen

		if (jahrhundert >= 300 && jahrhundert < 400)
		{
			ankerJahr = 1900;
			ankerTag = ankerTag - 3; // Sonntag 25 FEB 
		}

		else if (jahrhundert >= 0 && jahrhundert < 100)
		{
			ankerJahr = 2000;
			ankerTag = ankerTag - 2; //Sonntag 26 FEB
		}

		else if (jahrhundert >= 200 && jahrhundert < 300)
		{
			ankerJahr = 1800;
			ankerTag = ankerTag - 5; // Sonntag 23 FEB
		} 

		else if (jahrhundert >= 100 && jahrhundert < 200)
		{
			ankerJahr = 2100;
			ankerTag = ankerTag; //Sonntag 28 FEB
		}

		//Anzahl der Tage zwischen Anker und gesuchtem Datum bestimmen
	
		tageDifferenz = daysBetween(ankerTag, ankerJahr, ankerMonat, tag, jahr, monat);
		wochentag = tageDifferenz % 7; // bestimmt den Wochentag (SUNDAY = 0, MONDAY = 1,...)

		return getNthWeekday(wochentag);
	}
}