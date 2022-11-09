import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class ShapesApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapesApp window = new ShapesApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShapesApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 403, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JTextArea textAreaOut = new JTextArea();
		textAreaOut.setEditable(false);
		textAreaOut.setRows(5);
		textAreaOut.setColumns(40);
		frame.getContentPane().add(textAreaOut);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Circle c0 = new Circle(10,10,5);
				c0.setID("c0");
				
				Rectangle r0 = new Rectangle(20,30, 5, 12);
				r0.setID("r0");
				Shape shapes[] = new Shape[10];
				shapes[0] = c0;
				shapes[1] = r0;
				shapes[2] = new Circle(40,50,6);
				
				String out = "Shapes:";
				for(Shape s : shapes) {
					if(s==null) continue;
					else {
						out += "\n"+s.toString();
					}
				}
				textAreaOut.setText(out+tglbtnNewToggleButton.isSelected());
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		DrawJPanel drawJPanel = new DrawJPanel(null); // PASSED IN NULL
		drawJPanel.setBackground(Color.WHITE);
		drawJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		drawJPanel.setPreferredSize(new Dimension(300,300));
		frame.getContentPane().add(drawJPanel);
		
	}

}
