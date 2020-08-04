import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;

public class MatrixProblem {

	public static LinkedHashMap<String,String> layoutMap = new LinkedHashMap<String,String>();
	public static ArrayList<String> blockedCellsList =  new ArrayList<String>();
	public static String currentCell = "0,0";
	public static int moveCount;
	public static int totalRows;
	public static int totalColumns;
	public static int totalCells;

	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Total Number of rows");
		totalRows = new Integer(input.nextLine());
		System.out.println("Enter Total Number of columns");
		totalColumns = new Integer(input.nextLine());
		System.out.println("Enter Total Number of blocked cells");
		totalCells = new Integer(input.nextLine());
		String cell = "";
		System.out.println("Enter the blocked cell co-ordinates in 'x,y' format in separate lines");
		for(int i = 0 ; i < totalCells ; i++){
			cell = input.nextLine();
			blockedCellsList.add(cell);
		}
		Thread.sleep(5000);
		System.out.println("Blocked Cells :"+blockedCellsList);
		createLayout(totalRows,totalColumns,blockedCellsList);
		playGame(input,totalRows,totalColumns,blockedCellsList,layoutMap);
		input.close();
	}

	/**
	 * Creates a layout with Zig-Zag moves
	 * @param rows
	 * @param columns
	 * @param bcells
	 */
	public static void createLayout(int rows, int columns, ArrayList<String> bcells){

		int startColumnNumber = 0 , endColumnNumber = 0;
		for(int i = 0 ; i < rows ; i++){
			if(i % 2 == 0){
				startColumnNumber = 0;
				endColumnNumber = columns;
				for(int j = startColumnNumber ; j < endColumnNumber ;j++){
					if(bcells.contains(i+","+j)){
						layoutMap.put(i+","+j,"OC");
					}else{
						layoutMap.put(i+","+j,"FR");
					}
				}
			}else{
				startColumnNumber = columns - 1;
				endColumnNumber = 0;
				for(int j = startColumnNumber ; j >= endColumnNumber ;j--){
					if(bcells.contains(i+","+j)){
						layoutMap.put(i+","+j,"OC");
					}else{
						layoutMap.put(i+","+j,"FR");
					}
				}
			}

		}
		System.out.println("Map Contents :"+layoutMap);

	}


	/**
	 * Creates random number and starts the game ; Checks for game completion through row or a column fills
	 * @param in
	 * @param rows
	 * @param columns
	 * @param blockedCells
	 * @param cellsLayoutMap
	 */
	
	public static void playGame(Scanner in,int rows, int columns, ArrayList<String> blockedCells,LinkedHashMap<String,String> cellsLayoutMap){
		System.out.println("Current Starting position : "+getFirstFreePosition());
		System.out.println("Wanna Play ; y for 'Yes' OR any character for 'No'");
		String moveDecision = in.nextLine().toLowerCase();
	
		while(moveDecision.equals("y")){
			System.out.println("Current Starting position : "+currentCell);
			Random rand = new Random();
			moveCount = 1 + rand.nextInt((rows * columns) - blockedCells.size());
			System.out.println("Taking "+moveCount+" move/s from "+currentCell);
			makeAMove();
			if(isGameCompleteColumnWise() || isGameCompleteRowWise()){
				System.out.println("GAME is COMPLETE, as the row OR column is blocked or marked!!!");
				break;
			}else{
				System.out.println("Wanna Continue ; y for 'Yes' OR any character for 'No'");
				moveDecision = in.nextLine().toLowerCase();
			}
		}
		System.out.println("GAME ENDS HERE");

	}

	/**
	 * Checks for game completion column wise
	 * @return
	 */
	
	public static boolean isGameCompleteColumnWise(){
		boolean isComplete = false;
		int count = 0;

		for(int i = 0 ; i < totalColumns ; i++){
			for(int j = 0 ; j < totalRows ; j++){
				if(layoutMap.get(i+","+j).equals("MRKD") || layoutMap.get(i+","+j).equals("OC")){
					count += 1;
				}
			}
			if(count == totalColumns){
				isComplete = true;
				return isComplete;
			}else{
				count = 0;
			}
		}

		return isComplete;
	}
	
	/**
	 * Checks for game completion row wise
	 * @return
	 */
	
	public static boolean isGameCompleteRowWise(){
		boolean isComplete = false;
		int count = 0;

		for(int i = 0 ; i < totalRows ; i++){
			for(int j = 0 ; j < totalColumns ; j++){
				if(layoutMap.get(i+","+j).equals("MRKD") || layoutMap.get(i+","+j).equals("OC")){
					count += 1;
				}
			}
			if(count == totalRows){
				isComplete = true;
				return isComplete;
			}else{
				count = 0;
			}
		}

		return isComplete;
	}

	
	/**
	 * Makes a move on the layout with all the user information
	 */

	public static void makeAMove(){
		Set<String> keySet = layoutMap.keySet();
		Iterator<String> cellIterator = keySet.iterator();
		while (cellIterator.hasNext()) {
			String cell = cellIterator.next();
			if(cell.equals(currentCell)){
				updateLayout(cell);
			}
		}
		System.out.println("Current Layout Position : "+layoutMap);
	}

	/**
	 * Updates the layout with MRKD signatues
	 * @param cellId
	 */
	public static void updateLayout(String cellId){
		
		Set<String> keySet = layoutMap.keySet();
		Iterator<String> cellIterator = keySet.iterator();
		while (cellIterator.hasNext() && moveCount != 1) {
			String cellNo = cellIterator.next();
			System.out.println("Cell No :"+cellNo);
			if(cellId.equals(cellNo)){
				System.out.println("There is a Match");
				while(moveCount != 1){
					if(cellIterator.hasNext()){
						cellNo = cellIterator.next();
						if(layoutMap.get(cellNo).equals("FR")){
							moveCount -= 1;
							System.out.println("Cell Num : "+cellNo+" Move Count : "+moveCount);
						}else{
							continue;
						}
					}else{

						LinkedHashMap<String,String> newLayoutMap = new LinkedHashMap<String,String>(layoutMap);
						Set<String> freshkeySet = newLayoutMap.keySet();
						Iterator<String> freshCellIterator = freshkeySet.iterator();
						while (freshCellIterator.hasNext() && moveCount != 1) {
							cellNo = freshCellIterator.next();
							if(newLayoutMap.get(cellNo).equals("FR")){
								moveCount -= 1;
								System.out.println("Cell Num : "+cellNo+" Move Count : "+moveCount);
							}else{
								continue;
							}
						}
					}
				}
				layoutMap.put(cellNo, "MRKD");
				blockedCellsList.add(cellNo);
				currentCell = getCurrentCell(cellNo);
				System.out.println("Next Open Position : "+currentCell);
			}
		}
	}

	/**
	 * Returns the next available open position to start at each step
	 * @param cellNumber
	 * @return
	 */
	
	public static String getCurrentCell(String cellNumber){

		boolean isFound = false;
		Set<String> keySet = layoutMap.keySet();
		Iterator<String> cellIterator = keySet.iterator();
		while (cellIterator.hasNext()) {
			String cellNo = cellIterator.next();
			if(cellNo.equals(cellNumber) && isFound == false){
				isFound = true;
			}else if(!cellNo.equals(cellNumber) && isFound == true && layoutMap.get(cellNo).equals("FR")){
				currentCell = cellNo;
				break;
			}
		}
		return currentCell;
	}

	/**
	 * Returns the first free position before the game begins
	 * @return
	 */
	public static String getFirstFreePosition(){
		String openCell = "";
		Set<String> keySet = layoutMap.keySet();
		Iterator<String> cellIterator = keySet.iterator();
		while (cellIterator.hasNext()) {
			openCell = cellIterator.next();
			if(layoutMap.get(openCell) == "FR"){
				break;
			}
		}
		currentCell = openCell;
		return openCell;
	}
}
