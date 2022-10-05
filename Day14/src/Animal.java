
public class Animal {
	private String name;
	private String species;
	private String move;
	private String sound;
	
	public Animal(String species, String move, String sound) {
		name = null;
		this.species = species;
		this.move = move;
		this.sound = sound;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	protected String whatToCall() {
		return name == null ? this.species : this.name;
	}
	
	public void goTo(String place) {
		System.out.println(whatToCall()+" "+move+" to "+place);
	}
	
	public void speak() {
		System.out.println(whatToCall()+" goes \""+this.sound+"\"");
	}
	
}
