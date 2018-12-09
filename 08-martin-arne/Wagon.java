public class Wagon{
	//Aufgabe a) Attribute 

	private int seatsFree,
			seatsOccupied,
			seatsTotal = seatsOccupied + seatsFree;	
	private int klasse;
	private int   etagen;
	private boolean kloKaputt,
					kloBesetzt,
					kloFrei;
	private Wagon wagenDahinter;
	private boolean lichtAn;


	//Aufgabe b) Konstruktor
	public Wagon ()
	{
		//Sitze
		seatsTotal = 100;
		seatsOccupied = 50;
		seatsFree = 50;

		//Klasse
		klasse = 1;

		//Klo
		double kloVariable = Math.random();
		if (kloVariable > 0.7)
		{
			double kloOccupied = Math.random();
			if (kloOccupied > 0.5)
			{
				kloFrei = true;
			}
			else
			{
				kloBesetzt = true;
			}
		}
		else
		{
			kloKaputt = true;
		}
	}

	public Wagon (int seatsTotal, int seatsFree, int klasse, int etagen, Wagon wagenDahinter)
	{
		//Sitze
		this.seatsTotal = seatsTotal;
		this.seatsFree = seatsFree;
		if(seatsFree > seatsTotal)
		{
			seatsOccupied = 0;
		}
		seatsOccupied = seatsTotal - seatsFree;

		//Klasse
		this.klasse = klasse;
		if (klasse > 1)
		{
			klasse = 2;
		}

		//Doppelstock
		this.etagen = etagen;
		if (etagen > 1)
		{
			etagen = 2;
		}

		//Klo
		double kloVariable = Math.random();
		if (kloVariable > 0.3)
		{
			double kloOccupied = Math.random();
			if (kloOccupied > 0.5)
			{
				kloFrei = true;
			}
			else
			{
				kloBesetzt = true;
			}
		}
		else
		{
			kloKaputt = true;
		}

		//Wagen dahinter ?
		this.wagenDahinter = wagenDahinter;	
	}


	public void ankoppeln (Wagon wagenDahinter)
	{
		if(this.wagenDahinter != null)
		{
			this.wagenDahinter.ankoppeln(wagenDahinter);
		}
		else
		{
			this.wagenDahinter = wagenDahinter;
		}
	}


    public int getSeats() 
    {
		return seatsFree + (wagenDahinter != null ? wagenDahinter.getSeats() : 0);
	}

	public void setLight(boolean on)
	{
		this.lichtAn = on;
	}

	public void setToilets(boolean besetzt)
	{
		this.kloBesetzt = besetzt;
	}

	public void setEndhalt()
	{
		this.seatsFree = seatsTotal;
		this.lichtAn = false; //gibt keine Reservierungen, aber dafür geht das Licht aus

		double kloVariable = Math.random();
		if (kloVariable > 0.7)
		{
			double kloOccupied = Math.random();
			if (kloOccupied > 0.25)
			{
				this.kloFrei = true;
			}
			else
			{
				this.kloBesetzt = true;
			}
		}
		else
		{
			this.kloKaputt = true;
		}

		if(wagenDahinter != null)
		{
			wagenDahinter.setEndhalt();
		}
	}


}