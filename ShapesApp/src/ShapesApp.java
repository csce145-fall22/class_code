import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class ShapesApp {

	private JFrame frmShapesApp;
	private ArrayList<Shape> shapes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapesApp window = new ShapesApp();
					window.frmShapesApp.setVisible(true);
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
		frmShapesApp = new JFrame();
		frmShapesApp.setTitle("Shapes App");
		frmShapesApp.setBounds(100, 100, 403, 586);
		frmShapesApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShapesApp.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		frmShapesApp.getContentPane().add(tglbtnNewToggleButton);
		
		JTextArea textAreaOut = new JTextArea();
		textAreaOut.setEditable(false);
		textAreaOut.setRows(5);
		textAreaOut.setColumns(40);
		frmShapesApp.getContentPane().add(textAreaOut);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Circle c0 = new Circle(10,10,5);
//				c0.setID("c0");
//				
//				Rectangle r0 = new Rectangle(20,30, 5, 12);
//				r0.setID("r0");
//				Shape shapes[] = new Shape[10];
//				shapes[0] = c0;
//				shapes[1] = r0;
//				shapes[2] = new Circle(40,50,6);
//				
//				String out = "Shapes:";
//				for(Shape s : shapes) {
//					if(s==null) continue;
//					else {
//						out += "\n"+s.toString();
//					}
//				}
//				textAreaOut.setText(out+tglbtnNewToggleButton.isSelected());
			}
		});
		frmShapesApp.getContentPane().add(btnNewButton);
		
		shapes = new ArrayList<Shape>();
		
		
//		shapes.add( new Circle(10,30,5));
//		shapes.add( new Circle(30,10,8));
//		shapes.add( new Rectangle(80, 120, 50, 60));
		
		try {
			FileInputStream fis = new FileInputStream("shapes.txt");
			Scanner fin = new Scanner(fis);
			while(fin.hasNext()) {
				String line = fin.nextLine();
				String[] tokens = line.split("\\s");
				String shape = tokens[0];
				int x = Integer.parseInt(tokens[1]);
				int y = Integer.parseInt(tokens[2]);
				if(shape.equals("circle")) {
					int r = Integer.parseInt(tokens[3]);
					Circle c = new Circle(x,y,r);
					shapes.add(c);
				} else if (shape.equals("rectangle")) {
					int w = Integer.parseInt(tokens[3]);
					int h = Integer.parseInt(tokens[4]);
					Rectangle rect = new Rectangle(x,y,w,h);
					shapes.add(rect);
				} else if(shape.equals("square")) {
					int w = Integer.parseInt(tokens[3]);
					Square s = new Square(x,y,w);
					shapes.add(s);
				}
			}
			fin.close();
		} catch(FileNotFoundException fne) {
			textAreaOut.setText("shapes.txt file Not Found");
		} catch(Exception e) {
			textAreaOut.setText(e.getMessage());
		}
		DrawJPanel drawJPanel = new DrawJPanel(shapes); 
		drawJPanel.setBackground(Color.WHITE);
		drawJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		drawJPanel.setPreferredSize(new Dimension(300,300));
		frmShapesApp.getContentPane().add(drawJPanel);
		
	}

}
