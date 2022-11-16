import java.awt.Color;
import java.awt.Graphics;

public class Star5 extends Shape {

	private Point[] pts;
	
	public Star5(int x, int y){
		Point c = new Point(x,y);
		Point top = new Point(x,y-10);
		
		pts = new Point[5];
		
		pts[0]=top;
		for(int i = 1; i<=4; ++i) {
			Point pt = top.rotateAround(c, i*360/5);
			pts[i]=pt;
		}
	}
	
	@Override
	public void drawTo(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		for(int i =0; i< 5; ++i) {
			Point from = pts[i];
			Point to = pts[(i+2)%pts.length];
			g.drawLine(from.getX(), from.getY(), to.getX(), to.getY());
			

		}

	}

}
