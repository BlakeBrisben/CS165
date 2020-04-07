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
    public MyArrayList(int initialCapacity) {
        // YOUR CODE HERE
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

        return true;
    }


    // If the array is full, expand its capacity by an additional 50% (defined through
    // CAPACITY_INCREASE), using integer math. For example, if the current capacity is 15
    // the new capacity will be 22, and if the current capacity is 22 the new capacity
    // will be 33.
    @Override
    public void add(int index, E e) {
        // YOUR CODE HERE
    }

    @Override
    public boolean remove(Object o) {
        // YOUR CODE HERE
        return false;
    }


    @Override
    public E remove(int index) {
        // YOUR CODE HERE
        return null;
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        // YOUR CODE HERE
    }

    @Override
    public E get(int index) {
        // YOUR CODE HERE

        return null;
    }

    @Override
    public E set(int index, E e) {
        // YOUR CODE HERE

        return null;
    }


    @Override
    public boolean contains(Object o) {
        // YOUR CODE HERE

        return false;
    }

    @Override
    public int indexOf(Object o) {
        // YOUR CODE HERE

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // YOUR CODE HERE

        return -1;
    }

    @Override
    public void clear() {
        // YOUR CODE HERE

    }


    @Override
    public int size() {
        // YOUR CODE HERE

        return -1;
    }

    @Override
    public boolean isEmpty() {
        // YOUR CODE HERE

        return false;
    }

    // use the reallocateArray method
    public void trimToSize() {
        // YOUR CODE HERE

    }


    private void reallocateArray(int capacity) {
        // YOUR CODE HERE

    }

}
