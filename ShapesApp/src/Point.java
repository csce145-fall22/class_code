
public class Point {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	private double deg2rad(double deg) {
		return deg*2*Math.PI/360;
	}
	
	public Point rotateAround(Point c, double degrees) {
		int cx = c.getX();
		int cy = c.getY();
		
		int tx = x - cx;
		int ty = y - cy;
		
		double rad = deg2rad(degrees);
		
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		double rx = tx*cos - ty*sin;
		double ry = ty*cos + tx*sin;
		
		return new Point((int)(cx+rx), (int)(cy+ry));
		
	}
}
