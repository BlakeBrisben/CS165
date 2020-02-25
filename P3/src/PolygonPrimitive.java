
public class PolygonPrimitive extends Primitive{

	public int[] xPoints, yPoints;
	
	@Override
	public void draw(UserInterface ui) {
		// TODO Auto-generated method stub
		ui.fillColor(color);
		ui.lineColor(color);
		ui.drawPolygon(xPoints, yPoints, isFilled);
	}

}
