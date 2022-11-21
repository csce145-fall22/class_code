import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShapesApp {

	private JFrame frmShapesApp;
	private ArrayList<Shape> shapes;
	private JTextArea textAreaOut;
	private ButtonGroup bgShape = new ButtonGroup();
	private JRadioButton[] rdbuttons = new JRadioButton[4];
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private JTextField textFieldRed;
	private JTextField textFieldGreen;
	private JTextField textFieldBlue;

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
				}
			}
			fin.close();
		} catch(FileNotFoundException fne) {
			textAreaOut.setText("shapes.txt file Not Found");
		} catch(Exception e) {
			textAreaOut.setText(e.getMessage());
		}
		
		JPanel panel_1 = new JPanel();
		frmShapesApp.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Width/Radius:");
		panel_1.add(lblNewLabel);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setText("20");
		panel_1.add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Height");
		panel_1.add(lblNewLabel_1);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setText("10");
		panel_1.add(textFieldHeight);
		textFieldHeight.setColumns(10);
		
		JPanel panel = new JPanel();
		frmShapesApp.getContentPane().add(panel);
		
		JRadioButton rdbtnSquare = new JRadioButton("Square");
		rdbtnSquare.setSelected(true);
		panel.add(rdbtnSquare);
		
		JRadioButton rdbtnRectangle = new JRadioButton("Rectangle");
		panel.add(rdbtnRectangle);
		
		JRadioButton rdbtnCircle = new JRadioButton("Circle");
		panel.add(rdbtnCircle);
		
		JRadioButton rdbtnStar = new JRadioButton("Star");
		panel.add(rdbtnStar);
		
		bgShape.add(rdbtnStar);
		bgShape.add(rdbtnRectangle);
		bgShape.add(rdbtnCircle);
		bgShape.add(rdbtnSquare);
		
		rdbuttons[0]=rdbtnStar;
		rdbuttons[1]=rdbtnRectangle;
		rdbuttons[2]=rdbtnCircle;
		rdbuttons[3]=rdbtnSquare;
		
		JPanel panel_2 = new JPanel();
		frmShapesApp.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		panel_2.add(lblNewLabel_2);
		
		textFieldRed = new JTextField();
		textFieldRed.setBackground(Color.RED);
		textFieldRed.setText("0");
		textFieldRed.setForeground(Color.WHITE);
		panel_2.add(textFieldRed);
		textFieldRed.setColumns(4);
		
		textFieldGreen = new JTextField();
		textFieldGreen.setBackground(Color.GREEN);
		textFieldGreen.setText("0");
		panel_2.add(textFieldGreen);
		textFieldGreen.setColumns(4);
		
		textFieldBlue = new JTextField();
		textFieldBlue.setForeground(Color.WHITE);
		textFieldBlue.setBackground(Color.BLUE);
		textFieldBlue.setText("0");
		panel_2.add(textFieldBlue);
		textFieldBlue.setColumns(4);
		
		DrawJPanel drawJPanel = new DrawJPanel(shapes); 
		drawJPanel.setBackground(Color.WHITE);
		drawJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		drawJPanel.setPreferredSize(new Dimension(300,300));
		frmShapesApp.getContentPane().add(drawJPanel);
		
		textAreaOut = new JTextArea();
		textAreaOut.setEditable(false);
		textAreaOut.setRows(5);
		textAreaOut.setColumns(40);
		frmShapesApp.getContentPane().add(textAreaOut);
		
		drawJPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				System.out.println("Pressed!");

				int x = me.getX();
				int y = me.getY();
				
//				shapes.add(new Star5(x,y));
				try {
					int w = Integer.parseInt(textFieldWidth.getText());
					int ht = Integer.parseInt(textFieldHeight.getText());
					Shape s = null;
					if(rdbtnCircle.isSelected()) {
						s= new Circle(x,y,w);
					} else if (rdbtnRectangle.isSelected()) {
						s= new Rectangle(x,y,w,ht);
					} else if( rdbtnSquare.isSelected()) {
						s= new Square(x,y,w);
					} else if (rdbtnStar.isSelected()) {
						s = new Star5(x,y,w);
					}
					
					shapes.add(s);
				} catch (NumberFormatException nfe) {
					textAreaOut.setText("Width and Height should be numbers!");
				}
				
				drawJPanel.repaint();
			}
		});
		
	}

}
