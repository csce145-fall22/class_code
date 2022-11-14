import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes;
	
	public DrawJPanel(ArrayList<Shape> shapes) {
		this.shapes= shapes;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(20, 20, 10, 30);
		g.drawOval(40, 60, 10, 10);
	}

}
