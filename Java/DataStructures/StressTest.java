import Stack.*;
import java.util.*;
import java.io.*;
import java.nio.*;

public class StressTest<T>{

    StackInterface stack;
    String filename = new String("./Log");
    
    public static void main(String[] args)
    {
        
	boolean underflow = false;
	boolean overflow = false;
	boolean generictest = false;
	boolean isempty = false;
	boolean isfull = false;
	boolean sizetest = false;
	
	StressTest stress = new StressTest();
	
	System.out.println("Testing Stack Overflow");
	overflow = stress.overflowTest();
	
	System.out.println("Testing Stack Underflow");
	underflow = stress.underflowTest();

	System.out.println("Testing isemptyTest");
	isempty = stress.isemptyTest();

	System.out.println("Test isFullTest");
	isfull = stress.isfullTest();
	
	System.out.println("Underflow Result " + underflow + "\nOverflow Result " + overflow + "\nis empty test " + isempty + "\nis full test " + isfull);

	System.out.println("Performing Size stress test");
	
	sizetest = stress.sizeStressTest();

	System.out.println("Size Result " + sizetest);
	
    }

    
    public boolean sizeStressTest(){

	int size = 10000000;
	
        byte[] array = new byte[size];

	
        StackInterface<Byte> stack = new ArrayStack<Byte>(size);

	
	Random rand = new Random();

	rand.nextBytes(array);
	try{
	    PrintWriter writer = new PrintWriter(filename);
	    for(int i = 0; i < size; i++)
		{
		    stack.push(array[i]);
		    //writer.println("Pushing " + array[i]);
		    
		}
	    
	    for(int j = size - 1; j > 0; j--)
		{
		    writer.println("Popping " + stack.top() + " and comparing " + array[j]);
		    byte temp = stack.pop();
		    
		    if(array[j] != temp)
			return false;
		    
		}
	    writer.close();
	} catch(IOException e)
	    {
		System.err.println(e);
	    }
	return true;

    }
    
    public boolean isemptyTest()
    {
	stack = new ArrayStack();
	stack.push("f");
	stack.pop();
	if(stack.isEmpty() == true)
	    return true;
	return false;
    }

    public boolean isfullTest()
    {
	stack = new ArrayStack();
	Random rand = new Random();
	try{
	    while(stack.isFull())
		stack.push(rand.nextInt());
	}catch(StackOverflowException e)
	    {
		return false;
	    }
	return true;
       
    }
    
    public boolean underflowTest()
    {
	try{
	    stack = new ArrayStack();
	    while(true)
		stack.pop();
	} catch(StackUnderflowException e)
	    {
		return true;
	    }

    }

    public boolean overflowTest()
    {
	try{
	    stack = new ArrayStack();
	    while(true)
		stack.push("FFF");
	} catch(StackOverflowException e)
	    {
		return true;

	    }

    }
    
}
