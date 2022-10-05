
public class AnimalFarm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal a0 = new Animal("Cow","Moo","plods");
		
		Cow cow1 = new Cow(); 
		
//		a0.goTo("trough");
		cow1.goTo("trough");
		cow1.speak();
		
		Animal cow2 = new Cow();
		cow2.setName("Bessie");
		
		cow2.goTo("trough");
		cow2.speak();
		
		Animal chicken1 = new Chicken();
		chicken1.goTo(" the henhouse");
		chicken1.speak();
		
		Animal[] animals = {cow1,cow2,chicken1};
		
		System.out.println("Farmer Phil comes out with food");
		
		for (Animal a : animals) { // for each loop, great loop
			a.goTo("Farmer Phil");
			a.speak();
		}
	}

}
