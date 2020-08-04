package CodeEvalModerate;
/**
 * PARTIAL
 * https://www.codeeval.com/open_challenges/35/
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EmailValidation {

	public static void main(String[] args) {

		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.length() > 0)) {
				verifyEmailAddress(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void verifyEmailAddress(String email){

		if(email.contains("@") && email.contains(".")){
			String beforeAtRate = email.substring(0,email.lastIndexOf('@'));
			String afterAtrate = email.substring(email.lastIndexOf('@')+1,email.lastIndexOf('.'));
			String afterDot = email.substring(email.lastIndexOf('.'));

			if( (!beforeAtRate.matches("[^!#$%&'*+-/=?^_`.{|}~a-z0-9]")) && (!beforeAtRate.contains(" ")) &&
					(beforeAtRate.length() >= 1) && 
					(afterAtrate.length() >= 1) && 
					(!afterAtrate.matches("[^a-z0-9.()]")) && //
					(!afterDot.matches("[^a-z.]")) && (!afterDot.contains("*")) &&
					(!consecutiveDots(beforeAtRate)) && (quoteDelimited(beforeAtRate)) &&
					(!consecutiveDots(afterDot)) ){
				System.out.println("true");
			}else{
				System.out.println("false");
			}
		}else{
			System.out.println("false");
		}
	}

	public static boolean consecutiveDots(String uname){

		for(int i = 0 ; i < uname.length() ; i++){
			if( (uname.charAt(i) == '.' ) && (uname.charAt(i+1) == '.')){
				return true;
			}
		}
		return false;
	}

	public static boolean quoteDelimited(String uname){

		for(int i = 0 ; i < uname.length() ; i++){
			if( (i == 0) && (uname.charAt(i) == '"') ){
				return false;
			}else if((i != 0) && (uname.charAt(i) == '"') && (uname.charAt(i-1) == '\\')){
				return true;
			} 
		}
		return true;
	}
}
