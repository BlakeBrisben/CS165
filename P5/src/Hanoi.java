// Hanoi.java - class that implements an iterative solution of Hanoi using Stack Frames
// Author: 
// Date: 
// Course: 
// Email: 

public class Hanoi{
	private int count = 0; // counts the number of moves
	private boolean debug; // in debug mode, print the runtime stack (rts)
	private Stack<Frame> rts; // runtime stack


	/**
	 * constructor sets debug: 
	 * @param debug: if debug is true, rtsHanoi prints rts
	 */
	public Hanoi(boolean debug){
		this.debug = debug;
	}

	/**
	 * 
	 * @return the number of moves
	 */
	public int getCount(){
		// DO NOT CHANGE THIS CODE
		return count;
	}

	/**
	 * print the disk n move from peg from to peg to
	 * @param n: disk number
	 * @param from: peg from where the disk is moved
	 * @param to: peg to which the disk is moved
	 * This method must be called from rtsHanoi.
	 */
	private void printMove(int n, int from, int to) {
		// DO NOT CHANGE THIS CODE
		System.err.println("move disk " + n + 
				" from " + from + " to " + to);
	}

	/**
	 * Hanoi using an explicit Run Time Stack rts
	 * @throws StackException
	 * 
	 *Assume initially there is one Frame [state,n,from,to] on rts
	 * Keep popping frames until rts is empty
	 * 
	 * When popping a frame:
	 *    if n == 0 do nothing (discard frame)
	 *    else if frame in state 0:
	 *        Do first call hanoi(n-1,from,via):
	 *        by going into state 1 and pushing [1,n,from,to]
	 *        and pushing [0,n-1,from,via]
	 *    else if in state 1
	 *        print disk n move
	 *       push [2,n,from,to] , push [0,n-1,via,to]
	 *    else (in state 2) do nothing
	 */

	private void rtsHanoi() throws StackException{
		Frame frame;
		
		
		
		while(!rts.isEmpty()){
			if(debug) System.err.println("RTS: " + rts); // only in debug mode
			
			// STUDENT CODE HERE
			// You must use the provided printMove method in the appropriate places.
			
			frame = rts.pop();
			int from = frame.getFrom();
			int to = frame.getTo();
			int tot = 0;
			
			for(int i = from; i <= to; i++)
			{
				tot += i;
			}
			
			int via = tot - from - to;
			
			
			if(frame.getN() != 0)
			{
				if(frame.getState() == 0 )
				{
					
					rts.push(new Frame(1, frame.getN(), from, to));
					rts.push(new Frame(0,frame.getN()-1, from, via));
					
				}
				else if(frame.getState() == 1)
				{
									
					rts.push(new Frame(2, frame.getN(), from, to));
					rts.push(new Frame(0,frame.getN()-1, via, to));
					
					printMove(frame.getN(), from, to);
					count++;
					
				}
			}
			
		}
	}

	/**
	 * iterative Hanoi using stack of frames rts
	 * @param n: size of problem (number of disks)
	 * @param from: peg from where the disks are initially kept
	 * @param to: peg to which the disks are eventually moved to
	 * via is computed using from and to
	 * number of moves get counted as a result of calling rtsHanoi
	 * @throws StackException
	 */
	public void itHanoi(int n, int from, int to) throws StackException{
		// DO NOT CHANGE THIS CODE
		Frame start = new Frame(0,n,from,to);
		rts = new Stack<Frame>();
		rts.push(start);
		rtsHanoi();
	}

	/**
	 * @param args
	 * @throws StackException 
	 */
	public static void main(String[] args) throws StackException {
		// STUDENTS: feel free to change this code to test the methods
		// Implement iterative Hanoi, counting moves
		// In debug mode, print the run time stack in the iterative method
		boolean debug = true;
		int n = Integer.parseInt(args[0]);
		if(args.length > 1)
			debug = true;
		System.out.println("Iterative Hanoi from 1 to 3: n = " +n+ ", debug = " +debug);
		Hanoi h = new Hanoi(debug);
		if(n>0){				
			h.itHanoi(n,1,3);
			System.out.println("\nnumber of moves: " + h.getCount());				
		}
	}
}
