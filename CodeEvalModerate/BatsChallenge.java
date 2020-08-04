package CodeEvalModerate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class BatsChallenge {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				findAdditionalAccomodation(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void findAdditionalAccomodation(String series){
		String[] positionData = series.split(" ");

		int wireLength = Integer.parseInt(positionData[0]);
		int distanceBetween =  Integer.parseInt(positionData[1]);
		int alreadyHanging = Integer.parseInt(positionData[2]);
		int maxAccomodation = 0;

		if(alreadyHanging == 0){
			maxAccomodation = ((wireLength - 12)/distanceBetween) + 1;
		}else if(alreadyHanging > 0 && positionData.length == 3){
			maxAccomodation = (wireLength / distanceBetween) - alreadyHanging;  
		}else if(alreadyHanging > 0 && positionData.length == 4){
			maxAccomodation = analyseSinglePoisitions(positionData);
		}else if(alreadyHanging > 0 && positionData.length > 4){
			maxAccomodation = analyseMultiplePoisitions(positionData);
		}
		System.out.println(maxAccomodation);
	}

	public static int analyseSinglePoisitions(String[] positions){

		int position = Integer.parseInt(positions[3]);
		int elmentsBetweenPosition = ((position - 6)/(Integer.parseInt(positions[1])));
		int lastPosition = Integer.parseInt(positions[0]) - 6;
		elmentsBetweenPosition = elmentsBetweenPosition + ((lastPosition - position)/(Integer.parseInt(positions[1])));

		return elmentsBetweenPosition;
	}

	public static int analyseMultiplePoisitions(String[] positions){
		int position = 0 , elmentsBetweenPositions = 0 , previousPosition = 6 ;
		ArrayList<Integer> positionList =  new ArrayList<Integer>();
		for(int i = 0 ; i < positions.length ; i++){
			if( i != 0 && i != 1 && i != 2){
				positionList.add(Integer.parseInt(positions[i]));
			}
		}
		Collections.sort(positionList);
		for(int i = 0 ; i < positionList.size() ; i++){
			if(i == 0){
				position = positionList.get(i);
				elmentsBetweenPositions = elmentsBetweenPositions + ((position - previousPosition) / (Integer.parseInt(positions[1])));
				previousPosition = position;
			}else{
				position = positionList.get(i);
				elmentsBetweenPositions = elmentsBetweenPositions + ((position - previousPosition) / (Integer.parseInt(positions[1]))) - 1;
				previousPosition = position;
			}
		}
		elmentsBetweenPositions = elmentsBetweenPositions + (((Integer.parseInt(positions[0]) - 6) - previousPosition) / (Integer.parseInt(positions[1])));
		return elmentsBetweenPositions;
	}

}
