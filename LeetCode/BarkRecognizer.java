package Serials;

public class BarkRecognizer {

	private DogDoor door;
	
	public BarkRecognizer(DogDoor doors){
		this.door = doors;
	}
	
	public void recognize(Bark barkHeard){
		System.out.println("Heard a bark "+barkHeard.getSound());
		
		for(Bark bark : door.getBarks()){
			if(bark.equals(barkHeard)){
				door.open();
				break;
			}
			else{
				System.out.println("This dog is not allowed inside");
			}
		}
	}
}
