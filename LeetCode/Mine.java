package Serials;


import java.util.Scanner;

public class Mine {

	public  String[] squares = new String[3];
	public static void main(String[] args) {
		 Mine mine = new Mine();
		Scanner strInput = new Scanner(System.in);
		mine.squares = strInput.nextLine().split(",");
		System.out.println(mine);
		  
		mine.playUser();
		strInput.close();
	}



	public void playUser(){
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		int firstCo = Integer.parseInt(userInput.substring(userInput.indexOf('(')+1, userInput.indexOf(',')));
		int secondCo = Integer.parseInt(userInput.substring(userInput.indexOf(',')+1, userInput.indexOf(')')));

		if(userInput.contains("f")){
			this.squares = this.flagLocation(firstCo,secondCo,this.squares);
			System.out.println(this.toString());
		} 
		else if(userInput.contains("o")){
			for(int i = 0 ; i < squares.length ; i++ ){
				if(squares[i].charAt(secondCo) == 'm'){
					System.out.println(this.toString());
					System.out.println("Oops,you stepped on a mine! Game over");
					break;
				}else{
					this.squares = this.openLocation(firstCo,secondCo,this.squares);
				}
				
			}
			System.out.println(this.toString());
			 
		}
		input.close();
	}

	public String[] flagLocation(int first , int last,String[] items){
		for(int k = 0 ; k < items.length ; k++){
			if( first == k){
				items[k] = items[k].replace(items[k].charAt(last) ,'f');
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
				 elements[i] = replaceNow(last,elements[i]);
				 break;
			 }
		 }
		return elements;
		

	}
	
	public static String replaceNow(int index,String sample){
		String temp = "";
		for(int k = 0 ; k < sample.length() ; k++){
			if(k == index && sample.charAt(index) != 'm'){
				temp = temp + "0";
			}else{
			temp = temp + sample.charAt(k);
			}
		}
		
		return temp;
	}
	
	
	public String toString(){
		String value = "";
		for(int i = 0 ; i< this.squares.length ; i++){
			value = value + this.squares[i] + "\n"; 
		}
		return value;
	}

}
