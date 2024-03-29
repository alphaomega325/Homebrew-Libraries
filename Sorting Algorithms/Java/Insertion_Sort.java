package SortingAlgorithms;

/**
 * Homebrew Insertion Sort algorithm
 * @author alphaomega325, David Wright
 * @version .01
 * @since 11-25-16
 */

public class Insertion_Sort extends SortAdapter{
    
    /**
     * Will simply initialize the class
     */

    boolean debug;
    
    public Insertion_Sort()
    {
    	debug = false;
    }
    
    /**
     * If the boolean is set true will allow debug messages;
     */
    public Insertion_Sort(Boolean debugger)
    {
	debug = debugger;
	if(debug == true)
	System.out.println("Insertion Sort Debugger activated.");
	
    }
    
    /**
     * Will be the thing that Sorts the Array via the Insertion Sort Algorithm.
     * @return returns a sorted list
     */
    public int[] sort(int[] array)
    {	
	boolean previous = false;
	int locprevious = 0;
	
	for(int review = 0; review < array.length - 1; review++)
	    {
		//Debug messages;
		
		if(debug == true)
		    {
			System.out.println("Review " + review + " , item at review " + array[review]);

		    }
			
		//IF the variable in i is less than i + 1 switch the variables	       
		
		if(array[review] > array[review + 1])
		    {
			if(debug == true)
			    {
				System.out.println("Swapping array location " + (review + 1) + " and " + review + "\nitems " + array[review+1] + " " + array[review]);
			    }

			if(previous == false)
			    {
				previous = true;
				locprevious = review;
			    }
			
			int temp = array[review + 1];
			array[review + 1] = array[review];
			array[review] = temp;

			//insures that review will move back 2 moving the smaller variables back;
			//if moving the review back 2 will be lest then -1 move the review back to -1;
			
			if(review - 2 > -1)
			    {
				review = review - 2;
			    }
			else{
			    
			    review = -1;

			}
			
		    }
		else
		    {
			if(previous == true)
			    {
				review = locprevious;
				previous = false;
			    }

		    }
		

	    }
	
	
	return array;
	
    }

    
}
