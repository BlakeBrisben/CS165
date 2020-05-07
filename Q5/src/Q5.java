// Q5.java - supplied code for final programming quiz
// Name:  ?????
// Date:  ?????
// Class: CS165
// Email: ?????

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q5 {

    // Node data structure
    public static class Node {

        // Letter value
        private char letter;

        // Visited?
        // YOUR CODE HERE
        public boolean visited = false;

        // Children nodes
        public Node left;
        public Node center;
        public Node right;

        // Constructor
        public Node(char letter) {
            this.letter = letter;
        }
    }

    // Graph nodes
    public static ArrayList<Node> nodes;

    // Main program
    public static void main(String[] args) {

        // Test code for breadthFirst
        nodes = buildGraph();
        System.out.println("Breadth First Traversal: ");
        breadthFirst(nodes.get(0));
        System.out.println();
    }

    // buildGraph: build graph of letters
    public static ArrayList<Node> buildGraph() {

        nodes = new ArrayList<>();

        // Nodes
        nodes.add(new Node('J')); // 0
        nodes.add(new Node('P')); // 1
        nodes.add(new Node('R')); // 2
        nodes.add(new Node('a')); // 3
        nodes.add(new Node('r')); // 4
        nodes.add(new Node('o')); // 5
        nodes.add(new Node('g')); // 6
        nodes.add(new Node('a')); // 7
        nodes.add(new Node('k')); // 8
        nodes.add(new Node('o')); // 9
        nodes.add(new Node('m')); // 10
        nodes.add(new Node('n')); // 11
        nodes.add(new Node('s')); // 12
        nodes.add(new Node('a')); // 13
        nodes.add(new Node('i')); // 14
        nodes.add(new Node('c')); // 15
        nodes.add(new Node('v')); // 16
        nodes.add(new Node('r')); // 17
        nodes.add(new Node('m')); // 18
        nodes.add(new Node('g')); // 19
        nodes.add(new Node(' ')); // 20
        nodes.add(new Node(' ')); // 21
        nodes.add(new Node('!')); // 22

        // Edges
        nodes.get( 0).left   = nodes.get( 3);
        nodes.get( 0).center = nodes.get(13);
        nodes.get( 0).right  = nodes.get(19);
        nodes.get( 2).left   = nodes.get( 9);
        nodes.get( 2).center = nodes.get(15);
        nodes.get( 2).right  = nodes.get( 8);
        nodes.get( 3).left   = nodes.get(16);
        nodes.get( 3).right  = nodes.get( 7);
        nodes.get( 4).left   = nodes.get( 5);
        nodes.get( 4).center = nodes.get( 6);
        nodes.get( 4).right  = nodes.get(17);
        nodes.get( 7).left   = nodes.get(20);
        nodes.get( 7).center = nodes.get( 1);
        nodes.get( 7).right  = nodes.get( 4);
        nodes.get( 8).center = nodes.get(12);
        nodes.get( 8).right  = nodes.get(22);
        nodes.get( 9).left   = nodes.get( 5);
        nodes.get(10).center = nodes.get(18);
        nodes.get(13).left   = nodes.get(10);
        nodes.get(13).center = nodes.get(14);
        nodes.get(13).right  = nodes.get(11);
        nodes.get(16).center = nodes.get( 3);
        nodes.get(17).left   = nodes.get( 4);
        nodes.get(18).left   = nodes.get(10);
        nodes.get(19).left   = nodes.get(21);
        nodes.get(19).right  = nodes.get( 2);
        nodes.get(22).right  = nodes.get( 0);

       
        return nodes;
    }

    /**
     * breadthFirst: breadth first traversal printing letters
     * <ol>
     *     <li> Create a Queue to track which nodes to visit next
     *     <li> Only visit nodes which have not been visited already
     *     <li> Branch out to visit neighboring nodes in the order: left, center, right, by adding them to the queue
     *     <li> Print all characters on the same line
     * </ol>
     * @param current the current node in the Graph
     */
    public static void breadthFirst(Node current) {
        //YOUR CODE HERE
    	
    	LinkedList<Node> queue = new LinkedList<Node>();
    	
    	current.visited = true;
    	queue.add(current);
    	
    	while(queue.size() > 0)
    	{
    		Node cur = queue.poll();
    		System.out.print(cur.letter);
    		
    		if(cur.left != null)
	    		if(cur.left.visited == false)
	    		{
	    			queue.add(cur.left);
	    			cur.left.visited = true;
	    		}
    		
    		if(cur.center != null)
    			if(cur.center.visited == false)
    			{
    				queue.add(cur.center);
    				cur.center.visited = true;
    			}
    		
    		if(cur.right != null)
    			if(cur.right.visited == false)
    			{
    				queue.add(cur.right);
    				cur.right.visited = true;
    			}
    		
    	}
    	
    }
}
