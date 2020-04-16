// Q4.java - provided code for programming quiz
// Name:  ?????
// Date:  ?????
// Class: CS165
// Email: ?????

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q4 {

    // Instance variables for Q4
    static Node root;

    public static void main(String[] args) {

        int[] numbers = {4, 17, 2, -1, 50, 6, 21, 5, 3, 11, 14, 39, 78, -4};
        System.out.println("Numbers: " + Arrays.toString(numbers));
        buildTree(numbers);
        
        //Test code for printRecursive
        System.out.println("Numbers in order traversal: ");
        printTree(root);
    }

    /**
     * Adds a root node with value 0, then each number in the values list to the tree.
     * 
     * You do not need to modify this method
     * 
     * @param values list of numbers to be added to the tree
     */
    static void buildTree(int[] values) {
    	root = new Node(0);
    	for(int val : values) {
    		addRecursive(root, val);
    	}
    }
    
    /**
     * Add a number to the tree in its correct sorted position.
     * 
     * Compare val to the current node's value to see which side to insert into.
     * 
     * If the child node on that side is null, create a new node.
     * Otherwise, call this function recursively.
     * 
     * @param current the current node
     * @param val the value to add to the tree
     */
    static void addRecursive(Node current, int val) {
    	//YOUR CODE HERE
    	Node added = new Node(val);
    	
    	if(current == null)
    	{
    		current = new Node(val);
    	}
    	else if(val > current.value)
    	{
    		if(current.right == null)
    		{
    			current.right = added;
    			added.left = current;
    		}
    		else if(current.right.value > val)
    		{
    			added.left = current;
    			added.right = current.right;
    			current.right.left = added;
    			current.right = added;
    		}
    		else
    		{
    			addRecursive(current.right, val);
    		}
    	}
    	else if(val < current.value)
    	{
    		if(current.left == null)
    		{
    			current.left = added;
    			added.right = current;
    			root = added;
    			
    		}
    		else if(current.left.value < val)
    		{
    			added.right = current;
    			added.left = current.left;
    			current.left.right = added;
    			current.left = added;
    		}
    		else
    		{
    			addRecursive(current.left, val);
    		}
    	}
    	
    	
    }


    /**
     * Traverse the tree in order from least to greatest using recursion
     * and print each number.
     * 
     * If the node specified is null, return immediately. This is a base case.
     * 
     * Call this function recursively for each child node.
     * 
     * @param current a reference to the tree node
     */
    static void printTree(Node current) {
        // YOUR CODE HERE
    	if(current == null)
    		return;
    	else
    	{
    		System.out.println(current.value);
			printTree(current.right);
    	}
    	
    }
}
