package Serials;

public class PlayerManipulations {

	public MineSweeper gamePlayer;

	public PlayerManipulations (MineSweeper gamer){
		this.gamePlayer = gamer;
	}

	public MineSweeper getGamePlayer() {
		return gamePlayer;
	}

	public void setGamePlayer(MineSweeper gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	public void startPlay(String userInput){
		String[] inputSquares = this.getGamePlayer().getSquares();
		int numberOfZeroes = this.getGamePlayer().getNumOfpossibleZeros();
		int firstIndex = Integer.parseInt(userInput.substring(userInput.indexOf('(')+1, userInput.indexOf(',')));
		int secondIndex = Integer.parseInt(userInput.substring(userInput.indexOf(',')+1, userInput.indexOf(')')));

		if(userInput.contains("f")){
			this.performFlagOperations(firstIndex,secondIndex,inputSquares,numberOfZeroes);
		} 
		else if(userInput.contains("o")){
			this.performOpenOperations(firstIndex,secondIndex,inputSquares,numberOfZeroes);
		}
	}

	public void performFlagOperations(int first,int second,String[] squaresInput,int number){
		 
		if(GameOperations.getZeroCoordinates(squaresInput) == number){
			displaySuccessMessage();
			this.getGamePlayer().setKeepPlaying(false);
		}else{
			this.getGamePlayer().setSquares(GameOperations.flagLocation(first,second,squaresInput));
			System.out.println(this.getGamePlayer().toString());
			if(GameOperations.getZeroCoordinates(squaresInput) == number){
				System.out.println("Wow,you cleared the ,minefield ! Game over");
				this.getGamePlayer().setKeepPlaying(false);
			}
		}
	}
	public void performOpenOperations(int first,int second,String[] squaresInput,int number){

		for(int i = 0 ; i < squaresInput.length  ; i++ ){
			if(GameOperations.getZeroCoordinates(squaresInput) == number){
				displaySuccessMessage();
				this.getGamePlayer().setKeepPlaying(false);
				break;
			}
			else if((first == i) && (squaresInput[i].charAt(second) == 'm')){
				displayFailureMessage();
				this.getGamePlayer().setKeepPlaying(false);
				break;
			}else if((first == i) && (squaresInput[i].charAt(second) == 'x')){
				this.getGamePlayer().setSquares(GameOperations.openLocation(first,second,squaresInput));
				System.out.println(this.getGamePlayer().toString());
				if(GameOperations.getZeroCoordinates(squaresInput) == number){
					System.out.println("Wow,you cleared the ,minefield ! Game over");
					this.getGamePlayer().setKeepPlaying(false);
					break;
				}else{
					break;
				}
			}else if((first == i)  && (squaresInput[i].charAt(second) == 'f')){
				System.out.println("You can't open a flagged square");
				System.out.println(this.getGamePlayer().toString());
				continue;
			}
		}
	}

	public void displayFailureMessage(){
		System.out.println(this.getGamePlayer().toString());
		System.out.println("Oops,you stepped on a mine! Game over");
	}

	public void displaySuccessMessage(){
		System.out.println(this.getGamePlayer().toString());
		System.out.println("Wow,you cleared the ,minefield ! Game over");
	}
}
