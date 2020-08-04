package HackerRank;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class HRStringCompare {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String check = input.nextLine();
		int lexiLength = input.nextInt();
		System.out.println(isLexicographic(check,lexiLength));

	}

	public static String isLexicographic(String lexiStr,int lexLength){

		HashSet<String> lexiStringSet = new HashSet<String>();
		if(lexiStr.length() != 0 ){
			lexiStringSet =	saveLexiString(lexiStr,lexLength,lexiStringSet);
		}
		return getMaxMinLexicographString(lexiStringSet);

	}

	public static HashSet<String> saveLexiString(String lexiString,int length,HashSet<String> lexiSet){

		int k = 0;
		for(int i = 0 ;i < (lexiString.length() - (length -1)) ; i++){
			String sb = "";
			while(k < length){
					sb = sb +  String.valueOf(lexiString.charAt(k+i));
				k++;
			}
			k = 0;
			lexiSet.add(sb);
		}
		//System.out.println("Set Contents : "+lexiSet);
		return lexiSet;

	}

	public static String getMaxMinLexicographString(HashSet<String> lexicoSet){

		TreeSet<String> lexicoTreeSet = new TreeSet<String>(lexicoSet);
		//System.out.println("Tree Set Contents : "+lexicoTreeSet);
		return lexicoTreeSet.first()+"\n"+lexicoTreeSet.last();

	}

}
