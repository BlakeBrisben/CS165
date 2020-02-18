
public class Rectangle extends Primitive {
	private int x, y, color, width, height;
	private boolean isFilled = false;
	
	public Rectangle(int x, int y, int width, int height) 
	{
		this.x = x;
		this.y = y;
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
		ui.fillColor(color);
		ui.lineColor(color);
		ui.drawRectangle(x, y, width, height, isFilled);
	}
}
