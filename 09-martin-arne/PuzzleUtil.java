import java.util.Arrays;
public class PuzzleUtil {
    public static void main(String[] args) {
        int[] arr1 = new int[]{25, 42, 69, 17};

        System.out.println("arr1: ");
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftLeft: ");
        shiftLeft(arr1);
        view(arr1);

        System.out.println("\narr1 shiftRight: ");
        shiftRight(arr1);
        view(arr1);

        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\narr2t: ");
        view(arr2);

        System.out.println("\narr2 shiftRowsRight(1,3): ");
        shiftRows(arr2, 1, 3, false);
        view(arr2);

        System.out.println("\narr2 shiftRowsLeft(1,3): ");
        shiftRows(arr2, 1, 3, true);
        view(arr2);

        System.out.println("\narr2 shiftcols(1,3): ");
        shiftCols(arr2, 1, 3, true);
        view(arr2);

        System.out.println("\narr2 extractArray(0,2,0,2): ");
        view(extractArray(arr2, 0, 2, 0, 2));

        System.out.println("\narr2 extractArray(2,4,2,4): ");
        view(extractArray(arr2, 2, 4, 2, 4));

        System.out.println("\narr2 rotateClockwise: ");
        rotateClockwise(arr2);
        view(arr2);

        System.out.println("\narr2 replaceInArray with zeros: ");
        replaceInArray(arr2, new int[][]{{0, 0}, {0, 0}}, 1, 1);
        view(arr2);

        System.out.println("\narr2 partialRotateClockwise(0,2,0,2): ");
        partialRotateClockwise(arr2, 0, 2, 0, 2);
        view(arr2);
    }

    //a)
    public static void shiftRight(int[] array) {
        //TODO

    int temp = array[array.length - 1];
        for(int i = (array.length - 1); i > 0; i--)
        	{
        	 array[i] = array[i -1];
        	}

        array[0] = temp;

    }

    //b)
    public static void shiftLeft(int[] array) {
        //TODO
        int temp = array[0];
        for(int i = 0; i < (array.length - 1); i++)
        	{
        	 array[i] = array[i + 1];
        	}

        array[(array.length - 1)] = temp;
    }

    //c)
    public static void shiftRows(int[][] array, int rowStart, int rowEnd, boolean shiftLeft) {
        //TODO
    	if(shiftLeft == true)
    	{
    		for(int i = rowStart; i < rowEnd; i++)
    		{
    			shiftLeft(array[i]);
    		}	
    	}
    	else
    	{
    		for(int i = rowStart; i < rowEnd; i++)
    		{
    			shiftRight(array[i]);
    		}
    	}

    }

    //d)
    public static void shiftCols(int[][] array, int colStart, int colEnd, boolean shiftDown) {
        //TODO
        if(shiftDown == false)
        {
            
        	for(int spalte = colStart; spalte < colEnd; spalte++) //Schleife für Spalten
        		{
        			int temp = array[array.length - 1][spalte]; //Hält den untersten Wert fest

        			for(int zeile = (array.length - 1); zeile > 0; zeile--) //Schleife für Zeilen
        			{
        				array[zeile][spalte] = array[zeile -1][spalte];
        			}

        			array[0][spalte] = temp; //setzt untersten Wert oben ein
        		}
        }
        else if (shiftDown == true)
        {
        	for(int spalte = colStart; spalte < colEnd; spalte++) //Schleife für Spalten
        		{
        			int temp = array[0][spalte]; //Hält den obersten Wert fest

        			for(int zeile = 0; zeile < array.length - 1; zeile++) //Schleife Zeilen
        			{
        				array[zeile][spalte] = array[zeile+1][spalte];
        			}

        			array[array.length - 1][spalte] = temp; //setzt obersten Wert unten ein
        		}
        }
    }

    //e)
    public static int[][] extractArray(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        //TODO
        int collums;
        int rows;

        if(rowEnd > array.length)
        {
        	rowEnd = array.length;
        }

        if(colEnd > array.length)
        {
        	colEnd = array.length;
        }

        collums = (colEnd - colStart);
        rows = (rowEnd - rowStart);

         

        int [][] extracted = new int[rows][collums]; //extrahiertes Array

        for(int zeile = rowStart, extrZeile = 0; zeile < rowEnd; zeile++, extrZeile++)
        {
        	
        	for(int spalte = colStart, extrSpalte = 0; spalte < colEnd; spalte++, extrSpalte++)
        	{
        		extracted[extrZeile][extrSpalte] = array[zeile][spalte];
        	}
        }
        return extracted;
    }

    //f)
    public static void replaceInArray(int[][] array, int[][] delta, int rowIndex, int colIndex) {
        //TODO
        int ende;
        
        if(delta.length > array.length)
        {
        	ende = array.length; 
        }
        else
        {
        	ende = delta.length;
        }

        for(int zeile = rowIndex; zeile < ende; zeile++)
        {       	
        	for(int spalte = colIndex; spalte < ende; spalte++)
        	{
        		array[zeile][spalte] = delta[zeile][spalte];
        	}
        }
    }

    //g)
    public static void rotateClockwise(int[][] array) {
        //TODO
        int [][] spender = extractArray(array, 0, array.length, 0, array.length);
       // System.out.println(Arrays.deepToString(spender));

        for(int spalten = 0; spalten < array.length ; spalten++)
        {
        	
        	for(int zeilen = 0; zeilen < array.length ; zeilen++)
        	{
        		array[zeilen][spalten] = spender[array.length - 1 - spalten][zeilen];
        	}
        }
    }

    //h)
    public static void partialRotateClockwise(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        //TODO

        int [][] subarray = extractArray(array, rowStart, rowEnd, colStart, colEnd);
        rotateClockwise(subarray);
        for(int zeilen = rowStart, subZeile = 0; zeilen < rowEnd; zeilen++, subZeile++)
        {
        	for(int spalten = colStart, subSpalte = 0; spalten < colEnd; spalten++, subSpalte++)
        	{
        		array[zeilen][spalten] = subarray[subZeile][subSpalte];
        	}
        }
    }


    //vvvvv Blackbox vvvvv
    public static void view(int[] array) {

        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void view(int[][] array) {

        System.out.println("2d-Array:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
