import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * CoolLinkedList.java - student implementation of LinkedList
 * Author: ?????
 * Date:   ?????
 * Class:  CS165
 * Email:
 *
 * @param <E> the type of elements in this list
 */
public class MyLinkedList<E> implements ILinkedList<E> {

    // Node data structure
    public class Node {
        // YOUR CODE HERE
    }

    // Head (first) pointer
    private Node listHead;

    // Tail (last) pointer
    private Node listTail;

    // Current size
    private int listSize;

    // Default constructor
    public MyLinkedList() {
        // YOUR CODE HERE
    }

    /**
     * Special debug method. Uncomment this method after completing the Node class.
     */
    public void printDebug() {
         /*
        Debug.printf("LinkedList.size() = %d\n", listSize);
        int index = 0;
        for (Node c = listHead; c != null; c = c.next) {
            String sNode = c.getClass().getSimpleName() + "@" + Integer.toHexString(c.hashCode());
            String sNext;
            if (c.next == null)
                sNext = "null";
            else
                sNext = c.next.getClass().getSimpleName() + "@" + Integer.toHexString(c.hashCode());
            Debug.printf("LinkedList[%d]: element %s, next %s\n", index++, sNode, sNext);
        }
         */
    }

    // Possible helper method? Delete if you don't want to use it.
    private Node getNode(int index){
        return null;
    }

    public boolean add(E e) {
        // YOUR CODE HERE

        return true;
    }

    public void add(int index, E e) {
        // YOUR CODE HERE
    }

    public boolean remove(Object o) {
        // YOUR CODE HERE

        return true;
    }

    public E remove(int index) {
        // YOUR CODE HERE

        return null;
    }


    @Override
    public void removeRange(int fromIndex, int toIndex) {
        // YOUR CODE HERE

    }

    public E get(int index) {
        // YOUR CODE HERE

        return null;
    }


    public E set(int index, E e) {
        // YOUR CODE HERE

        return null;
    }

    public boolean contains(Object o) {
        // YOUR CODE HERE

        return false;
    }

    public int indexOf(Object o) {
        // YOUR CODE HERE

        return -1;
    }

    public int lastIndexOf(Object o) {
        // YOUR CODE HERE

        return -1;
    }

    public void clear() {
        // YOUR CODE HERE

    }

    public int size() {
        // YOUR CODE HERE

        return 0;
    }

    public boolean isEmpty() {
        // YOUR CODE HERE

        return false;
    }

    public void addFirst(E e) {
        // YOUR CODE HERE

    }

    public void addLast(E e) {
        // YOUR CODE HERE

    }

    public E removeFirst() {
        // YOUR CODE HERE

        return null;
    }

    public E removeLast() {
        // YOUR CODE HERE

        return null;
    }

    public void push(E e) {
        // YOUR CODE HERE

    }

    public E pop() {
        // YOUR CODE HERE

        return null;
    }

    public E peek() {
        // YOUR CODE HERE

        return null;
    }



    // Extra credit
    public class MyLinkedListIterator implements ListIterator<E> {
        // declare and initialize member variables

        @Override
        public boolean hasNext() {
            // YOUR CODE HERE

            return false;
        }

        @Override
        public E next() {
            // YOUR CODE HERE

            return null;
        }

        @Override
        public boolean hasPrevious() {
            // YOUR CODE HERE

            return false;
        }

        @Override
        public E previous() {
            // YOUR CODE HERE

            return null;
        }

        @Override
        public int nextIndex() {
            // YOUR CODE HERE

            return 0;
        }

        @Override
        public int previousIndex() {
            // YOUR CODE HERE

            return 0;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    public MyLinkedListIterator listIterator() {
        // YOUR CODE HERE

        return null;
    }

}

