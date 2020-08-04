package CodeEval;

public class SumOfPrime {

	public static long sum = 0;
	public static int count = 0;
	public static void main(String[] args) {

		int i = 2;
		while(count < 1000){
			checkPrimeOrNot(i);
			i++;
		}
		System.out.println(sum);
	}

	public static void checkPrimeOrNot(int number){

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
			count++;
			sum = sum + number;
		}

	}	 

}
