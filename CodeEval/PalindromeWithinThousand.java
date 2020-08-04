package CodeEval;

public class PalindromeWithinThousand {

	public static void main(String[] args) {
		int palindrome = 0;
		for(int i = 1000 ; i >= 10 ; i--){
			palindrome = checkPalindrome(i);
			 if((i == palindrome) && (checkPrimeness(i))){
				 System.out.println(i);
				 break;
			 }
		}
		
	}

	public static int checkPalindrome(int number){
		int reverse = 0;
		while(number != 0){
			reverse = (reverse * 10) + (number % 10);
			number = number/10;
		}
		return reverse;
	}

	public static boolean checkPrimeness(int number){
		 
		boolean isPrime = true;
		for(int i=2;i<=number/2;i++)
		{
			if(number % i == 0)
			{
				isPrime=false;
				break;
			}
		}
		if(isPrime){
			
			return true;
		}
		else
			return false;

	}
}
