
public class Fish extends Animal implements Swimmer {
	public Fish() {
		super("Fish", "swims", "bubble-bubble");
	}
	
	public void swimTo(String place) {
		System.out.println(whatToCall()+" swims to "+place);
	}
}
