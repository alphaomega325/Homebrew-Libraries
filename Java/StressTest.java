import SortingAlgorithms.*;

import java.util.Random;

/**
 * Stress tester for the algorithms to see how long it will take before they break.
 * @author alphaomega325
 * @version .01
 * @since 12-22-16
 */

public class StressTest {

    public static void main(String[] args)
    {

	SortInterface sort = new QuickSort();
	boolean iscorrect = true;
	Random rand = new Random();
	int[] array;
	int size = 1;

	try{
	    while(iscorrect)
		{
		    array = new int[size];
		    for(int i = 0; i < size; i++)
			{
			    array[i] = rand.nextInt();
			}
		    System.out.println("Checking array size " + size);
		    size = size * 2;
		    array = sort.sort(array);
		    iscorrect = checker(array);
		}

	} catch(Exception e)
	    {
		System.err.println("Array failed after " + size + " attempts\n Reason of failure\n");
		e.printStackTrace();
	    }

    }

    public static boolean checker(int[] array)
    {

	for(int j = 1; j < array.length; j++)
	    {
		if(array[j-1] > array[j])
		    return false;
	    }
	return true;
	    

    }

}
    
	
