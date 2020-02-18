
public class Oval extends Primitive {
	private int x, y, width, height, color;
	private boolean isFilled = false;
	
	public Oval(int x, int y, int width, int height)
	{
		this.x = x;
		this.y  = y;
		this.width = width;
		this.height = height;
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
		ui.drawOval(x, y, width, height, isFilled);
	}
}
