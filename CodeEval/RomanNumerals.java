package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeMap;

public class RomanNumerals {
	final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				System.out.println(toRoman(Integer.parseInt(line)));
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public final static String toRoman(int number) {
		int l =  map.floorKey(number);
		if ( number == l ) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number-l);
	}

}
