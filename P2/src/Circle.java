
public class Circle extends Primitive {

	private int x, y, radius, color;
	private boolean isFilled = false;
	
	public Circle(int x, int y, int radius)
	{
		this.x = x;
		this.y  = y;
		this.radius = radius;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void setFilled(boolean isFilled)
	{
		this.isFilled = isFilled;
	}
	
	public void draw(UserInterface ui)
	{
		ui.lineColor(color);
		ui.fillColor(color);
		ui.drawOval(x, y, radius, radius, isFilled);
	}
}
