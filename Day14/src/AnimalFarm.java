
public class AnimalFarm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] cow1 = {"Cow","moo","plods"};
//		String[] chicken1 = {"Chicken","cluck", "walks"};
//		String[][] animals = {cow1,chicken1};
//		
////		for(int i = 0; i<animals.length; ++i) {
////			System.out.println(animals[i][0]+" "+animals[i][2]+" to the trough");
////		}
//		
//		for(String[] animal: animals) {
//			System.out.println(animal[0]+" "+animal[2]+" to the trough");
//		}
		
		Animal cow2 = new Animal("Cow","plods","moo");
		cow2.goTo("the trough");
		
		Cow cow3 = new Cow();
		cow3.setName("Bessie");
		cow3.goTo("the field");
		
		cow3.speak();
		cow2.speak();
		
		Chicken chick1 = new Chicken();
		Chicken  chick2 = new Chicken();
		chick2.setName("Bojangles");
		
		chick1.goTo("henhouse");
		chick2.goTo("henhouse");
		
		Animal[] animals = {cow2,cow3,chick1,chick2};
		
		System.out.println("Farmer Phil comes outside...");
		for(Animal a : animals) {
			a.goTo("Farmer Phil");
		}

	}

}
