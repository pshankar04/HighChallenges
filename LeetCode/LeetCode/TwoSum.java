	package LeetCode;
	
	import java.util.Scanner;
	
	public class TwoSum {
	
		public static boolean targetMet = false;
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			int integers[] = new int[input.nextInt()];
			for(int i = 0 ;i < integers.length ; i++){
				integers[i] = input.nextInt();
			}
	
			System.out.println("Enter the target item now : ");
			int target = input.nextInt();
			if(target != 0 && integers.length !=0 ){
				twoSum(integers,target);
			}
		}
	
		public static void twoSum(int integers[],int target){
			for(int i = 0 ; i < integers.length ; i++ ){
				for(int k = 0 ; k < integers.length ; k++){
					if(i == k) continue;
					if( (integers[i] + integers[k]) == target){
						swapIfRequired(i, k);
						targetMet = true;
						break;
					}
					 
				}
				if(targetMet) break;
			}
		}
	
		public static void swapIfRequired(int a,int b){
			int temp;
			if(a > b){
				temp = a;
				a = b;
				b = temp;
			}
			System.out.println("The index positions are :"+(a+1)+" and "+(b+1));
	
	
		}
	}
