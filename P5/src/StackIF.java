// StackIF.java - generic interface for a stack
// Author: Wim Bohm
// Course: CS165

public interface StackIF<E> {
	/**
	 * add String op to top of stack
	 * @param op: The object to be pushed on to the stack
	 */
	void push(E op);

	/**
	 * remove and return the item from top of stack
	 * @return that item
	 * @throws StackException when stack is empty
	 */
	E pop() throws StackException;

	/**
	 * @return return true if stack empty, false otherwise
	 */
	boolean isEmpty();

}

