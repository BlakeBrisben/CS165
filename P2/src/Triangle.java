
public class Triangle extends Primitive {
	private int x0, x1, x2, y0, y1, y2, color;
	private boolean isFilled = false;
	
	public Triangle(int x0, int y0, int x1, int y1, int x2, int y2)
	{
		this.x0 = x0;
		this.x1 = x1;
		this.x2 = x2;
		this.y0 = y0;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void setFilled(boolean isFilled)
	{
		this.isFilled = isFilled;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void draw(UserInterface ui)
	{
		int[] x = {x0, x1, x2};
		int[] y = {y0, y1, y2};
		
		ui.fillColor(color);
		ui.lineColor(color);
		ui.drawPolygon(x, y, isFilled);		
	}
	
}
