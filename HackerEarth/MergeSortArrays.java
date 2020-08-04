package HackerEarth;

 
import java.util.Arrays;
import java.util.Scanner;

public class MergeSortArrays {

	public static long[] firstArray;
	public static long[] secondArray;
	public static long[] resultArray;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tc = input.nextInt();
		int firstSize = 0 , secondSize = 0;

		for(int i = 0 ; i < tc ; i++){

			firstSize = input.nextInt();
			secondSize = input.nextInt();
			firstArray = new long[firstSize];
			for(int j = 0 ; j < firstSize ; j++){
				firstArray[j] = input.nextLong();
			}
			secondArray = new long[secondSize];
			for(int k = 0 ; k < secondSize ; k++){
				secondArray[k] = input.nextLong();
			}
			resultArray = new long[firstArray.length + secondArray.length];
			 
			System.arraycopy(firstArray,0,resultArray,0,firstArray.length);
			System.arraycopy(secondArray,0,resultArray,firstArray.length,secondArray.length);
		
			Arrays.sort(resultArray);
			for(int l = resultArray.length - 1 ; l >= 0 ; l--){
				System.out.print(resultArray[l]+" ");
			}
			System.out.println();
		}
		input.close();
	}

}