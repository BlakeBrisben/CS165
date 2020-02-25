// DrawProgram.java - Solution for drawing program
// Author: Chris Wilcox
// Date: 2/2/2017
// Class: CS165
// Email: wilcox@cs.colostate.edu

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DrawProgram {

    public static UserInterface ui;

    /**
     * Calls load, passing args[0] as the name of the text file containing graphics primitives.
     * Calls draw to draw the primitives.
     * @param args in this case, a valid filename for a Primitive file
     * @throws InterruptedException thrown when graphics program fails
     */
    public static void main(String[] args) throws InterruptedException {

        // Drawing primitives
        ArrayList<Primitive> primitives;

        // Instantiate user interface
        ui = new UserInterface();

        // Close window
        ui.open();

        // Read primitives
        primitives = load(args[0]);

        // Draw primitives
        draw(primitives);

        // Wait for awhile (change if you want the drawing to be rendered for a
        // longer period of time.
        Thread.sleep(10000);

        // Close window
        ui.close();
    }

    /**
     * Read graphics primitives from file
     * @param filename the filename with primitive values
     * @return a list of primitives
     */
    public static ArrayList<Primitive> load(String filename) {

        ArrayList<Primitive> primitives = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {

                int x0,y0,x1,y1,x2,y2,width,height,radius;
                int[] xPoints, yPoints;

                // Read and parse line
                String line = scan.nextLine();
                String[] fields = line.split(",");
                if (fields.length == 0) continue; // discard empty

                // Interpret primitives
                switch (fields[0]) {
                    case "TEXT":
                        x0 = Integer.parseInt(fields[3]);
                        y0 = Integer.parseInt(fields[4]);
                        Text text = new Text(x0, y0 , fields[2]);
                        text.setColor(Integer.parseInt(fields[1], 16));
                        text.setFont(fields[5], Integer.parseInt(fields[6]));
                        primitives.add(text);
                        break;

                    case "SQUARE":
                        x0 = Integer.parseInt(fields[2]);
                        y0 = Integer.parseInt(fields[3]);
                        Square square = new Square(x0, y0, Integer.parseInt(fields[4]));
                        square.setColor(Integer.parseInt(fields[1], 16));
                        square.setFilled(fields[5].equals("filled"));
                        primitives.add(square);
                        break;

                    case "RECTANGLE":
                        x0 = Integer.parseInt(fields[2]);
                        y0 = Integer.parseInt(fields[3]);
                        width = Integer.parseInt(fields[4]);
                        height = Integer.parseInt(fields[5]);
                        Rectangle rect = new Rectangle(x0, y0, width, height);
                        rect.setColor(Integer.parseInt(fields[1], 16));
                        rect.setFilled(fields[6].equals("filled"));
                        primitives.add(rect);
                        break;

                        
                    case "TRIANGLE":
                    	x0 = Integer.parseInt(fields[2]);
                    	y0 = Integer.parseInt(fields[3]);
                    	x1 = Integer.parseInt(fields[4]);
                    	y1 = Integer.parseInt(fields[5]);
                    	x2 = Integer.parseInt(fields[6]);
                    	y2 = Integer.parseInt(fields[7]);
                    	
                    	Triangle tri = new Triangle(x0, y0, x1, y1, x2, y2);
                    	tri.setColor(Integer.parseInt(fields[1], 16));
                    	tri.setFilled(fields[8].equals("filled"));
                    	primitives.add(tri);
                    	break;
                    	
                    case "CIRCLE":
                    	x0 = Integer.parseInt(fields[2]);
                    	y0 = Integer.parseInt(fields[3]);
                    	radius = Integer.parseInt(fields[4]);
                    	
                    	Circle cir = new Circle(x0, y0, radius);
                    	cir.setColor(Integer.parseInt(fields[1], 16));
                    	cir.setFilled(fields[5].equals("filled"));
                    	primitives.add(cir);
                    	break;
                    	
                    case "OVAL":
                    	x0 = Integer.parseInt(fields[2]);
                    	y0 = Integer.parseInt(fields[3]);
                    	width = Integer.parseInt(fields[4]);
                    	height = Integer.parseInt(fields[5]);
                    	
                    	Oval oval = new Oval(x0, y0, width, height);
                    	oval.setColor(Integer.parseInt(fields[1], 16));
                    	oval.setFilled(fields[6].equals("filled"));
                    	primitives.add(oval);
                    	break;
                    case "POLYGON":
                    	
                    	xPoints = new int[Integer.parseInt(fields[3])];
                    	yPoints = new int[Integer.parseInt(fields[3])];
                    	
                    	
                    	for(int i = 0; i < Integer.parseInt(fields[3]) * 2; i++)
                    	{
                    		if(i % 2 == 0)
                    			xPoints[i/2] = Integer.parseInt(fields[i + 4]);
                    		else
                    			yPoints[i/2] = Integer.parseInt(fields[i + 4]);
                    		
                    	}
                    	
                    	Polygon polygon = new Polygon(xPoints, yPoints);
                    	polygon.setColor(Integer.parseInt(fields[1], 16));
                    	polygon.setFilled(fields[2].equals("filled"));
                    	primitives.add(polygon);
                    	break;
                }
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("Cannot open file: " + filename);
        }
        return primitives;
    }

    /**
     * Draw graphics primitives in arraylist
     * @param primitives the list of Primitives
     */
    public static void draw(ArrayList<Primitive> primitives) {

    	for(Primitive prims:primitives)
    	{
    		prims.draw(ui);
    	}
    }
}
