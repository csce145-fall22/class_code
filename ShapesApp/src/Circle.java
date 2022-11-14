import java.awt.Graphics;

public class Circle extends Shape {
	int radius =1;
	
	public String getName() {
		return "Circle";
	}
	
	public Circle(int x, int y, int radius) {
		this.setPosition(x, y);
		this.radius = radius;
	}
	
	public String toString() {
		return super.toString()+" Radius:"+radius;
	}

	@Override
	public void drawTo(Graphics g) {
		g.drawOval(getX(), getY(), 2*radius, 2*radius);
		
	}
}
