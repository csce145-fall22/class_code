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
		
	}

}
