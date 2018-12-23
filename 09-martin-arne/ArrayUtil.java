import java.util.Arrays;

public class ArrayUtil {

    public static void main(String[] args) {

        double[] arr1 = {1, 2, 3, 4, 5};
        double[] arr2 = {5, 4, 3, 2, 1};
        double[] arr3 = randomArray(1000);

        System.out.printf("arr1: %s%n", array2String(arr1));
        System.out.printf("arr2: %s%n", array2String(arr2));
        System.out.printf("arr3: %s%n", array2String(arr3));
        System.out.println();

        //a) sum
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr1), Arrays.stream(arr1).sum());
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr2), Arrays.stream(arr2).sum());
        System.out.printf("Sum: %.2f\t (should: %2.2f)%n", sum(arr3), Arrays.stream(arr3).sum());
        System.out.println();

        //b) avg
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr1), Arrays.stream(arr1).average().getAsDouble());
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr2), Arrays.stream(arr2).average().getAsDouble());
        System.out.printf("Average: %.2f\t (should: %2.2f)%n", avg(arr3), Arrays.stream(arr3).average().getAsDouble());
        System.out.println();

        //c) max
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr1), Arrays.stream(arr1).max().getAsDouble());
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr2), Arrays.stream(arr2).max().getAsDouble());
        System.out.printf("Max: %.2f\t (should: %2.2f)%n", max(arr3), Arrays.stream(arr3).max().getAsDouble());
        System.out.println();

        //d) min
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr1), Arrays.stream(arr1).min().getAsDouble());
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr2), Arrays.stream(arr2).min().getAsDouble());
        System.out.printf("Min: %.2f\t (should: %2.2f)%n", min(arr3), Arrays.stream(arr3).min().getAsDouble());
        System.out.println();

        //e) sort
        sort(arr1);
        sort(arr2);
        sort(arr3);
        System.out.printf("Sorted: %s%n", array2String(arr1));
        System.out.printf("Sorted: %s%n", array2String(arr2));
        System.out.printf("Sorted: %s%n", array2String(arr3));
        System.out.println();

        //g) isSorted
        double[] arrUnsorted = randomArray(1000);
        System.out.printf("isSorted arr1: %s%n", isSortedDesc(arr1));
        System.out.printf("isSorted arr2: %s%n", isSortedDesc(arr2));
        System.out.printf("isSorted arr3: %s%n", isSortedDesc(arr3));
        System.out.printf("isSorted arrUnsorted: %s%n", isSortedDesc(arrUnsorted));
    }

    //a)
    private static double sum(double[] arr) {

        //TODO
        double count = 0;
		for (int i = 0; i < arr.length; i++) {
			
				count = count + arr[i];
		}

 	    return (double)count; //CHANGE ME
    }

    //b)
    private static double avg(double[] arr) {

    	double count = 0.0;
    	double average = 0.0;
    	double elemente = 0.0;

		for (int i = 0; i < arr.length; i++) {
			
				count = count + arr[i];
				elemente++;
		}
		average = (count/elemente);


        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }
        
        //TODO
        return average; //CHANGE ME
    }

    //c)
    private static double max(double[] arr) {

    	double max = arr[0];

    	for(int i = 0; i < (arr.length - 1); i++)
    	{
    		if(arr[i] < arr[i+1])
    		{
    			 max = arr[i+1];
    		}
    	}

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        //TODO
        return max; //CHANGE ME
    }

    //d)
    private static double min(double[] arr) {

    	double min = arr[0];

    	for(int i = 0; i < (arr.length - 1); i++)
    	{
    		if(arr[i] > arr[i+1])
    		{
    			min = arr[i+1] ;
    		}
    	}

        if (arr == null || arr.length == 0) {
            return Double.NaN;
        }

        return min; //CHANGE ME
    }

    //e)
    private static void sort(double[] arr) {

    	double temp;
	   	double count = 1.0;
	   	
    	while (count > 0)
    	{
    		count = 0.0;

    		
			for (int i = 0, j = 1; i < (arr.length - 1); i++, j++) {

				
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count ++;	
				}
				
			}
			
		}	

    }
    //f
    /*
	Es funktioniert, weil man bei Arrays mit call-by share arbeitet und nicht call-by value. 
	Angenommen mein Nachbar wohnt in einem grauen Haus. Ich schreibe die Adresse seines Hauses
	(Kopie der Adresse) auf und gebe sie jemandem (Mr.Methode). Mr.Methode geht los und
	malt das Haus meines Nachbarn gelb an. Wenn ich dann meinen Nachbarn besuche ist sein Haus 
	gelb aber an der Adressse die ich nutze um zu seinem Haus zu gelangen hat sich nichts geändert.
	Ich gehe zur selben Adresse wie vorher aber finde ein "anderes" Haus vor. 

	Haus = Element;
	Straße in der das Haus steht = Array;
	Adresse seines Hauses = index; 
	Kopie der Adresse  = Referenz (call-by share);
	Methode = Typ der das Haus anmalt.

    */


    //g)
    private static boolean isSortedDesc(double[] arr) {
        //TODO

			for (int i = 0, j = 1; i < (arr.length - 1); i++, j++) {

				
				if(arr[i] > arr[j])
				{
					return false;
				}	
			}
        return true; //CHANGE ME
    }

    //h)
    private static double median(double[] arr) {

    	sort(arr);

        if (arr == null || arr.length == 0 || !isSortedDesc(arr)) {
            return Double.NaN;
        }

        return (double)arr[arr.length/2]; //CHANGE ME
    }

    //vvvvv Blackbox vvvvv
    private static double[] randomArray(int n) {

        double[] arr = new double[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() - 0.5;
        }

        return arr;
    }

    private static String array2String(double[] arr) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(String.format("%.4f", arr[i]));
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return new String(sb);
    }
}