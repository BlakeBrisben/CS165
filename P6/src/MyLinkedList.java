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
    	
    	E item;
    	Node next;
    	Node prev;
    	
    	public Node(E item)
    	{
    		this.item = item;
    	}
    	public Node(E item, Node prev, Node next)
    	{
    		this.item = item;
    		this.prev = prev;
    		this.next = next;
    	}
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
    	this.listSize = 0;
    }

    /**
     * Special debug method. Uncomment this method after completing the Node class.
     */
    public void printDebug() {
         
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
         
    }

    // Possible helper method? Delete if you don't want to use it.
    private Node getNode(int index){
    	Node n = listHead;
    	
    	if(index > -1 && index < size())
    	{
	    	for(int i = 0; i < index-1; i++)
	    	{
	    		n = n.next;
	    	}
	
	        return n;
    	}
    	else
    		throw new IndexOutOfBoundsException();	
    }

    public boolean add(E e) {
    	
    	add(size(), e);
        return true;
    }

    public void add(int index, E e) {
    	Node n = listHead;
    	Node added = null;
    	
    	if(listHead == null)
    	{
    		listHead = new Node(e, null, listTail);
    		
    		listSize++;
    		
    	}
    	else if(index <= size())
    	{
	    	for(int i = 0; i < index-1 && n.next != null; i++)
	    	{
	    		n = n.next;
	    	}
	    	added = new Node(e, n, n.next);
	    	n.next = added;
	    	
	    	printDebug();
	    	listSize++;
	    	
	    	//Debug.printf("listSize: %d", listSize);
    	}
    	else
    		throw new IndexOutOfBoundsException();
    	
    }

    public boolean remove(Object o) {
        
    	Debug.printf("indexof: %d", indexOf(o));
    	
    	try
    	{
    		remove(indexOf(o));
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		return false;
    	}
    	
        return true;
    }

    public E remove(int index) {
    	
    	Node n = listHead;
    	Node ret;
    	Node newPrev;
    	
    	Debug.printf("index: %d", index);
    	
    	if(index == 0)
    	{
    		return removeFirst();
    	}
    	else if(index > -1 && index < size())
    	{    	
	    	for(int i = 0; i < index-1; i++)
	    	{
	    		n = n.next;
	    	}
	    	
	    	ret = n;
	    	newPrev = n.prev;
	    	n = n.next;
	    	newPrev.next = n;
	    	listSize--;
	    	
	        return n.item;
    	}
    	else
    		throw new IndexOutOfBoundsException();
    }


    @Override
    public void removeRange(int fromIndex, int toIndex) {
    	Node n, k;
    	
    	if(fromIndex == 0)
    	{
    		k = getNode(toIndex);
    		listHead = k;
    		listSize -= toIndex-fromIndex;
    		
    	}
    	else if(fromIndex > 0 && fromIndex < size() && toIndex > 0 && toIndex < size())
    	{
	    	n = getNode(fromIndex-1);
	    	
	    	k = getNode(toIndex);
	    	
	    	
	    	
	    	n.next = k;
	    	k.prev = n;
	    	
	    	listSize -= toIndex-fromIndex;
    	}
    	else
    		throw new IndexOutOfBoundsException();
    	
    }

    public E get(int index) {
    	Node n = listHead;
    	
    	if(index > -1 && index < size())
    	{
	    	for(int i = 0; i < index-1; i++)
	    	{
	    		n = n.next;
	    	}
	
	        return n.item;
    	}
    	else
    		throw new IndexOutOfBoundsException();
    }


    public E set(int index, E e) {
    	
    	Node n = listHead;
    	E ret;
    	
    	if(index > -1 && index < size())
    	{
	    	for(int i = 0; i < index-1; i++)
	    	{
	    		n = n.next;
	    	}
	    	
	    	ret = n.item;
	    	n.item = e;
	    	
	        return ret;
    	}
    	else
    		throw new IndexOutOfBoundsException();
    }

    public boolean contains(Object o) {

        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {

    	Node n = listHead;
    	int counter = 0;
    	int index = -1;
    	
    	while(n.next != null || n.equals(o))
    	{
    		n = n.next;
    		counter++;
    		if(n.equals(o))
    		{
    			index = counter;
    		}
    	}
    	
        return index;
    }

    public int lastIndexOf(Object o) {
    	Node n = listHead;
    	int counter = 0;
    	int index = -1;
    	
    	while(n.next != null)
    	{
    		n = n.next;
    		counter++;
    		if(n.equals(o))
    		{
    			index = counter;
    		}
    	}
    	
        return index;
    }

    public void clear() {
    	listHead.next = listTail;
    	listSize = 0;
    }

    public int size() {

    	return listSize;
    }

    public boolean isEmpty() {

        return listSize == 0;
    }

    public void addFirst(E e) {
    	add(0, e);

    }

    public void addLast(E e) {
    	add(size()-1, e);
        
    }

    public E removeFirst() {
        E ret = listHead.item;
        listHead = listHead.next;
    	
        return ret;
    }

    public E removeLast() {
    	
    	Node ret = getNode(size()-1);
    	Node newNode = getNode(size()-2);
    	printDebug();
    	newNode.next = listTail;
    	
    	
    	

        return ret.item;
    }

    public void push(E e) {
    	add(0, e);

    }

    public E pop() {

        return removeFirst();
    }

    public E peek() {
    	return this.get(0);
    }



    // Extra credit
    public class MyLinkedListIterator implements ListIterator<E> {
        // declare and initialize member variables
    	
    	int nextIndex = 0;
    	int prevIndex = -1;
    	Node next = listHead.next;
    	Node prev = listHead;

        @Override
        public boolean hasNext() {
        	
        	return this.next() != null;
        }

        @Override
        public E next() {
        	if(this.hasNext())
        	{
	        	E ret = next.item;
	        	
	        	nextIndex++;
	        	prevIndex++;
	        	prev = next;
	        	next = next.next;
	        	
	        	
	            return ret;
            
	        }
	    	else
	    		throw new NoSuchElementException();
	        }

        @Override
        public boolean hasPrevious() {

        	return this.previous() != null;
        }

        @Override
        public E previous() {
        	
        	if(this.hasPrevious())
        	{
	        	E ret = prev.item;
	        	
	        	nextIndex--;
	        	prevIndex--;
	        	next = prev;
	        	prev = prev.prev;
	        	
	        	
	            return ret;
        	}
        	else
        		throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {

            return nextIndex;
        }

        @Override
        public int previousIndex() {
        
            return prevIndex;
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
            	
        return new MyLinkedListIterator();
    }

}

