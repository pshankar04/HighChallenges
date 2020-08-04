package Serials;

public class DogDoorSimulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		door.addBarks(new Bark("roolf"));
		door.addBarks(new Bark("roolf roolf"));
		door.addBarks(new Bark("woolf"));
		door.addBarks(new Bark("wolf wolf"));
		BarkRecognizer reco = new BarkRecognizer(door);
		System.out.println(door.dogBarks.size());
		reco.recognize(new Bark("woolf"));
		
		System.out.println("Bruce is done and playing outside...");
		
		reco.recognize(new Bark("yooor..yoooor"));
		reco.recognize(new Bark("wolf wolf"));
		System.out.println("Bruce is back Inside");
		 
		
	}

}
