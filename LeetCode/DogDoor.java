package Serials;
import java.util.*;
public class DogDoor {

	private boolean openDoor;
	public List<Bark> dogBarks = new ArrayList<Bark>();
	
	public DogDoor(){
		this.openDoor = false;
	}
	
	public void open(){
		System.out.println("Door Opens");
		this.openDoor = true;
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {	
			public void run() {
				 close();
			}
		}, 5000);
	}
	
	public void close(){
		this.openDoor = false;
		System.out.println("Door closes");
	}
	
	public boolean isOpen(){
		return this.openDoor;
	}
	
	public void addBarks(Bark bark){
		dogBarks.add(bark);
	}
	
	public List<Bark> getBarks(){
		return dogBarks;
	}
}
