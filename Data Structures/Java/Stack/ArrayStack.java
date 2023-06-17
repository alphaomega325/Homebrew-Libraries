package Stack;

/**
 * A stack implemented using a array
 * @author alphaomega325
 * @version .01
 * @since 12-24-2016
 */

public class ArrayStack<T> implements StackInterface<T>{
    
    private int maxitems;

    private int index;

    private T[] stack;

    /**
     * Automatically initializes stack with 100 items
     */
    
    public ArrayStack()
    {
	maxitems = 100;

	index = -1;

	stack =(T[]) new Object[maxitems];

    }

    /**
     * Alternatively User gives maxitems
     * @param number of maxitems
     * @exception maxitems is negative
     * @throws NegativeArraySizeException
     */

    public ArrayStack(int maxitems)
    {
	if(maxitems < 0)
	    {
		throw new NegativeArraySizeException();
	    }
	
	this.maxitems = maxitems;

	index = -1;
	
	stack =(T[]) new Object[maxitems];

    }

    /**
     * Adds Items to the stack
     * @param Item added to the stack
     * @return Whether the operation is successful or not
     * @exception Arraysize is bigger than the maxitems
     * @throws StackOverflowException
     */
    
    public boolean push(T item)
    {
	
	if(index == (maxitems - 1))
	    {
		throw new StackOverflowException();
	    }
	
	index++;

	stack[index] = item;
	
	return true;

    }

    /**
     * Removes Item from the top of the stack
     * @return The Item at the top of the stcak
     * @exception Arrasize is less than zero
     * @throws StackUnderflowException
     */
    
    public T pop()
    {
	if(index < 0)
	    {
		throw new StackUnderflowException();

	    }
	T item = stack[index];

	index--;

	return item;

    }

    /**
     * Returns item at the top of the stack
     * @return The Item at the top of the stack
     * @exception Arraysize is less than zero
     * @throws StackUnderflowException
     */
    
    public T top()
    {
	if(index < 0)
	    {
		throw new StackUnderflowException();

	    }

	return stack[index];

    }

    /**
     * Expands the stack
     * @return Boolean Whether the operation is successful or not
     * @param int new stack size
     * @exception Param is less than zero
     * @throws NegativeArraySizeException
     */

    public boolean expand(int size)
    {
	if(size < 0)
	    {
		throw new NegativeArraySizeException();
	    }

	T[] temp =(T[]) new Object[maxitems];

	//sends stack contents to the temp array
	for(int j = 0; j < maxitems; j++)
	    {
		temp[j] = stack[j];
	    }

	//initializes new stack
	stack =(T[]) new Object[size];

	for(int i = 0; i < maxitems; i++)
	    {
		stack[i] = temp[i];
	    }

	maxitems = size;

	return true;
    }

    /**
     * Returns whether the stack is empty
     * @return boolean true if the stack is empty false if not empty
     */
    public boolean isEmpty()
    {
	if(index == -1)
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }

    /**
     * Returns whether the stack is full
     * @return boolean true if the stack is full flase if not full
     */
    public boolean isFull()
    {
	if(index == (maxitems - 1))
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }
}
