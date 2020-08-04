package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class QueryBoard {

	public static int[][] matrixData = new int[256][256];

	static{
		for(int i = 0 ; i < 256 ; i++){
			for(int j = 0 ; j<256 ; j++){
				matrixData[i][j] = 0;
			}
		}

	}
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				executeQuery(line);

			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void executeQuery(String query){
		int row = 0,col = 0,value = 0,queryRow = 0,queryCol = 0,sum = 0;
		if(query.contains("SetRow")){
			row = Integer.parseInt(query.substring(query.indexOf("SetRow") + 7).split(" ")[0]);
			value = Integer.parseInt(query.substring(query.indexOf("SetRow") + 7).split(" ")[1]);
			if(row >=0 && row <= 255 && value >= 0 && value <= 31){
				for(int i = 0 ; i< 256 ; i++){
					if((i == (row - 1))){
						for(int k = 0 ; k< 256 ; k++){
							matrixData[i][k] = value;
						}
					}
				}
			}
		}

		if(query.contains("SetCol")){
			col = Integer.parseInt(query.substring(query.indexOf("SetCol") + 7).split(" ")[0]);
			value = Integer.parseInt(query.substring(query.indexOf("SetCol") + 7).split(" ")[1]);
			if(row >=0 && row <= 255 && value >= 0 && value <= 31){
				for(int i = 0 ; i< 256 ; i++){
					for(int k = 0 ; k< 256 ; k++){
						if((k == (col - 1))){
							matrixData[i][k] = value;
						}
					}
				}
			}
		}

		if(query.contains("QueryRow")){
			queryRow = Integer.parseInt(query.substring(query.indexOf("QueryRow") + 9));
			if(queryRow >= 0 && queryRow <= 255){
				for(int i = 0 ; i< 256 ; i++){
					if((i == (queryRow - 1))){
						for(int k = 0 ; k< 256 ; k++){
							sum = sum + matrixData[i][k];
						}
					}
				}
				System.out.println(sum);
			}
		}

		if(query.contains("QueryCol")){
			queryCol = Integer.parseInt(query.substring(query.indexOf("QueryCol") + 9));
			if(queryCol >= 0 && queryCol <= 255){
				for(int i = 0 ; i< 256 ; i++){
					for(int k = 0 ; k< 256 ; k++){
						if((k == (queryCol - 1))){
							sum = sum + matrixData[i][k];
						}
					}
				}
				System.out.println(sum);
			}
		}
	}


}
