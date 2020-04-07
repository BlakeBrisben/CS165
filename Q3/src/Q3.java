import java.util.Arrays;
import java.util.stream.Collectors;

public class Q3<E> {

    private E[] stack;
    private int size;

    /**
     * Initializes objects of type Q3.
     * <p>
     * This should instantiate the stack field and assign the size field.
     * @param capacity the maximum size of the stack
     */
    public Q3(int capacity){
        stack = newArray(capacity);
        this.size = 0;
    }

    /**
     * @param capacity the size of the array
     * @return a generic array of size capacity
     */
    @SuppressWarnings("unchecked")
	public E[] newArray(int capacity){
        E[] genArray = (E[]) new Object[capacity];
        return genArray;
    }

    /**
     * @return the stack
     */
    public E[] getStack(){
        return stack;
    }

    /**
     * Sets the stack so that we can decouple testing for the add and remove operations
     * @param items items for the array
     */
    public void setStack(E[] items){
        stack = items;
        size = items.length;
    }

    /**
     * A method to help with testing
     * @param items a list of the items to print
     * @param <E> the type of the items
     * @return returns a String that is similar to Arrays.toString but fills in "null" if there is a null.
     */
    public static <E> String formatOutput(Object[] items){
        if (items == null) return "null";
        return String.format("[%s]\n",
                             String.join(", ",
                                         Arrays.stream(items).map(o -> ((o != null) ? o.toString() : "null")).collect(Collectors.toList())));
    }

    /**
     * If the number of items to remove is larger than the current size of the stack,
     * return null. Otherwise remove and return n items from the stack.
     * @param n the number of elements to remove
     * @return the list of items removed in the order they were removed, from front
     *         to the back.
     */
    public E[] removeNItems(int n){
        @SuppressWarnings("unchecked")
		E[] removed = (E[]) new Object[n];
        int ogSize = size;
    	
    	if(size - n < 0)
        	return null;
        else
        {
        	for(int i = 0; i < n; i++)
        	{
        		removed[i] = stack[ogSize - 1 - i];
        		stack[ogSize - 1 - i] = null;
        		size--;
        	}
        	return removed;
        }
    }


    /**
     * If the number of items to be added plus the current elements would exceed the capacity of the stack, return false.
     * Otherwise add the items to the stack from the first element to the last element and return true.
     * @param items the items to be added
     * @return true if the items were added successfully, false otherwise.
     */
    public boolean addNItems(E[] items){
       
    	if(items.length + size > stack.length)
    		return false;
    	else
    	{
	    	for(E things : items)
	        {
	        	stack[size] = things;
	        	size++;
	        }
	    	return true;
    	}
    }

    public int size(){
        return size;
    }


    public static void main(String [] args){
        // testing the constructor
        Q3<Integer> q3 = new Q3<>(10);
        System.out.print("Testing the constructor with a capacity of 10: " + formatOutput(q3.getStack()));
        System.out.println("Size of stack after operation: " + q3.size());
        // testing the newArray method
        System.out.println("Testing the newArray method with a capacity of 5: " + formatOutput(q3.newArray(5)));

        System.out.println("Trying to add 5 items");
        Integer[] addFive = {1, 2, 3, 4, 5};
        System.out.println("Able to add 5 items-> " + q3.addNItems(addFive));
        System.out.println("Size of stack after operation: " + q3.size());
        System.out.println("Array after adding 5 ints: " + formatOutput(q3.getStack()));

        System.out.println("Trying to remove 4 items");
        Object[] fourItemsRemoved = q3.removeNItems(4);
        System.out.print("Items removed: " + formatOutput(fourItemsRemoved));
        System.out.println("Size of stack after operation: " + q3.size());
        System.out.println("Array after trying to remove four items: " + formatOutput(q3.getStack()));
        
        System.out.println("Trying to add 8 items");
        Integer[] addEight = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Able to add 8 items-> " + q3.addNItems(addEight));
        System.out.println("Size of stack after operation: " + q3.size());
        System.out.println("Array after adding 5 ints: " + formatOutput(q3.getStack()));

    }
}
