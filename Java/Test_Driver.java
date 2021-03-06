import SortingAlgorithms.*;
import DataStructures.*;

import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.time.*;

/**
 * Test Driver for the various java sorting and Datatype Algorithms
 * @author alphaomega325, David Wright
 * @version .01
 * @since 11-24-16
 */

public class Test_Driver{

    
    public static void main(String[] args)
    {
	SortInterface sort = null;
	boolean iscorrect = true;
	Random rand = new Random();
	Scanner scanner = new Scanner(System.in);
	File file = new File("Log");
	int[] array;
	boolean d = false;
	//User Input
	
	System.out.println("Creating Array \nPlease Put in number of elements");
	int n = scanner.nextInt();

	System.out.println("Do you want the debugger, t or f only");

	String debugger = scanner.next();
	switch(debugger){
	case"f": d = false;
	    break;
	case"t": d = true;
	    break;
	case"": d = false;
	    break;
	}
	
	System.out.println("Enter your selection");

	System.out.println("1. Insertion Sort \n2. Quicksort\nq. exit program");
	String selection = scanner.next();
	switch(selection) {
	case "1": sort = new Insertion_Sort(d);
	    break;
	case "2": sort = new QuickSort(d);
	    break;
	case "q": System.out.println("Exiting the program");
	    System.exit(0);

	}    
        
	array = new int[n];
 	
	//Fill Random Numbers
	for(int i = 0; i < n; i++)
	    {
		array[i] = rand.nextInt(10);
	    }
	
	//Displays array if the debug is true

	if(d == true)
	    {
		System.out.println("Array List \nItem Number \t Item");
		
		for(int k = 0; k < n; k++)
		    {
			System.out.println("Item " + k + "\t" + array[k]);
		    }
	    }
	
	System.out.println("Calculating Array");

	
	if(sort == null)
	    {
		System.out.println("Unable to access sorting system, automatic shutdown");
		System.exit(0);
	    }
	
	try {
	    
	    array = sort.sort(array);
	    
	    } catch (Exception e)
	    {
		//errorPrint(file, e);
		e.printStackTrace();
		try(PrintWriter out = new PrintWriter(new FileWriter(file,true))){
			e.printStackTrace(out);
			out.close();
		    }
		    catch(FileNotFoundException x)
			{
			    System.out.println("Unable to find file.");
			    e.printStackTrace();
			    System.exit(0);
			}
		    catch(IOException x)
			{
			    System.out.println("Unable to write to file.");
			    e.printStackTrace();
			    System.exit(0);
			}
		    }
		
		System.out.println("Calculation Completed");
	
	for(int k = 0; k < n - 1; k++)
	    {
		if(array[k] > array[k + 1])
		    {
			System.out.println("Array not sorted at " + k);
			iscorrect = false;
			break;
		    }
		
	    }
	
	if(iscorrect == true)
	    {
		System.out.println("array successfully sorted.");
	    }
	else
	    {
		System.out.println("Array is not sorted.");
		System.out.println("Printing Debug List.");
		for(int j = 0; j < n; j++)
		    {
			System.out.println("Item " + j + " " + array[j]);
		    }
		
	    }

	LinkerInterface linker = new DataStructureLinker();
    }    
	
}
