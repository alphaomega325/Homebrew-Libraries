package SortingAlgorithms;

/**
 * Homebrew Mergesort Algorith
 * @author alphaomega325, David Wright
 * @version .01
 * @since 01-06-17
 */

public class MergeSort extends SortAdapter
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
	int n = a.length;
	b = new int[n];
	TopDownMergeSort(a,b,n);
	return a;
	
    }
	
    private void TopDownMergeSort(int[] a,int[] b,int n)
    {
	CopyArray(a,0,n,b);

	TopDownSplitMerge(b,0,n,a);
	
	
    }

    private void TopDownSplitMerge(int[] b, int begin, int end, int[] a)
    {
	if(end - begin < 2)
	    return;

	int middle = (end + begin) / 2;
	TopDownSplitMerge(a, begin, middle, b);
	TopDownSplitMerge(b, middle, end, a);
	TopDownMerge(b, begin, middle, end, a);

    }

    private void TopDownMerge(int[] a, int begin, int middle, int end, int[] b)
    {
	int i = begin;
	int j = middle;
	
	for(int k = begin; k < end; k++) {

	    if (i < middle && (j >=end || a[i] <= a[j])) {
		b[k]=a[i];
		i = i + 1;
	    } else {
		b[k] = a[j];
		j = j + 1;
		
	    }
	}
	    
    }
	
    
    private void CopyArray(int[] a, int begin, int end, int[] b)
    {
	for(int k = begin; k < end; k++)
	    b[k] = a[k];

    }

}
