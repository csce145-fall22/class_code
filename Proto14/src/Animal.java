//capitalize class names
public class Animal {
	private String name;
	private String species;
	private String sound;
	private String move;
	
	public Animal(String species, String sound , String move) {
		this.name = "";
		this.species = species;
		this.sound = sound;
		this.move = move;
	}
	
	public Animal() {
		this("None","makes no noise","walks");
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	//protected -- subclasses can see
	//also, DRY principle (Don't repeat yourself).
	//start private
	protected String whatToCall() {
		return this.name.equals("") ? this.species: this.name;
	}
	
	public void speak() {
		String name = this.name.equals("") ? this.species: this.name;
		System.out.println(name + " goes \""+ this.sound + "\"");
	}
	
	public void goTo(String place) {
		String name = this.name.equals("") ? this.species: this.name;
		System.out.println(name + " " + this.move + " to " + place  );
	}
	
}
