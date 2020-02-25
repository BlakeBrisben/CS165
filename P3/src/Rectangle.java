
public class Rectangle extends PolygonPrimitive {
	
	public Rectangle(int x, int y, int width, int height) 
	{
		this.xPoints = new int[] {x , x + width, x + width, x};
		this.yPoints = new int[] {y, y,  y + height, y + height};
		
	}
	
	
}
