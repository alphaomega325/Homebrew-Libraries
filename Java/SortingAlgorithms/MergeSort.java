package SortingAlgorithms;

/**
 * Homebrew Mergesort Algorith
 * @author alphaomega325, David Wright
 * @version .01
 * @since 01-06-17
 */

public class MergeSort implements SortInterface
{

    boolean debug;
    int[] a;
    int[] b;

    public MergeSort()
    {
	debug = false;
    }

    public MergeSort(boolean debugger)
    {
	try{
	    debug = debugger;

	    if(debug == true)
		System.out.println("MergeSort debugger activated.");

	} catch (Exception e)
	    {
		e.printStackTrace();
	    }

    }

    /**
     * Will be sorting the array via the merge sort algorithm
     * @return a sorted list
     */

    public int[] sort(int[] array)
    {
	a = array;
	n = a.length;
	b = new int[n];
	
	
    }
	
    private void TopDownMergeSort(int[] a,int[] b,int n)
    {
	
	
	
    }

    private void 

    private void CopyArray(int[] a, int begin, int end, int[] b)
    {
	for(k = begin; k < end; k++)
	    b[k] = a[k];
    }
    
    private void swap(int first, int last)
    {
	int temp = array[first];
	array[first] = array[last];
	array[last] = temp;

    }
	
