package HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PrimeFactors
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n;
		System.out.print("Enter a Number : ");
		n=Integer.parseInt(br.readLine());

		System.out.print("The Prime Factors of "+n+" are : ");

		int i=2;
		while(n>1)
		{
			if(n%i == 0)
			{
				System.out.print(i+" ");
				n=n/i;
			}
			else
				i++;
		}
	}
}
