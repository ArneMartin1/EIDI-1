public class Test{
	
	public static void main(String[] args)
	{
		Train train1 = new Train("ICE 4 (Baureihe 412)", "elektrisch", 135000, 250, null);
		train1.ankoppeln(new Wagon(50, 24, 1, 2, null));
		train1.ankoppeln(new Wagon(100,12, 2, 2, null));
		train1.ankoppeln(new Wagon(100, 32, 2, 2, null));
		train1.ankoppeln(new Wagon(50, 17, 1, 2, null));
		
		/*
		Wozu gibt es bei den Sitzen 3 Nummern, reserviert und besetzt ist doch das 
		selbe. Daher habe ich nur zwei Zahlen bzgl. der Sitzplätze angegeben. 
		Erstens wie viele Plätze es insgesamt im Wagen gibt und zweitens 
		wie viele davon frei sind. 
		*/

		System.out.println(train1);
		System.out.println(train1.getSeats());
		train1.setLight(true); //Macht das Licht an
		train1.setToilets(true); //Alle Toiletten sind besetzt
		train1.setEndhalt();
	}
}