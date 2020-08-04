package Random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LongestPalindromeCheck {

	public static void main(String[] args) {
		File file = new File(args[0]);
		int midPoint = 0, charCount = 0;
		String line, firstHalf = "", secondHalf = "", fullText = "";
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			while ((line = buffer.readLine()) != null) {
				fullText = fullText + line.replace(",", "").replace(" ", "").replace("'", "").toLowerCase();
			}
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		charCount = fullText.length();
		midPoint = charCount / 2;
		for (int i = 0; i < midPoint; i++) {
			firstHalf = firstHalf + fullText.charAt(i);
		}
		for (int i = charCount - 1; i > midPoint; i--) {
			secondHalf = secondHalf + fullText.charAt(i);
		}
		if (firstHalf.equals(secondHalf)) {
			System.out.println("Its is Palindrome of length :" + charCount);
		} else {
			System.out.println("Its is not a Palindrome ");
			System.out.println("firstHalf  :" + firstHalf.length());
			System.out.println("secondHalf  :" + secondHalf.length());
			
		}
	}

}
