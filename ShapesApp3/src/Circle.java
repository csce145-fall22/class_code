
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
}
