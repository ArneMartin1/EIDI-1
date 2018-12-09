public class Train{

	//Aufgabe c

	//Attribute
	private String baureihe;

	private String motor;

	private int ps;

	private int speed;

	private Wagon wagenHinter;


	//Konstruktor 
	public Train()
	{
		baureihe = "ICE4";
		motor = "diesel";
		ps = 13000;
		speed = 350;
	}

	public Train(String baureihe, String motor, int ps, int speed, Wagon wagenHinter)
	{
		this.baureihe = baureihe;
		this.motor = motor;
		this.ps = ps;
		this.speed = speed;
		this.wagenHinter = wagenHinter;
	}

	public void ankoppeln (Wagon wagenHinter)
	{
		if(this.wagenHinter != null)
		{
			this.wagenHinter.ankoppeln(wagenHinter);
		}
		else
		{
			this.wagenHinter = wagenHinter;
		}
	}
	//Aufgabe e
    public String toString() {
        return baureihe; //man hätte auch eine andere Eigenschaft zurückgeben können (oder auch alle)
    }

    public int getSeats()
    {
    	return (wagenHinter != null ? wagenHinter.getSeats() : 0);
    }

    public void setLight(boolean on)
    {
    	if(wagenHinter != null)
    	{
			wagenHinter.setLight(on);
		}
    }

    public void setToilets(boolean besetzt)
    {
    	if(wagenHinter != null)
    	{
    		wagenHinter.setToilets(besetzt);
    	}
    }

    public void setEndhalt()
    {
    	if(wagenHinter != null)
    	{
    		wagenHinter.setEndhalt();
    	}
    }
	
}