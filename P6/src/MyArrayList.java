import java.util.Arrays;

/**
 * MyArrayList.java - student implementation of ArrayList
 * Author: ?????
 * Date:   ?????
 * Class:  CS165
 * Email:
 *
 * @param <E> the type of elements in this list
 */
public class MyArrayList<E> implements IArrayList<E> {

    /**
     * Declare underlying array
     */
    private E[] underlyingArray;

    /**
     * Current size
     */
    private int listSize;

    public final static double CAPACITY_INCREASE = 0.5;

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param initialCapacity the initial capacity of the list
     */
    @SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
        // YOUR CODE HERE
    	
    	underlyingArray = (E[]) new Object[initialCapacity];
    	
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     * Because we are using generics you will have to create a new
     * array of type Object and cast it to type E.
     * <p>
     * Think about constructor chaining.
     */
    public MyArrayList() {
        // YOUR CODE HERE
    	this(10);
    }


    /**
     * Special debug method
     */
    public void printDebug() {
        Debug.printf("ArrayList.size() = %d\n", listSize);
        Debug.printf("ArrayList.capacity() = %d\n", underlyingArray.length);
        for (int index = 0; index < listSize; index++) {
            E e = (E)underlyingArray[index];
            String sElement = e.getClass().getName() + "@" + Integer.toHexString(e.hashCode());
            System.err.printf("ArrayList[%d]:  %s: %s\n", index, sElement, e.toString());
        }
    }


    // If the array is full, expand its capacity by an additional 50% (defined through
    // CAPACITY_INCREASE), using integer math. For example, if the current capacity is 15
    // the new capacity will be 22, and if the current capacity is 22 the new capacity
    // will be 33.
    @Override
    public boolean add(E e) {
        // YOUR CODE HERE
    	
    	add(listSize, e);
    	
    	return true;
    }


    // If the array is full, expand its capacity by an additional 50% (defined through
	// CAPACITY_INCREASE), using integer math. For example, if the current capacity is 15
    // the new capacity will be 22, and if the current capacity is 22 the new capacity
    // will be 33.
    @Override
    @SuppressWarnings("unchecked")
    public void add(int index, E e) {
        // YOUR CODE HERE
    	boolean beforeInd = true;
    	E[] temp = null;
    	int count = 1;
    	
    	if(index > listSize)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		if(underlyingArray.length == size())
    		{
    			int newCap = (int) (size() + size() * CAPACITY_INCREASE);
    			temp = underlyingArray;
        		underlyingArray = null;
        		underlyingArray = (E[]) new Object[newCap];	
        		
        		for(int i = 0; i < listSize + 1; i++)
        		{
        			if(index == i)
        			{
        				underlyingArray[i] = e;
        				beforeInd = false;
        			}
        			else if(beforeInd)
        			{
        				underlyingArray[i] = temp[i]; 
        			}
        			else
        			{
        				underlyingArray[i] = temp[i-1];
        			}
        		}
    		}
    		else
    		{
    			temp = Arrays.copyOfRange(underlyingArray, index, underlyingArray.length-1);
    			underlyingArray[index] = e;
    			for(E vals:temp)
    			{
    				underlyingArray[index+count] = vals;
    				count++;
    			}
    		}
    		
    		
    	}
    	
    	listSize++;
    }

    @Override
    public boolean remove(Object o) {
        // YOUR CODE HERE
    	
    	
    	int index = indexOf(o);
    	
    	if(index == -1)
    		return false;
    	else
    	{
    		remove(index);
    		return true;
    	}
    	
        
    }


    @Override
    public E remove(int index) {
        // YOUR CODE HERE
    	
    	E[] temp = null;
    	E ret = underlyingArray[index];
    	
    	if(index > listSize - 1)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		temp = Arrays.copyOfRange(underlyingArray, index+1, underlyingArray.length);
    		for(int i = index; i < listSize-1; i++)
    		{
    			underlyingArray[i] = temp[i-index];
    		}
    		listSize--;
    	}
    	
        return ret;
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        // YOUR CODE HERE
    	
    	E[] temp = Arrays.copyOfRange(underlyingArray, toIndex, underlyingArray.length);
    	Arrays.fill(underlyingArray, fromIndex, underlyingArray.length, null);
    	
    	for(int i = fromIndex; i < temp.length + fromIndex; i++)
    	{
    		underlyingArray[i] = temp[i-fromIndex];
    	}
    	
    	listSize -= toIndex-fromIndex;
    	Debug.printf("Size after: %d", size());
    	
    	
    }

    @Override
    public E get(int index) {
        // YOUR CODE HERE

        return underlyingArray[index];
    }

    @Override
    public E set(int index, E e) {
        // YOUR CODE HERE
    	
    	E ret = get(index);

    	underlyingArray[index] = e;
    	
        return ret;
    }


    @Override
    public boolean contains(Object o) {
        // YOUR CODE HERE

    	return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        // YOUR CODE HERE

    	int index = -1;
    	
    	for(int i = 0; i < size(); i++)
    	{
    		if(underlyingArray[i].equals(o))
    		{
    			index = i;
    			i = size();
    		}
    		
    	}
    	return index;
    }
    
    public int indexOf(Object o, int start) {
        // YOUR CODE HERE

    	int index = -1;
    	
    	for(int i = start; i < size(); i++)
    	{
    		if(underlyingArray[i].equals(o))
    		{
    			index = i;
    			i = size();
    		}
    		
    	}
    	return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        // YOUR CODE HERE

    	int index = -1;
    	
    	for(int i = size()-1; i >= 0; i--)
    	{
    		if(underlyingArray[i].equals(o))
    		{
    			index = i;
    			i = 0;
    		}
    		
    	}
    	
        return index;
    }

    @Override
    public void clear() {
        // YOUR CODE HERE
    	Arrays.fill(underlyingArray, null);
    	listSize = 0;
    }


    @Override
    public int size() {
        // YOUR CODE HERE

        return listSize;
    }

    @Override
    public boolean isEmpty() {
        // YOUR CODE HERE
    	
        return size() == 0;
    }

    // use the reallocateArray method
    public void trimToSize() {
        // YOUR CODE HERE
    	
    	E[] temp = Arrays.copyOfRange(underlyingArray, 0, listSize);
    	reallocateArray(listSize);
    	
    	underlyingArray = temp;
    	
    }


    @SuppressWarnings("unchecked")
	private void reallocateArray(int capacity) {
        // YOUR CODE HERE
    	
    	underlyingArray = (E[]) new Object[capacity];
    	
    }

}
