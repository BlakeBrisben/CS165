
public class Square extends PolygonPrimitive {

	public Square(int x, int y, int size) 
	{
		this.xPoints = new int[] {x, x + size, x + size, x};
		this.yPoints = new int[] {y, y, y + size, y + size};
	}
	

}
