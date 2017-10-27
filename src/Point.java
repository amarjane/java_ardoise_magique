import java.awt.Color;


public class Point {

	private int x = -10;
	private int y = -10;
	private int width = 10;
	private int height = 10;
	
	private Color color = Color.WHITE;
	private String form = "ROND";
	
	public Point(){}
	
	public Point(int x, int y, int w, int h, Color c, String f) {
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
		this.setColor(c);
		this.setForm(f);		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
}
