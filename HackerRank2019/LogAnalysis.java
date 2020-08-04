package HackerRank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class LogAnalysis {

	public static HashSet<String> snSet = new HashSet<String>();
	public static HashSet<String> siSet = new HashSet<String>();
	public static HashSet<Integer> ssSet = new HashSet<Integer>();

	public static int infoCount = 0;
	public static int warnCount = 0;

	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		String line = "";
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = (buffer.readLine()).trim()) != null && ((line.trim()).length() > 0)){
				if(line.contains("INFO") || line.contains("WARN")){
					if(line.contains("INFO")){
						infoCount++;
					}else if(line.contains("WARN")){
						warnCount++;
					}
					snSet.add(line.substring(line.indexOf("sn")+6,line.indexOf("ht")-4));
					siSet.add(line.substring(line.indexOf("si")+6,line.indexOf("sh")-4));
					ssSet.add(Integer.parseInt(line.substring(line.indexOf("ss")+5,line.indexOf("s2")-3)));
				}
			}
			buffer.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println(infoCount);
		System.out.println(warnCount);
		System.out.println(snSet.size());
		System.out.println(siSet.size());
		System.out.println(Collections.max(ssSet));

		//input.close();
	}

}
