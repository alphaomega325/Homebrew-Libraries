package SortingAlgorithms;

/**
 * Homebrew Quick Sort Algorithm
 * @author alphaomega325, David Wright
 * @version .01
 * @since 12-20-16
 */

public class QuickSort extends SortAdapter
{
    /**
     * Boolean Debug cycles whether the class is in debug mode or not
     */

    boolean debug;
    int[] array;

    public QuickSort()
    {
	debug = false;

    }

    public QuickSort(boolean debugger)
    {
	try{
	    
	    debug = debugger;
	    
	    if(debug == true)
		System.out.println("Quick Sort Debugger activated.");
	    
	} catch (Exception e)
	    {
		e.printStackTrace();
		
	    }
    }


    /**
     * Will be sorting a array via the quicksort algorithm
     *@return a sorted list
     */

    public int[] sort(int[] earray)
    {
	//tests for already sorted list;
	/*boolean tester = test(array);

	if(tester == true)
	    {
		return array;
		} */
	array = earray;
	
	quicksort(array, 0, array.length - 1);

	return array;
	
	
    }

    /**
     * Tests whether the array is already sorted
     *@return whether the array is already sorted or not
     */
    
    private boolean test(int[] array)
    {
	
	boolean sorted = true;
	int number = 1;
	
	while((sorted == true) && (number < array.length))
	    {
		if(array[number] < array[number - 1])
		    sorted = false;

	    }
	
	return sorted;
    }

    /**
     * Quicksort class will partition out the array
     */

    private void quicksort(int[] array, int low, int high)
    {
	try{
	    if(low < high)
		{
		    if(debug == true)
			{
			    System.out.println("partitioning " + low + " " + high);
			    show();
			}
		    int pivot = partition(array, low, high);
		    if(debug == true)
			{
			    System.out.println("Pivot = " + pivot + "\nQuicksorting " + low + " " + (pivot - 1));
			    //show();
			}
		    quicksort(array, low, pivot - 1);
		    if(debug == true)
			{
			    System.out.println("Quicksorting " + (pivot + 1) + " " + high);
			    //show();
			}
		    quicksort(array, pivot + 1, high);
		    
		}
	}
	catch (Exception e)
	    {
	        System.out.println("Error Detected");

	    }
	//return array;
    }


    /**
     * Partition class will sort the array
     */
    
    private int partition(int[] array, int low, int high)
    {
	int pivot = array[high];
	int i = low; //place for swapping
	
	for(int j = low; j <= high - 1; j++)
	    {
		
		if(array[j] <= pivot)
		    {
			if(debug == true)
			    System.out.println("Swapping New Pivot " + i + " " + array[i] + " Checker " + j + " " + array[j]);
			swap(j, i);
			i++;
		    }
		
	    }
	if(debug == true)
	    System.out.println("Final partition swap Low " + array[i] + " High " + array[high]);
        swap(high, i);
	if(debug == true)    
	    System.out.println("Returning new pivot " + i);
	return i;
    }

    /**
     * swaps elements in a array
     */
    private void swap(int first, int last)
    {
	int temp = array[first];
	array[first] = array[last];
	array[last] = temp;
	//return array;

    }
    
    /**
     * shows contents in current array
     */
    private void show()
    {
	int element = 0;
	while(element < array.length)
	    {
	    System.out.println("Element " + element + " Content " + array[element]);
	    element++;
	    }

    }
	    
	
}
