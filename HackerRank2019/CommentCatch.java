package HackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CommentCatch {

	public static String comment = "";
	public static boolean continuedComment = false;
	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				catchComment(line); 
			}
			buffer.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void catchComment(String statement){

		if(statement.contains("//")){
			statement = statement.substring(statement.indexOf('/'),statement.length());
			System.out.println(statement);
			statement = "";
		}
		else if(statement.contains("/*") || statement.contains("*/") || statement.contains("*") || (continuedComment)){
			for(int k = 0 ; k < statement.length() ; k++){
				if(statement.charAt(k) ==  '/' && statement.charAt(k+1) == '*' ){
					statement = statement.substring(k,statement.length());
					continuedComment = true;
					System.out.println(statement);
					break;
				}else if(statement.charAt(k) ==  '*' && statement.charAt(k+1) == '/' ){
					continuedComment = false;
					if(k == 0){
						System.out.println(comment+statement);
					}else{
						statement = statement.substring(0,(k+1));
						System.out.println(statement);
					}
					break;
				}else if(statement.charAt(k) == '*'){
					System.out.println(statement);
					break;
				}else{
					if(statement.contains("*/")){
						System.out.println(statement);
						break;
					}else{
						comment = comment + statement + "\n";
						break;
					}
				}
			}

		}
	}
}
