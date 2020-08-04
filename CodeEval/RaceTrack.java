package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RaceTrack {

	public static int trackIndex = 0;
	public static int trackCount = 0;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				findWays(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findWays(String track){
		 
		for(int i = 0 ; i < track.length() ; i++){
			if((trackCount == 0)){
				if((track.contains("C") && (!track.contains("_")))){
					track = track.replace("C","|");
					trackIndex = track.indexOf('|');
					trackCount++;
					break;
				}else if((track.contains("C") && (track.contains("_")))){
					track = track.replace("C","|");
					trackIndex = track.indexOf('|');
					trackCount++;
					break;
				}if((!track.contains("C") && (track.contains("_")))){
					track = track.replace("_","|");
					trackIndex = track.indexOf('|');
					trackCount++;
					break;
				}
			}else{
				if(track.contains("C") && (!track.contains("_"))){
					if(track.indexOf('C') < trackIndex){
						track = track.replace("C","/");
						trackIndex = track.indexOf('/');
						trackCount++;
						break;
					}else if(track.indexOf('C') > trackIndex){
						track = track.replace("C",""+(char)92);
						trackIndex = track.indexOf((char)92);
						trackCount++;
						break;
					}else if(track.indexOf('C') == trackIndex){
						track = track.replace("C","|");
						trackIndex = track.indexOf('|');
						trackCount++;
						break;
					}
				}else if(track.contains("_") && (!track.contains("C"))){
					if((track.indexOf('_') < trackIndex)){
						track = track.replace("_","/");
						trackIndex = track.indexOf('/');
						trackCount++;
						break;
					}else if((track.indexOf('_') > trackIndex)){
						track = track.replace("_",""+(char)92);
						trackIndex = track.indexOf((char)92);
						trackCount++;
						break;
					}else if((track.indexOf('_') == trackIndex)){
						track = track.replace("_","|");
						trackIndex = track.indexOf('|');
						trackCount++;
						break;
					}
				}if(track.contains("C") && (track.contains("_"))){
					if(track.indexOf('C') < trackIndex){
						track = track.replace("C","/");
						trackIndex = track.indexOf('/');
						trackCount++;
						break;
					}else if(track.indexOf('C') > trackIndex){
						track = track.replace("C",""+(char)92);
						trackIndex = track.indexOf((char)92);
						trackCount++;
						break;
					}else if(track.indexOf('C') == trackIndex){
						track = track.replace("C","|");
						trackIndex = track.indexOf('|');
						trackCount++;
						break;
					}
				}
			}
		}
		System.out.println(track);
	}
}
