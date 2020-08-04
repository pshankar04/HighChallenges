package Serials;

import java.util.ArrayList;

public class Testing {

	public  String[] squares ;
	public boolean keepPlaying = true;
	public int  numOfpossibleZeros = 0;

	public Testing(int numberOfSquares){
		squares = new String[numberOfSquares];
	}
	public void startPlay(String userInput){

		int firstCo = Integer.parseInt(userInput.substring(userInput.indexOf('(')+1, userInput.indexOf(',')));
		int secondCo = Integer.parseInt(userInput.substring(userInput.indexOf(',')+1, userInput.indexOf(')')));

		if(userInput.contains("f")){
			if(this.getZeroCoordinates(this.squares) == this.numOfpossibleZeros){
				System.out.println(this.toString());
				System.out.println("Wow,you cleared the ,minefield ! Game over");
				this.keepPlaying = false;
			}else{
				this.squares = this.flagLocation(firstCo,secondCo,this.squares);
				System.out.println(this.toString());
			}
		} 
		else if(userInput.contains("o")){
			for(int i = 0 ; i < squares.length  ; i++ ){
				if(this.getZeroCoordinates(this.squares) == this.numOfpossibleZeros){
					System.out.println(this.toString());
					System.out.println("Wow,you cleared the ,minefield ! Game over");
					this.keepPlaying = false;
					break;
				}
				else if((firstCo == i) && (squares[i].charAt(secondCo) == 'm')){
					System.out.println(this.toString());
					System.out.println("Oops,you stepped on a mine! Game over");
					this.keepPlaying = false;
					break;
				}else if((firstCo == i) && (squares[i].charAt(secondCo) == 'x')){
					this.squares = this.openLocation(firstCo,secondCo,this.squares);
					System.out.println(this.toString());
					if(this.getZeroCoordinates(this.squares) == this.numOfpossibleZeros){
						System.out.println("Wow,you cleared the ,minefield ! Game over");
						this.keepPlaying = false;
						break;
					}else{
						break;
					}
				}else if((firstCo == i)  && (squares[i].charAt(secondCo) == 'f')){
					System.out.println("You can't open a flagged square");
					System.out.println(this.toString());
					continue;
				}
			}
		}
	}

	public void getMines(){
		int totalMines = this.getMineCoordinates(this.squares);
		this.numOfpossibleZeros = (squares.length * squares.length) - totalMines ;
		 
	}
	public int getMineCoordinates(String[] fields){
		ArrayList<String> mineCoordinatesList = new ArrayList<String>();
		for(int k = 0 ; k < fields.length ; k++){
			for(int j = 0 ; j < fields.length  ;j++){
				if(fields[k].charAt(j) == 'm'){
					mineCoordinatesList.add(k+""+j);
				}
			}
		}
		return mineCoordinatesList.size();
	}

	public int getZeroCoordinates(String[] fields){
		ArrayList<String> zeroCoordinatesList = new ArrayList<String>();
		for(int k = 0 ; k < fields.length ; k++){
			for(int j = 0 ; j < fields.length ;j++){
				if(fields[k].charAt(j) == '0' || fields[k].charAt(j) == 'f'){
					zeroCoordinatesList.add(k+""+j);
				}
			}
		}
		return zeroCoordinatesList.size();
	}

	public String[] flagLocation(int first , int last,String[] items){
		for(int k = 0 ; k < items.length ; k++){
			if( (first == k)){
				items[k] = replaceFlag(last,items[k]);
				break;
			}else{
				continue;
			}
		}
		return items;

	}

	public String[] openLocation(int first , int last,String[] elements){
		for(int i = 0 ; i < elements.length ; i++ ){
			if(i == first){
				elements[i] = replaceOpen(last,elements[i]);
				break;
			}
		}
		return elements;
	}

	public static String replaceOpen(int index,String sample){
		String temp = "";
		for(int k = 0 ; k < sample.length() ; k++){
			if(k == index && sample.charAt(k) != 'f'){
				temp = temp + "0";
			}else{
				temp = temp + sample.charAt(k);
			}
		}
		return temp;
	}

	public static String replaceFlag(int index,String sample){
		String temp = "";
		for(int k = 0 ; k < sample.length() ; k++){
			if(k == index && sample.charAt(k) != 'f'){
				temp = temp + "f";
			}else{
				temp = temp + sample.charAt(k);
			}
		}
		return temp;
	}


//	public void loadSquares(String entities){
//		this.squares = entities.split(",");
//	}
	
	
//	public String toString(){
//		String value = "";
//		for(int i = 0 ; i< this.squares.length ; i++){
//			value = value + this.squares[i] + "\n"; 
//		}
//		return value;
//	}

}
