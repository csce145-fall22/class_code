
public class Cow extends Animal implements Walker {
	public Cow() {
		super("Cow","plods","moo");
	}
	
	public void walkTo(String place) {
		System.out.println(whatToCall()+" "+move+" to "+place);
	}
}
