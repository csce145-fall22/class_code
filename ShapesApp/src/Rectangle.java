import java.awt.Graphics;

public class Rectangle extends Shape {
	private int width=10;
	private int height =10;
	
	public String getName() {
		return "Rectangle";
	}
	
	public Rectangle(int x, int y, int width, int height) {
		this.setPosition(x, y);
		this.width=width;
		this.height=height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public String toString() {
		return super.toString() + " Width: "+width+" Height: "+height;
	}

	@Override
	public void drawTo(Graphics g) {
		g.drawRect(this.getX(), this.getY() , this.getWidth(), this.getHeight());
		
	}
	
	
}
