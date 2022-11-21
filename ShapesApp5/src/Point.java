
public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	private double deg2rad(double deg) {
		return deg*2*Math.PI/360;
	}
	
	public Point rotateAround(Point c, double degrees ) {
		int cx = c.getX();
		int cy = c.getY();
		
		int tx = getX()-cx;
		int ty = getY()-cy;
		
		double rad = deg2rad(degrees);
		
		double cosAngle = Math.cos(rad);
		double sinAngle = Math.sin(rad);
		
		double rx = tx*cosAngle-ty*sinAngle;
		double ry = ty*cosAngle+tx*sinAngle;
		
		return new Point((int)(cx+rx),(int)(cy+ry));
		
	}
}
