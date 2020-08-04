package GeekTrust;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class GoldenCrown {

	public static LinkedHashSet<String> alliesOfKingShan = new LinkedHashSet<String>();
	public static HashMap<String,String> kingdomsMap = new HashMap<String,String>();
	public static HashMap<String,Integer> codeMap = new HashMap<String,Integer>();
	public static String WHO_RULER = "Who is the ruler of Southeros?";
	public static String WHO_ARE_ALLIES = "Allies of King Shan?";
	public static String MESSAGE_TITLE = "Messages to kingdoms from King Shan:";
	public static String NONE = "None";
	public static String KING_SHAN = "King Shan";


	static{
		kingdomsMap.put("Water","octopus");
		kingdomsMap.put("Air","owl");
		kingdomsMap.put("Ice","mammoth");
		kingdomsMap.put("Fire","dragon");
		kingdomsMap.put("Land","panda");
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		askQuestion(inp);
		inp.close();
	}

	public static void askQuestion(Scanner in){

		String message = "";
		while(alliesOfKingShan.size() >= 0 && alliesOfKingShan.size() <= 5){
			if(in.nextLine().contains(WHO_RULER)){		 
				System.out.println(answerRulerQuestion());
			}else if(WHO_ARE_ALLIES.contains(in.nextLine())){								 
				System.out.println(answerAlliesQuestion());
				//				if(alliesOfKingShan.size() >= 3){
				//					break;
				//				}
			}else if(MESSAGE_TITLE.contains(in.nextLine())){

				message = in.nextLine();
				while(!message.contains(WHO_RULER) && (message.contains("Air") || message.contains("Land") || message.contains("Ice") 
						|| message.contains("Fire") || message.contains("Water"))){
					if(verifySecretCode(message)){
						alliesOfKingShan.add(message.substring(0,message.indexOf(',')));
						codeMap = new HashMap<String,Integer>();
					}				 
					message = in.nextLine();	 
				}
			}			
		}
	}

	public static boolean verifySecretCode(String msg){

		String secretCode = "" , kingdomAnimal = "";
		int codeCount = 0;
		if(msg.contains("Air")){
			secretCode = msg.substring(msg.indexOf(',')+1,msg.length() - 1);
			createMap(secretCode);
			kingdomAnimal = kingdomsMap.get("Air");
			for(int i = 0 ; i < kingdomAnimal.length() ; i++){
				if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") > 0){
					codeMap.put(kingdomAnimal.charAt(i)+"", codeMap.get(kingdomAnimal.charAt(i)+"") - 1);
					codeCount++;
				}else if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") == 0){
					return false;
				}else if(!codeMap.containsKey(kingdomAnimal.charAt(i)+"")){
					return false;
				}
			}
			return (codeCount == kingdomAnimal.length()) ? true : false;

		}else if(msg.contains("Water")){
			secretCode = msg.substring(msg.indexOf(',')+1,msg.length() - 1);
			createMap(secretCode);
			kingdomAnimal = kingdomsMap.get("Water");
			for(int i = 0 ; i < kingdomAnimal.length() ; i++){
				if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") > 0){
					codeMap.put(kingdomAnimal.charAt(i)+"", codeMap.get(kingdomAnimal.charAt(i)+"") - 1);
					codeCount++;
				}else if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") == 0){
					return false;
				}else if(!codeMap.containsKey(kingdomAnimal.charAt(i)+"")){
					return false;
				}
			}

			return (codeCount == kingdomAnimal.length()) ? true : false;
		}else if(msg.contains("Land")){
			secretCode = msg.substring(msg.indexOf(',')+1,msg.length() - 1);
			createMap(secretCode);
			kingdomAnimal = kingdomsMap.get("Land");
			for(int i = 0 ; i < kingdomAnimal.length() ; i++){
				if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") > 0){
					codeMap.put(kingdomAnimal.charAt(i)+"", codeMap.get(kingdomAnimal.charAt(i)+"") - 1);
					codeCount++;
				}else if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") == 0){
					return false;
				}else if(!codeMap.containsKey(kingdomAnimal.charAt(i)+"")){
					return false;
				}
			}
			return (codeCount == kingdomAnimal.length()) ? true : false;
		}else if(msg.contains("Ice")){
			secretCode = msg.substring(msg.indexOf(',')+1,msg.length() - 1);
			createMap(secretCode);
			kingdomAnimal = kingdomsMap.get("Ice");
			for(int i = 0 ; i < kingdomAnimal.length() ; i++){
				if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") > 0){
					codeMap.put(kingdomAnimal.charAt(i)+"", codeMap.get(kingdomAnimal.charAt(i)+"") - 1);
					codeCount++;
				}else if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") == 0){
					return false;
				}else if(!codeMap.containsKey(kingdomAnimal.charAt(i)+"")){
					return false;
				}
			}
			return (codeCount == kingdomAnimal.length()) ? true : false;
		}else if(msg.contains("Fire")){
			secretCode = msg.substring(msg.indexOf(',')+1,msg.length() - 1);
			createMap(secretCode);
			kingdomAnimal = kingdomsMap.get("Fire");
			for(int i = 0 ; i < kingdomAnimal.length() ; i++){
				if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") > 0){
					codeMap.put(kingdomAnimal.charAt(i)+"", codeMap.get(kingdomAnimal.charAt(i)+"") - 1);
					codeCount++;
				}else if(codeMap.containsKey(kingdomAnimal.charAt(i)+"") && codeMap.get(kingdomAnimal.charAt(i)+"") == 0){
					return false;
				}else if(!codeMap.containsKey(kingdomAnimal.charAt(i)+"")){
					return false;
				}
			}
			return (codeCount == kingdomAnimal.length()) ? true : false;
		}
		return false;
	}

	public static void createMap(String code){
		code = code.toLowerCase();
		for(int i = 0 ; i < code.length() ; i++){
			if(codeMap.containsKey(code.charAt(i)+"".toLowerCase())){
				codeMap.put(code.charAt(i)+"".toLowerCase(),codeMap.get(code.charAt(i)+"".toLowerCase()) + 1);
			}else{
				codeMap.put(code.charAt(i)+"".toLowerCase(),1);
			}
		}
	}

	public static String answerAlliesQuestion(){
		return (alliesOfKingShan.size() >= 1) ? printAllies() : NONE;
	}

	public static String answerRulerQuestion(){
		return (alliesOfKingShan.size() >= 3) ? KING_SHAN : NONE;
	}

	public static String printAllies(){
		String allies = "";
		for(String s : alliesOfKingShan){
			allies = allies + s + ","; 
		}
		return allies.substring(0,allies.length() - 1);
	}

}
