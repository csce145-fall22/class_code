import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawJPanel extends JPanel {

	private ArrayList<Shape> shapes;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DrawJPanel(ArrayList<Shape> shapes) {
		super();
		this.shapes = shapes;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.drawRect(20, 10, 5, 5);
//		g.drawRect(10, 20, 10, 10);
//		
//		g.drawLine(50, 100, 100, 50);
		
		for(Shape s : shapes) {
			s.drawTo(g);
		}
	}

}
