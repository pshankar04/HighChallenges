package Serials;

/**
 * 
 * @author puneethshankar
 *a class to separate the common operations on MineSweeper game parameters
 */

public class GameOperations {

	/**
	 * 
	 * @param fields ; String array of input squares
	 * @return : total number of mines square in the input 
	 */
	public static int getMineCoordinates(String[] fields){
		int mineCoordinates = 0;
		for(int k = 0 ; k < fields.length ; k++){
			for(int j = 0 ; j < fields.length  ;j++){
				if(fields[k].charAt(j) == 'm'){
					mineCoordinates++;
				}
			}
		}
		return mineCoordinates;
	}

	/**
	 * 
	@param fields ; String array of input squares
	 * @return : current number of zero (i.e.,'0') square in the squares 
	 */
	public static int getZeroCoordinates(String[] fields){
		int zeroCoordinates = 0;
		for(int k = 0 ; k < fields.length ; k++){
			for(int j = 0 ; j < fields.length ;j++){
				if(fields[k].charAt(j) == '0' || fields[k].charAt(j) == 'f'){
					zeroCoordinates++;
				}
			}
		}
		return zeroCoordinates;
	}

	/**
	 * 
	 * @param first index position to be set to 'f'
	 * @param last ; second index position to be set to 'f'
	 * @param items ; squares array
	 * @return
	 */
	public static String[] flagLocation(int first , int last,String[] items){
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

	/**
	 * 
	 * @param first index position to be set to '0'
	 * @param last ; second index position to be set to '0'
	 * @param items ; squares array
	 * @return
	 */
	
	public static String[] openLocation(int first , int last,String[] elements){
		for(int i = 0 ; i < elements.length ; i++ ){
			if(i == first){
				elements[i] = replaceOpen(last,elements[i]);
				break;
			}
		}
		return elements;
	}

	/**
	 * 
	 * @param character at index position to be replaced 
	 * @param sample ; set of squares in a row
	 * @return : replaces '0' in position of 'x'
	 */
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

	/**
	 * 
	 * @param character at index position to be replaced 
	 * @param sample ; set of squares in a row
	 * @return : replaces 'f' in position of 'x'
	 */
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
}
