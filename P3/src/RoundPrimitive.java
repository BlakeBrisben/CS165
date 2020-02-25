
public class RoundPrimitive extends Primitive{

	public int x, y, width, height;
	
	@Override
	public void draw(UserInterface ui) {
		// TODO Auto-generated method stub
		ui.fillColor(color);
		ui.lineColor(color);
		ui.drawOval(x, y, width, height, isFilled);
	}

}
