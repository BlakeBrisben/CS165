/**
 * Created by garethhalladay on 8/28/17
 */
public abstract class Primitive {
	
	public int color;
	public boolean isFilled;
	
	public abstract void draw(UserInterface ui);
	public void setFilled(boolean isFilled) 
	{
		this.isFilled = isFilled;
	}
	public void setColor(int color) 
	{
		this.color = color;
	}
	
}
