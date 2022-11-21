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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ShapesApp {

	private JFrame frmShapesApp;
	private ArrayList<Shape> shapes;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	JTextArea textAreaOut;
	ButtonGroup bgShapes = new ButtonGroup();
	private JTextField textFieldRed;
	private JTextField textFieldGreen;
	private JTextField textFieldBlue;
	private JButton btnColorSample;
	private JRadioButton rdbtnStars;
	private JRadioButton rdbtnCircle;
	private JRadioButton rdbtnSquare;
	private JRadioButton rdbtnRect;
	private JRadioButton[] rdbtns = new JRadioButton[4];

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
		
		JPanel panel_1 = new JPanel();
		frmShapesApp.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Width/Radius:");
		panel_1.add(lblNewLabel);
		
		textFieldWidth = new JTextField();
		panel_1.add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Height:");
		panel_1.add(lblNewLabel_1);
		
		textFieldHeight = new JTextField();
		panel_1.add(textFieldHeight);
		textFieldHeight.setColumns(10);
		
		JPanel panel = new JPanel();
		frmShapesApp.getContentPane().add(panel);
		
		rdbtnStars = new JRadioButton("Stars");
		rdbtnStars.setSelected(true);
		panel.add(rdbtnStars);
		
		rdbtnCircle = new JRadioButton("Circle");
		panel.add(rdbtnCircle);
		
		rdbtnRect = new JRadioButton("Rectangle");
		panel.add(rdbtnRect);
		
		rdbtnSquare = new JRadioButton("Square");
		panel.add(rdbtnSquare);
		
		bgShapes.add(rdbtnSquare);
		bgShapes.add(rdbtnStars);
		bgShapes.add(rdbtnRect);
		bgShapes.add(rdbtnCircle);
		
		rdbtns[0]=rdbtnCircle;
		rdbtns[1]=rdbtnRect;
		rdbtns[2]=rdbtnSquare;
		rdbtns[3]=rdbtnStars;
		
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
		
		JPanel panel_2 = new JPanel();
		frmShapesApp.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Color:");
		panel_2.add(lblNewLabel_2);
		
		textFieldRed = new JTextField();
		textFieldRed.setText("0");
		textFieldRed.setForeground(Color.RED);
		panel_2.add(textFieldRed);
		textFieldRed.setColumns(4);
		
		textFieldGreen = new JTextField();
		textFieldGreen.setText("0");
		textFieldGreen.setForeground(Color.GREEN);
		panel_2.add(textFieldGreen);
		textFieldGreen.setColumns(4);
		
		textFieldBlue = new JTextField();
		textFieldBlue.setText("0");
		textFieldBlue.setForeground(Color.BLUE);
		panel_2.add(textFieldBlue);
		textFieldBlue.setColumns(4);
		
		btnColorSample = new JButton("  ");
		panel_2.add(btnColorSample);
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
	
		textFieldRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorChangedOrError();
				
			}
		});
		
		textFieldGreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorChangedOrError();
				
			}
		});
		
		textFieldBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorChangedOrError();
				
			}
		});
		
		drawJPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				System.out.println("Pressed!");
//				if (!tglbtnStars.isSelected())
//					return; //do nothing else
				int x = me.getX();
				int y = me.getY();
				Color c = btnColorSample.getBackground();
				
				
				try {
					int w = Integer.parseInt(textFieldWidth.getText());
					int h = Integer.parseInt(textFieldHeight.getText());
					Shape s=null;
					
					if (rdbtnCircle.isSelected()) {
						s=new Circle(x,y,w);
					} else if (rdbtnSquare.isSelected()) {
						s=new Square(x,y,w);
					} else if (rdbtnRect.isSelected()) {
						s=new Rectangle(x,y,w,h);
					} else if (rdbtnStars.isSelected()) {
						s=new Star5(x,y,w);
					} else throw new Exception("how did I get here?");
					s.setColor(btnColorSample.getBackground());
					shapes.add(s);
				} catch(Exception e) {
					textAreaOut.setText("width and height must be postive numbers\n"
							+e.getMessage());
					
				}
				
				
				drawJPanel.repaint();
			}
		});
		
		colorChangedOrError();
		
	}

	private void colorChangedOrError() {
		// TODO Auto-generated method stub
		
		try {
			int r;
			int g;
			int b;
			
			r=Integer.parseInt(textFieldRed.getText());
			g=Integer.parseInt(textFieldGreen.getText());
			b=Integer.parseInt(textFieldBlue.getText());
			
			if (r<0|| g<0 || b< 0) throw new NumberFormatException();
			if (r>255|| g>255 || b>255) throw new NumberFormatException();
			
			Color c = new Color(r,g,b);
			btnColorSample.setBackground(c);
		} catch(NumberFormatException nfe) {
			textAreaOut.setText("Colors must be integers 0-255");
			textFieldRed.setText("0");
			textFieldGreen.setText("0");
			textFieldBlue.setText("0");
			btnColorSample.setBackground(new Color(0,0,0));
		}
	}
}
