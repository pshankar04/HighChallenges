package Serials;

/**
 * 
 * @author puneethshankar
 *
 */
public class MineSweeper {

	public  String[] squares ;
	public boolean keepPlaying = true;
	public int  numOfpossibleZeros = 0;
	public int  numberOfSquaresInRow ;
	
	/**
	 * 
	 * @param squaresInStrings,number of rows of squares
	 * @param number
	 */
	public MineSweeper(String squaresInStrings,int number) {
		super();
		this.squares = squaresInStrings.split(",");
		this.numberOfSquaresInRow = number;
		this.numOfpossibleZeros = getMines();
	}
	
	/**
	 * 
	 * @return : number of possible '0' squares other than 'm' squares from the input squares
	 */
	public int getMines(){
		int totalMines = GameOperations.getMineCoordinates(this.squares);
		this.numOfpossibleZeros = (squares.length * squares.length) - totalMines ;
		return this.numOfpossibleZeros;
		 
	}
	
	public void setNumberOfSquaresinRow(int numberOfSquaresinRow) {
		this.numberOfSquaresInRow = numberOfSquaresinRow;
	}
	
	/**
	 * @return
	 */
	public int getNumberOfSquaresinRow() {
		return this.numberOfSquaresInRow;
	}

	public String[] getSquares() {
		return squares;
	}
	public void setSquares(String[] squares) {
		this.squares = squares;
	}
	
	public boolean isKeepPlaying() {
		return keepPlaying;
	}
	public void setKeepPlaying(boolean keepPlaying) {
		this.keepPlaying = keepPlaying;
	}
	public int getNumOfpossibleZeros() {
		return numOfpossibleZeros;
	}
	public void setNumOfpossibleZeros(int numOfpossibleZeros) {
		this.numOfpossibleZeros = numOfpossibleZeros;
	}
	
	/**
	 * returns the status of 'squares' attribute of the MineSweeper
	 */
	
	public String toString(){
		String value = "";
		for(int i = 0 ; i< this.squares.length ; i++){
			value = value + this.squares[i] + "\n"; 
		}
		return value;
	}
}
