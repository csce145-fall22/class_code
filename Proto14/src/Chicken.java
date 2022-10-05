
public class Chicken extends Animal {
	public Chicken() {
		super("Chicken","Cluck","walks");
	}
	
	//polymorphism
	public void goTo(String place) {
		//chickens can also fly, maybe flip a coin?
		boolean willFly = Math.random()>0.5;
		
		if(willFly) {
			System.out.println(whatToCall()+ " flies to "+ place);
		} else {
			super.goTo(place); //accesses superclass implementation
		}
	}
}
