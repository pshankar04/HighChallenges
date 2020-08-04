package CareerCup;

public class EquiStar {

	public static int sideLength = 20;
	public static int midPoint = sideLength/2;

	public static void main(String[] args) {
		int leftRun = midPoint , rightRun = midPoint , decRightRun = 1 , decLeftRun = sideLength;
		int i = 1;
		boolean lineCompleted = false;
		boolean decRightRunFound = false;
		boolean decLeftRunFound = false;
		
		while(i <= sideLength && !lineCompleted){
			for(int j = 1 ; j <= sideLength ; j++){
				 
				if((j == midPoint) && (i == 1)){
					System.out.print("*");
					leftRun--;
					rightRun++;
					break;
				}else if(i == 5){
					for(int k = 1 ; k <= sideLength ; k++){
						System.out.print("*");
					}
					 
					 
					rightRun = rightRun + 2; 
					decRightRun = decRightRun + 1;
					decLeftRun = decLeftRun - 1;
					break;
				}
				else if((j == leftRun) || (j == rightRun) || (((j == decLeftRun) || (j == decRightRun)) && (i > 5))){
					
					if(j == leftRun){
						System.out.print("*");
						leftRun = leftRun - 1;	
					}
					
					
					if((j == decRightRun) && !decRightRunFound){
						System.out.print("#");
						decRightRun = decRightRun + 1;
						decRightRunFound = true;
						 
					}
					if(j == rightRun){
						System.out.print("*");
						rightRun = rightRun + 1;
						if( i == 7){
							leftRun = leftRun - 1;
						}
						break;
					}
					if((j == decLeftRun) && !decLeftRunFound){
						System.out.print("*");
						decLeftRun = decLeftRun - 1;
						decLeftRunFound = true;
					}

				}
 
				else{
					System.out.print(" ");
				}
				if(leftRun == 0 || rightRun == sideLength){
					for(int k = 1 ; k <= sideLength ; k++){
						System.out.print("*");
					}
					lineCompleted = true;
					break;
				}
			}
			System.out.print("\n");
			i++;
			decRightRunFound = false;
			decLeftRunFound = false;
		}


	}

}
