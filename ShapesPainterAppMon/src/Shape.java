import java.awt.Color;
import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable{
	private int posX;
	private int posY;
	
	protected Color color;
	
	private String id = null;
	
	public String getName() {
		return "None";
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void setPosition(int x, int y) {
		posX=x;
		posY=y;
	}
	
	public int[] getPosition() {
		int[] pos = {posX,posY};
		return pos;
	}
	
	public void setID(String s) {
		id=s;
	}
	
	public String getID() {
		return id;
	}
	
	private String pos2String() {
		return "["+posX+","+posY+"]";
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public String toString() {
		String basic = "Name: "+getName() + " Position: "+ pos2String(); 
		if (id==null)
			return basic;
		else {
			return "ID: "+id+" "+basic; 
		}
	}
	
}
