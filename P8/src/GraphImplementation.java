// GraphImplementation.java - supplied code for graph assignment
// Author: ?????
// Date:   ?????
// Class:  CS165
// Email:  ?????

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GraphImplementation extends GraphAbstract {

    // Main entry point
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("usage: java GraphImplementation <distanceFile> <graphFile>");
            System.exit(-1);
        }

        // Instantiate code
        GraphImplementation impl = new GraphImplementation();

        // Read distances chart
        System.out.println("Reading Chart: " + args[0]);
        impl.readGraph(args[0]);
        System.out.println();

        // Write distances graph
        System.out.println("Writing Graph: " + args[1]);
        impl.writeGraph(args[1]);
        System.out.println();

        // Print depth first search
        System.out.println("Depth First Search:");
        impl.depthFirst("Fort Collins");
        System.out.println();

        // Print breadth first search
        System.out.println("Breadth First Search:");
        impl.breadthFirst("Aspen");
        System.out.println();

    }

    // Reads mileage chart from CSV file
    public void readGraph(String filename) {
        // YOUR CODE HERE
    	try {
    		
			Scanner in = new Scanner(new File(filename));
			
			String currentLine = in.nextLine();
			
			Scanner lineRead = new Scanner(currentLine);
			lineRead.useDelimiter(",");
			
			while(lineRead.hasNext())
			{
				cities.add(new GraphNode(lineRead.next()));
			}
			
			int from = 0;
			
			while(in.hasNext())
			{
				
				currentLine = in.nextLine();
				lineRead = new Scanner(currentLine);
				lineRead.useDelimiter(",");
				int to = 0;
				
				lineRead.next();
				//System.out.println("Next City");
				
				
				while(lineRead.hasNext())
				{
					//System.out.println("Checking if has mileage");
					String mileage1 = lineRead.next();
					int mileage;
					if(mileage1.length() > 0)
					{
						mileage = Integer.parseInt(mileage1);
						
						cities.get(from).edges.add(new GraphEdge(from, to, mileage));
						cities.get(to).edges.add(new GraphEdge(to, from, mileage));
						
						//System.out.println("Added new edge to city");
					}
					
					to++;
				}				
				
				from++;
			}
			
			for(int k = 0; k < cities.size(); k++)
			{
				for(int i = 0; i < cities.get(k).edges.size()-1; i++)
				{
					for(int j = 0; j < cities.get(k).edges.size()-i-1; j++)
					{
						if(cities.get(k).edges.get(j).compareTo(cities.get(k).edges.get(j+1)) > 0)
						{
							//System.out.println("sorting swap");
							Collections.swap(cities.get(k).edges, j, j+1);
						}
					}
				}
			}
			
			int cityIn = 0;
			
			while(cityIn < cities.size())
			{
				//System.out.println("Next City to add to mileage");
				int edgeIn = 0;
				while(edgeIn < cities.get(cityIn).edges.size())
				{
					GraphEdge cur = cities.get(cityIn).edges.get(edgeIn);
					int index = 0;
					boolean insert = false, allow = true;
					
					for(int i = 0; i < mileages.size(); i++)
					{
						if(mileages.get(i).fromIndex == cur.toIndex && mileages.get(i).toIndex == cur.fromIndex)
						{
							allow = false;
						}
					}
					
					if(allow)
					{
						//System.out.println("Adding new edge to mileage");
						if(mileages.size() == 0)
							mileages.add(cur);
						else
						{
							while(index < mileages.size() && !insert)
							{
								if(cur.compareTo(mileages.get(index)) < 0)
								{
									//System.out.println("Added edge sorted");
									mileages.add(index, cur);
									insert = true;
								}
								
								index++;
							}
							if(!insert)
								mileages.add(cur);
						}
					}
					edgeIn++;
				}
				cityIn++;
			}
			
			in.close();
			lineRead.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
    	
    	
    }

    public void writeGraph(String filename) {

    	System.out.println(filename);
        ArrayList<String> output = new ArrayList<>();
        output.add("digraph BST {");
        output.add("    ratio = 1.0;");
        output.add("    node [style=filled]");
        output.add("    node [fillcolor=darkslateblue]");
        output.add("    node [fixedsize=true]");
        output.add("    node [shape=oval]");
        output.add("    node [width=6]");
        output.add("    node [height=4]");
        output.add("    node [fontname=Arial]");
        output.add("    node [fontsize=60]");
        output.add("    node [fontcolor=white]");
        output.add("    edge [dir=none]");
        output.add("    edge [penwidth=24]");
        output.add("    edge [fontname=Arial]");
        output.add("    edge [fontsize=110]");
        
        for (GraphNode n : cities){
            output.add(String.format("    Node%d [label=\"%s\"]", n.edges.get(0).fromIndex, n.name));
        }
        for (GraphEdge e : mileages){
            output.add(String.format("    Node%d -> Node%d [label=\"%d\" color=\"%s\"]",
                                     e.fromIndex, e.toIndex, e.mileage, getColor(e.mileage)));
        }
        output.add("}");
        writeFile(filename, output);
    }

    private String getColor(int mileage){
        if(mileage <= 100) {
            return "green";
        }if(mileage <= 200) {
            return "blue";
        }if(mileage <= 300){
            return "magenta";
        }
        return "red";
    }


    public void depthFirst(String startCity) {
        // YOUR CODE HERE
    	int startingIndex = cities.indexOf(new GraphNode(startCity));
    	
    	ArrayList<Integer> visited = new ArrayList<Integer>();
    	visited.add(startingIndex);
    	System.out.println("Visited " + startCity);
    	depthFirst(startingIndex, visited);
    }

    // Recursive helper method
    public void depthFirst(int index, ArrayList<Integer> visited) {
    	
    	for(GraphEdge edge: cities.get(index).edges)
    	{
    		if(!visited.contains(edge.toIndex))
    		{
    			System.out.println("Visited " + cities.get(edge.toIndex).name);
    			visited.add(edge.toIndex);
    			depthFirst(edge.toIndex, visited);
    		}
    	}
    	
    }

    public void breadthFirst(String startCity) {
        
    	LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    	ArrayList<Integer> visited = new ArrayList<Integer>();
    	
    	int startingIndex = cities.indexOf(new GraphNode(startCity));
    	
    	visited.add(startingIndex);
    	
    	queue.add(cities.get(startingIndex));
    	
    	while(queue.size() > 0)
    	{
    		GraphNode city = queue.poll();
    		
    		System.out.println("Visited " + city.name);
    		
    		for(GraphEdge edge : city.edges)
    		{
    			if(!visited.contains(edge.toIndex))
    			{
    				visited.add(edge.toIndex);
    				queue.add(cities.get(edge.toIndex));
    			}
    		}
    	}
    	
    	
    }


    // Helper functions

    /**
     * Reads the contents of file to {@code ArrayList}
     * @param filename the file to read from
     * @return an ArrayList of the contents
     */
    static ArrayList<String> readFile(String filename) {
        ArrayList<String> contents = new ArrayList<>();
        try(Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty())
                    contents.add(line);
            }
        } catch (IOException e) {
            System.err.println("Cannot read chart: " + filename);
        }
        return contents;
    }

    /**
     * Write contents of {@code ArrayList} to file
     * @param filename the name of the file to write to
     * @param contents an ArrayList of contents to write
     */
    static void writeFile(String filename, ArrayList<String> contents) {
        try(PrintWriter writer = new PrintWriter(filename)) {
            for (String line : contents)
                writer.println(line);
        } catch (IOException e) {
            System.err.println("Cannot write graph: " + filename);
        }
    }
}
