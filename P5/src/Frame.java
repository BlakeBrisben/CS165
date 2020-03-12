// Frame.java - class for stack frames for Hanoi
// Author: 
// Date: 
// Course: 
// Email: 

public class Frame {

	// A frame has four int instance variables: [state, n, from, to]
	// see toString()

	// state: the state a Hanoi frame is in:
	// 0: initial state: no action performed
	// 1: "called" (pushed Frame really) hanoi(n-1, from, via)
	// 2: done, both "calls" performed
	private int state;

	// n: the size of the problem
	private int n;

	// from: source peg
	private int from;

	// to: destination peg
	private int to;

	// constructor
	public Frame(int state, int n, int from, int to){
		// STUDENT CODE HERE
		this.state = state;
		this.n = n;
		this.from = from;
		this.to = to;
	}

	public int getN(){
		// STUDENT CODE HERE
		return n;
	}

	public int getFrom(){
		// STUDENT CODE HERE
		return from;
	}

	public int getTo(){
		// STUDENT CODE HERE
		return to;
	}

	public int getState(){
		// STUDENT CODE HERE
		return state;
	}

	public void setState(int s){
		// STUDENT CODE HERE
		this.state = s;
		
	}

	public String toString(){
		// DO NOT CHANGE THIS CODE
		return "[s:" + state + ", n:" + n + ", f:" + from + ", t:" + to + "]";
	}

	public static void main(String[] args){
		// STUDENTS: feel free to change this code to test the methods
		Frame f = new Frame(0,3,1,3);
		System.out.println(f);
		f.setState(1);
		System.out.println("[" + f.getState() + ", " + f.getN() + ", " + f.getFrom()  + ", " + f.getTo()+"]");

	}
}
