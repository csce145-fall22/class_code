
public class Chicken extends Animal {
	public Chicken() {
		super("Chicken","walks","cluck");
	}
	
	//polymorphism
	public void goTo(String place) {
		boolean flyThere = Math.random()<0.5;
		if( flyThere ) {
			System.out.println(whatToCall()+" flies to "+ place);
			
		} else {
			super.goTo(place);
		}
	}
}
