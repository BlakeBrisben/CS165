
public class Text extends Primitive {
	private int x, y, fontSize, color;
	private String text, fontName;
	
	public Text(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
	}
	
	public void draw(UserInterface ui)
	{
		ui.setFont(fontName, fontSize);
		ui.textColor(color);
		ui.drawText(x, y, text);
		
	}
	
	public void setColor(int color) 
	{
		this.color = color;
	}
	
	public void setFont(String fontName, int fontSize)
	{
		this.fontName = fontName;
		this.fontSize = fontSize;
	}
}
