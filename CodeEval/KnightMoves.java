package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class KnightMoves {

	public static HashMap<String,Integer> moveCountMap = new HashMap<String,Integer>();
	public static final int TWO = 2;
	public static final int ONE = 1;

	static{
		moveCountMap.put("a",1);moveCountMap.put("b",2);moveCountMap.put("c",3);moveCountMap.put("d",4);
		moveCountMap.put("e",5);moveCountMap.put("f",6);moveCountMap.put("g",7);moveCountMap.put("h",8); 
	}

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				moveKnight(line);
				System.out.println();
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void moveKnight(String move){
		TreeSet<String> movesList = new TreeSet<String>();
		movesList = findHorizontalMoves(move,movesList);
		printMoves(movesList);

	}

	public static TreeSet<String> findHorizontalMoves(String knightMove,TreeSet<String> knightMoveList){
		String horizMove = knightMove.charAt(0)+"";
		int verticalMove = Integer.parseInt(knightMove.charAt(1)+"");
		 
		for(Map.Entry<String, Integer> entry : moveCountMap.entrySet()){
			String key = entry.getKey();
			int value = entry.getValue();
			if(key.equals(horizMove)){
				OneH2RightVerticalUp(value,verticalMove,knightMoveList);
				OneH2LeftVerticalUp(value,verticalMove,knightMoveList);
				OneH2RightVerticalDown(value,verticalMove,knightMoveList);
				OneH2LeftVerticalDown(value,verticalMove,knightMoveList);
				TwoH1RightVerticalUp(value,verticalMove,knightMoveList);
				TwoH1LeftVerticalUp(value,verticalMove,knightMoveList);
				TwoH1RightVerticalDown(value,verticalMove,knightMoveList);
				TwoH1LeftVerticalDown(value,verticalMove,knightMoveList);
			}
		}
		return knightMoveList;
	}

	public static void OneH2RightVerticalUp(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";
		if(((ONE + horizontal) <= 8)){
			movement = movement + returnKey(ONE + horizontal);
		}
		if(((TWO + vertical) <= 8)){
			movement = movement + (TWO + vertical);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	public static void OneH2LeftVerticalUp(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";

		if(((horizontal - ONE) >= 1)){
			movement = movement + returnKey(horizontal - ONE);
		}
		if(((TWO + vertical) <= 8)){
			movement = movement + (TWO + vertical);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	public static void OneH2RightVerticalDown(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";
		if(((ONE + horizontal) <= 8)){
			movement = movement + returnKey(ONE + horizontal);
		}
		if(((vertical - TWO) >= 1)){
			movement = movement + (vertical - TWO);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	public static void OneH2LeftVerticalDown(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";

		if(((horizontal - ONE) >= 1)){
			movement = movement + returnKey(horizontal - ONE);
		}
		if(((vertical - TWO) >= 1)){
			movement = movement + (vertical - TWO);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}



	public static String returnKey(int moveCount){
		String key = "";
		for(Map.Entry<String, Integer> entry : moveCountMap.entrySet()){
			key = entry.getKey();
			int value = entry.getValue();
			if(value == moveCount){
				return key;
			}
		}
		return key;
	}


	public static void TwoH1RightVerticalUp(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";
		if(((TWO + horizontal) <= 8)){
			movement = movement + returnKey(horizontal + TWO);
		}
		if(((ONE + vertical) <= 8)){
			movement = movement + (ONE + vertical);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	public static void TwoH1LeftVerticalUp(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";

		if(((horizontal - TWO) >= 1)){
			movement = movement + returnKey(horizontal - TWO);
		}
		if(((ONE + vertical) <= 8)){
			movement = movement + (ONE + vertical);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	public static void TwoH1RightVerticalDown(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";
		if(((TWO + horizontal) <= 8)){
			movement = movement + returnKey(TWO + horizontal);
		}
		if(((vertical - ONE) >= 1)){
			movement = movement + (vertical - ONE);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	public static void TwoH1LeftVerticalDown(int horizontal,int vertical,TreeSet<String> knightMoveList){
		String movement = "";

		if(((horizontal - TWO) >= 1)){
			movement = movement + returnKey(horizontal - TWO);
		}
		if(((vertical - ONE) >= 1)){
			movement = movement + (vertical - ONE);
		}
		if(movement.length() == 2){
			knightMoveList.add(movement);
		}
	}

	 public static void printMoves(TreeSet<String> treeMoves){
		 
		 for(String move : treeMoves){
			 System.out.print(move+" ");
		 }
	 }
	 












}
