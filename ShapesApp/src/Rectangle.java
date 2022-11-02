
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
	
	public String toString() {
		return super.toString() + " Width: "+width+" Height: "+height;
	}
}
