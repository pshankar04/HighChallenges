package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AgeDistribution {

	public static void main(String[] args) {
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null && (line.trim().length() > 0)){
				categorize(line);
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void categorize(String personAge){
		int age = Integer.parseInt(personAge);
		if(age >= 0 && age <= 2){
			System.out.println("Still in Mama's arms");
		}else if(age >= 3 && age <= 4){
			System.out.println("Preschool Maniac");
		}else if(age >= 5 && age <= 11){
			System.out.println("Elementary school");
		}else if(age >= 12 && age <= 14){
			System.out.println("Middle school");
		}else if(age >= 15 && age <= 18){
			System.out.println("High school");
		}else if(age >= 19 && age <= 22){
			System.out.println("College");
		}else if(age >= 23 && age <= 65){
			System.out.println("Working for the man");
		}else if(age >= 62 && age <= 100){
			System.out.println("The Golden Years");
		}else{
			System.out.println("This program is for humans");
		}
	}
}
