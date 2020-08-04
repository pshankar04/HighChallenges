package Serials;

public class Bark {
	private String sound;
	
	public Bark(String barkSound){
		this.sound = barkSound;
	}
	public String getSound(){
		return sound;
	}
	
	public boolean equals(Object bark){
		if(bark instanceof Bark){
			Bark dogBark = (Bark) bark;
			if(this.sound.equals(dogBark.sound)){
				return true;
			} 
		}
		return false;
	}
	
	 
}
