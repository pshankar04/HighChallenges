package CareerCup;

public class PrintArray {
public  static String[] st = {"Puneeth","India"};

	public static void main(String[] args) {
		
		//System.out.println(new PrintArray().toString());
		String str = "";
		str = (java.util.Arrays.toString(st)).replaceAll("\\[|\\]|\\,","");
		System.out.println(str);
	}

	public String toString(){
		String string = "";
		for(int i = 0 ; i <  st.length ; i++){
			 
			string =  string + st[i]+ " ";
		}
		return string;
	}
}	
